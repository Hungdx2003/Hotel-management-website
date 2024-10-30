<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="objects.CustomerObject" %>
<%@ page import="cms.customer.CustomerFunction" %>
<%@ page import="cms.customer.CustomerFunctionImpl" %>
<%@ page import="util.ConnectionPool" %>
<%@ page import="util.ConnectionPoolImpl" %>
<%@ page import="java.util.*" %>
<%
    String customer_id = request.getParameter("customerId");
    ConnectionPool cp = new ConnectionPoolImpl();
    CustomerFunction cf = new CustomerFunctionImpl(cp);

    CustomerObject customer = cf.getCustomer(Integer.parseInt(customer_id));
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
                <div class="pagetitle">
		            <h1>Edit Customer</h1>
		            <nav>
		                <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
		                    <li class="breadcrumb-item"><a href="Customer.jsp">Customer</a></li>
		                    <li class="breadcrumb-item active">Edit Customer</li>
		                </ol>
		            </nav>
		        </div><!-- End Page Title -->
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Edit Customer</h5>
                            <form action="editCustomer" method="post">
			                    <input type="hidden" name="customer_id_edit" value="<%= customer.getCustomer_id() %>">
			                    <div class="row mb-3">
			                        <label for="Name" class="col-sm-2 col-form-label">Name</label>
			                        <div class="col-sm-10">
			                            <input type="text" class="form-control" id="Name" name="cname_edit" value="<%= customer.getCustomer_fullname() %>">
			                        </div>
			                    </div>
			                    <div class="row mb-3">
			                        <label class="col-sm-2 col-form-label">Birthday</label>
			                        <div class="col-sm-10">
			                            <div class="d-flex">
			                                <input type="number" class="form-control mr-2" id="Day" placeholder="Day" min="1" max="31" name="c_b_day_edit" value="<%= customer.getCustomer_birthday().split("/")[0] %>">
			                                <input type="number" class="form-control mr-2" id="Month" placeholder="Month" min="1" max="12" name="c_b_month_edit" value="<%= customer.getCustomer_birthday().split("/")[1] %>">
			                                <input type="number" class="form-control" id="Year" placeholder="Year" min="1900" max="2100" name="c_b_year_edit" value="<%= customer.getCustomer_birthday().split("/")[2] %>">
			                            </div>
			                        </div>
			                    </div>
			                    <div class="row mb-3">
			                        <label for="Mobile" class="col-sm-2 col-form-label">Mobile</label>
			                        <div class="col-sm-10">
			                            <input type="tel" class="form-control" id="Mobile" name="mphone_edit" value="<%= customer.getCustomer_mobilephone() %>">
			                        </div>
			                    </div>
			                    <div class="row mb-3">
			                        <label for="Email" class="col-sm-2 col-form-label">Email</label>
			                        <div class="col-sm-10">
			                            <input type="email" class="form-control" id="Email" name="email_edit" value="<%= customer.getCustomer_email() %>">
			                        </div>
			                    </div>
			                    <div class="row mb-3">
			                        <label class="col-sm-2 col-form-label">Gender</label>
			                        <div class="col-sm-10">
			                            <div class="form-check form-check-inline">
			                                <input class="form-check-input" type="radio" name="gender_edit" id="Male" value="Nam" <%= customer.getCustomer_gender().equalsIgnoreCase("Nam") ? "checked" : "" %>>
			                                <label class="form-check-label" for="Male">Male</label>
			                            </div>
			                            <div class="form-check form-check-inline">
			                                <input class="form-check-input" type="radio" name="gender_edit" id="Female" value="Nữ" <%= customer.getCustomer_gender().equalsIgnoreCase("Nữ") ? "checked" : "" %>>
			                                <label class="form-check-label" for="Female">Female</label>
			                            </div>
			                            <div class="form-check form-check-inline">
			                                <input class="form-check-input" type="radio" name="gender_edit" id="Other" value="Khác" <%= customer.getCustomer_gender().equalsIgnoreCase("Khác") ? "checked" : "" %>>
			                                <label class="form-check-label" for="Other">Other</label>
			                            </div>
			                        </div>
			                    </div>
			                    <div class="row mb-3">
			                        <label for="Nationality" class="col-sm-2 col-form-label">Nationality</label>
			                        <div class="col-sm-10">
			                            <input type="text" class="form-control" id="Nationality" name="nation_edit" value="<%= customer.getCustomer_nationality() %>">
			                        </div>
			                    </div>
			                    <div class="row mb-3">
			                        <label for="IDNumber" class="col-sm-2 col-form-label">ID Number</label>
			                        <div class="col-sm-10">
			                            <input type="text" class="form-control" id="IDNumber" name="id_number_edit" value="<%= customer.getCustomer_ID_number() %>">
			                        </div>
			                    </div>
			                    <div class="row mb-3">
			                        <label for="Address" class="col-sm-2 col-form-label">Address</label>
			                        <div class="col-sm-10">
			                            <input type="text" class="form-control" id="Address" name="address_edit" value="<%= customer.getCustomer_address() %>">
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
