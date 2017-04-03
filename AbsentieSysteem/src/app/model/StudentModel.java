package app.model;

import app.object.CoreObject;
import app.object.Student;

public class StudentModel extends CoreModel {
    public StudentModel() {
        super(Student.class);
    }

    @Override
    public CoreObject getById(int id) throws Exception {
        Student newStudent = (Student) super.getById(id);
        newStudent.klas = KlasModel.getKlasForPersoon(newStudent);
        return newStudent;
    }
}
