<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    BookingSchedule s = bsf.getSchedule(Integer.parseInt(booking_id));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link href="assets/img/logo_ma.png" rel="icon">
  	<link href="assets/img/logo_ma.png" rel="apple-touch-icon">
    <title>Edit Schedule</title>
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
                	<div class="pagetitle">
			            <h1>Edit Schedule</h1>
			            <nav>
			                <ol class="breadcrumb">
			                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
			                    <li class="breadcrumb-item"><a href="Booking.jsp">Booking</a></li>
			                    <li class="breadcrumb-item active">Edit Booking</li>
			                </ol>
			            </nav>
			        </div>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Edit Schedule</h5>
                            <form action="editSchedule" method="post">
			                    <input type="hidden" name="booking_id_edit" value="<%= s.getBooking_id() %>">
			                    <div class="row mb-3">
			                        <label for="Name" class="col-sm-2 col-form-label">Customer Name</label>
			                        <div class="col-sm-10">
			                            <input type="text" class="form-control" id="Name" name="cname_edit" value="<%= s.getCustomer_fullname() %>"readonly>
			                        </div>
			                    </div>
			                    <div class="row mb-3">
			                        <label for="Mobile" class="col-sm-2 col-form-label">Room Number</label>
			                        <div class="col-sm-10">
			                            <input type="tel" class="form-control" id="Mobile" name="room_num_edit" value="<%= s.getRoomNumber() %>">
			                        </div>
			                    </div>
			                    <div class="row mb-3">
			                        <label class="col-sm-2 col-form-label">Check-in Date</label>
			                        <div class="col-sm-10">
			                            <div class="d-flex">
			                                <input type="number" class="form-control mr-2" id="Day" placeholder="Day" min="1" max="31" name="ck_i_day_edit" value="<%= s.getCheck_in_date().split("-")[2] %>"readonly>
			                                <input type="number" class="form-control mr-2" id="Month" placeholder="Month" min="1" max="12" name="ck_i_month_edit" value="<%= s.getCheck_in_date().split("-")[1] %>"readonly>
			                                <input type="number" class="form-control" id="Year" placeholder="Year" min="1900" max="2100" name="ck_i_year_edit" value="<%= s.getCheck_in_date().split("-")[0] %>"readonly>
			                            </div>
			                        </div>
			                    </div>
			                    <div class="row mb-3">
			                        <label class="col-sm-2 col-form-label">Check-out Date</label>
			                        <div class="col-sm-10">
			                            <div class="d-flex">
			                                <input type="number" class="form-control mr-2" id="Day" placeholder="Day" min="1" max="31" name="ck_o_day_edit" value="<%= s.getCheck_out_date() == null ? "" : s.getCheck_out_date().split("-")[2] %>" readonly>
			                                <input type="number" class="form-control mr-2" id="Month" placeholder="Month" min="1" max="12" name="ck_o_month_edit" value="<%= s.getCheck_out_date() == null ? "" : s.getCheck_out_date().split("-")[1] %>" readonly>
			                                <input type="number" class="form-control" id="Year" placeholder="Year" min="1900" max="2100" name="ck_o_year_edit" value="<%= s.getCheck_out_date() == null ? "" : s.getCheck_out_date().split("-")[0] %>" readonly>
			                            </div>
			                        </div>
			                    </div>
			                    <div class="row mb-3">
				                  <label class="col-sm-2 col-form-label">Status</label>
				                  <div class="col-sm-10">
				                    <select class="form-select" aria-label="Default select example" name="status_edit">
                                            <option value="Nhận phòng" <%= s.getStatus().equalsIgnoreCase("Nhận phòng") ? "selected" : "" %>>Nhận phòng</option>
                                            <option value="Trả phòng" <%= s.getStatus().equalsIgnoreCase("Trả phòng") ? "selected" : "" %>>Trả phòng</option>
                                            <option value="Hủy" <%= s.getStatus().equalsIgnoreCase("Hủy") ? "selected" : "" %>>Hủy</option>
                                        </select>
				                  </div>
				                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Edit</button>
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
