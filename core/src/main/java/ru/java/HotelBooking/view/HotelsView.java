package ru.java.HotelBooking.view;

import ru.java.HotelBooking.service.HotelsService;

import java.util.Scanner;

public class HotelsView {
    private Scanner in = new Scanner(System.in);
    private HotelsService hotelsService = new HotelsService();
    //private UserMenu userMenu = new UserMenu();

    public void showHotels() {
        System.out.println("-----Hotels: ------");
        hotelsService.getHotels().forEach(System.out::println);
    }

    public void showRooms(long hotelID) {
        System.out.println(String.format("-----Rooms in Hotel=%d: ------", hotelID));
        //hotelsService.getRoomsById(hotelID).forEach(System.out::println);
        hotelsService.getRooms().forEach(System.out::println);
    }

    public void showStaff(long hotelId) {
        System.out.println(String.format("----Staff in Hotel=%d: -------", hotelId));
        hotelsService.getStaffById(hotelId).forEach(System.out::println);
    }

    public void showBooking(long roomId) {
        System.out.println(String.format("----Room's =%d booking: -------", roomId));
        hotelsService.getBookingsById(roomId).forEach(System.out::println);
    }

    public void bookRoom(Long roomId, Long guestId, String dates) {
        if (hotelsService.bookRoom(roomId, guestId, dates)) {
            System.out.println(String.format("Room with id=%d has been booked", roomId));
        } else {
            System.out.println(String.format("Room with id=%d hasn't been booked", roomId));
        }
    }

    public void fireTheEmployee(long emplId) throws IllegalAccessException {
        if (hotelsService.fireTheEmployee(emplId)) {
            System.out.println(String.format("Employee with id=%d has been fired", emplId));
        } else {
            System.out.println(String.format("Employee with id=%d doesn't exist", emplId));
        }
    }

//    public void showUsers() {
//        System.out.println("------Admins------");
//        hotelsService.getUsers().forEach(System.out::println);
//    }

    public boolean login(String userLogin, String userPassword) {
        return hotelsService.loginIsSuccesful(userLogin, userPassword);
    }

    public void getInfoAboutCurrentUser() {
        String login = hotelsService.getUsersLogin();
        System.out.println(String.format("You login as %s", login));
    }

    public String getCurrentUserName() {
        return hotelsService.getUsersLogin();
    }

    public void addHotel() throws IllegalAccessException {
        System.out.println("Enter the chain hotel id");
        int chainHotelId = in.nextInt();
        System.out.println("Enter hotel's address");
        String address = in.next();
        System.out.println("Enter hotel's rating");
        Float rating = in.nextFloat();
        hotelsService.addHotel((long) chainHotelId, address, rating);
    }
}
