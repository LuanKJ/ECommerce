package br.com.app;

import br.com.DAO.ProdutoDAO;
import br.com.modelo.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto produto = new Produto();
        ProdutoDAO produtodao = new ProdutoDAO();
        
        produto.setId(Integer.parseInt(request.getParameter("id")));

        produtodao.excluirProduto(produto);

        request.setAttribute("ok", "Excluído com sucesso!");

        RequestDispatcher rd = request.getRequestDispatcher("ListagemProdutos.jsp");
        rd.forward(request, response);
    }

}
