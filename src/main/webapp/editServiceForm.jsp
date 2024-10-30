<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="objects.ServiceObject" %>
<%@ page import="cms.ServiceFunction" %>
<%@ page import="cms.ServiceFunctionImpl" %>
<%@ page import="util.ConnectionPool" %>
<%@ page import="util.ConnectionPoolImpl" %>
<%@ page import="java.util.*" %>
<%
    String service_id = request.getParameter("serviceId");
    ConnectionPool cp = new ConnectionPoolImpl();
    ServiceFunction cf = new ServiceFunctionImpl(cp);

    ServiceObject s = cf.getService(Integer.parseInt(service_id));
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
		            <h1>Edit Service</h1>
		            <nav>
		                <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
		                    <li class="breadcrumb-item"><a href="Service.jsp">Service</a></li>
		                    <li class="breadcrumb-item active">Edit Service</li>
		                </ol>
		            </nav>
		        </div><!-- End Page Title -->
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Edit Service</h5>
                            <form action="editService" method="post">
			                    <input type="hidden" name="service_id_edit" value="<%= s.getService_id() %>">
			                    <div class="row mb-3">
			                        <label for="Name" class="col-sm-2 col-form-label">Name</label>
			                        <div class="col-sm-10">
			                            <input type="text" class="form-control" id="Name" name="sname_edit" value="<%= s.getService_name() %>">
			                        </div>
			                    </div>
			                    <div class="row mb-3">
						              <label for="inputPrice" class="col-sm-2 col-form-label">Price</label>
						              <div class="col-sm-10">
						                <input type="tel" class="form-control" id="inputPrice" name="price_edit" value="<%= s.getPrice() %>">
						              </div>
						            </div>
						            <div class="row mb-3">
						              <label for="inputDescription" class="col-sm-2 col-form-label">Description</label>
						              <div class="col-sm-10">
						                <textarea class="form-control" id="description" name="description_edit" rows="3"><%= s.getDescription() %></textarea>
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
