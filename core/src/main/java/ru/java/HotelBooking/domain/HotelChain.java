package ru.java.HotelBooking.domain;

public class HotelChain {

    private Long hotelchain_id;
    private String name;
    private String country;

    public HotelChain(){}

    public HotelChain(String name,String country){
        this.name = name;
        this.country = country;
    }

    public HotelChain(Long hotel_chain_id, String name, String country) {
        this.hotelchain_id = hotel_chain_id;
        this.name = name;
        this.country = country;
    }

    public void setHotel_chain_id(Long hotel_chain_id) {
        this.hotelchain_id = hotel_chain_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber_of_hotels(String country) {
        this.country = country;
    }

    public Long getHotel_chain_id() {
        return hotelchain_id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Hotel_chain{" +
                "hotel_chain_id=" + hotelchain_id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
