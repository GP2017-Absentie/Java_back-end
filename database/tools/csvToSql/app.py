import import_functions

try:
		dbVars = import_functions.setupDatabase()
		cnx = dbVars[0]
		cursor = dbVars[1]
except:
		print("ERROR: failed to connect to the database,'\nplease check db_config.py")

# try:
import_functions.foreignKeyToggle(cnx, cursor, 0)
import_functions.importRollen(cnx, cursor)
klassenLijst = import_functions.importKlassen(cnx,cursor)
import_functions.importDocenten(cnx, cursor)
import_functions.importRooster(cnx, cursor)

for klas in klassenLijst:
		import_functions.importStudenten(cnx, cursor, klas)

import_functions.foreignKeyToggle(cnx, cursor, 1)

print("Import succesfull")

# except:
# 		print("ERROR: something went wrong")
