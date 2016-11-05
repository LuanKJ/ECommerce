package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import br.com.DAO.ProdutoDAO;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>E-Commerce</title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("        <!-- JS -->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/lib/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/lib/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/reset.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/normalize.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/custom.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\r\n");
      out.write("            <h1 style=\"text-align: center\"><span class=\"label label-danger\">START</span></h1>\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("                <li class=\"active\"><a href=\"#\">Home</a></li>\r\n");
      out.write("                <li><a href=\"LoginSenha.jsp\">Entrar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("            <div style=\"text-align: right\">\r\n");
      out.write("                <button type=\"submit\" style=\" position: absolute; right: 1%\" class=\"btn btn-danger\" onclick=\"location.href = 'CarrinhoCompras.jsp'\">\r\n");
      out.write("                    <span class=\"glyphicon glyphicon-shopping-cart\" aria-hidden=\"true\"></span> Carrinho\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-lg-6\" style=\"width: 30%; position: absolute; left: 35%\">\r\n");
      out.write("                <form action=\"ServletProdutoList?acao=pes\" method=\"get\">\r\n");
      out.write("                    <div class=\"input-group\">  \r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"pesquisa\" placeholder=\"Pesquisar produtos...\"/>\r\n");
      out.write("                        <span class=\"input-group-btn\">\r\n");
      out.write("                            <button class=\"btn btn-danger\" type=\"submit\">\r\n");
      out.write("                                <span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\"></span>\r\n");
      out.write("                            </button>                           \r\n");
      out.write("                        </span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"panel panel-danger\" style=\"width: 90%; position: absolute; left: 5%\">\r\n");
      out.write("            ");
if (request.getAttribute("msg") != null && !request.getAttribute("msg").equals("")) {
      out.write("\r\n");
      out.write("            <div class=\"alert alert-danger\">\r\n");
      out.write("                <strong>");
      out.print( request.getAttribute("msg"));
      out.write("</strong> \r\n");
      out.write("            </div>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("            <div class=\"panel-heading\">Produtos</div>\r\n");
      out.write("            <table class=\"table table-bordered\">\r\n");
      out.write("\r\n");
      out.write("                ");

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
                
      out.write("\r\n");
      out.write("                <tr> \r\n");
      out.write("                    <td>");
      out.print(descricao);
      out.write("</td> \r\n");
      out.write("                    <td>");
      out.print(informacao);
      out.write("</td> \r\n");
      out.write("                    <td>");
      out.print(valor);
      out.write("</td>\r\n");
      out.write("                    <td style=\"width: 5%\"> \r\n");
      out.write("                        <form action=\"ServletProdutoList?id=");
      out.print(id);
      out.write("&acao=add\" method=\"post\">\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-danger\"> \r\n");
      out.write("                                <span class=\"glyphicon glyphicon-shopping-cart\" aria-hidden=\"true\"></span> Comprar\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("            </table> \r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/app.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
