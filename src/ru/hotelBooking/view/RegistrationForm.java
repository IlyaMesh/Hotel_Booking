package ru.hotelBooking.view;

import java.util.Scanner;

public class RegistrationForm {

    private Scanner in = new Scanner(System.in);
    private HotelsView hotelsView = new HotelsView();

    public boolean login(){
        System.out.println("Enter login");
        String userLogin = in.nextLine();
        System.out.println("Enter password");
        String userPassword = in.nextLine();
        return hotelsView.login(userLogin, userPassword);
    }


    public String getCurrentUserName() {
        return hotelsView.getCurrentUserName();
    }
}
