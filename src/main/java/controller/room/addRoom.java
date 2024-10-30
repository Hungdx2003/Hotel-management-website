package controller.room;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.room.RoomFunction;
import cms.room.RoomFunctionImpl;
import objects.Room;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

/**
 * Servlet implementation class addRoom
 */
@WebServlet("/addRoom")
public class addRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRoom() {
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
		
		String rtype=request.getParameter("roomTypeID");
		String price=request.getParameter("price");
		String status=request.getParameter("status");
		String image=request.getParameter("image");
		String reviews=request.getParameter("reviews");
		String floorRoom=request.getParameter("floorRoom");
		String numberOfBeds=request.getParameter("numberOfBeds");
		String maxOccupancy=request.getParameter("maxOccupancy");
		String area=request.getParameter("area");
		String amentities=request.getParameter("amentities");
		String numberPhoneExtension=request.getParameter("numberPhoneExtension");
		String bookingHistory=request.getParameter("bookingHistory");
		
		Room r=new Room();
		r.setRoomTypeID(Integer.parseInt(rtype));
		r.setPrice(Long.parseLong(price));
		r.setStatus(status);
		r.setImage(image);
		r.setReviews(reviews);
		r.setFloorRoom(Integer.parseInt(floorRoom));
		r.setNumberOfBeds(Integer.parseInt(numberOfBeds));
		r.setMaxOccupancy(Integer.parseInt(maxOccupancy));
		r.setArea(Float.parseFloat(area));
		r.setAmentities(amentities);
		r.setBookingHistory(bookingHistory);
		r.setNumberPhoneExtension(numberPhoneExtension);
		
		ConnectionPool cp=new ConnectionPoolImpl();
		RoomFunction cf=new RoomFunctionImpl(cp);
		int addResult=cf.addItem(r);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (addResult!=0) {
            // Thêm thành công
            out.println("<script>alert('Added room successfully'); window.location.href='Room.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('adding room failed'); window.location.href='Room.jsp';</script>");
        }
	}

}
