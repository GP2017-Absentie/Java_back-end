package app.model;

import app.model.DatabaseModel;
import app.object.Absentie;
import app.object.Docent;
import app.object.Les;
import app.object.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public final class LesModel {

	public static Les getById(int id) { // VERVANG Les DATE door Les TIME
		try {
			Statement stat = DatabaseModel.myConn.createStatement();
			ResultSet res = stat.executeQuery("SELECT * FROM `les` WHERE `id` = " + id);
			res.next();
			System.out.println("DEBUG: ID = " + res.getInt("id"));

			int les_id = res.getInt("id");
			int vak_FK = res.getInt("vak_FK");
			String klas = res.getString("klas_FK");
			int lokaal_FK = res.getInt("lokaal_FK");
			int docent_FK = res.getInt("docent_FK");
			Time starttijd = res.getTime("starttijd"); // 10:00:00
			Time eindtijd = res.getTime("eindtijd"); // 12:30:00

			System.out.println(starttijd);
			System.out.println(eindtijd);

			res = stat.executeQuery("SELECT * FROM `vak` WHERE `id` = " + vak_FK);
			res.next();

			String vakNaam = res.getString("naam");
			String vakCode = res.getString("code");

			res = stat.executeQuery("SELECT * FROM `lokaal` WHERE `id` = " + lokaal_FK);
			res.next();

			String gebouw = res.getString("gebouw");
			String lokaal_nummer = res.getString("nummer");

			Docent docent = DocentModel.getById(docent_FK);
			// ArrayList<Absentie> absenties = AbsentieModel.getById(les_id);
			// ABSENTIEMODEL

			Les l = new Les(vakNaam, vakCode, gebouw, lokaal_nummer, starttijd, eindtijd, klas, docent);

			res.close();
			stat.close();

			return l;

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}

	public static ArrayList<Absentie> getAbsentieByLesId(int id) {
		try {
			ArrayList<Absentie> absenties = new ArrayList<Absentie>();
			Statement stat = DatabaseModel.myConn.createStatement();
			ResultSet res = stat.executeQuery("SELECT * FROM `absentie` WHERE `les_FK` = " + id);

			while (res.next()) {
				absenties.add(AbsentieModel.getById(res.getInt("id")));
			}

			System.out.println("DEBUG: aantal absenties voor opgegevens les: " + absenties.size());

			res.close();
			stat.close();

			return absenties;

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}
	
	public static ArrayList<Student> getStudentenByLes(int id) {
		try {
			ArrayList<Student> studenten = new ArrayList<Student>();
			
			Statement stat = DatabaseModel.myConn.createStatement();
			ResultSet res = stat.executeQuery("SELECT `klas_FK` FROM `les` WHERE `id` = " + id);
			res.next();
			
			ResultSet res2 = stat.executeQuery("SELECT * FROM `persoon` WHERE `klas_FK` = '" + res.getString("klas_FK") + "'");
			
			while (res2.next()) {
				studenten.add(StudentModel.getById(res2.getInt("id")));
			}
			
			res.close();
			res2.close();
			stat.close();
			
			return studenten;
			
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}
}
