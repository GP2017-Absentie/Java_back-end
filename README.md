# Java-back-end

## Database design

### Entity Relationship Diagram



![ERD_v1.3](database/diagrams/ERD_v1.3.png)



### Data Definition Code

To setup the database:

* in mySQL, create a new database called 'AbsentieSys';
* inside this git directory, copy the DDL code from `database/ddl/*`
* paste and run the code in the new database you just created

> `clean_database_init.sql`
>
> - initializes all tables and coloums without any data
>
> `database_init.sql`
>
> * initalizes all tables and fields, then adds the data extracted from the CSV files

