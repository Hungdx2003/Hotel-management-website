<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="objects.Room" %>
<%@ page import="cms.room.RoomFunction" %>
<%@ page import="cms.room.RoomFunctionImpl" %>
<%@ page import="util.ConnectionPool" %>
<%@ page import="util.ConnectionPoolImpl" %>
<%@ page import="java.util.*" %>
<%
    String room_id = request.getParameter("roomId");
    ConnectionPool cp = new ConnectionPoolImpl();
    RoomFunction rf = new RoomFunctionImpl(cp);
    Room er=rf.selectById(Integer.parseInt(room_id));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link href="assets/img/logo_ma.png" rel="icon">
  	<link href="assets/img/logo_ma.png" rel="apple-touch-icon">
    <title>Edit Room</title>
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
		            <h1>Edit Room</h1>
		            <nav>
		                <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
		                    <li class="breadcrumb-item"><a href="Room.jsp">Room</a></li>
		                    <li class="breadcrumb-item active">Edit Room</li>
		                </ol>
		            </nav>
		        </div><!-- End Page Title -->
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">CHỈNH SỬA PHÒNG </h5>
	                <form action="editRoom" method="post">
	                	
	                    <input type="hidden" id="editRoomId" name="roomId" value="<%= er.getRoomID() %>">
	                    
	                    <div class="row mb-3">
              <label for="inputPrice" class="col-sm-2 col-form-label">Loại phòng(*)</label>
              <div class="col-sm-10">
                <input type="number" class="form-control" id="inputRoomType" name="roomTypeID" value="<%= er.getRoomTypeID() %>">
             </div>
            </div>
	
	                    <div class="row mb-3">
              <label for="inputPrice" class="col-sm-2 col-form-label">Giá(*)</label>
              <div class="col-sm-10">
                <input type="number" class="form-control" id="inputPrice" name="price1" value="<%= er.getPrice() %>">
             </div>
            </div>
            
            <div class="row mb-3">
              <label for="inputStatus" class="col-sm-2 col-form-label">Tình trạng phòng(*)</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="inputStatus" name="status1" value="<%= er.getStatus() %>">
               </div>
              </div>
              
             <div class="row mb-3">
              <label for="inputImage" class="col-sm-2 col-form-label">Ảnh(*)</label>
              <div class="col-sm-10">
                <input type="url" class="form-control" id="inputImage" name="image1" value="<%= er.getImage() %>">
              </div>
              </div>
              
              <div class="row mb-3">
	            <label for="inputReview" class="col-sm-2 col-form-label">Review</label>
	            <div class="col-sm-10">
	             <input type="text" class="form-control" id="inputReview" name="review1" value="<%= er.getReviews() %>">
	             </div>
	            </div> 

				<div class="row mb-3">
	            <label for="inputFloor" class="col-sm-2 col-form-label">Tầng(*)</label>
	            <div class="col-sm-10">
	             <input type="number" class="form-control" id="inputFloor" name="floor1" value="<%= er.getFloorRoom() %>">
	             </div>
	            </div>  

            <div class="row mb-3">
            <label for="inputNumberOfBeds" class="col-sm-2 col-form-label">Số giường(*)</label>
            <div class="col-sm-10">
            <input type="number" class="form-control" id="inputNumberOfBeds" name="numberOfBeds1" value="<%= er.getNumberOfBeds() %>">
            </div>
            </div>
            
            <div class="row mb-3">
            <label for="inputMaxOccupancy" class="col-sm-2 col-form-label">Số người tối đa(*)</label>
            <div class="col-sm-10">
            <input type="number" class="form-control" id="inputMaxOccupancy" name="maxOccupancy1" value="<%= er.getMaxOccupancy() %>">
            </div>
            </div>
            
            <div class="row mb-3">
            <label for="inputArea" class="col-sm-2 col-form-label">Diện tích(*)</label>
            <div class="col-sm-10">
            <input type="number" class="form-control" id="inputArea" name="area1" value="<%= er.getArea() %>">
            </div>
            </div>
            
            
            <div class="row mb-3">
            <label for="inputAmentities" class="col-sm-2 col-form-label">Tiện ích(*)</label>
            <div class="col-sm-10">
             <input type="text" class="form-control" id="inputAmentities" name="amentities1" value="<%= er.getAmentities() %>">
             </div>
            </div>  
            
            <div class="row mb-3">
            <label for="inputPhone" class="col-sm-2 col-form-label">Số điện thoại nội bộ</label>
            <div class="col-sm-10">
             <input type="tel" class="form-control" id="inputPhone" name="phone1" value="<%= er.getNumberPhoneExtension() %>">
             </div>
            </div>  
            
            <div class="row mb-3">
            <label for="inputBookingHistory" class="col-sm-2 col-form-label">Lịch sử đặt phòng(*)</label>
            <div class="col-sm-10">
             <input type="text" class="form-control" id="inputBookingHistory" name="bookingHistory1" value="<%= er.getBookingHistory() %>">
             </div>
            </div>  
	
	                    <!-- Add other fields as needed for editing -->
	
	                    <div class="text-center">
	                        <button type="submit" class="btn btn-primary ">Cập nhật</button>
	                        <button type="button" class="btn btn-danger " onclick="window.history.back()">Hủy</button>
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
