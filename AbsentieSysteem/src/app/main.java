package app;

import app.model.DatabaseModel;
import app.model.DocentModel;
import app.model.KlasModel;
import app.model.LesModel;
import app.model.PersoonModel;
import app.model.StudentModel;

public class main {
    public static void main(String [] args) {
//        DatabaseModel.open();
//        PersoonModel.getById(1);
//        
//        DatabaseModel.open();
//        LesModel.getById(1);
//        
//        DatabaseModel.open();
//        KlasModel.getListStudent("V1D");
//    	
//    	DatabaseModel.open();
//    	KlasModel.getLessenKlas("V1D");
//    	
//    	DatabaseModel.open();
//    	DocentModel.getLessenDocent(3);
//    	
//    	DatabaseModel.open();
//    	StudentModel.getAbsentiesStudent(1676955);
//    	
//    	DatabaseModel.open();
//    	DocentModel.getAbsentiesDocent(2);
    	
    	DatabaseModel.open();
    	LesModel.getStudentenByLes(1);
    }
}
