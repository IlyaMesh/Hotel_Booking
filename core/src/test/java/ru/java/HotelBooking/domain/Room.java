package ru.java.HotelBooking.domain;

import java.util.Objects;

public class Room {

    private Long room_id;
    private Integer room_number;
    private Long hotel_id;
    private Integer price_per_night;
    private Integer max_persons;
    private String room_category;
    private String room_description;

    public Room(Long room_id, Integer room_number, Long hotel_id, Integer price_per_night, Integer max_persons, String room_category, String room_description){
        this.room_id = room_id;
        this.room_number = room_number;
        this.hotel_id = hotel_id;
        this.price_per_night = price_per_night;
        this.max_persons = max_persons;
        this. room_category = room_category;
        this.room_description = room_description;
    }

    public Room(Long roomId) {
        this.room_id=roomId;
    }
    public Room(){}

    public Integer getRoom_number() {
        return room_number;
    }

    public void setRoom_number(Integer room_number) {
        this.room_number = room_number;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getHotel_id(){
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id){
        this.hotel_id = hotel_id;
    }

    public Integer getPrice_per_night(){
        return price_per_night;
    }

    public void setPrice_per_night(Integer price_per_night){
        this.price_per_night = price_per_night;
    }

    public Integer getMax_persons(){
        return max_persons;
    }

    public void setMax_persons(Integer max_persons){
        this.max_persons = max_persons;
    }

    public String getRoom_category(){
        return room_category;
    }

    public void setRoom_category(String room_category){
        this.room_category = room_category;
    }

    public String getRoom_description(){
        return room_description;
    }

    public void setRoom_description(String room_description){
        this.room_description = room_description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", room_number=" + room_number +
                ", hotel_id=" + hotel_id +
                ", price_per_night=" + price_per_night +
                ", max_persons=" + max_persons +
                ", room_category='" + room_category + '\'' +
                ", room_description='" + room_description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return room_id.equals(room.room_id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(room_id);
    }
}
