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
 * Servlet implementation class editEmployee
 */
@WebServlet("/editEmployee")
public class editEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editEmployee() {
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
		
		String id=request.getParameter("employee_id_edit");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email_edit");
		String phonenumber=request.getParameter("mphone_edit");
		String gender=request.getParameter("gender_edit");
		String idposition=request.getParameter("id_position");
		String createdat=request.getParameter("c_b_day_edit")+"/"+request.getParameter("c_b_month_edit")+"/"+request.getParameter("c_b_year_edit");
		
		EmployeeObject co=new EmployeeObject();
		co.setEmployee_id(Integer.parseInt(id));
		co.setEmployee_username(username);
		co.setEmployee_password(password);
		co.setEmployee_full_name(fullname);
		co.setEmployee_email(email);
		co.setEmployee_phone_number(phonenumber);
		co.setEmployee_gender(gender);
		co.setEmployee_position_id(idposition);
		co.setEmployee_created_at(createdat);
		
		ConnectionPool cp=new ConnectionPoolImpl();
		EmployeeFunction cf=new EmployeeFunctionImpl(cp);
		boolean editResult=cf.editEmployee(co);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (editResult) {
            // Thêm thành công
            out.println("<script>alert('Edited Employee successfully'); window.location.href='Employee.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Editing Employee failed'); window.location.href='Employee.jsp';</script>");
        }
	}

}
