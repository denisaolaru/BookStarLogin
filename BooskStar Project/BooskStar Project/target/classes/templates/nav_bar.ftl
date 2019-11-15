[#ftl]
[#import "/spring.ftl" as spring /]
<html lang="en">
<head>
[#include '/bootstrap_header.ftl']
</head>
<body>
	<div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/books/all">BookStar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>

  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" a href="/home/">Home <span class="sr-only">(current)</span></a>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Books
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" a href="/books/all">All</a>
          <a class="dropdown-item" a href="/books/adventure">Adventure</a>
          <a class="dropdown-item" a href="/books/drama">Drama</a>
          <a class="dropdown-item" a href="/books/fantasy">Fantasy</a>
          <a class="dropdown-item" a href="/books/horror">Horror</a>
          <a class="dropdown-item" a href="/books/mystery">Mystery</a>
          <a class="dropdown-item" a href="/books/poetry">Poetry</a>
          <a class="dropdown-item" a href="/books/romance">Romance</a>
          <a class="dropdown-item" a href="/books/SF">Science-Fiction</a>

          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Audio Books</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">New Releases</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" a href="/books/contact">Contact</a>
      </li>
    </ul>
    <form method="get" action="/books/search">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" ">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

   </form>
  </div>
<div>

<button type="button" class="btn btn-success">Cart</button>
   </div>&nbsp;&nbsp;
   <div>
   <button type="button" class="btn btn-primary">Log In </button>
   </div>
</nav>
</div>
</div>
</body>
</html>

