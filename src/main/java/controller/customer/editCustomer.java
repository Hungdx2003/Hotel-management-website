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
 * Servlet implementation class editCustomer
 */
@WebServlet("/editCustomer")
public class editCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("customer_id_edit");
		String name=request.getParameter("cname_edit");
		String birthday=request.getParameter("c_b_day_edit")+"/"+request.getParameter("c_b_month_edit")+"/"+request.getParameter("c_b_year_edit");
		String mobile=request.getParameter("mphone_edit");
		String email=request.getParameter("email_edit");
		String gender=request.getParameter("gender_edit");
		String na=request.getParameter("nation_edit");
		String idnumber=request.getParameter("id_number_edit");
		String address=request.getParameter("address_edit");
		
		CustomerObject co=new CustomerObject();
		co.setCustomer_id(Integer.parseInt(id));
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
		boolean editResult=cf.editCustomer(co);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (editResult) {
            // Thêm thành công
            out.println("<script>alert('Edited successfully'); window.location.href='Customer.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Edit failed'); window.location.href='Customer.jsp';</script>");
        }
	}

}
