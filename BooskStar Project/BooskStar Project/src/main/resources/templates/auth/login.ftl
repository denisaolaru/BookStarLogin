[#ftl]

[#import "/spring.ftl" as spring /]
<head>
[#include '/nav_bar.ftl']

 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link  href="[@spring.url '/CSS/BookstarCSS.css' /]" rel="stylesheet">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="[@spring.url '/js/bootstrap.min.js' /] "></script>



</head>
[#escape x as x?html]

	<div class="container">

		<ol class="breadcrumb">
			<li><a href="/books/all">Home</a></li>
			<li><a href="/books/contact">User</a></li>
			<li class="active">Login</li>
		</ol>

		<div class="panel panel-default" style="margin-left:auto; margin-right:auto; width:400px">


			<div class="panel-body">

			    [#if RequestParameters.error??]
				    <div>
				        <ul>
				                <b style="color:red">
								[@spring.message 'invalid.username'/]
				                </b>

				        </ul>
				    </div>
				[/#if]


				<form action="/login" method="POST">
					<div class="form-group">
						<label for="firstName">Username</label>
						<input type="text"
							class="form-control" id="username" name="username"
							placeHolder="Username" "/>
					</div>
					<div class="form-group">
						<label for="lastName">Password</label>
						<input type="password"
							class="form-control" id="password" name="password"
							placeHolder="Password" />
					</div>


					<div class="container-fluid">
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav navbar-right">

								<li><button type="submit" class="btn btn-default">LOGIN</button></li>
							</ul>
						</div>
					</div>
					<br /> <input type="submit" class="form-control" id="id" value="login" />
			</form>
			</div>
		</div>
	</div>



[/#escape]