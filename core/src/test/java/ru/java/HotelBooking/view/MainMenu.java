package ru.java.HotelBooking.view;

import java.util.Scanner;

public class MainMenu {

    private Scanner in = new Scanner(System.in);
    private HotelsView hotelsView = new HotelsView();
    private RegistrationForm registrationForm = new RegistrationForm();

    public void run() throws IllegalAccessException {
//        Boolean isSighnedAs = registrationForm.login();
//        if(!isSighnedAs){
//            System.out.println("Something went wrong. Try again.");
//            registrationForm.login();
//        }
//        else{
            while(true){
                //System.out.println(String.format("Sighned in as %s",hotelsView.getCurrentUserName()));
                System.out.println("-----Menu: -----");
                System.out.println("1. Show hotels (Enter 1)");
                System.out.println("2. Show rooms (Enter 2)");
                System.out.println("3. Show staff (Enter 3)");
                System.out.println("4. Show room's booking (Enter 4)");
                System.out.println("5 Book a room (Enter 5)");
                System.out.println("6 Fire an employee (Enter 6)");
                System.out.println("7 Show users(Enter 7)");
                System.out.println("8 Add hotels(Enter 8)");
                System.out.println("10. Exit (Enter 10)");

                int menuitem = in.nextInt();
                int hotelId,roomId;
                switch (menuitem){
                    case 1:
                        hotelsView.showHotels();
                        break;
                    case 2:
                        System.out.println("Enter hotel id");
                        hotelId=in.nextInt();
                        hotelsView.showRooms((long)hotelId);
                        break;
                    case 3:
                        System.out.println("Enter hotel id");
                        hotelId=in.nextInt();
                        hotelsView.showStaff(hotelId);
                        break;
                    case 4:
                        System.out.println("Enter room id");
                        roomId =in.nextInt();
                        hotelsView.showBooking(roomId);
                        break;
                    case 5:
                        System.out.println("Enter the guest id");
                        int guestId = in.nextInt();
                        System.out.println("Enter the room id");
                        roomId = in.nextInt();
                        System.out.println("Enter the booking period");
                        String dates = in.next();
                        hotelsView.bookRoom((long)roomId,(long)guestId,dates);
                        break;
                    case 6:
                        System.out.println("Enter the employee id");
                        int emplId = in.nextInt();
                        hotelsView.fireTheEmployee(emplId);
                        break;
                    case 7:
                        //hotelsView.showUsers();
                        break;

                    case 8:
                        hotelsView.addHotel();
                        break;

                    case 10:
                        System.exit(0);
                }
           // }
        }
    }
}
