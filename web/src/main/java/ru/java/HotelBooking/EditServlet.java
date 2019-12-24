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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private HotelsService hotelsService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        hotelsService = new HotelsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String staff_id = req.getParameter("staff_id");
        if(staff_id != null){
            Staff memberById = hotelsService.getMemberById(Long.valueOf(staff_id));
           req.setAttribute("staff",memberById);
           getServletContext().getRequestDispatcher("/edit.jsp").forward(req,resp);
        }
        else{
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer staff_id = Integer.parseInt(req.getParameter("staff_id"));
        Long hotel_id =  hotelsService.getHotelIdByStaffId(Long.valueOf(staff_id));
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String job_name = req.getParameter("job_name");
        Integer salary = Integer.parseInt(req.getParameter("salary"));
        hotelsService.updateStaff(staff_id,hotel_id,first_name,last_name,job_name,salary);
        resp.sendRedirect(req.getContextPath()+"/staff?hotel_id="+hotel_id);
    }
}
