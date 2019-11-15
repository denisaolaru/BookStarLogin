[#ftl]
[#import "/spring.ftl" as spring /]
<html lang="en">
<head>
[#include '/nav_bar.ftl']
</head>
<body>



<div class="container">
    <!-- Default panel contents -->
    <div class="panel-heading">Books List:
    </div>

<table>
    <tr>
        <th style="min-width:150px">title</th>
        <th style="min-width:150px">author</th>
        <th style="min-width:150px">genre</th>
        <th style="min-width:150px">language</th>
        <th style="min-width:150px">year</th>
        <th style="min-width:150px">price</th>
        <th style="min-width:150px">path</th>
        <th style="min-width:150px">singlePath</th>
        <th style="min-width:150px"></th>

    </tr>

    [#list books as books]
    <tr>
        <td style="min-width:150px">${books.title}</td>
        <td style="min-width:150px">${books.author}</td>
        <td style="min-width:150px">${books.genre}</td>
        <td style="min-width:150px">${books.language}</td>
        <td style="min-width:150px">${books.year}</td>
        <td style="min-width:150px">${books.price}</td>
        <td style="min-width:150px">${books.photopath}</td>
        <td style="min-width:150px">${books.singlePath}</td>
        <td style="min-width:150px"><a href="/books/add?id=${books.id?c}">Add</a>
        <td style="min-width:150px"><a href="/books/edit?id=${books.id?c}">Edit</a>
            <a href="/books/delete?id=${books.id?c}">Delete</a>
        </td>
    </tr>
    [/#list]
</table>

 </div>
</div>
</div>
</body>
</html>
