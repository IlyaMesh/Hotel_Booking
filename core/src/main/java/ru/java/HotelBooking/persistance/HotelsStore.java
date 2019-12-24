package ru.java.HotelBooking.persistance;

import ru.java.HotelBooking.domain.*;

import java.util.List;

public interface HotelsStore {

    <T> List<T> getAll(Class<T> tClass);

    <T> boolean removeById(T t, long id) throws IllegalAccessException;

    <T> T getById(T t,Long id);

    <T> boolean add(T t) throws IllegalAccessException;

    <T> boolean update(T t,Long id) throws IllegalAccessException;
         boolean updateStaff(Integer staff_id,Long hotel_id,String first_name,String last_name,String job_name,Integer salary);
//    boolean addHotel(long chainHotelId,String adress, Integer rating);
//    boolean deleteHotel(long id);
}
