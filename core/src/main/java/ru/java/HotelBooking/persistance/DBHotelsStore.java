package ru.java.HotelBooking.persistance;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import ru.java.HotelBooking.persistance.ExecuteQueries.Mapper;

public class DBHotelsStore implements HotelsStore {

    public DBHotelsStore() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not found");
        }
    }


    @Override
    public <T> List<T> getAll(Class<T> clazz) {
        Mapper a = new Mapper<T>() {
            @Override
            public T foo(ResultSet rs) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
                List<T> list = new ArrayList<>();
                final Field[] declaredFields = clazz.getDeclaredFields();
                for (Field f : declaredFields
                ) {
                    f.setAccessible(true);
                }
                while (rs.next()) {
                    T test = (T) clazz.getConstructor().newInstance();
                    for (Field field :
                            declaredFields) {
                        String name = field.getName();
                        try {
                            String value = rs.getString(name);
                            field.set(test, field.getType().getConstructor(String.class).newInstance(value));
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                    list.add(test);
                }
                return (T) list;
            }
        };
        String class_name = clazz.getSimpleName().toLowerCase();
        StringBuilder query = new StringBuilder().append("select * from ").append(class_name);
        return ExecuteQueries.executeSelectQuery(query.toString(), a);
    }

    @Override
    public <T> boolean removeById(T t, long id) throws IllegalAccessException {

        final Class<?> clazz = t.getClass();
        String class_name = clazz.getSimpleName().toLowerCase();
        Field[] declaredFields = clazz.getDeclaredFields();
        Field id_field = declaredFields[0];
        id_field.setAccessible(true);
        String name = "";
        try {
            name = id_field.getName();
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder query = new StringBuilder().append("delete from ").append(class_name).append(" where ").append(name).append("=").append(id);
        return ExecuteQueries.executeNonSelectQuery(query.toString());
    }

    @Override
    public <T> boolean add(T t) throws IllegalAccessException {
        Class<?> clazz = t.getClass();
        String tableName = clazz.getSimpleName().toLowerCase();
        Field[] declaredFields = clazz.getDeclaredFields();
        List<String> names = new ArrayList<>();
        List<Object> par = new ArrayList<>();
        for (Field f : declaredFields
        ) {
            f.setAccessible(true);
        }

        for (int i = 1; i < declaredFields.length; i++) {
            names.add(declaredFields[i].getName());
            par.add(declaredFields[i].get(t));
        }
        StringBuilder params = new StringBuilder();
        int j = 0;
        for (String str : names
        ) {
            if (j != names.size() - 1) {
                params.append(str).append(",");
            } else {
                params.append(str);
            }
            j++;
        }
        StringBuilder q = new StringBuilder();
        j = 0;
        for (Object obj : par
        ) {
            if (j != par.size() - 1) {
                q.append(obj).append(",");
            } else {
                q.append(obj);
            }
            j++;

        }
        StringBuilder query = new StringBuilder().append("insert into ").append(tableName).append("(").append(params).append(")").append(" values (").append(q).append(")");
        return ExecuteQueries.executeNonSelectQuery(query.toString());
    }

    @Override
    public <T> T getById(T t,Long id) {
        return null;
    }


//    @Override
//    public boolean deleteHotel(long id) {
//        TestMapper t = new TestMapper<Hotel>() {
//            @Override
//            public boolean foo() throws SQLException {
//                return false;
//            }
//        };
//        return executeDeleteQuery(String.format("delete from hotels where hotel_id= {0}",id),t);
//    }


//    private <T> List<T> executeSelectQuery(String query, Mapper<T> a) {
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); //проводник в БД
//             Statement statement = connection.createStatement();) {
//            ResultSet resultSet = statement.executeQuery(query);//лучше в ед. числе называть
//            return a.foo(resultSet);
//        } catch (SQLException e) {
//            System.out.println("Connection error" + e.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    private <T> boolean executeInsertQuery(String query) {
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); //проводник в БД
//             Statement statement = connection.createStatement();) {
//            return true;//лучше в ед. числе называть
//            // return p.test(resultSet);
//        } catch (SQLException e) {
//            System.out.println("Connection error" + e.getMessage());
//        }
//        return false;
//    }
//
//    private <T> boolean executeDeleteQuery(String query) {
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); //проводник в БД
//             Statement statement = connection.createStatement();) {
//            return true;//лучше в ед. числе называть
//            // return p.test(resultSet);
//        } catch (SQLException e) {
//            System.out.println("Connection error" + e.getMessage());
//        }
//        return false;
//    }

}
