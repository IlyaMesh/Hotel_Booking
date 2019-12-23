package ru.java.HotelBooking.domain;

public class Hotel{

    //TODO modify hotel class
    private Long hotel_id;
    private Long chain_hotel_id;
    private String adress;
    private Integer rating;

    public Hotel(){}

    public Hotel(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Hotel(Long chain_hotel_id, String adress, Integer rating) {
        this.chain_hotel_id = chain_hotel_id;
        this.adress = adress;
        this.rating = rating;
    }

    public Hotel(Long hotel_id, Long chain_hotel_id, String adress, Integer rating) {
        this.hotel_id = hotel_id;
        this.chain_hotel_id = chain_hotel_id;
        this.adress = adress;
        this.rating = rating;
    }

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Long getChain_hotel_id() {
        return chain_hotel_id;
    }

    public void setChain_hotel_id(Long chain_hotel_id) {
        this.chain_hotel_id = chain_hotel_id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id=" + hotel_id +
                ", chain_hotel_id=" + chain_hotel_id +
                ", adress='" + adress + '\'' +
                ", rating=" + rating +
                '}';
    }
}
