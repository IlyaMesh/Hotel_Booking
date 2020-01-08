package ru.java.HotelBooking;

import ru.java.HotelBooking.domain.Hotel;
import ru.java.HotelBooking.domain.HotelChain;
import ru.java.HotelBooking.service.HotelsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/chains"})
public class MainServlet extends HttpServlet {
    private HotelsService hotelsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        hotelsService = new HotelsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hotelchain_id = req.getParameter("chain_id");
        if (hotelchain_id != null) {
            List<Hotel> chainsById = hotelsService.getHotelsById(Long.valueOf(hotelchain_id));
            req.setAttribute("hotels", chainsById);
            req.getRequestDispatcher("/chain.jsp").forward(req, resp);
        } else {
            req.setAttribute("chains", hotelsService.getChains());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

}
