package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import java.io.IOException;

public class MonitoramentoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{}

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("-> Monitoramento Filter <-");
        long antes = System.currentTimeMillis();

        String acao = servletRequest.getParameter("acao");

        filterChain.doFilter(servletRequest, servletResponse);

        long depois = System.currentTimeMillis();
        System.out.println("Tempo de execução da ação: " + acao + " -> " + (depois - antes));
    }
}
