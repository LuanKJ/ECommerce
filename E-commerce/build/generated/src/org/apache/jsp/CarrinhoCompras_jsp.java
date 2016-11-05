package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.app.ServletProdutoList;
import br.com.modelo.Produto;
import java.util.ArrayList;

public final class CarrinhoCompras_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Carrinho de Compras</title>\n");
      out.write("        <!-- CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/reset.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/custom.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <h1 style=\"text-align: center\"><span class=\"label label-danger\">Danger</span></h1>\n");
      out.write("            <ul class=\"nav navbar-nav\">\n");
      out.write("                <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"LoginSenha.jsp\">Entrar</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"panel panel-danger\" style=\"width: 90%; position: absolute; left: 5%;\">\n");
      out.write("            <div class=\"panel-heading\">Produtos no carrinho</div>\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("\n");
      out.write("                ");

                    HttpSession sessao = request.getSession();
                    ArrayList<Produto> produtos = (ArrayList) sessao.getAttribute("produtos");
                    if (produtos != null) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <th><b>Descrição</b></th> <th>Informação</th> <th>Valor</th> <th>Quantidade</th> <th>Sub-Total</th> <th>Remover</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    for (Produto p : produtos) {
                
      out.write("\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( p.getDescricao());
      out.write("</td> \n");
      out.write("                    <td>");
      out.print( p.getInformacao());
      out.write("</td> \n");
      out.write("                    <td>");
      out.print( p.getValor());
      out.write("</td> \n");
      out.write("                    <td>");
      out.print(p.getQuantidade());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getValor() * p.getQuantidade());
      out.write("</td>\n");
      out.write("                    <td> \n");
      out.write("                        <form action=\"ServletProdutoList?acao=remov&id=");
      out.print(p.getId());
      out.write("\" method=\"post\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-danger\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-trash\" aria-hidden=\"true\"></span>\n");
      out.write("                            </button>\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write(" \n");
      out.write("            </table>\n");
      out.write("            <div style=\"text-align: right\">\n");
      out.write("                <form action=\"ServletPedido\" method=\"post\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-default btn-lg\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span> Finalizar Compra\n");
      out.write("                    </button>\n");
      out.write("                </form>    \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <br/><h2>Carrinho Vazio!</h2><br/>\n");
      out.write("        ");
}
      out.write(" \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
