<%@page import="br.com.DAO.ProdutoDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="br.com.modelo.Produto"%>
<%@page import="br.com.controller.LoginController"%>

<% if (LoginController.estaLogado(request)) { %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Produtos</title>
        <!-- CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/custom.css">
    </head>

    <nav class="navbar navbar-inverse">
        <h1 style="text-align: center"><span class="label label-danger">Produtos</span></h1>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Listagem de produtos</a></li>
        </ul>
    </nav> 

    <div style="text-align: center">
        <button type="submit" class="btn btn-danger" onclick="location.href = 'CadastroProduto.jsp?acao=cadastrar'">
            <span class="glyphicon glyphicon-file" aria-hidden="true"></span> Cadastrar Produto
    </div> <br/>   

    <div class="panel panel-danger" style="width: 80%; position: absolute; left: 10%">
        <%if (request.getAttribute("ok") != null && !request.getAttribute("ok").equals("")) {%>
        <div class="alert alert-danger">
            <strong><%= request.getAttribute("ok")%></strong> 
        </div>
        <%}%>
        <div class="panel-heading">Listagem de produtos</div>
        <table class="table table-bordered">
            <tr>
                <th>Descrição</th> <th>Informação</th> <th>Valor</th> <th>Alterar</th> <th>Remover</th>  
            </tr>
            <%
                ProdutoDAO produtodao = new ProdutoDAO();
                ResultSet rs = produtodao.consultarProdutos();
                while (rs.next()) {
                    String id = rs.getString("id");
                    String descricao = rs.getString("descricao");
                    String informacao = rs.getString("informacao");
                    String valor = rs.getString("valor");
            %>
            <tr> 
                <td><%=descricao%></td> 
                <td><%=informacao%></td> 
                <td><%=valor%></td>
                <td> 
                    <a href = "CadastroProduto.jsp?id=<%=id%>&acao=atualizar"> 
                        <button type="submit" class="btn btn-danger"> 
                            <span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
                        </button> 
                    </a>
                </td>
                <td> 
                    <a href = "ServletProduto?id=<%=id%>">   
                        <button type="submit" class="btn btn-danger">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </button>
                    </a>
                </td>
            </tr>
            </tr>
            <%}%>
        </table>
    </div> 
</html>

<% } else {
        response.sendRedirect("LoginSenha.jsp");
    }
%>
