package ru.java.HotelBooking;

import ru.java.HotelBooking.service.HotelsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private HotelsService hotelsService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        hotelsService = new HotelsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long staff_id = Long.valueOf(req.getParameter("staff_id"));
        try {
            hotelsService.deleteStaff(staff_id);
            resp.sendRedirect(req.getContextPath()+"/staff?hotel_id="+"1");
        } catch (IllegalAccessException e) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req,resp);
        }

    }
}
