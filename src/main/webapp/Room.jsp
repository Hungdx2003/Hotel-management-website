<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="objects.Room" %>
<%@page import="java.util.ArrayList" %>
<%@page import="cms.room.RoomFunction" %>
<%@page import="cms.room.RoomFunctionImpl" %>
<%@page import="util.ConnectionPool" %>
<%@page import="util.ConnectionPoolImpl" %>
<%@ page import="objects.EmployeeObject" %>
<%@ page import="cms.employee.EmployeeFunction" %>
<%@ page import="cms.employee.EmployeeFunctionImpl" %>
<%
	ConnectionPool cp = new ConnectionPoolImpl();
	RoomFunction r = new RoomFunctionImpl(cp);
	EmployeeFunction e=new EmployeeFunctionImpl(cp);
%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Customer</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/logo_ma.png" rel="icon">
  <link href="assets/img/logo_ma.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">
  
  <link rel="stylesheet" href="assets/css/form.css">
  
  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
  
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.jsp" class="logo d-flex align-items-center">
        <img src="assets/img/logo_ma.png" alt="">
        <span class="d-none d-lg-block">The Mecure </span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
      <form class="search-form d-flex align-items-center" method="POST" action="#">
        <input type="text" name="query" placeholder="Search" title="Enter search keyword">
        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
      </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <%
			HttpSession userSession = request.getSession();
			EmployeeObject loggedInUser = (EmployeeObject) userSession .getAttribute("loggedInUser");
			
			if (loggedInUser != null) {	
				String rs=e.getPositionNameByID(Integer.parseInt(loggedInUser.getEmployee_position_id()));
		%>
        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->

        <li class="nav-item dropdown">

          <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
            <i class="bi bi-bell"></i>
            <span class="badge bg-primary badge-number">4</span>
          </a><!-- End Notification Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
            <li class="dropdown-header">
              You have 4 new notifications
              <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-exclamation-circle text-warning"></i>
              <div>
                <h4>Lorem Ipsum</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>30 min. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-x-circle text-danger"></i>
              <div>
                <h4>Atque rerum nesciunt</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>1 hr. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-check-circle text-success"></i>
              <div>
                <h4>Sit rerum fuga</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>2 hrs. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-info-circle text-primary"></i>
              <div>
                <h4>Dicta reprehenderit</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>4 hrs. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>
            <li class="dropdown-footer">
              <a href="#">Show all notifications</a>
            </li>

          </ul><!-- End Notification Dropdown Items -->

        </li><!-- End Notification Nav -->
        <li class="nav-item dropdown">

          <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
            <i class="bi bi-chat-left-text"></i>
            <span class="badge bg-success badge-number">3</span>
          </a><!-- End Messages Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
            <li class="dropdown-header">
              You have 3 new messages
              <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="message-item">
              <a href="#">
                <img src="assets/img/messages-1.jpg" alt="" class="rounded-circle">
                <div>
                  <h4>Maria Hudson</h4>
                  <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                  <p>4 hrs. ago</p>
                </div>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="message-item">
              <a href="#">
                <img src="assets/img/messages-2.jpg" alt="" class="rounded-circle">
                <div>
                  <h4>Anna Nelson</h4>
                  <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                  <p>6 hrs. ago</p>
                </div>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="message-item">
              <a href="#">
                <img src="assets/img/messages-3.jpg" alt="" class="rounded-circle">
                <div>
                  <h4>David Muldon</h4>
                  <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                  <p>8 hrs. ago</p>
                </div>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="dropdown-footer">
              <a href="#">Show all messages</a>
            </li>

          </ul><!-- End Messages Dropdown Items -->

        </li><!-- End Messages Nav -->
        <li class="nav-item dropdown pe-3">

           <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
            <img src="assets/img/avatar.jpg" alt="Profile" class="rounded-circle">
            <span class="d-none d-md-block dropdown-toggle ps-2"><%=loggedInUser.getEmployee_full_name()%></span>
          </a><!-- End Profile Iamge Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
            <li class="dropdown-header">
              <h6><%=loggedInUser.getEmployee_full_name()%></h6>
              <span><%= rs != null ? rs : "Default Position"%></span>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>My Profile</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                <i class="bi bi-gear"></i>
                <span>Account Settings</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
                <i class="bi bi-question-circle"></i>
                <span>Need Help?</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="Login.jsp">
                <i class="bi bi-box-arrow-right"></i>
                <span>Sign Out</span>
              </a>
            </li>
			<%
				}else{
         	%>
         	<li class="nav-item dropdown pe-3"><a type="button" class="btn btn-outline-primary" href="Login.jsp">Login</a></li>
         	<%
				}
         	%>

          </ul><!-- End Profile Dropdown Items -->
        </li><!-- End Profile Nav -->

      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->
		<%
			if (loggedInUser != null) {	
		%>
  <!-- ======= Sidebar ======= -->
 <aside id="sidebar" class="sidebar">
      <ul class="sidebar-nav" id="sidebar-nav">
		<li class="nav-item">
	        <a class="nav-link collapsed" href="index.jsp">
	          <i class="bi bi-grid"></i>
	          <span>Home</span>
	        </a>
	      </li><!-- End Dashboard Nav -->
	      
      <li class="nav-item">
        <a class="nav-link collapsed" href="Employee.jsp">
          <i class="bi bi-people"></i>
          <span>Employee</span>
        </a>
      </li><!-- End Employee Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="Position.jsp">
          <i class="bx bx-bookmark"></i>
          <span>Position</span>
        </a>
      </li><!-- End Position Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="Customer.jsp">
          <i class="bi bi-person-circle"></i>
          <span>Customer</span>
        </a>
      </li><!-- End Customer Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="Booking.jsp">
          <i class="bx bx-table"></i>
          <span>Booking</span>
        </a>
      </li><!-- End Employee Nav -->
      
      <li class="nav-item">
        <a class="nav-link" href="Room.jsp">
          <i class="bx bx-door-open"></i>
          <span>Room</span>
        </a>
      </li><!-- End Room Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="RoomType.jsp">
          <i class="bx bx-bookmarks"></i>
          <span>Room Type</span>
        </a>
      </li><!-- End Room_type Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="Service.jsp">
          <i class="bi bi-bag"></i>
          <span>Service</span>
        </a>
      </li><!-- End Service Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="Invoice.jsp">
          <i class="bx bx-receipt"></i>
          <span>Invoice</span>
        </a>
      </li><!-- End Involve Nav -->
	</ul>
  </aside><!-- End Sidebar-->

  <main id="main" class="main">
 <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title"> <b>PHÒNG </b></h5>
                 <button type="button" class="btn btn-primary add-btn" id="openModalAddBtn">
                <i class="bi bi-plus-circle"></i> Add
              </button>
              <!-- Table with stripped rows -->
              <table class="table datatable">
                <thead>
                  <tr>
                    <th>Mã phòng</th>
                    <th>Loại phòng</th>
                    <th>Giá</th>
                    <th>Tình trạng</th>
                    <th>Số giường</th> 
                    <th>Các tiện ích đi kèm</th>
                    <th>Thao tác</th>
                  </tr>
                </thead>
                 <tbody>
                 <%
				    ArrayList<Room> roomList = r.displayAllItem();
                   for (Room c : roomList) {
				%>
				    <tr>
				        <td><%= c.getRoomID() %></td>
				        <td><%= c.getRoomTypeID() %></td>
				        <td><%= c.getPrice() %></td>
				        <td><%= c.getStatus() %></td>
				        <td><%= c.getNumberOfBeds() %></td>
				        <td><%= c.getAmentities() %></td>
				        <td>
				            <button type="button" class="btn btn-sm btn-info view-btn" data-object-id="<%= c.getRoomID() %>"  id="openModalViewBtn">
				                <i class="bi bi-eye"></i> Xem
				            </button>
				             <button type="button" class="btn btn-sm btn-info edit-btn" data-object-id="<%= c.getRoomID() %>" id="openModalEditBtn">
				                <i class="bi bi-pencil"></i> Sửa
				            </button>
				            <button type="button" class="btn btn-sm btn-danger delete-btn" data-object-id="<%= c.getRoomID() %>"  id="openModalDelBtn">
				                <i class="bi bi-trash"></i> Xóa
				            </button>
				        </td>
				    </tr>
				<%
				    }
				%>
                </tbody> 
              </table>
              <!-- End Table with stripped rows -->
                </div>
          </div>
        </div>
      </div>
      
    </section>
   <!-- add modal -->
     <div id="myModalAdd" class="modal">
    <div class="modal-content">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title ">THÊM PHÒNG</h5>
          
          <form action="addRoom" method="post">
          <div class="row mb-3">
              <label for="inputPrice" class="col-sm-2 col-form-label">Loại phòng(*)</label>
              <div class="col-sm-10">
                <input type="number" class="form-control" id="inputRoomType" name="roomTypeID">
             </div>
            </div>

            <div class="row mb-3">
              <label for="inputPrice" class="col-sm-2 col-form-label">Giá(*)</label>
              <div class="col-sm-10">
                <input type="number" class="form-control" id="inputPrice" name="price">
             </div>
            </div>
            
            <div class="row mb-3">
              <label for="inputStatus" class="col-sm-2 col-form-label">Tình trạng phòng(*)</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="inputStatus" name="status">
               </div>
              </div>
              
             <div class="row mb-3">
              <label for="inputImage" class="col-sm-2 col-form-label">Ảnh(*)</label>
              <div class="col-sm-10">
                <input type="url" class="form-control" id="inputImage" name="image">
              </div>
              </div>
              
              <div class="row mb-3">
	            <label for="inputReview" class="col-sm-2 col-form-label">Review</label>
	            <div class="col-sm-10">
	             <input type="text" class="form-control" id="inputReview" name="reviews">
	             </div>
	            </div> 

				<div class="row mb-3">
	            <label for="inputFloor" class="col-sm-2 col-form-label">Tầng(*)</label>
	            <div class="col-sm-10">
	             <input type="number" class="form-control" id="inputFloor" name="floorRoom">
	             </div>
	            </div>  

            <div class="row mb-3">
            <label for="inputNumberOfBeds" class="col-sm-2 col-form-label">Số giường(*)</label>
            <div class="col-sm-10">
            <input type="number" class="form-control" id="inputNumberOfBeds" name="numberOfBeds">
            </div>
            </div>
            
            <div class="row mb-3">
            <label for="inputMaxOccupancy" class="col-sm-2 col-form-label">Số người tối đa(*)</label>
            <div class="col-sm-10">
            <input type="number" class="form-control" id="inputMaxOccupancy" name="maxOccupancy">
            </div>
            </div>
            
            <div class="row mb-3">
            <label for="inputArea" class="col-sm-2 col-form-label">Diện tích(*)</label>
            <div class="col-sm-10">
            <input type="number" class="form-control" id="inputArea" name="area">
            </div>
            </div>
            
            
            <div class="row mb-3">
            <label for="inputAmentities" class="col-sm-2 col-form-label">Tiện ích(*)</label>
            <div class="col-sm-10">
             <input type="text" class="form-control" id="inputAmentities" name="amentities">
             </div>
            </div>  
            
            <div class="row mb-3">
            <label for="inputPhone" class="col-sm-2 col-form-label">Số điện thoại nội bộ</label>
            <div class="col-sm-10">
             <input type="tel" class="form-control" id="inputPhone" name="numberPhoneExtension">
             </div>
            </div>  
            
            <div class="row mb-3">
            <label for="inputBookingHistory" class="col-sm-2 col-form-label">Lịch sử đặt phòng(*)</label>
            <div class="col-sm-10">
             <input type="text" class="form-control" id="inputBookingHistory" name="bookingHistory">
             </div>
            </div>  
            
            <div class="text-center">
              <button type="submit" class="btn btn-primary ">Submit</button>
              <button type="reset" class="btn btn-secondary">Reset</button>
              <button type="button" class="btn btn-danger close-modal">Cancel</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  
	
	<!-- delete modal -->
	<!-- Del Modal  -->
	<div id="myModalDel" class="modal">
		  <div class="modal-content small-modal">
		    <div class="card">
		      <div class="card-body">
		        <h5 class="card-title"><i class="ri-error-warning-line"></i>  Notification</h5>
		        <p>Are you sure you want to delete this room?</p>
		        <div class="text-center">
		          <form action="delRoom" method="post" class="d-inline">
		            <input type="hidden" id="room_id_del" name="room_id_del" value="0">
		            <button type="submit" class="btn btn-primary mr-2 d-inline-block close-modal" id="confirmDelete">Yes</button>
		          </form>
		          <button type="button" class="btn btn-danger d-inline-block close-modal" id="cancelDelete">No</button>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
 
 </main>
<%}else{ %>
	<aside id="sidebar" class="sidebar">
      <ul class="sidebar-nav" id="sidebar-nav">
		<li class="nav-item">
	        <a class="nav-link collapsed" >
	          <i class="bi bi-grid"></i>
	          <span>Home</span>
	        </a>
	      </li><!-- End Dashboard Nav -->
	      
      <li class="nav-item">
        <a class="nav-link collapsed" >
          <i class="bi bi-people"></i>
          <span>Employee</span>
        </a>
      </li><!-- End Employee Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" >
          <i class="bx bx-bookmark"></i>
          <span>Position</span>
        </a>
      </li><!-- End Position Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" >
          <i class="bi bi-person-circle"></i>
          <span>Customer</span>
        </a>
      </li><!-- End Customer Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" >
          <i class="bx bx-table"></i>
          <span>Booking</span>
        </a>
      </li><!-- End Employee Nav -->
      
      <li class="nav-item">
        <a class="nav-link " >
          <i class="bx bx-door-open"></i>
          <span>Room</span>
        </a>
      </li><!-- End Room Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" >
          <i class="bx bx-bookmarks"></i>
          <span>Room Type</span>
        </a>
      </li><!-- End Room_type Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" >
          <i class="bi bi-bag"></i>
          <span>Service</span>
        </a>
      </li><!-- End Service Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" >
          <i class="bx bx-receipt"></i>
          <span>Invoice</span>
        </a>
      </li><!-- End Involve Nav -->
	</ul>
  </aside><!-- End Sidebar-->
    <main id="main" class="main">

    <section class="section">
      <div class="row">
        <div >

       <section class="section error-404 min-vh-100 d-flex flex-column align-items-center justify-content-center">
        <h1>The Mecure</h1>
        <h2>Raise the level of hotel services.</h2>
        <img src="assets/img/not-found.svg" class="img-fluid py-5" alt="Page Not Found">
      </section>

        </div>
      </div>
    </section>
  </main>
  <%} %>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/chart.js/chart.umd.js"></script>
  <script src="assets/vendor/echarts/echarts.min.js"></script>
  <script src="assets/vendor/quill/quill.js"></script>
  <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  <script type="text/javascript">
  // Function to show modal based on button click
  function showModal(modalId) {
    var modal = document.querySelector('#' + modalId);
    console.log('Hàm myFunction đã được gọi.1');
    modal.style.display = 'block';
  }

  // Function to close modal
  function closeModal(modalId) {
    var modal = document.querySelector('#' + modalId);
    console.log('Hàm myFunction đã được gọi.2');
    modal.style.display = 'none';
  }
  // Hàm sửa
 document.querySelectorAll('.edit-btn').forEach(function(button) {
	    button.addEventListener('click', function() {
	    	var roomId = this.getAttribute('data-object-id');
	      window.location.href = "editRoomForm.jsp?roomId=" + roomId;
	    });
	  });
  // Hàm thêm
 document.getElementById('openModalAddBtn').addEventListener('click', function() {
	 console.log('Hàm myFunction đã được gọi.4');
    showModal('myModalAdd');
  	});
  
	
  //Hàm xóa
  document.querySelectorAll('.delete-btn').forEach(function(button) {
	    button.addEventListener('click', function() {
	      showModal('myModalDel');
	      document.getElementById('room_id_del').value=this.getAttribute('data-object-id');
	    });
	  });
 

  // Event listeners for closing modals
  document.querySelectorAll('.close-modal').forEach(function(button) {
    button.addEventListener('click', function() {
      var modalId = this.closest('.modal').id;
      closeModal(modalId);
    });
  });

  // Close modal if clicked outside of it
  window.onclick = function(event) {
    if (event.target.classList.contains('modal')) {
      closeModal(event.target.id);
    }
  };
</script>
</body>

</html>