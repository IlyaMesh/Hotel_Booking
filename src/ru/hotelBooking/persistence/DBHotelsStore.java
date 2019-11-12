package ru.hotelBooking.persistence;


import ru.hotelBooking.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.Statement;

public class DBHotelsStore implements HotelsStore {
    private static final String URL="jdbc:sqlite:./hotelsDB";
    private static final String USER = "sa";
    private static final String PASS = "sa";

    public DBHotelsStore(){
       try{
        Class.forName("org.sqlite.JDBC");}
        catch (ClassNotFoundException e){
            System.out.println("Driver class not found");
        }
    //CreateTable();
        //insertHotel();
    }

    private void CreateTable(){
//        Connection connection = null;
//        try {
//            connection = DriverManager
//                    .getConnection("jdbc:sqlite:./hotelsDB");
//            System.out.println("Connection to SQLite has been established.");
//        } catch (SQLException e) {
//            System.out.println("Connection Failed");
//            e.printStackTrace();
//            return;
//        }
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement();){

            statement.executeQuery("CREATE TABLE hotels (" + "hotel_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                    "chain_hotel_id INTEGER NOT NULL," +
                    "adress VARCHAR (150) NOT NULL,"+
                    "rating INT NOT NULL " + ")");//здесь create table
        } catch (SQLException e){
            System.out.println("DDL error " + e.getMessage());
        }
    }
    private void insertHotel(){
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement();){
            statement.execute("INSERT INTO hotels" + "(chain_hotel_id,adress, rating) " + "VALUES (1,'adress-1', 5)");
        }
        catch (Exception e){
            System.out.println("Insertion was wrong " + e.getMessage());
        }
    }

    @Override
    public void addHotel(long chainHotelId, String address, Integer rating) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement();){
            String sql = "INSERT INTO hotels" + "(chain_hotel_id,adress, rating) " + "VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,chainHotelId);
            preparedStatement.setString(2,address);
            preparedStatement.setInt(3,rating);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            System.out.println("Insertion was wrong " + e.getMessage());
        }
    }

    @Override
    public List<Hotel> getHotels(){
       try (
               Connection connection = DriverManager.getConnection(URL);
               Statement statement = connection.createStatement();
               )
       {
           ResultSet resultset = statement.executeQuery("select * from hotels");
           List<Hotel> hotels = new ArrayList<>();
           while(resultset.next()){
               long id = resultset.getLong("hotel_id");
               long chain_hotel_id  = resultset.getLong("chain_hotel_id");
               String adress = resultset.getString("adress");
               Integer rating = resultset.getInt("rating");
               Hotel hotel = new Hotel(id,chain_hotel_id,adress,rating);
               hotels.add(hotel);
           }
           return hotels;
       }
       catch (SQLException e){
           System.out.println("Connection error "+e.getMessage());

       }
       return null;
    }

    @Override
    public List<Room> getRooms(){return null;}
    @Override
    public List<Staff> getStaff(){return null;}

    @Override
    public List<User> getUsers(){return null;}

    @Override
    public List<Booking> getBookings(){return null;}


}
