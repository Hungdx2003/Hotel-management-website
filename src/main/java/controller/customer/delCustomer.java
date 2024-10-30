package controller.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.customer.CustomerFunction;
import cms.customer.CustomerFunctionImpl;
import objects.CustomerObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

/**
 * Servlet implementation class delCustomer
 */
@WebServlet("/delCustomer")
public class delCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delCustomer() {
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
		int id=Integer.parseInt(request.getParameter("customer_id_del"));
		
		ConnectionPool cp=new ConnectionPoolImpl();
		CustomerFunction cf=new CustomerFunctionImpl(cp);
		CustomerObject co=new CustomerObject();
		co.setCustomer_id(id);
		
		boolean delResult=cf.delCustomer(co);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (delResult) {
            // Thêm thành công
            out.println("<script>alert(' Deleted customer successfully'); window.location.href='Customer.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Deleted customer failed'); window.location.href='Customer.jsp';</script>");
        }
	}

}
