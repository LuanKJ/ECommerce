<%@page import="br.com.controller.FilterProduto"%>
<%@page import="br.com.DAO.ProdutoDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="br.com.controller.LoginController" %>
<% if (LoginController.estaLogado(request)) { %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manutenção de Produtos</title>
        <!-- CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <h1 style="text-align: center"><span class="label label-danger">Cadastro de produtos</span></h1>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Manutenção de produtos</a></li>
            </ul>
        </nav>

        <%
            String descricao = "";
            String informacao = "";
            String valor = "";
            String ident = "";

            String id = request.getParameter("id");
            if (id != null && !id.equals("")) {
                ProdutoDAO produtodao = new ProdutoDAO();
                ResultSet rs = produtodao.consultarProdutosCodigo(Integer.parseInt(id));

                ident = id;

                rs.first();
                descricao = rs.getString("descricao");
                informacao = rs.getString("informacao");
                valor = rs.getString("valor");
            }
        %>

        <div class="panel panel-danger" style="width: 70%; position: absolute; left: 15%">
            <div class="panel-heading">Manutenção de produtos</div>
            <div class="panel-body">
                <form action="ServletProdutoSalvar?id=<%=ident%>&funcao=<%=request.getParameter("acao")%>" method="post">
                    <input type="hidden" name="id" value="<%=ident%>"/>
                    <div class="form-group">
                        <label>Descrição</label>
                        <input type="text" class="form-control" name="descricao" value="<%=descricao%>" placeholder="Descrição do produto"> <!--required="" autofocus=""-->
                    </div>
                    <div class="form-group">
                        <label>Informação</label>
                        <input type="text" class="form-control" name="informacao" value="<%=informacao%>" placeholder="Informação do produto"> <!--required="" autofocus=""-->
                    </div>
                    <div class="form-group">
                        <label>Valor</label>
                        <input type="text" class="form-control" name="valor" value="<%=valor%>" placeholder="R$">
                    </div>
                    <button type="submit" class="btn btn-default btn-lg">
                        <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span> Gravar
                    </button>
                </form>
                <div style="text-align: right">
                    <button type="submit" class="btn btn-default btn-lg" onclick="location.href = 'ListagemProdutos.jsp'">
                        <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Listagem de Produtos
                    </button> 
                </div> <br/>
                <% if (request.getAttribute("errMsg") != null && !request.getAttribute("errMsg").equals("")) {%>
                <div class="alert alert-danger">
                    <strong><%= request.getAttribute("errMsg")%></strong> 
                </div>
                <% } %>   
            </div>
        </div>
    </div>
</body>
</html>

<% } else {
        response.sendRedirect("LoginSenha.jsp?tela=1");
    }
%>