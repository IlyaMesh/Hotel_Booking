package ru.java.HotelBooking;

import ru.java.HotelBooking.domain.FreeRoom;
import ru.java.HotelBooking.domain.Room;
import ru.java.HotelBooking.domain.Staff;
import ru.java.HotelBooking.service.HotelsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/rooms")
public class RoomServlet extends HttpServlet {
    HotelsService hotelsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hotel_id = req.getParameter("hotel_id");
        List<FreeRoom> roomsById = hotelsService.getUpdatedRooms(Long.valueOf(hotel_id));
        req.setAttribute("rooms", roomsById);
        req.getRequestDispatcher("/rooms.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        hotelsService = new HotelsService();
    }
}
