[#ftl]
[#import "/spring.ftl" as spring /]
<html lang="en">
<head>
[#include '/nav_bar.ftl']
<link rel="stylesheet" href="[@spring.url '/CSS/BookstarCSS.css' /]"/>
</head>
<body>

<section class = "table-rows">
<div class="container">
  <div class="title-box">
    <h2>Romance Books</h2>
  </div>
  <div class="row">

    [#list books as books]
    <div class="col-md-3">
      <div class="product-top">
        <a href="/books/product"> <img src="[@spring.url '${books.photopath}' /]">
        <div class="overlay-right">
          <button type="button" class="btn btn-secondary" title="Quick Shop">
          <i class="fa fa-eye"></i>
          </button>
          <button type="button" class="btn btn-secondary" title="Add to Wishlist">
          <i class="fa fa-heart-o"></i>
          </button>
          <button type="button" class="btn btn-secondary" title="Add to Cart">
          <i class="fa fa-shopping-cart"></i>
          </button>
        </div>
      </div>
      <div class="product-bottom text-center">
        <i class="fa fa-star"></i>
        <i class="fa fa-star"></i>
        <i class="fa fa-star"></i>
        <i class="fa fa-star"></i>
        <i class="fa fa-star-half-o"></i>
        <h3>${books.title}</h3>
        <h5>${books.author}</h5>
        <h5>${books.price} $</h5>
      </div>
    </div>
    [/#list]

  </div>
</div>
</section>
</body>
</html>