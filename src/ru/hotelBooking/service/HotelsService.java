package ru.hotelBooking.service;

import ru.hotelBooking.domain.*;
import ru.hotelBooking.domain.Staff;
import ru.hotelBooking.persistence.HotelsStore;
import ru.hotelBooking.persistence.DBHotelsStore;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HotelsService {
    private HotelsStore hotelsStore = new DBHotelsStore();
    private static User current_user;

    public List<Hotel> getHotels() {
        return hotelsStore.getHotels();
    }

    public List<Staff> getStaff() {
        return hotelsStore.getStaff();
    }

    public List<Room> getRooms() {
        return hotelsStore.getRooms();
    }

    public void addHotel(long hotelChainId, String adress, Integer rating){
        hotelsStore.addHotel(hotelChainId,adress,rating);
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
        return hotelsStore.getBookings();
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

//    public boolean fireTheEmployee(long emplId) {
//        Staff employee = new Staff(emplId);
//        return categoryStore.removeEmployee(employee);
//    }

    public List<User> getUsers() {
        return hotelsStore.getUsers();
    }

    public boolean loginIsSuccesful(String userLogin, String userPassword) {
        User newUser = new User(userLogin,userPassword);
        //current_user = categoryStore.findUser(newUser);

        return current_user!=null;
    }
    public String getUsersLogin() {
         return current_user.getLogin();
    }


}
