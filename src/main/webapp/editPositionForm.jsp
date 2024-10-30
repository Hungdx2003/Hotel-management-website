<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="objects.PositionObject" %>
<%@ page import="cms.position.PositionFunction" %>
<%@ page import="cms.position.PositionFunctionImpl" %>
<%@ page import="util.ConnectionPool" %>
<%@ page import="util.ConnectionPoolImpl" %>
<%@ page import="java.util.*" %>
<%
    String position_id = request.getParameter("positionId");
    ConnectionPool cp = new ConnectionPoolImpl();
    PositionFunction cf = new PositionFunctionImpl(cp);

    PositionObject p = cf.getPosition(Integer.parseInt(position_id));
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
		            <h1>Edit Position</h1>
		            <nav>
		                <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
		                    <li class="breadcrumb-item"><a href="Position.jsp">Position</a></li>
		                    <li class="breadcrumb-item active">Edit Position</li>
		                </ol>
		            </nav>
		        </div><!-- End Page Title -->
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Edit Position</h5>
                            <form action="editPosition" method="post">
			                    <input type="hidden" name="position_id_edit" value="<%= p.getPosition_id() %>">
			                    <div class="row mb-3">
			                        <label for="Name" class="col-sm-2 col-form-label">Name</label>
			                        <div class="col-sm-10">
			                            <input type="text" class="form-control" id="Name" name="name" value="<%= p.getPosition_name() %>">
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
