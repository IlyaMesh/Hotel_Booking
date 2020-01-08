package ru.java.HotelBooking.domain;

import java.util.Date;

public class Booking {

    private Long booking_id;
    private Long room_id;
    private Long client_id;
    private Date start_date;
    private Date end_date;

    public Booking(Long booking_id,Long room_id,Long client_id,Date start_date, Date end_date){
        this.booking_id = booking_id;
        this.room_id = room_id;
        this.client_id = client_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    public Booking(){}

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", room_id=" + room_id +
                ", client_id=" + client_id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
