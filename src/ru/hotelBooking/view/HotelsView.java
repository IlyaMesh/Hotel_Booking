package ru.hotelBooking.view;

import ru.hotelBooking.service.HotelsService;

public class HotelsView {
    private HotelsService hotelsService = new HotelsService();

    public void showHotels(){
        System.out.println("-----Hotels: ------");
        hotelsService.getHotels().forEach(System.out::println);
    }
    //комнаты стафф и букинги надо показывать в выбранном отеле!
    public void showRooms(long hotelID){
        System.out.println(String.format("-----Rooms in Hotel=%d: ------",hotelID));
        hotelsService.getRoomsById(hotelID).forEach(System.out::println);
    }
    public void showStaff(long hotelId){
        System.out.println(String.format("----Staff in Hotel=%d: -------",hotelId));
        hotelsService.getStaffById(hotelId).forEach(System.out::println);
    }
    public void showBooking(long roomId){
        System.out.println(String.format("----Room's =%d booking: -------",roomId));
        hotelsService.getBookingsById(roomId).forEach(System.out::println);
    }

    public void bookRoom(Long roomId, Long guestId,String dates) {
       if(hotelsService.bookRoom(roomId,guestId,dates)){
            System.out.println(String.format("Room with id=%d has been booked",roomId));
        }
        else {
           System.out.println(String.format("Room with id=%d hasn't been booked", roomId));
       }
    }

    public void fireTheEmployee(long emplId) {
        if(hotelsService.fireTheEmployee(emplId)){
            System.out.println(String.format("Employee with id=%d has been fired",emplId));
        }
        else {
            System.out.println(String.format("Employee with id=%d doesn't exist", emplId));
        }
    }

    public void showUsers() {
        System.out.println("------Admins------");
        hotelsService.getUsers().forEach(System.out::println);
    }

    public void login(String userLogin, String userPassword) {
        if(hotelsService.loginIsSuccesful(userLogin,userPassword)){
            System.out.println("You succesfully login");
        }
        else{
            System.out.println("Something went wrong");
        }
    }
}
