package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Acao;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Banco banco = new Banco();
        Empresa empresaPesquisa = banco.pesquisa(id);

        request.setAttribute("empresa", empresaPesquisa);
        return "forward:/mostraEmpresa.jsp";
    }
}
