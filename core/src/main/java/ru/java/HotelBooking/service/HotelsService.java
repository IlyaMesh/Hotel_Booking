package ru.java.HotelBooking.service;

import ru.java.HotelBooking.domain.*;
import ru.java.HotelBooking.domain.Staff;
import ru.java.HotelBooking.persistance.HotelsStore;
import ru.java.HotelBooking.persistance.DBHotelsStore;
import ru.java.HotelBooking.persistance.InMemoryHotelsStore;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HotelsService {
    //private HotelsStore hotelsStore = new InMemoryHotelsStore();
    InMemoryHotelsStore hotelsStore = InMemoryHotelsStore.getInstance();
    private static User current_user;

    public List<Hotel> getHotels() {
        //return hotelsStore.getAll(Hotel.class);
        return hotelsStore.getHotels();

    }
    public Hotel getHotelById(Long id){
        List<Hotel> hotels = getHotels();
        for(Hotel h:hotels){
            if(h.getHotel_id()==id){
                return h;
            }
        }
        return null;
    }
    public List<Staff> getStaff() {
        return hotelsStore.getAll(Staff.class);
    }

    public List<Room> getRooms() {
        return hotelsStore.getAll(Room.class);
    }

    public void addHotel(long hotelChainId, String adress, Integer rating) throws IllegalAccessException {
        Hotel hotel = new Hotel(hotelChainId,adress,rating);
        hotelsStore.add(hotel);
    }

    public List<Room> getRoomsById(long hotelId) {
        return getRooms().stream()
                .filter(room -> room.getHotel_id() == hotelId)
                .collect(Collectors.toList());
    }

    public List<Staff> getStaffById(long hotelId) {
        return getStaff().stream()
                .filter(staff1 -> staff1.getHotel_id() == hotelId)
                .collect(Collectors.toList());

    }

    public List<Booking> getBookings() {
        return Collections.emptyList();
        //return hotelsStore.getBookings();
    }

    //перенести в persistance
    public List<Booking> getBookingsById(long roomID) {
        return getBookings().stream()
                .filter(booking -> booking.getRoom_id() == roomID)
                .collect(Collectors.toList());
    }


    public boolean bookRoom(Long roomId, Long guestId, String dates) {
        //dates aren't using now
        Room testRoom = new Room(roomId);
        if (getRooms().contains(testRoom)) {
            Booking booking = new Booking(11L, roomId, guestId, new Date(), new Date());
            //categoryStore.AddBooking(booking);
            return true;
        }
        return false;

    }

    public boolean fireTheEmployee(long emplId) throws IllegalAccessException {
        Staff employee = new Staff(emplId);
        //return hotelsStore.remove(employee);
        return hotelsStore.removeById(employee,emplId);
    }

//    public List<User> getUsers() {
//        return hotelsStore.getUsers();
//    }

    public boolean loginIsSuccesful(String userLogin, String userPassword) {
        User newUser = new User(userLogin,userPassword);
        //current_user = categoryStore.findUser(newUser);

        return current_user!=null;
    }
    public String getUsersLogin() {
         return current_user.getLogin();
    }


}
