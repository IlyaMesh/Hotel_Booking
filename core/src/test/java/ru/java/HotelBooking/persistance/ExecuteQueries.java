package ru.java.HotelBooking.persistance;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ExecuteQueries {
    private static final String URL = "jdbc:sqlite:./hotelsDB";
    private static final String USER = "sa";
    private static final String PASS = "sa";

    interface Mapper<R> {
        R foo(ResultSet rs) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
    }

    public static <T> List<T> executeSelectQuery(String query, Mapper<T> a) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); //проводник в БД
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(query);//лучше в ед. числе называть
            return (List<T>) a.foo(resultSet);
        } catch (SQLException e) {
            System.out.println("Connection error" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean executeNonSelectQuery(String query) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); //проводник в БД
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(query);//лучше в ед. числе называть
            return true;
        } catch (Exception e) {
            System.out.println("Connection error" + e.getMessage());

        }
        return false;

    }
}
