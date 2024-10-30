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
 * Servlet implementation class editPosition
 */
@WebServlet("/editPosition")
public class editPosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPosition() {
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
		
		String id=request.getParameter("position_id_edit");
		String name=request.getParameter("name");

		
		PositionObject co=new PositionObject();
		co.setPosition_id(Integer.parseInt(id));
		co.setPosition_name(name);
		
		ConnectionPool cp=new ConnectionPoolImpl();
		PositionFunction cf=new PositionFunctionImpl(cp);
		boolean editResult=cf.editPosition(co);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (editResult) {
            // Thêm thành công
            out.println("<script>alert('Edited Position successfully'); window.location.href='Position.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Edited Position failed'); window.location.href='Position.jsp';</script>");
        }
	}

}
