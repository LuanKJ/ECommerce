<%@page import="java.sql.ResultSet"%>
<%@page import="br.com.DAO.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>E-Commerce</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- JS -->
        <script type="text/javascript" src="js/lib/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/lib/bootstrap.min.js"></script>

        <!-- CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <h1 style="text-align: center"><span class="label label-danger">Loja Virtual</span></h1>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="LoginSenha.jsp">Entrar</a></li>
            </ul>

            <div style="text-align: right">
                <button type="submit" style=" position: absolute; right: 1%" class="btn btn-danger" onclick="location.href = 'CarrinhoCompras.jsp'">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Carrinho
                </button>
            </div>

            <div class="col-lg-6" style="width: 30%; position: absolute; left: 35%">
                <form action="ServletProdutoList?acao=pes" method="get">
                    <div class="input-group">  
                        <input type="text" class="form-control" name="pesquisa" placeholder="Pesquisar produtos..."/>
                        <span class="input-group-btn">
                            <button class="btn btn-danger" type="submit">
                                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                            </button>                           
                        </span>
                    </div>
                </form>
            </div>
        </nav>

        <div class="panel panel-danger" style="width: 90%; position: absolute; left: 5%">
            <%if (request.getAttribute("msg") != null && !request.getAttribute("msg").equals("")) {%>
            <div class="alert alert-danger">
                <strong><%= request.getAttribute("msg")%></strong> 
            </div>
            <%}%>
            <div class="panel-heading">Produtos</div>
            <table class="table table-bordered">

                <%
                    ProdutoDAO produtodao = new ProdutoDAO();

                    ResultSet rs = null;

                    if (request.getParameter("acao") == null || request.getParameter("acao").equals(null)) {
                        rs = produtodao.consultarProdutos();
                    } else {
                        rs = (ResultSet) request.getAttribute("pesquisas");
                    }

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
                    <td style="width: 5%"> 
                        <form action="ServletProdutoList?id=<%=id%>&acao=add" method="post">
                            <button type="submit" class="btn btn-danger"> 
                                <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Comprar
                            </button>
                        </form>
                    </td>
                </tr>
                <%}%>
            </table> 
        </div>

        <script type="text/javascript" src="js/app.js"></script>
    </body>
</html>