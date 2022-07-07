package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginForm implements Acao {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "forward:/formLogin.jsp";
    }
}
