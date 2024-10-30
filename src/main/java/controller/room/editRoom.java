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
 * Servlet implementation class editRoom
 */
@WebServlet("/editRoom")
public class editRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editRoom() {
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
		
		String id=request.getParameter("roomId");
		String rtype=request.getParameter("roomTypeID");
		String price=request.getParameter("price1");
		String status=request.getParameter("status1");
		String image=request.getParameter("image1");
		String reviews=request.getParameter("review1");
		String floorRoom=request.getParameter("floor1");
		String numberOfBeds=request.getParameter("numberOfBeds1");
		String maxOccupancy=request.getParameter("maxOccupancy1");
		String area=request.getParameter("area1");
		String amentities=request.getParameter("amentities1");
		String numberPhoneExtension=request.getParameter("phone1");
		String bookingHistory=request.getParameter("bookingHistory1");
		
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
		r.setRoomID(Integer.parseInt(id));
		
		ConnectionPool cp=new ConnectionPoolImpl();
		RoomFunction cf=new RoomFunctionImpl(cp);
		int editResult=cf.editItem(r);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (editResult!=0) {
            // Thêm thành công
            out.println("<script>alert('Edited room successfully'); window.location.href='Room.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Editing room failed'); window.location.href='Room.jsp';</script>");
        }
	}

}
