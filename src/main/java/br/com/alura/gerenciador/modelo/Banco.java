package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Banco {

    private static List<Empresa> empresas = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(chaveSequencial++);
        empresa.setNome("Alura");
        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial++);
        empresa2.setNome("Caelum");
        empresas.addAll(Arrays.asList(empresa, empresa2));

        Usuario u1 = new Usuario();
        u1.setLogin("kzo");
        u1.setSenha("123");
        Usuario u2 = new Usuario();
        u2.setLogin("banjo");
        u2.setSenha("kzo");
        usuarios.addAll(Arrays.asList(u1, u2));
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        empresas.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        return Banco.empresas;
    }

    public Empresa pesquisa (Integer id) {
        for (Empresa emp : Banco.empresas) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    public void remove(Integer id) {
        Banco.empresas.removeIf(emp -> emp.getId().equals(id));
    }

    public void atualizar (Empresa empresa) {
        for (Empresa emp : Banco.empresas) {
            if (emp.getId().equals(empresa.getId())) {
                emp.setNome(empresa.getNome());
                emp.setDataAbertura(empresa.getDataAbertura());
            }
        }
    }
    
    public Usuario buscaUsuario (String login, String senha) {
        for (Usuario u : usuarios) {
            if (u.ehIgual(login, senha)) {
                return u;
            }
        }
        return null;
    }
}
