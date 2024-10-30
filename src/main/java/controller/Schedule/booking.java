package controller.Schedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
 * Servlet implementation class booking
 */
@WebServlet("/booking")
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booking() {
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
		
		String name=request.getParameter("cname_book");
		String room_num=request.getParameter("roomNumber_book");
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime ldt=LocalDateTime.now();
		String ck_i_date=dtf.format(ldt);
		
		
		BookingSchedule b=new BookingSchedule();
		b.setCheck_in_date(ck_i_date);
		b.setStatus("Nhận phòng");
		b.setCustomer_fullname(name);
		b.setRoomNumber(Integer.parseInt(room_num));
		
		ConnectionPool cp=new ConnectionPoolImpl();
		BookingScheduleFunction bf=new BookingScheduleFunctionImpl(cp);
		boolean addResult=bf.addSchedule(b);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (addResult) {
            // Thêm thành công
            out.println("<script>alert('Scheduled successfully'); window.location.href='Customer.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Scheduling failed'); window.location.href='Customer.jsp';</script>");
        }
	}

}
