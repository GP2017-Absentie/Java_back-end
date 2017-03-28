import mysql.connector
import db_config
import csv

# db connection setup
try:
    cnx = mysql.connector.connect(**db_config.mysql_config)  # connect to db using the config.py file
    cursor = cnx.cursor(buffered=True)  # handler structure for inserting data into the db
except:
    print("ERROR: failed to connect to the database,'\nplease check db_config.py")

with open('CSV/docenten.csv', newline='') as f:
    reader = csv.reader(f)
    i = 0
    for row in reader:
        docentId = i
        docentMail = row[0]
        if row[2] == '':
            docentNaam = row[1] + ' ' + row[3]
            docentUserName = row[1] + row[3]

        else:
            docentNaam = row[1] + ' ' + row[2] + ' ' + row[3]
            docentUserName = row[1] +row[2]+ row[3]

        # create user record
        cursor.execute("""
                                          INSERT INTO
                                              user
                                          (username, password)
                                          VALUES
                                              (%s, %s)""", (docentUserName, "geheim"))
        cnx.commit()

        # fetch id from the just created user record
        query = ("""SELECT `id` FROM `user`
                                 WHERE username = %s""")
        cursor.execute(query, (docentUserName,))

        cnx.commit()

        user_id = cursor.fetchone()

        # add the corresponding person record and link the FK (user_id)
        cursor.execute("""
               INSERT INTO
                    persoon
                (id, email, naam, user_FK, rol_FK)
                VALUES
                    (%s, %s, %s, %s, %s)""", [docentId, docentMail, docentNaam, user_id[0], 2])
        cnx.commit()

        i += 1
