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
 * Servlet implementation class delEmployee
 */
@WebServlet("/delEmployee")
public class delEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delEmployee() {
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
		int id=Integer.parseInt(request.getParameter("employee_id_del"));
		
		ConnectionPool cp=new ConnectionPoolImpl();
		EmployeeFunction cf=new EmployeeFunctionImpl(cp);
		EmployeeObject co=new EmployeeObject();
		co.setEmployee_id(id);
		
		boolean delResult=cf.delEmployee(co);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (delResult) {
            // Thêm thành công
            out.println("<script>alert('Deleted Employee successfully'); window.location.href='Employee.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Deleted Employee failed'); window.location.href='Employee.jsp';</script>");
        }
	}

}
