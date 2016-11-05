<%@page import="br.com.app.ServletProdutoList"%>
<%@page import="br.com.modelo.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho de Compras</title>
        <!-- CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <h1 style="text-align: center"><span class="label label-danger">Carrinho de Compra</span></h1>
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="LoginSenha.jsp">Entrar</a></li>
            </ul>
        </nav>

        <div class="panel panel-danger" style="width: 90%; position: absolute; left: 5%;">
            <div class="panel-heading">Produtos no carrinho</div>
            <table class="table table-bordered">

                <%
                    HttpSession sessao = request.getSession();
                    ArrayList<Produto> produtos = (ArrayList) sessao.getAttribute("produtos");
                    if (produtos != null) {
                %>
                <tr>
                    <th>Descrição</th> <th>Informação</th> <th>Valor</th> <th>Quantidade</th> <th>Sub-Total</th> <th>Remover</th>
                </tr>
                <%
                    for (Produto p : produtos) {
                %>

                <tr>
                    <td><%= p.getDescricao()%></td> 
                    <td><%= p.getInformacao()%></td> 
                    <td><%= p.getValor()%></td> 
                    <td><%=p.getQuantidade()%></td>
                    <td><%= p.getValor() * p.getQuantidade()%></td>
                    <td> 
                        <form action="ServletProdutoList?acao=remov&id=<%=p.getId()%>" method="post">
                            <button type="submit" class="btn btn-danger">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </button>
                        </form>
                    </td>
                </tr>
                <%}%> 
            </table>
            <div style="text-align: right">
                <form action="ServletPedido" method="post">
                    <button type="submit" class="btn btn-default btn-lg">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Finalizar Compra
                    </button>
                </form>    
            </div>
        </div>
        <%} else {%>
        <br/><h2>Carrinho Vazio!</h2><br/>
        <%}%> 
    </body>
</html>
