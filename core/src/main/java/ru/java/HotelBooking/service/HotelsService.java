package ru.java.HotelBooking.service;

import ru.java.HotelBooking.domain.*;
import ru.java.HotelBooking.domain.Staff;
import ru.java.HotelBooking.persistance.HotelsStore;
import ru.java.HotelBooking.persistance.DBHotelsStore;
import ru.java.HotelBooking.persistance.InMemoryHotelsStore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HotelsService {
    private HotelsStore hotelsStore = new DBHotelsStore();
    //InMemoryHotelsStore hotelsStore = InMemoryHotelsStore.getInstance();
    private static User current_user;

    public List<Hotel> getHotels() {
        return hotelsStore.getAll(Hotel.class);
        //return hotelsStore.getHotels();

    }

    public List<Booking> getBookings() {
        return hotelsStore.getAll(Booking.class);
    }

    public Hotel getHotelById(Long id) {
        List<Hotel> hotels = getHotels();
        for (Hotel h : hotels) {
            if (h.getHotel_id().equals(id)) {
                return h;
            }
        }
        return null;
    }

    public List<Booking> getBookingByRoomId(Long roomId) {
        List<Booking> bookings = getBookings();
        List<Booking> result = new ArrayList<>();
        for (Booking book : bookings
        ) {
            if (book.getRoom_id().equals(roomId)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Staff> getStaff() {
        return hotelsStore.getAll(Staff.class);
    }

    public List<Room> getRooms() {
        return hotelsStore.getAll(Room.class);
    }

    public List<HotelChain> getChains() {
        return hotelsStore.getAll(HotelChain.class);
    }

    public List<Hotel> getHotelsById(Long id) {
        List<Hotel> hotels = getHotels();
        List<Hotel> res = new ArrayList<>();
        for (Hotel h : hotels) {
            Long hotelchain_id = h.getHotelchain_id();
            if (hotelchain_id.equals(id)) {
                res.add(h);
            }
        }
        return res;
    }

    public void addHotel(long hotelChainId, String adress, Float rating) throws IllegalAccessException {
        Hotel hotel = new Hotel(hotelChainId, adress, rating);
        hotelsStore.add(hotel);
    }

    public void addStaff(Long hotel_id, String first_name, String last_name, String job_name, Integer salary) throws IllegalAccessException {
        Staff staff = new Staff(hotel_id, first_name, last_name, job_name, salary);
        hotelsStore.add(staff);
    }

    public void deleteStaff(Long staff_id) throws IllegalAccessException {
        Staff staff = new Staff(staff_id);
        hotelsStore.removeById(staff, staff_id);
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

    public Staff getMemberById(long staff_id) {
        List<Staff> staff = getStaff();
        for (Staff st : staff) {
            if (st.getStaff_id().equals(staff_id)) {
                return st;
            }
        }
        return null;
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
        return hotelsStore.removeById(employee, emplId);
    }

//    public List<User> getUsers() {
//        return hotelsStore.getUsers();
//    }

    public boolean loginIsSuccesful(String userLogin, String userPassword) {
        User newUser = new User(userLogin, userPassword);
        //current_user = categoryStore.findUser(newUser);

        return current_user != null;
    }

    public String getUsersLogin() {
        return current_user.getLogin();
    }

    public boolean updateStaff(Integer staff_id, Long hotel_id, String first_name, String last_name, String job_name, Integer salary) {
        return hotelsStore.updateStaff(staff_id, hotel_id, first_name, last_name, job_name, salary);
    }

    public Long getHotelIdByStaffId(Long staff_id) {
        List<Staff> staff = getStaff();
        for (Staff st : staff
        ) {
            if (st.getStaff_id().equals(staff_id)) {
                return st.getHotel_id();
            }
        }
        return null;
    }

    public boolean isNumberFree(Long roomId) {
        List<Booking> bookings = getBookingByRoomId(roomId);
        if (bookings.isEmpty()) {
            return true;
        }
        Date currentDate = new Date();
        for (Booking booking : bookings
        ) {
            if (booking.getStart_date().before(currentDate) && booking.getEnd_date().after(currentDate)) {
                return false;
            }
        }
        return true;
    }

    public List<FreeRoom> getUpdatedRooms(Long hotel_id) {
        List<Room> roomsById = getRoomsById(hotel_id);
        List<FreeRoom> result = new ArrayList<>();
        for (Room room : roomsById
        ) {
            Long room_id = room.getRoom_id();
            Integer room_number = room.getRoom_number();
            Integer price_per_night = room.getPrice_per_night();
            Integer max_persons = room.getMax_persons();
            String room_category = room.getRoom_category();
            String room_description = room.getRoom_description();
            boolean numberFree = isNumberFree(room_id);//NPE!!
            FreeRoom freeRoom = new FreeRoom(room_id, room_number, hotel_id, price_per_night, max_persons, room_category, room_description, numberFree);
            result.add(freeRoom);
        }
        return result;
    }
}
