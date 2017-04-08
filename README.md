# Java-back-end

Yoo Timo, ik ben gister absurt veel tijd kwijt geraakt met proberen ervoor te zorgen dat ik niet absurt veel data naar jou toe stuur, maar dat is voor geen meter gelukt.

Je krijgt nu wel al de de lessen en absenties in de getById meegestuurt, maar zoals je zal zien is het absurt veel onnodige data. Ik probeer dat later er nog uit te halen.



per les kun je nu ook de absenties ophalen met /les/getAbsentiesByLesId{id}. Zodra ik wakker word ga ik weer verder. 



## API INDEX

**[Persoon](absentieAPI/docs/persoon.md)**

​		 [/persoon (getAll)](absentieAPI/docs/persoonGetAll.md)

​		 [/persoon/getById/{id}](absentieAPI/docs/persoonGetById.md)

​		 [/persoon/login](absentieAPI/docs/persoonLogin.md)

**[Student](absentieAPI/docs/student.md)**

​		[/student (getAll)](absentieAPI/docs/student/GetAll.md)

​		[/student/getById/{id}](absentieAPI/docs/studentGetById.md)

**[Docent](absentieAPI/docs/docent.md)**

 		[/docent (getAll)](absentieAPI/docs/docent/GetAll.md)

 		[/docent/getById/{id}](absentieAPI/docs/studentGetById.md)

**[Absentie](absentieAPI/docs/absentie.md)**

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
