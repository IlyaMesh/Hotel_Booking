package ru.java.HotelBooking;

import ru.java.HotelBooking.domain.Hotel;
import ru.java.HotelBooking.service.HotelsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/hotel")
public class DemoServlet extends HttpServlet {
    private HotelsService hotelsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        hotelsService = new HotelsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hotel_id = req.getParameter("hotel_id");
        if (hotel_id != null) {
            Hotel hotelById = hotelsService.getHotelById(Long.valueOf(hotel_id));
            req.setAttribute("hotel", hotelById);
            req.getRequestDispatcher("/hotel.jsp").forward(req, resp);
        } else {
            req.setAttribute("hotels", hotelsService.getHotels());
            req.getRequestDispatcher("/hotels.jsp").forward(req, resp);
        }
    }
    //TODO Show is room is free for the selected dates on the main page
}
