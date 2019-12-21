package ru.java.HotelBooking.persistance;

import ru.java.HotelBooking.domain.*;

import java.util.List;

public interface HotelsStore {

    <T> List<T> getAll(Class<T> tClass);

    <T> boolean removeById(T t, long id) throws IllegalAccessException;

    <T> T getById(Long id);

    <T> boolean add(T t) throws IllegalAccessException;

//    boolean addHotel(long chainHotelId,String adress, Integer rating);
//    boolean deleteHotel(long id);
}
