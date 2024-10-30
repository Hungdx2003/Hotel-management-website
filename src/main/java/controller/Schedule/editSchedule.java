package controller.Schedule;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.booking.BookingScheduleFunction;
import cms.booking.BookingScheduleFunctionImpl;
import objects.BookingSchedule;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

/**
 * Servlet implementation class editSchedule
 */
@WebServlet("/editSchedule")
public class editSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("booking_id_edit");
		String name=request.getParameter("cname_edit");
		String room_num=request.getParameter("room_num_edit");
		String ck_i_date=request.getParameter("ck_i_year_edit")+"-"+request.getParameter("ck_i_month_edit")+"-"+request.getParameter("ck_i_day_edit");
		String status=request.getParameter("status_edit");
		
		
		BookingSchedule b=new BookingSchedule();
		b.setBooking_id(Integer.parseInt(id));
		b.setCheck_in_date(ck_i_date);
		b.setStatus(status);
		b.setCustomer_fullname(name);
		b.setRoomNumber(Integer.parseInt(room_num));
		
		ConnectionPool cp=new ConnectionPoolImpl();
		BookingScheduleFunction bf=new BookingScheduleFunctionImpl(cp);
		boolean editResult=bf.editSchedule(b);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (editResult) {
            // Thêm thành công
            out.println("<script>alert('Edited schedule successfully'); window.location.href='Booking.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Edited schedule failed'); window.location.href='Booking.jsp';</script>");
        }
	}

}
