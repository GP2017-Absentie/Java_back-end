package app.model;

import app.object.CoreObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.function.Supplier;

class CoreModel <T extends CoreObject> {

    private Class<T> classRef;

    public CoreModel(Class<T> _classRef) {
        this.classRef = _classRef;
    }

    public T getById(int id) throws Exception {


        try {
            CoreObject x = this.classRef.newInstance();
            String typeName = this.classRef.getSimpleName();
            if (typeName.equals("Student")){
                typeName = "persoon";
            }

            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `"+typeName+"` WHERE `id` = (?)");
            prepStat.setInt(1,id);
            ResultSet res = prepStat.executeQuery();

            HashMap hMap = resultSetToArrayList(res);
            x.deserialize(hMap);


            prepStat.close();
            res.close();
            return this.classRef.cast(x);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap resultSetToArrayList(ResultSet rs) throws SQLException{
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        rs.next();

        HashMap row = new HashMap(columns);
        for(int i=1; i<=columns; ++i){
            row.put(md.getColumnName(i),rs.getObject(i));
        }


        return row;
    }
}
