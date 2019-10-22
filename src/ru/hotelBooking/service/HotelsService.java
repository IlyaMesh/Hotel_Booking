package ru.hotelBooking.service;

import ru.hotelBooking.domain.Booking;
import ru.hotelBooking.domain.Hotel;
import ru.hotelBooking.domain.Room;
import ru.hotelBooking.domain.Staff;
import ru.hotelBooking.domain.UserAdmin;
import ru.hotelBooking.persistence.HotelsStore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HotelsService {
    private HotelsStore hotelsStore = HotelsStore.getInstance();

    public List<Hotel> getHotels() {
        return hotelsStore.getHotels();
    }

    public List<Staff> getStaff() {
        return hotelsStore.getStaff();
    }

    public List<Room> getRooms() {
        return hotelsStore.getRooms();
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
            hotelsStore.AddBooking(booking);
            return true;
        }
        return false;

    }

    public boolean fireTheEmployee(long emplId) {
        Staff employee = new Staff(emplId);
        return hotelsStore.removeEmployee(employee);
    }

    public List<UserAdmin> getAdmins() {
        return hotelsStore.getAdmins();
    }
}
