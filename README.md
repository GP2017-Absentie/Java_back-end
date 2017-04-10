# Java-back-end



## API v2.0

**Biggest changes in respect to v1.0:**

> Absentie and Les instances are no longer included in Persoon, Student and Docent getById calls. To get this information please call the getAbsenties- and getLessenById methods.

> Persoon, Student and Docent instances now have a `rol` attribute.

> Single object instances no longer come in an array. They are represented as single json-objects.



### API INDEX

------

**Persoon**

​		 [getAll](docs/persoon/persoonGetAll.md)

​		 [getById](docs/persoon/persoonGetById.md)

​		 [login](docs/persoon/persoonLogin.md)

**Student**

​		[getAll](docs/student/studentGetAll.md)

​		[getById](docs/student/studentGetById.md)

​		[getLessenbyStudentId](docs/student/studentGetLessenByStudentId.md)

​		[getAbsentiesByStudentId](docs/student/studentGetAbsentiesByStudentId.md)

**Docent**

 		[getAll](docs/docent/docentGetAll.md)

 		[getById](docs/docent/studentGetById.md)

​		[getLessenByDocentId](docs/docent/docentGetLessenByDocentId.md)

​		[getAbsentiesByDocentId](docs/docent/docentGetAbsentiesByDocentId.md)

**Klas**

​		[getAll](docs/klas/klasGetAll.md)

​		[getById](docs/klas/klasGetById.md)

​		[getLessenbyKlasId](docs/klas/klasGetLessenByKlasId.md)

​		[getAbsentiesbyKlasId](docs/klas/klasGetAbsentiesByKlasId.md)

**Les**

​		[getAll](docs/les/lesGetAll.md)

​		[getById](docs/les/lesGetById.md)

​		[getStudentenbyKlasId](docs/les/lesGetStudentenByKlasId.md)

​		[getAbsentiesbyKlasId](docs/les/lesGetAbsentiesByKlasId.md)

**Absentie**

​		[getAll](docs/absentie/absentieGetAll.md)

​		[getById](docs/absentie/absentieGetById.md)

​		[removeById](docs/absentie/absentieRemoveById.md)

​		[meldAbsent](docs/absentie/absentieMeldAbsent.md)

​		[meldZiek](docs/absentie/absentieMeldZiek.md)





## Database design

### Entity Relationship Diagram



![ERD_v1.3](database/diagrams/ERD_v1.4.png)



### Data Definition Code

**Database Setup**

To setup the database, first create a new database in MySQL called 'AbsentieSys'. There are two ways to fill the database with content:

- Use the `clean_database_init.sql` file located in `database/ddl` to setup the architecture and run the `app.py` to fill the database with content.
- Use the `database_init.sql` file located in  `database/ddl` to setup the architecture and fill the content. This file also has INSERT statements for all the data delivered by the HU.

> The first method (using Python) is especially useful when the csv data has been changed. For regular database initialization I recommend using the second method.
