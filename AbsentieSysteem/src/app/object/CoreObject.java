package app.object;

import static java.lang.Math.toIntExact;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class CoreObject {
    public int id;

    public CoreObject() {
    }

    public void deserialize(HashMap map) {
        Class objDesc = this.getClass();


        Field objFields[] = objDesc.getFields();
        System.out.println(objFields.length);

        map.forEach((k, v) -> {
            for (Field field : objFields) {
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                if (field.getName().equals(k)) {
                    try {


                        Class valueClass = v.getClass();
                        Type fieldType = field.getType();

                        switch (valueClass.getTypeName()) {
                            case "java.lang.Long":
                                int valInt = ((Long) v).intValue();
                                field.set(this, valInt);
                                break;

                            case "java.lang.String":


                                field.set(this, v);
                                break;

                        }


                        valueClass = v.getClass();

                        System.out.println("SQL TYPE\t" + valueClass.getTypeName());
                        System.out.println("FIELD TYPE\t" + field.getType());

                        if (fieldType.getTypeName().equals(valueClass.getTypeName())) {
                            System.out.println("Checkkkk");

                        }

                        field.setAccessible(accessible);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }

            }
            System.out.println(this.toString());
            System.out.println();

        });
    }


        @Override
        public String toString () {
            return "CoreObject{" +
                    "id=" + id +
                    '}';
        }
    }

