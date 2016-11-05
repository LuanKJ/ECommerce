package br.com.app;
import br.com.DAO.ProdutoDAO;
import br.com.modelo.Produto;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletProdutoList extends HttpServlet {

    private final ArrayList<Produto> produtos = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProdutoDAO produtoDAO = new ProdutoDAO();

        String pesquisa = request.getParameter("pesquisa");
        ResultSet rs = produtoDAO.consultarProdutosDescricao(pesquisa);

        request.setAttribute("pesquisas", rs);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp?acao=pesquisa");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("acao")) {
            case "add":
                addNoCarrinho(request);
                response.sendRedirect("CarrinhoCompras.jsp");
                break;

            case "remov":
                removDoCarrinho(request);
                response.sendRedirect("CarrinhoCompras.jsp");
                break;
        }

    }

    private void addNoCarrinho(HttpServletRequest request) {
        Produto p = new Produto();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        p.setId(id);

        ResultSet rs = produtoDAO.consultarProdutosCodigo(id);

        try {
            rs.first();
            p.setDescricao(rs.getString("DESCRICAO"));
            p.setInformacao(rs.getString("INFORMACAO"));
            p.setQuantidade(1);
            p.setValor(rs.getDouble("VALOR"));
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar produto no carrinho de compras! " + ex);
        }

        boolean add = true;

        for (Produto produto : produtos) {
            if (id == produto.getId()) {
                produto.setQuantidade(produto.getQuantidade() + 1);
                add = false;
            }
        }

        if (add) {
            produtos.add(p);
        }

        HttpSession sessao = request.getSession(true);
        sessao.setAttribute("produtos", produtos);
    }

    private void removDoCarrinho(HttpServletRequest request) {
        try {
            int ind = Integer.parseInt(request.getParameter("id"));

            for(Produto prod : produtos) {
                if (ind == prod.getId()) {
                    produtos.remove(prod);
                }
            }

        } catch (Exception e) {
        }
    }

}
