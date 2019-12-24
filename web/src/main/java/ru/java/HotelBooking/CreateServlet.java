package ru.java.HotelBooking;

import ru.java.HotelBooking.service.HotelsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private HotelsService hotelsService;
    Long hotel_id;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        hotelsService = new HotelsService();
        Integer hotel_id = null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String job_name = req.getParameter("job_name");
        Integer salary = Integer.parseInt(req.getParameter("salary"));
        try {
            hotelsService.addStaff(hotel_id,first_name,last_name,job_name,salary);
            resp.sendRedirect(req.getContextPath()+"/staff?hotel_id="+"1");
        } catch (IllegalAccessException e) {
           getServletContext().getRequestDispatcher("/create.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        hotel_id = Long.valueOf(req.getParameter("hotel_id"));
        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }
}
