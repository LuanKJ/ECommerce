package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.DAO.ProdutoDAO;
import java.sql.ResultSet;
import br.com.modelo.Produto;
import br.com.controller.LoginController;

public final class ListagemProdutos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 if (LoginController.estaLogado(request)) { 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Listagem de Produtos</title>\n");
      out.write("        <!-- CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/reset.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/custom.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <nav class=\"navbar navbar-inverse\">\n");
      out.write("        <h1 style=\"text-align: center\"><span class=\"label label-danger\">START</span></h1>\n");
      out.write("        <ul class=\"nav navbar-nav\">\n");
      out.write("            <li class=\"active\"><a href=\"#\">Listagem de produtos</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </nav> \n");
      out.write("\n");
      out.write("    <div style=\"text-align: center\">\n");
      out.write("        <button type=\"submit\" class=\"btn btn-danger\" onclick=\"location.href = 'CadastroProduto.jsp?acao=cadastrar'\">\n");
      out.write("            <span class=\"glyphicon glyphicon-file\" aria-hidden=\"true\"></span> Cadastrar Produto\n");
      out.write("    </div> <br/>   \n");
      out.write("\n");
      out.write("    <div class=\"panel panel-danger\" style=\"width: 80%; position: absolute; left: 10%\">\n");
      out.write("        <div class=\"panel-heading\">Listagem de produtos</div>\n");
      out.write("        <table class=\"table table-bordered\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Descrição</th> <th>Informação</th> <th>Valor</th> <th>Alterar</th> <th>Remover</th>  \n");
      out.write("            </tr>\n");
      out.write("            ");

                ProdutoDAO produtodao = new ProdutoDAO();
                ResultSet rs = produtodao.consultarProdutos();
                while (rs.next()) {
                    String id = rs.getString("id");
                    String descricao = rs.getString("descricao");
                    String informacao = rs.getString("informacao");
                    String valor = rs.getString("valor");
            
      out.write("\n");
      out.write("            <tr> \n");
      out.write("                <td>");
      out.print(descricao);
      out.write("</td> \n");
      out.write("                <td>");
      out.print(informacao);
      out.write("</td> \n");
      out.write("                <td>");
      out.print(valor);
      out.write("</td>\n");
      out.write("                <td> \n");
      out.write("                    <a href = \"CadastroProduto.jsp?id=");
      out.print(id);
      out.write("&acao=atualizar\"> \n");
      out.write("                        <button type=\"submit\" class=\"btn btn-danger\"> \n");
      out.write("                            <span class=\"glyphicon glyphicon-wrench\" aria-hidden=\"true\"></span>\n");
      out.write("                        </button> \n");
      out.write("                    </a>\n");
      out.write("                </td>\n");
      out.write("                <td> \n");
      out.write("                    <a href = \"ServletProdutoSalvar?id=");
      out.print(id);
      out.write("\">   \n");
      out.write("                        <button type=\"submit\" class=\"btn btn-danger\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-trash\" aria-hidden=\"true\"></span>\n");
      out.write("                        </button>\n");
      out.write("                    </a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            </tr>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("</html>\n");
      out.write("\n");
 } else {
        response.sendRedirect("LoginSenha.jsp");
    }

      out.write('\n');
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
