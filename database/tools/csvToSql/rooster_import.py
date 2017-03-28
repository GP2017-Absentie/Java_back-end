import mysql.connector
import db_config
import csv
# db connection setup
try:
    cnx = mysql.connector.connect(**db_config.mysql_config)  # connect to db using the config.py file
    cursor = cnx.cursor(buffered=True)  # handler structure for inserting data into the db
except:
    print("ERROR: failed to connect to the database,'\nplease check db_config.py")

with open('CSV/rooster.csv', newline='') as f:
    reader = csv.reader(f)
    i = 0
    for row in reader:
        lesDatum = row[0]
        lesStartTijd = row[1]
        lesEindTijd = row[2]
        vakNaam = row[3]
        vakCode = vakNaam[:-8]
        lesDocentMail = row[4]
        lesGebouw = row[5][:-10]
        lesLokaal = row[5][6:-5]
        lesKlas = row[6][9:]

        # fetch id from the just added vak record
        query = ("""SELECT * FROM `vak`
                                                 WHERE code = %s""")
        cursor.execute(query, (vakCode,))

        cnx.commit()
        print(lesLokaal)
        vak_id = cursor.fetchone()

        if vak_id == None:

            # add vak record
            cursor.execute("""
                                                      INSERT INTO
                                                          vak
                                                      (code, naam)
                                                      VALUES
                                                          (%s, %s)""", (vakCode, vakNaam))
            cnx.commit()

        # fetch id from the just added vak record
        query = ("""SELECT `id` FROM `vak`
                                         WHERE code = %s""")
        cursor.execute(query, (vakCode,))

        cnx.commit()

        vak_id = cursor.fetchone()

        # check if record exists
        query = ("""SELECT `id` FROM `lokaal`
                                                WHERE nummer = %s""")
        cursor.execute(query, (lesLokaal,))
        cnx.commit()

        lokaal_id = cursor.fetchone()


        if lokaal_id == None:

            # add lokaal record
            cursor.execute("""
                                                      INSERT INTO
                                                          lokaal
                                                      (gebouw, nummer)
                                                      VALUES
                                                          (%s, %s)""", (lesGebouw, str(lesLokaal)))
            cnx.commit()

        # fetch id from the just added lokaal record
        query = ("""SELECT `id` FROM `lokaal`
                                         WHERE nummer = %s""")
        cursor.execute(query, (lesLokaal,))

        cnx.commit()

        lokaal_id = cursor.fetchone()

        # fetch id from the just created user record
        query = ("""SELECT `id` FROM `persoon`
                                     WHERE email = %s""")
        cursor.execute(query, (lesDocentMail,))

        cnx.commit()

        docent_id = cursor.fetchone()


        print([lokaal_id[0], docent_id[0], lesKlas])

        # add les record

        # add the corresponding person record and link the FK (user_id)
        cursor.execute("""
                   INSERT INTO
                        les
                    (datum, starttijd, eindtijd, vak_FK, lokaal_FK, docent_FK, klas_FK)
                    VALUES
                        (%s, %s, %s, %s, %s, %s, %s)""", [lesDatum, lesStartTijd, lesEindTijd, vak_id[0], lokaal_id[0], docent_id[0], lesKlas])
        cnx.commit()
