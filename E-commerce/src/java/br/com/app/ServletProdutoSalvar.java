package br.com.app;

import br.com.DAO.ProdutoDAO;
import br.com.modelo.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletProdutoSalvar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        switch (request.getParameter("funcao")) {
            case "cadastrar":
                cadastrarProduto(request);

                request.setAttribute("ok", "Cadastrado com sucesso!");

                RequestDispatcher rd = request.getRequestDispatcher("ListagemProdutos.jsp");
                rd.forward(request, response);
                break;

            case "atualizar":
                atualizarProduto(request);
                
                request.setAttribute("ok", "Alterado com sucesso!");

                rd = request.getRequestDispatcher("ListagemProdutos.jsp");
                rd.forward(request, response);
                break;
                
            default:
                request.setAttribute("ok", "Não foi possível cadastrar desta forma, clique no botão 'Cadastrar Produto' e tente novamente!");

                rd = request.getRequestDispatcher("ListagemProdutos.jsp");
                rd.forward(request, response);
                break;
        }
    }

    private void cadastrarProduto(HttpServletRequest request) {
        Produto produto = new Produto();
        ProdutoDAO produtodao = new ProdutoDAO();

        String descricao = request.getParameter("descricao");
        String informacao = request.getParameter("informacao");
        double valor = Double.parseDouble(request.getParameter("valor"));

        produto.setDescricao(descricao);
        produto.setInformacao(informacao);
        produto.setValor(valor);

        produtodao.inserirProduto(produto);
    }

    private void atualizarProduto(HttpServletRequest request) {
        Produto produto = new Produto();
        ProdutoDAO produtodao = new ProdutoDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        String informacao = request.getParameter("informacao");
        double valor = Double.parseDouble(request.getParameter("valor"));

        produto.setId(id);
        produto.setDescricao(descricao);
        produto.setInformacao(informacao);
        produto.setValor(valor);

        produtodao.alterarProduto(produto);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
