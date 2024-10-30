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
 * Servlet implementation class delRoom
 */
@WebServlet("/delRoom")
public class delRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delRoom() {
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
		
		String id=request.getParameter("room_id_del");
		
		Room r=new Room();
		r.setRoomID(Integer.parseInt(id));
		
		ConnectionPool cp=new ConnectionPoolImpl();
		RoomFunction cf=new RoomFunctionImpl(cp);
		int delResult=cf.delItem(r);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (delResult!=0) {
            // Thêm thành công
            out.println("<script>alert('Deleted room successfully'); window.location.href='Room.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Deleting room failed'); window.location.href='Room.jsp';</script>");
        }
	}

}
