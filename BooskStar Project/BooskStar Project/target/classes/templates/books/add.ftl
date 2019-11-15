[#ftl]
[#import "/spring.ftl" as spring /]
<html lang="en">
<head>
[#include '/nav_bar.ftl']
</head>
<body>

<div class="container">


<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Edit/Add Employee</h3>
    </div>
    <div class="panel-body">

[#if errors??]
    [#list errors as error]
       <span style="color:red"> ${error}</span>
    <br>
    [/#list]
[/#if]
<form method="post" action="/books/save">

    Title: <input name="title" type="input" value="${books.title!''}">
    <br>
    Author: <input name="author" type="input"  value="${books.author!''}">
    <br>
    Genre: <input name="genre" type="input" value="${books.genre!''}">
    <br>
    Language: <input name="language" type="input"  value="${books.language!''}">
    <br>
    Publication year: <input name="year" type="input"  value="${books.year!''}">
    <br>
    Price: <input name="price" type="input" value="${books.price!''}">
    <br>
    PhotoPath: <input name="photopath" type="input" value="${books.photopath!''}">
    <br>
    SinglePath: <input name="singlePath" type="input" value="${books.singlePath!''}">
        <br>

    [#if books.id??]
        <input name="id" type="hidden" value="${books.id?c}"/>
    [/#if]
    <input value="save" type="submit"/>
</form>

    </div>
</div>
</div>

</body>
</html>




