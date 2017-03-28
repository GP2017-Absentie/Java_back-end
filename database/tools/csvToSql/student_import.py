import mysql.connector
import db_config
import csv


klas = 'V1F' # change to import other files to db


# db connection setup
try:
    cnx = mysql.connector.connect(**db_config.mysql_config)  # connect to db using the config.py file
    cursor = cnx.cursor(buffered=True)  # handler structure for inserting data into the db
except:
    print("ERROR: failed to connect to the database,'\nplease check db_config.py")

with open('CSV/'+klas+'.csv', newline='') as f:
  reader = csv.reader(f)
  for row in reader:
    studNum = row[0]
    if row[2] != '':
        studNaam = row[3] +' '+ row[2] +' '+ row[1]
        studMail = row[3] + row[2] + row[1] + '@student.hu.nl'
        studUsrName = row[1]+row[2]+row[3]
    else:
        studNaam = row[3] +' '+ row[1]
        studMail = row[3] + row[1] + '@student.hu.nl'
        studUsrName = row[1] + row[3]

        studMail = studMail.lower()
        studMail = studMail.replace(" ", "")
        studUsrName = studUsrName.replace(" ", "")

        print(studNaam)
        print(studNum)
        print(studMail)
        print(studUsrName)
        print('\n')

        # create user record
        cursor.execute("""
                                      INSERT INTO
                                          user
                                      (username, password)
                                      VALUES
                                          (%s, %s)""", (studUsrName, "geheim"))
        cnx.commit()

        # fetch id from the just created user record
        query = ("""SELECT `id` FROM `user`
                             WHERE username = %s""")
        cursor.execute(query, (studUsrName,))

        cnx.commit()

        user_id = cursor.fetchone()


        # add the corresponding person record and link the FK (user_id)
        cursor.execute("""
           INSERT INTO
                persoon
            (id, email, naam, user_FK, rol_FK, klas_FK)
            VALUES
                (%s, %s, %s, %s, %s, %s)""" , [studNum, studMail, studNaam, user_id[0], 1, klas])
        cnx.commit()



