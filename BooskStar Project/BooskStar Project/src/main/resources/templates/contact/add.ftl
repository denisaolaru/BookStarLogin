
[#ftl]
[#import "/spring.ftl" as spring /]
<html lang="en">

<head>
	<title>BookStar</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<style>
.right {
  float: middle;
  width: 1000px;
  padding: 100px;
  margin: auto;
}
.content {
  max-width: 1000px;
  margin: auto;
  background-image: linear-gradient(rgba(0.5, 0.5, 0.5, 0.5), rgba(0.5, 0.5, 0.5, 0.5));
  }
  body {
  background-image: url("../images/books.jpeg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;}
  .footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
}

 </style>
</head>
<body>
	<div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" a href="/home"><font size="6"><font color="green">BookStar</a></font></font>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">


      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Shop by category
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" a href="/action">Action</a>
                  <a class="dropdown-item" a href="/adventure">Adventure</a>
                  <a class="dropdown-item" a href="/crime">Crime</a>
                  <a class="dropdown-item" a href="/drama">Drama</a>
                  <a class="dropdown-item" a href="/fantasy">Fantasy</a>
                  <a class="dropdown-item" a href="/horror">Horror</a>
                  <a class="dropdown-item" a href="/mystery">Mystery</a>
                  <a class="dropdown-item" a href="/poetry">Poetry</a>
        		  <a class="dropdown-item" a href="/romance">Romance</a>
        		  <a class="dropdown-item" a href="#">SF</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#"></a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" a href="/releases">New Releases</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" a href="/contact">Contact</a>
      </li>
    </ul>



    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class= "btn btn-outline-success my-2 my-sm-0" type="submit"> Search </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    </form>
  </div>
      <div>
     <a href="/cart" class="btn btn-success">Cart</a>

       </div>&nbsp;&nbsp;
       <div>
    <a href="/login" class="btn btn-primary">Login</a>

       </div>
</nav>
</div>
<div class="content">
<div class="right">
<!--Section: Contact v.2-->
<section class="mb-4">
<font color="white">
    <!--Section heading-->
    <h2 class="h1-responsive font-weight-bold text-center my-4">Contact us</h2>
    <!--Section description-->
    <p class="text-center w-responsive mx-auto mb-5">Do you have any questions? Please do not hesitate to contact us directly. Our team will come back to you within
        a matter of hours to help you.</p>


<form method="post" action="/contact/save">
    <div class="row">

        <!--Grid column-->
        <div class="col-md-9 mb-md-0 mb-5">
            <form id="contact-form" name="contact-form" action="mail.php" method="POST">

                <!--Grid row-->
                <div class="row">

                    <!--Grid column-->
                    <div class="col-md-6">
                        <div class="md-form mb-0">
                            <input type="text" id="name" name="name" class="form-control">
                            <label for="name" class="">Your name</label>
                        </div>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-md-6">
                        <div class="md-form mb-0">
                            <input type="text" id="email" name="email" class="form-control">
                            <label for="email" class="">Your email</label>
                        </div>
                    </div>
                    <!--Grid column-->

                </div>
                <!--Grid row-->

                <!--Grid row-->
                <div class="row">
                    <div class="col-md-12">
                        <div class="md-form mb-0">
                            <input type="text" id="subject" name="subject" class="form-control">
                            <label for="subject" class="">Subject</label>
                        </div>
                    </div>
                </div>
                <!--Grid row-->

                <!--Grid row-->
                <div class="row">

                    <!--Grid column-->
                    <div class="col-md-12">

                        <div class="md-form">
                            <textarea type="text" id="message" name="message" rows="2" class="form-control md-textarea"></textarea>
                            <label for="message">Your message</label>
                        </div>

                    </div>
                </div>
                <!--Grid row-->

            </form>

            <div class="text-center text-md-left">
              <center><input value="Send" type="submit"/></center>

            </div>

            <div class="status"></div>
        </div></center>
        <!--Grid column-->

        <!--Grid column-->
        <div class="col-md-3 text-center">
            <ul class="list-unstyled mb-0">
                <li><i class="fas fa-map-marker-alt fa-2x"></i>
                    <p>Cluj Napoca, Romania</p>
                </li>

                <li><i class="fas fa-phone mt-4 fa-2x"></i>
                    <p>0264 222 432</p>
                </li>

                <li><i class="fas fa-envelope mt-4 fa-2x"></i>
                    <p>contact@bookstar.com</p>
                </li>
            </ul>
        </div>


    </div>
</div>
</section>
</div>
</font>

[#if errors??]
    [#list errors as error]
       <span style="color:red"> ${error}</span>
    <br>
    [/#list]
[/#if]



    [#if contact.id??]
        <input name="id" type="hidden" value="${contact.id?c}"/>
    [/#if]

</form>




<div class="footer">
  <h5>"A room without books is like a body without a soul."<h5>
  <i> Marcus Tullius Cicero</i>
</div>
</body>
</html>