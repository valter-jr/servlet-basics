package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Acao;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaEmpresas implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Banco banco = new Banco();
        List<Empresa> listaDeEmpresasCadastradas = banco.getEmpresas();

        request.setAttribute("lista", listaDeEmpresasCadastradas);

        return "forward:/listaEmpresas.jsp";
    }

}
