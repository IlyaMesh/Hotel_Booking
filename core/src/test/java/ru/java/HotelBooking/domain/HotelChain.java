package ru.java.HotelBooking.domain;

public class HotelChain {

    private Long hotelChain_id;
    private String name;
    private Integer number_of_hotels;

    public HotelChain(Long hotel_chain_id, String name, Integer number_of_hotels) {
        this.hotelChain_id = hotel_chain_id;
        this.name = name;
        this.number_of_hotels = number_of_hotels;
    }

    public void setHotel_chain_id(Long hotel_chain_id) {
        this.hotelChain_id = hotel_chain_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber_of_hotels(Integer number_of_hotels) {
        this.number_of_hotels = number_of_hotels;
    }

    public Long getHotel_chain_id() {
        return hotelChain_id;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber_of_hotels() {
        return number_of_hotels;
    }

    @Override
    public String toString() {
        return "Hotel_chain{" +
                "hotel_chain_id=" + hotelChain_id +
                ", name='" + name + '\'' +
                ", number_of_hotels=" + number_of_hotels +
                '}';
    }
}
