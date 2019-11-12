package ru.hotelBooking.persistence;

import ru.hotelBooking.domain.*;
import java.util.List;

public interface HotelsStore {
    List<Room> getRooms();
    List<Hotel> getHotels();
    List<Staff> getStaff();
    List<User> getUsers();
    List<Booking> getBookings();
    void addHotel(long chainHotelId,String adress, Integer rating);
}
