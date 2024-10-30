<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="objects.Invoice" %>
<%@ page import="cms.invoice.InvoiceFunction" %>
<%@ page import="cms.invoice.InvoiceFunctionImpl" %>
<%@ page import="util.ConnectionPool" %>
<%@ page import="util.ConnectionPoolImpl" %>
<%@ page import="java.util.*" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%
    String invoice_id = request.getParameter("invoiceId");
    ConnectionPool cp = new ConnectionPoolImpl();
    InvoiceFunction i = new InvoiceFunctionImpl(cp);
    
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDateTime ldt=LocalDateTime.now();
	String ck_o_date=dtf.format(ldt);

    Invoice in = i.getInvoice (Integer.parseInt(invoice_id));
    Invoice ir = i.getRoom(Integer.parseInt(invoice_id));
    ArrayList<Invoice> list = i.getServiceUsage(Integer.parseInt(invoice_id));
    Invoice it = i.getTotalInvoice(Integer.parseInt(invoice_id));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link href="assets/img/logo_ma.png" rel="icon">
  <link href="assets/img/logo_ma.png" rel="apple-touch-icon">
    <title>Edit Customer</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
     <link rel="stylesheet" href="assets/css/form.css">
</head>
<body>
    <main id="main" class="main">

        <section class="section">
            <div class="row">
                <div class="modal-content">
                    <div class="card">
                        <div class="card-body">
                        <div class="card-title text-center pb-0 fs-4">
				            <h1>The Mercure's invoice</h1>
				        </div>
                            <form action="payInvoice" method="post">
			                   <h5  class="text-center">Invoice ID:   <%= in.getInvoice_id() %></h5>
			                   <input type="hidden" name="invoice_id" value="<%= in.getInvoice_id() %>">
			                      <div class="row">
				                    <div class="col-lg-3 col-md-4 label ">Customer Name:</div>
				                    <div class="col-lg-9 col-md-8"><%= in.getCustomer_fullname() %></div>
				                  </div>
				                  <div class="row">
				                    <div class="col-lg-3 col-md-4 label">Phone Number:</div>
				                    <div class="col-lg-9 col-md-8"><%= in.getCustomer_mobilephone() %></div>
				                  </div>
								  <div class="row">
				                    <div class="col-lg-3 col-md-4 label">Room Number:</div>
				                    <div class="col-lg-9 col-md-8"><%= ir.getRoomNumber() %></div>
				                  </div>
				                  <div class="row">
				                    <div class="col-lg-3 col-md-4 label">Room Type:</div>
				                    <div class="col-lg-9 col-md-8"><%= ir.getRoomType() %></div>
				                  </div>
				                  <div class="row">
				                    <div class="col-lg-3 col-md-4 label">Check-in date:</div>
				                    <div class="col-lg-9 col-md-8"><%= in.getCheck_in_date() %></div>
				                  </div>
			                      <div class="row">
				                    <div class="col-lg-3 col-md-4 label">Check-out date:</div>
				                    <div class="col-lg-9 col-md-8"><%= in.getCheck_out_date()!=null ? in.getCheck_out_date():ck_o_date%></div>
				                  </div>
				                <h5 class="card-title">Invoice details</h5>
			                    <table class="table table-bordered">
					                <thead>
					                  <tr class="text-center">
					                    <th>Item</th>
					                    <th>Quantity/Days</th>
					                    <th>Unit Price (VND)</th>
					                    <th>Total (VND) </th>
					                  </tr>
					                </thead>
					                <tbody>
					                  <tr>
					                    <td>Giá phòng</td>
					                    <td class="text-center"><%= ir.getQuantity() %></td>
					                    <td style="text-align: right;"><%= ir.getRoom_price() %></td>
					                    <td style="text-align: right;"><%= ir.getTotal() %></td>
					                  </tr>
					                  <%
					                  	for(Invoice a:list){
					                  %>
					                  <tr>
					                  	<td><%= a.getService_name() %></td>
					                    <td class="text-center"><%= a.getQuantity() %></td>
					                    <td style="text-align: right;"><%= a.getService_price() %></td>
					                    <td style="text-align: right;"><%= a.getTotal() %></td>					                
					                  </tr>
					                  <%
					                  	}
					                  %>
					                  <tr>
					                  	<td class="text-center" colspan="3"><b>Total:</b></td>
					                  	<td style="text-align: right;"><%= it.getAmount() %></td>
					                  </tr>
					                </tbody> 
					              </table>
                                <div class="text-center">
                                <%
                                	if(in.getStatus().equalsIgnoreCase("Chưa thanh toán")){
                                %>
                                    <button type="submit" class="btn btn-primary">Pay</button>
                                <%
                                	}
                                %>
                                    <button type="button" class="btn btn-danger" onclick="window.history.back()">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main><!-- End #main -->

    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/quill/quill.min.js"></script>
    <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="assets/vendor/tinymce/tinymce.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>
</html>
