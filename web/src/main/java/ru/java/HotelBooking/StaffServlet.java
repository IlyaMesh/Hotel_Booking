package ru.java.HotelBooking;

import ru.java.HotelBooking.domain.Staff;
import ru.java.HotelBooking.service.HotelsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
    HotelsService hotelsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        hotelsService = new HotelsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hotel_id = req.getParameter("hotel_id");
        List<Staff> staffById = hotelsService.getStaffById(Long.valueOf(hotel_id));
        req.setAttribute("staff", staffById);
        req.getRequestDispatcher("/staff.jsp").forward(req, resp);
    }
}
