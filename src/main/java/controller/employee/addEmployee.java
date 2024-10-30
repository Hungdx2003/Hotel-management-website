package controller.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.employee.EmployeeFunction;
import cms.employee.EmployeeFunctionImpl;
import objects.EmployeeObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

/**
 * Servlet implementation class addEmployee
 */
@WebServlet("/addEmployee")
public class addEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmployee() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String phonenumber=request.getParameter("phonenumber");
		String gender=request.getParameter("gender");
		String idposition=request.getParameter("id_position");
		String createdat=request.getParameter("cr_day")+"/"+request.getParameter("cr_month")+"/"+request.getParameter("cr_year");
		
		EmployeeObject co=new EmployeeObject();
		co.setEmployee_username(username);
		co.setEmployee_password(password);
		co.setEmployee_full_name(fullname);
		co.setEmployee_email(email);
		co.setEmployee_phone_number(phonenumber);
		co.setEmployee_gender(gender);
		co.setEmployee_position_id(idposition);
		co.setEmployee_created_at(createdat);
		co.setEmployee_full_name(name);
		
		ConnectionPool cp=new ConnectionPoolImpl();
		EmployeeFunction cf=new EmployeeFunctionImpl(cp);
		boolean addResult=cf.addEmployee(co);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (addResult) {
            // Thêm thành công
            out.println("<script>alert('Added Employee successfully'); window.location.href='Employee.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Added Employee failed'); window.location.href='Employee.jsp';</script>");
        }
	}

}
