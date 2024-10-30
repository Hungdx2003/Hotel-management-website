<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="objects.CustomerObject" %>
<%@ page import="cms.customer.CustomerFunction" %>
<%@ page import="cms.customer.CustomerFunctionImpl" %>  
<%@ page import="objects.BookingSchedule" %>
<%@ page import="cms.booking.BookingScheduleFunction" %>
<%@ page import="cms.booking.BookingScheduleFunctionImpl" %>
<%@ page import="util.ConnectionPool" %>
<%@ page import="util.ConnectionPoolImpl" %>
<%@ page import="java.util.*" %>
<%
	String booking_id = request.getParameter("bookingId");
	ConnectionPool cp = new ConnectionPoolImpl();
	BookingScheduleFunction bsf = new BookingScheduleFunctionImpl(cp);
	
	BookingSchedule b = bsf.getSchedule(Integer.parseInt(booking_id));
	ArrayList<String> list = ((BookingScheduleFunctionImpl) bsf).getServiceName();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link href="assets/img/logo_ma.png" rel="icon">
  	<link href="assets/img/logo_ma.png" rel="apple-touch-icon">
    <title>Service Request</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/form.css">
    <script>
       	function transfer(){
       		window.location.href = 'Customer.jsp';
       	}
    </script>
</head>
<body>
    <main id="main" class="main">
        <section class="section">
            <div class="row"> 
                <div class="modal-content">
                	<div class="pagetitle">
			            <h1>Service Request</h1>
			            <nav>
			                <ol class="breadcrumb">
			                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
			                    <li class="breadcrumb-item"><a href="tables-data-customer.jsp">Booking</a></li>
			                    <li class="breadcrumb-item active">Booking</li>
			                </ol>
			            </nav>
			        </div>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Request Form</h5>
                            <form action="serviceRequest" method="post">
                                <input type="hidden" name="booking_id" value="<%= b.getBooking_id() %>">
                                <div class="row mb-3">
                                    <label for="Name" class="col-sm-2 col-form-label">Customer Name</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="Name" name="cname_book" value="<%= b.getCustomer_fullname() %>">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label class="col-sm-2 col-form-label">Service Name</label>
                                    <div class="col-sm-10">
                                        <select class="form-select" aria-label="Default select example" id="serviceNameSelect" name="serviceName">
                                            <option value="">Select Service Name</option>
                                            <% for (String s : list) { %>
                                                <option value="<%= s %>"><%= s %></option>
                                            <% } %>
                                        </select>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label class="col-sm-2 col-form-label">Quantity</label>
                                    <div class="col-sm-10">
                                    	<input type="text" class="form-control" name="quantity">
                                    </div>
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Save</button>
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
