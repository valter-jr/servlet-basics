package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Acao {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();

        sessao.invalidate();
        return "redirect:/gerenciador/entrada?acao=LoginForm";
    }
}
