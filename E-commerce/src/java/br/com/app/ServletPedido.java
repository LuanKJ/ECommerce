package br.com.app;

import br.com.DAO.PedidoDAO;
import br.com.DAO.PedidoItemDAO;
import br.com.controller.LoginController;
import br.com.modelo.Pedido;
import br.com.modelo.PedidoItem;
import br.com.modelo.Produto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletPedido extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoginController.estaLogado(request)) {
            HttpSession sessao = request.getSession();
            ArrayList<Produto> produtos = (ArrayList) sessao.getAttribute("produtos");

            if (produtos.isEmpty()) {
                request.setAttribute("msg", "O carrinho está vazio, selecione produtos!");

                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else {

                Pedido pedido = new Pedido();
                PedidoDAO pedidoDAO = new PedidoDAO();

                Cookie[] cookies = request.getCookies();
                LoginController login = new LoginController();
                int id = login.getIdUsuario(cookies[1].getValue());

                pedido.setIdUsuario(id);
                pedidoDAO.inserirPedido(pedido);
                String idPedido = pedidoDAO.ultimaOcorrencia("PEDIDO", "ID");

                PedidoItem pedidoItem = new PedidoItem();
                PedidoItemDAO pedidoItemDAO = new PedidoItemDAO();

                for (Produto produto : produtos) {
                    pedidoItem.getPedido().setId(Integer.parseInt(idPedido));
                    pedidoItem.getProduto().setId(produto.getId());
                    pedidoItem.setQuantidade(produto.getQuantidade());
                    pedidoItem.setValorUnitario(produto.getValor());

                    pedidoItemDAO.inserirPedidoItem(pedidoItem);
                }

                sessao.setAttribute("produtos", null);
                request.setAttribute("msg", "Pedido finalizado com sucesso!");

                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } else {
            response.sendRedirect("LoginSenha.jsp?tela=2");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
