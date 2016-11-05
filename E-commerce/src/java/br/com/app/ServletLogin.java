package br.com.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.controller.LoginController;
import javax.servlet.RequestDispatcher;

public class ServletLogin extends HttpServlet {

    protected void generico(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String tela = request.getParameter("tela");

        if (LoginController.login(usuario, senha)) {
            response.addCookie(LoginController.getCookie("usuario", usuario));
            response.addCookie(LoginController.getCookie("senha", senha));
            switch (tela) {
                case "1":
                    response.sendRedirect("CadastroProduto.jsp?acao=cadastrar");
                    break;
                case "2":
                    response.sendRedirect("CarrinhoCompras.jsp");
                    break;
                default:
                    response.sendRedirect("index.jsp");
            }
        } else {
            request.setAttribute("erro", "Dados inválidos!");

            RequestDispatcher rd = request.getRequestDispatcher("LoginSenha.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        generico(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        generico(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
