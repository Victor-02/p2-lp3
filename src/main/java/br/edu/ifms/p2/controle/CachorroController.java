package br.edu.ifms.p2.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.p2.dao.CachorroDAO;
import br.edu.ifms.p2.model.Cachorro;

@WebServlet("/CachorroControle")
public class CachorroController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CachorroDAO dao;

    @Override
    public void init() {
        dao = new CachorroDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processarRequisicao(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processarRequisicao(request, response);
    }

    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("acao");

        try {
            switch (action) {
                case "novo":
                    novoCachorro(request, response);
                    break;
                case "inserir":
                    gravarCachorro(request, response);
                    break;
                case "editar":
                    editarCachorro(request, response);
                    break;
                case "deletar":
                    deletarCachorro(request, response);
                    break;
                default:
                    listarCachorros(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void novoCachorro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void gravarCachorro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String raca = request.getParameter("raca");
        int tamanho = Integer.parseInt(request.getParameter("tamanho"));
        int idade = Integer.parseInt(request.getParameter("idade"));

        dao.inserirCachorro(new Cachorro(raca, tamanho, idade));

        RequestDispatcher dispatcher = request.getRequestDispatcher("listagem.jsp");

        dispatcher.forward(request, response);
    }

    private void listarCachorros(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Cachorro> listaCachorro = dao.listarTodosCachorros();

        request.setAttribute("listaCachorros", listaCachorro);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listagem.jsp");
        dispatcher.forward(request, response);
    }

    private void editarCachorro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Cachorro cachorro = dao.buscarPorId(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
        request.setAttribute("Cachorro", cachorro);
        dispatcher.forward(request, response);
    }

    private void deletarCachorro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        dao.deletarCachorro(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listagem.jsp");
        dispatcher.forward(request, response);
    }

}
