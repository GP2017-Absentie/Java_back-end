import mysql.connector
import db_config
import csv

klas = 'V1E'  # change to import other files to db


def setupDatabase():
		# db connection setup

		cnx = mysql.connector.connect(**db_config.mysql_config)  # connect to db using the config.py file
		cursor = cnx.cursor(buffered=True)  # handler structure for inserting data into the db



		return cnx, cursor

def foreignKeyToggle(cnx, cursor, value):
		cursor.execute("""SET FOREIGN_KEY_CHECKS = (%s)""", (value,))
		cnx.commit()

def importKlassen(cnx, cursor):
		klassen = ['V1A', 'V1B', 'V1C', 'V1D', 'V1E', 'V1F']

		for klas in klassen:
				cursor.execute("""
			                                          INSERT INTO
			                                              `klas`
			                                          (`code`)
			                                          VALUES
			                                              (%s)""", (klas,))
				cnx.commit()

		return klassen

def importRollen(cnx, cursor):
		cursor.execute("""
				                                          INSERT INTO
				                                              `rol`
				                                          (`naam`)
				                                          VALUES
				                                              (%s)""", ('student',))
		cnx.commit()

		cursor.execute("""
						                                          INSERT INTO
						                                              `rol`
						                                          (`naam`)
						                                          VALUES
						                                              (%s)""", ('docent',))
		cnx.commit()

def importDocenten(cnx, cursor):
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
								docentUserName = row[1] + row[2] + row[3]

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


def importStudenten(cnx, cursor, klas):
		with open('CSV/' + klas + '.csv', newline='') as f:
				reader = csv.reader(f)
				for row in reader:
						studNum = row[0]
						if row[2] != '':
								studNaam = row[3] + ' ' + row[2] + ' ' + row[1]
								studMail = row[3] + row[2] + row[1] + '@student.hu.nl'
								studUsrName = row[1] + row[2] + row[3]
						else:
								studNaam = row[3] + ' ' + row[1]
								studMail = row[3] + row[1] + '@student.hu.nl'
								studUsrName = row[1] + row[3]

								studMail = studMail.lower()
								studMail = studMail.replace(" ", "")
								studUsrName = studUsrName.replace(" ", "")

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
                    (%s, %s, %s, %s, %s, %s)""", [studNum, studMail, studNaam, user_id[0], 1, klas])
								cnx.commit()


def importRooster(cnx, cursor):
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


						# add les record

						# add the corresponding person record and link the FK (user_id)
						cursor.execute("""
	                   INSERT INTO
	                        les
	                    (datum, starttijd, eindtijd, vak_FK, lokaal_FK, docent_FK, klas_FK)
	                    VALUES
	                        (%s, %s, %s, %s, %s, %s, %s)""",
													 [lesDatum, lesStartTijd, lesEindTijd, vak_id[0], lokaal_id[0], docent_id[0], lesKlas])
						cnx.commit()
