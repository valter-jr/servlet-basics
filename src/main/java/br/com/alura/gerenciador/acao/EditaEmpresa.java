package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Acao;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditaEmpresa implements Acao {

    public String executa (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String nomeEmpresa = req.getParameter("nome");
        Integer id = Integer.parseInt(req.getParameter("id"));
        String paramDataEmpersa = req.getParameter("data");

        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpersa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }
        Banco banco = new Banco();
        Empresa empresaBusca = banco.pesquisa(id);
        empresaBusca.setNome(nomeEmpresa);
        empresaBusca.setDataAbertura(dataAbertura);

        banco.atualizar(empresaBusca);

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
