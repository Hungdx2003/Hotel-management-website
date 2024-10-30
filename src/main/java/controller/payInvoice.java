package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.invoice.InvoiceFunction;
import cms.invoice.InvoiceFunctionImpl;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

/**
 * Servlet implementation class payInvoice
 */
@WebServlet("/payInvoice")
public class payInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payInvoice() {
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
		
		String id=request.getParameter("invoice_id");
		ConnectionPool cp=new ConnectionPoolImpl();
		InvoiceFunction i=new InvoiceFunctionImpl(cp);
		boolean ip=i.payInvoice(Integer.parseInt(id));
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (ip) {
            // Thêm thành công
            out.println("<script>alert('Payment success'); window.location.href='Invoice.jsp';</script>");
        } else {
            // Thêm thất bại
            out.println("<script>alert('Payment failed'); window.location.href='Invoice.jsp';</script>");
        }
	}

}
