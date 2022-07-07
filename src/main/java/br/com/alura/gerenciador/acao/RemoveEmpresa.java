package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Acao;
import br.com.alura.gerenciador.modelo.Banco;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response)  {
        Integer id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Empresa " + id + " removida.");
        Banco banco = new Banco();
        banco.remove(id);

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
