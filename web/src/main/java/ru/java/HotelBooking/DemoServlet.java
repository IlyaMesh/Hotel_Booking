package ru.java.HotelBooking;

import ru.java.HotelBooking.service.HotelsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {
    private HotelsService hotelsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        hotelsService = new HotelsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idx = req.getParameter("idx");
        if (idx != null) {
            req.setAttribute("demo", hotelsService.getHotels());//здесь было отображение одного отеля
            req.getRequestDispatcher("/demo.jsp").forward(req, resp);
        } else {
            req.setAttribute("demos", hotelsService.getHotels());
            req.getRequestDispatcher("/demos.jsp").forward(req, resp);
        }
    }
    //TODO form for hotels adding, and deleting hotels. Hotel's link should return list of rooms and staff
}
