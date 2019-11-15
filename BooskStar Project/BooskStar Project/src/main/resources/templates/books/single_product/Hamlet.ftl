[#ftl]
[#import "/spring.ftl" as spring /]
<html lang="en">
<head>
[#include '/nav_bar.ftl']
<link rel="stylesheet" href="[@spring.url '/CSS/single_product.css' /]"/>
</head>
<body>


<section class="single-product">
    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <div id="product-slider" class="carousel slide carousel-fade" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                                <img src="[@spring.url '/images/drama/Hamlet.png' /]" class="d-block">
                        </div>
                        <div class="carousel-item">
                                <img src="[@spring.url '/images/drama/Hamlet.png' /]" class="d-block">
                        </div>
                        <div class="carousel-item">
                                <img src="[@spring.url '/images/drama/Hamlet.png' /]" class="d-block ">
                        </div>
                        <a class="carousel-control-prev" href="#product-slider" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                              </a>
                              <a class="carousel-control-next" href="#product-slider" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                              </a>
                    </div>
                </div>
            </div>
                [#list books as books]
                [#if books.id == 16]
                <div class="col-md-7">
                    <p class="new-arrival text-center">NEW</p>
                    <h2> ${books.title} </h2>
                    <p>${books.author}</p>
                    <p>Book ISBN: ISP210657</p>

                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-half-o"></i>



                    <p class="price">${books.price} $</p>
                    <p><strong>Genre:</strong>  ${books.genre}</p>
                    <p><b>Language:</b>  ${books.language} </p>
                    <p><b>Publication Year:</b>  ${books.year}</p>
                    <label>Quantity:</label>
                    <input type="text" value="1">
                    <button type="button" class="btn btn-primary"> Add to Cart</button>
                    [/#if]
                    [/#list]
            </div>
        </div>
    </div>
</section>

<section class="product-description">
    <div class="container">
        <h6>Product Description</h6>
        <p> This book is very good please buy it i need money</p>
        <p> This book is very good please buy it i need money</p>

        <hr>
    </div>

</section>
</body>
</html>