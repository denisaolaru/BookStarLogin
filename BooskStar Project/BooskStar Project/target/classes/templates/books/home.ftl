[#ftl]
[#import "/spring.ftl" as spring /]
<html lang="en">
<head>
[#include '/nav_bar.ftl']
</head>
<body>

<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="[@spring.url '/images/home/blackfridaybooks.jpg' /]" class="d-block w-100" alt="blackfriday">
    </div>
    <div class="carousel-item">
      <img src="[@spring.url '/images/home/bookgift.jpg' /]" class="d-block w-100" alt="voucher">
    </div>
    <div class="carousel-item">
      <img src="[@spring.url '/images/home/bookfestival.jpg' /]" class="d-block w-100" alt="bookfestival">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only"></span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>

  <div class="column">
  <div class="col-sm">
    <div class="card">
      <div class="card-body">
        <h5  style="font-size:30px; color:green; text-align:center;" class="card-title">Welcome to BookStar! We have more than 20 million titles and free delivery worldwide to over 170 countries.</h5>
        <br></br>
		<p class="card-text" style = "font-size:18px; text-align:center;">Looking for your new favourite book?</p>
		<p class="card-text" style = "font-size:18px; text-align:center;">Browse some of our top categories such as Action, Adventure, Crime, Drama, Fantasy, Horror, Mystery, Poetry, Romance and SF.</p>

      </div>
    </div>
  </div>

</div>

<div class="row">

  <div class="col-sm-4">
  <br></br>
    <div class="card">
      <div class="card-body">
        <h5  style=" color:green; text-align:center;" class="card-title"> <img src = "[@spring.url '/images/home/shipping.png' /]" height = "50" width = "50" allign = "middle"> Free shipping in Romania on orders > 300 RON</h5>
        <p style="text-align:center;"class="card-text"> We will pay for the shipping charges for your order if it is over 300 RON. Orders that receive free shipping usually arrive within 3-5 business days from when the order ships.</p>

      </div>
    </div>
  </div>

  <div class="col-sm-4">
  <br></br>
    <div class="card">
      <div class="card-body">
        <h5 style=" color:green;  text-align:center;" class="card-title" style = "text-align:center;"> <img src="[@spring.url '/images/home/gift.png' /]" height = "50" width = "50" allign = "middle"> Gift wrapping </h5>
        <p  style="text-align:center;" class="card-text" >Thoughtful gift packages for anyone who deserves something lovely tailored just for them.</p>
      </div>
    </div>
  </div>

  <div class="col-sm-4">
  <br></br>
    <div class="card">
      <div class="card-body">
        <h5 style=" color:green; text-align:center; " class="card-title"> <img src="[@spring.url '/images/home/bicycle.png' /]" height = "50" width = "50" allign = "middle">  Bicycle Book Delivery in Bucharest </h5>
        <p style="text-align:center;" class="card-text">If you are in the city limits, we can delivery your book by bicycle. Just place a special order, and when it arrives, let us know you want it delivered by bike! It's a free service that marries our two passions: reading and biking.</p>

      </div>
    </div>
  </div>
</div>
</div>

<div>

</div>


</body>
</html>