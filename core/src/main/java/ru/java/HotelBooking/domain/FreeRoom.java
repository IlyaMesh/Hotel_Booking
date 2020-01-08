package ru.java.HotelBooking.domain;

public class FreeRoom extends Room {
    private Boolean isFree;

    public FreeRoom(Long room_id, Integer room_number, Long hotel_id, Integer price_per_night, Integer max_persons, String room_category, String room_description, boolean isFree) {
        super(room_id, room_number, hotel_id, price_per_night, max_persons, room_category, room_description);
        this.isFree = isFree;
//        if (isFree) {
//            this.isFree = 1;
//        } else {
//            this.isFree = 0;
//        }
    }

    public FreeRoom() {
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(boolean free) {
        this.isFree = free;
//        if (free) {
//            this.isFree = 1;
//        } else {
//            this.isFree = 0;
//        }
    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "isFree=" + isFree +
                '}';
    }
}
