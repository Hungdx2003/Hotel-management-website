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
 * Servlet implementation class AddCustomer
 */
@WebServlet("/addCustomer")
public class addCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCustomer() {
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
		
		String name=request.getParameter("cname");
		String birthday=request.getParameter("c_b_day")+"/"+request.getParameter("c_b_month")+"/"+request.getParameter("c_b_year");
		String mobile=request.getParameter("mphone");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String na=request.getParameter("nation");
		String idnumber=request.getParameter("id_number");
		String address=request.getParameter("address");
		
		CustomerObject co=new CustomerObject();
		co.setCustomer_fullname(name);
		co.setCustomer_birthday(birthday);
		co.setCustomer_mobilephone(mobile);
		co.setCustomer_email(email);
		co.setCustomer_gender(gender);
		co.setCustomer_nationality(na);
		co.setCustomer_ID_number(idnumber);
		co.setCustomer_address(address);
		
		ConnectionPool cp=new ConnectionPoolImpl();
		CustomerFunction cf=new CustomerFunctionImpl(cp);
		boolean addResult=cf.addCustomer(co);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (addResult) {
            // Thêm thành công
            out.println("<script>alert('Added customers successfully'); window.location.href='Customer.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('adding customer failed'); window.location.href='Customer.jsp';</script>");
        }
	}

}
