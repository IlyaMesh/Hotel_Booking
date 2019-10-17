package ru.hotelBooking.persistence;

import ru.hotelBooking.domain.Booking;
import ru.hotelBooking.domain.Hotel;
import ru.hotelBooking.domain.Room;
import ru.hotelBooking.domain.Staff;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HotelsStore {
    private static final int HOTELS_LIST_SIZE = 10;
    private static final int ROOMS_LIST_SIZE = 50;
    private static final int STAFF_LIST_SIZE = 40;
    private static final int BOOKINGS_LIST_SIZE = 10;
    //HOTEL_CHAIN_ID is set by a const temporarily to facilitate program testing
    private static final Long HOTEL_CHAIN_ID = 1L;
    //CLIENT_ID is set by a const temporarily
    private static final int CLIENT_ID = 1;

    private static HotelsStore instance;
    private List<Hotel> hotels = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Staff> staff = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public static HotelsStore getInstance(){
        if(instance == null){
            instance = new HotelsStore();
        }
        return instance;
    }

    private HotelsStore(){
        populateHotels();
        populateRooms();
        populateBookings();
        populateStaff();
    }

    public List<Hotel> getHotels(){return hotels;}

    public List<Room> getRooms(){return rooms;}



    public List<Staff> getStaff() {return staff; }

    public List<Booking> getBookings() {return bookings; }

    private void populateHotels(){
        for (int i=1;i<=HOTELS_LIST_SIZE;i++){
            Hotel hotel = new Hotel((long) i,HOTEL_CHAIN_ID,"Adress"+i,(int)(Math.random()*5 + 1));
            hotels.add(hotel);
        }
    }

    private void populateRooms(){
        for (int i=1;i<=ROOMS_LIST_SIZE;i++){
            //5 - is rating
            Room room = new Room((long) i,(int) i,(long)(Math.random()*HOTELS_LIST_SIZE+1),(int)(Math.random()*2000+1000),(int)(Math.random()*5+1),"Category"+i,"Description"+i);
            rooms.add(room);
        }
    }

    private void populateStaff(){
        for (int i=1;i<=STAFF_LIST_SIZE;i++){
            Staff employee =new Staff((long) i,(long)(Math.random()*HOTELS_LIST_SIZE+1),"First_name"+i,"Last_name"+i,"Job"+i,(int)(Math.random()*1000+50));
            staff.add(employee);
        }
    }

    private void populateBookings(){
        for(int i=1;i<=BOOKINGS_LIST_SIZE;i++){
            Booking booking = new Booking((long) i,(long)(Math.random()*HOTELS_LIST_SIZE+1),(long)CLIENT_ID,new Date(),new Date());
            bookings.add(booking);
        }
    }

    public void AddBooking(Booking booking){ bookings.add(booking);}

    public boolean removeEmployee(Staff employee) {
        return staff.remove(employee);
    }
}
