package controller.service;

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
 * Servlet implementation class serviceRequest
 */
@WebServlet("/serviceRequest")
public class serviceRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serviceRequest() {
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
		String booking_id=request.getParameter("booking_id");
		String service_name=request.getParameter("serviceName");
		String quanity=request.getParameter("quantity");
		
		BookingSchedule b=new BookingSchedule();
		b.setBooking_id(Integer.parseInt(booking_id));
		b.setService_name(service_name);
		b.setQuanity(Integer.parseInt(quanity));
		
		ConnectionPool cp=new ConnectionPoolImpl();
		BookingScheduleFunction bf=new BookingScheduleFunctionImpl(cp);
		boolean addResult=((BookingScheduleFunctionImpl)bf).addRequest(b);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (addResult) {
            // Thêm thành công
            out.println("<script>alert('Request successful'); window.location.href='Booking.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Request failed'); window.location.href='Booking.jsp';</script>");
        }
	}

}
