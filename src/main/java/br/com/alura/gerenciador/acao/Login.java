package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Acao;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Banco banco = new Banco();

        Usuario usuarioLogado = banco.buscaUsuario(login, senha);

        if (usuarioLogado != null) {
            System.out.println("Usuario existe");
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado", usuarioLogado);
            return "redirect:entrada?acao=ListaEmpresas";
        } else {
            return "redirect:entrada?acao=LoginForm";
        }

    }
}
