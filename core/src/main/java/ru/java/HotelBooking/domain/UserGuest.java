package ru.java.HotelBooking.domain;

import java.util.Objects;

public class UserGuest extends User {

    private String guestName;

    public UserGuest(Long id, String login, String password, String email, String guestName) {
        super(id, login, password, email);
        this.guestName = guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestName() {
        return guestName;
    }



    @Override
    public String toString() {
        return "UserGuest{" +
                super.toString()+
                "guestName='" + guestName + '\'' +
                '}';
    }
}
