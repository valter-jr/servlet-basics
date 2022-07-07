package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class AutorizacaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{}

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("-> Autorização Filter <-");
        String paramAcao = servletRequest.getParameter("acao");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession sessao = request.getSession();
        boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
        boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
        if (acaoProtegida && usuarioNaoLogado) {
            response.sendRedirect("/gerenciador/entrada?acao=LoginForm");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
