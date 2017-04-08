# Java-back-end



## API v2.0

**Biggest changes in respect to v1.0:**

> Absentie and Les instances are no longer included in Persoon, Student and Docent getById calls. To get this information please call the getAbsenties- and getLessenById methods.

> Persoon, Student and Docent instances now have a `rol` attribute.

> Single object instances no longer come in an array. They are represented as single json-objects.



### API INDEX

------

**Persoon**

​		 [getAll](absentieAPI/docs/persoon/persoonGetAll.md)

​		 [getById](absentieAPI/docs/persoon/persoonGetById.md)

​		 [login](absentieAPI/docs/persoon/persoonLogin.md)

**Student**

​		[getAll](absentieAPI/docs/student/studentGetAll.md)

​		[getById](absentieAPI/docs/student/studentGetById.md)

​		[getLessenbyStudentId](absentieAPI/docs/student/studentGetLessenByStudentId.md)

​		[getAbsentiesByStudentId](absentieAPI/docs/student/studentGetAbsentiesByStudentId.md)

**Docent**

 		[getAll](absentieAPI/docs/docent/docentGetAll.md)

 		[getById](absentieAPI/docs/docent/studentGetById.md)

​		[getLessenByDocentId](absentieAPI/docs/docent/docentGetLessenByDocentId.md)

​		[getAbsentiesByDocentId](absentieAPI/docs/docent/docentGetAbsentiesByDocentId.md)

**Klas**

​		[getAll](absentieAPI/docs/klas/klasGetAll.md)

​		[getById](absentieAPI/docs/klas/klasGetById.md)

​		[getLessenbyKlasId](absentieAPI/docs/klas/klasGetLessenByKlasId.md)

​		[getAbsentiesbyKlasId](absentieAPI/docs/klas/klasGetAbsentiesByKlasId.md)

**Les**

​		[getAll](absentieAPI/docs/les/lesGetAll.md)

​		[getById](absentieAPI/docs/les/lesGetById.md)

​		[getStudentenbyKlasId](absentieAPI/docs/les/lesGetStudentenByKlasId.md)

​		[getAbsentiesbyKlasId](absentieAPI/docs/les/lesGetAbsentiesByKlasId.md)

**Absentie**

​		[getAll](absentieAPI/docs/absentie/absentieGetAll.md)

​		[getById](absentieAPI/docs/absentie/absentieGetById.md)

​		[meldAbsent](absentieAPI/docs/absentie/absentieMeldAbsent.md)

​		[meldZiek](absentieAPI/docs/absentie/absentieMeldZiek.md)





## Database design

### Entity Relationship Diagram



![ERD_v1.3](database/diagrams/ERD_v1.4.png)



### Data Definition Code

**Database Setup**

To setup the database, first create a new database in MySQL called 'AbsentieSys'. There are two ways to fill the database with content:

- Use the `clean_database_init.sql` file located in `database/ddl` to setup the architecture and run the `app.py` to fill the database with content.
- Use the `database_init.sql` file located in  `database/ddl` to setup the architecture and fill the content. This file also has INSERT statements for all the data delivered by the HU.

> The first method (using Python) is especially useful when the csv data has been changed. For regular database initialization I recommend using the second method.
