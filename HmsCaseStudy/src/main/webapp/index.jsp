<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style><%@include file="/css/login.css"%></style></head>
 <body>
<div class = "container" >
<div style="margin-bottom:40px">
<h1> ABC Hospital Management System</h1>
</div>
<form action="<%=request.getContextPath()%>/login" method="post">
<div>
<div  class="form-group">
<label class="form-check-label">User:</label>
<input  class="form-control" type="text" name="login" placeholder="Username">
</div>
<div class="form-group">

<label class="form-check-label">Password:</label>
<input class="form-control" type="text" name="password" placeholder="Password">
</div>
<div>
</div>
<input type="submit" class="btn btn-primary" value="Submit">
</div>

</form></div>
</body> 



</html>
