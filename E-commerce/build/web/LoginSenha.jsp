<%@page import="br.com.app.ServletLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrar</title>
        <!-- CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <h1 style="text-align: center"><span class="label label-danger">START</span></h1>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Entrar</a></li>
            </ul>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <div class="account-wall">
                        <img class="profile-img" src="img/profile.jpg"
                             alt="">
                        <form class="form-signin" action="ServletLogin?tela=<%=request.getParameter("tela")%>" method="post">
                            <input type="text" class="form-control" name="usuario" placeholder="Usuário" required autofocus>
                            <input type="password" class="form-control" name="senha" placeholder="Senha" required>
                            <button class="btn btn-lg btn-danger btn-block" type="submit">Entrar</button> </br>
                     
                            <% if (request.getAttribute("erro") != null && !request.getAttribute("erro").equals("")) {%>
                            <div class="alert alert-danger">
                                <strong><%= request.getAttribute("erro")%></strong> 
                            </div>
                            <% }%>  
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
