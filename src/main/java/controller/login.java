package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.EmployeeObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;
import cms.employee.EmployeeFunction;
import cms.employee.EmployeeFunctionImpl;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    // Sử dụng đối tượng User để kiểm tra thông tin đăng nhập
	    ConnectionPool cp=new ConnectionPoolImpl();
	    EmployeeFunction user = new EmployeeFunctionImpl(cp);
	    EmployeeObject loggedInUser = user.checkLogin(username, password);
	    
	    response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
	    if (loggedInUser != null) {
	        // Đăng nhập thành công, lưu thông tin người dùng vào Session
	        HttpSession session = request.getSession();
	        session.setAttribute("loggedInUser", loggedInUser);
	        session.setAttribute("loggedInUserId", loggedInUser.getEmployee_id());
	        
	        response.sendRedirect("index.jsp");
	        
	    } else {
	    	out.println("<script>alert('Login failed'); window.location.href='Login.jsp';</script>");
	    }
	}

}
