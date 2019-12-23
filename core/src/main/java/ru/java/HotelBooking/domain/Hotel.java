package ru.java.HotelBooking.domain;

public class Hotel{

    private Long hotel_id;
    private Long hotelchain_id;
    private String name;
    private String country;
    private String city;
    private Float rating;

    public Hotel(){}

    public Hotel(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Hotel(Long hotelchain_id, String city, Float rating) {
        this.hotelchain_id = hotelchain_id;
        this.city = city;
        this.rating = rating;
    }

    public Hotel(Long hotel_id, Long hotelchain_id, String city, Float rating) {
        this.hotel_id = hotel_id;
        this.hotelchain_id = hotelchain_id;
        this.city = city;
        this.rating = rating;
    }

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Long getHotelchain_id() {
        return hotelchain_id;
    }

    public void setHotelchain_id(Long hotelchain_id) {
        this.hotelchain_id = hotelchain_id;
    }

    public Float getRating() {
        return rating;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id=" + hotel_id +
                ", chain_hotel_id=" + hotelchain_id +
                ", adress='" + city + '\'' +
                ", rating=" + rating +
                '}';
    }
}
