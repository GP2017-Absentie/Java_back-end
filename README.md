# Java-back-end

## API INDEX

**Persoon**

​		 [/persoon (getAll)](absentieAPI/docs/persoonGetAll.md)

​		 [/persoon/getById/{id}](absentieAPI/docs/persoonGetById.md)

​		 [/persoon/login](absentieAPI/docs/persoonLogin.md)

**Student**

​		[/student (getAll)](absentieAPI/docs/student/GetAll.md)

​		[/student/getById/{id}](absentieAPI/docs/studentGetById.md)

**Docent**

 		[/docent (getAll)](absentieAPI/docs/docent/GetAll.md)

 		[/docent/getById/{id}](absentieAPI/docs/studentGetById.md)

**Absentie**

​		[/absentie/meldAbsent](absentieAPI/docs/absentieMeldAbsent.md)

​		[/absentie/meldZiek](absentieAPI/docs/absentieMeldZiek.md)





## Database design

### Entity Relationship Diagram



![ERD_v1.3](database/diagrams/ERD_v1.4.png)



### Data Definition Code

**Database Setup**

To setup the database, first create a new database in MySQL called 'AbsentieSys'. There are two ways to fill the database with content:

- Use the `clean_database_init.sql` file located in `database/ddl` to setup the architecture and run the `app.py` to fill the database with content.
- Use the `database_init.sql` file located in  `database/ddl` to setup the architecture and fill the content. This file also has INSERT statements for all the data delivered by the HU.

> The first method (using Python) is especially useful when the csv data has been changed. For regular database initialization I recommend using the second method.
