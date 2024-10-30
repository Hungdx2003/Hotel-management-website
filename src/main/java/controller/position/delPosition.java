package controller.position;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.position.PositionFunction;
import cms.position.PositionFunctionImpl;
import objects.PositionObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

/**
 * Servlet implementation class delPosition
 */
@WebServlet("/delPosition")
public class delPosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delPosition() {
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
int id=Integer.parseInt(request.getParameter("position_id_del"));
		
		ConnectionPool cp=new ConnectionPoolImpl();
		PositionFunction cf=new PositionFunctionImpl(cp);
		PositionObject co=new PositionObject();
		co.setPosition_id(id);
		
		boolean delResult=cf.delPosition(co);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (delResult) {
            // Thêm thành công
            out.println("<script>alert(' Deleted Position successfully'); window.location.href='Position.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Deleted Position failed'); window.location.href='Position.jsp';</script>");
        }
	}

}
