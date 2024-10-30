package controller.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.ServiceFunction;
import cms.ServiceFunctionImpl;
import objects.ServiceObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

/**
 * Servlet implementation class editService
 */
@WebServlet("/editService")
public class editService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editService() {
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
		
		String id=request.getParameter("service_id_edit");
		String name=request.getParameter("sname_edit");
		String price=request.getParameter("price_edit");
		String des=request.getParameter("description_edit");
		
		ServiceObject so=new ServiceObject();
		so.setService_name(name);
		so.setPrice(Integer.parseInt(price));
		so.setDescription(des);
		so.setService_id(Integer.parseInt(id));
		
		ConnectionPool cp=new ConnectionPoolImpl();
		ServiceFunction sf=new ServiceFunctionImpl(cp);
		boolean editResult=sf.editService(so);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (editResult) {
            // Thêm thành công
            out.println("<script>alert('Edited service successfully'); window.location.href='Service.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Editting service failed'); window.location.href='Service.jsp';</script>");
        }
	}

}
