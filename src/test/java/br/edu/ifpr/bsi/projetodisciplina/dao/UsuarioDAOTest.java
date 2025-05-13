package br.edu.ifpr.bsi.projetodisciplina.dao;

import br.edu.ifpr.bsi.projetodisciplina.model.Usuario;
import org.junit.jupiter.api.Test;

public class UsuarioDAOTest {

    @Test
    public void inserir(){
        Usuario usuario = new Usuario();
        usuario.setNome("Shayene Wosnes");
        usuario.setEmail("shayenewosnes@gmail.com");
        usuario.setCpf("123456789");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(usuario);
    }

    @Test
    public void remover(){
        Usuario usuario = new Usuario();
        // Preciso especificar o ID que quero remover
        usuario.setID(2L);
        // Se foi definido um atributo como "Nullable = False" (obrigatório)
        // é preciso deixá-lo diferente de null
        // caso contrário dará ERRO

        UsuarioDAO dao = new UsuarioDAO();
        dao.remover(usuario);
    }

    @Test
    public void listar(){
        UsuarioDAO dao = new UsuarioDAO();
        for (Usuario usuario : dao.listar()) {
            System.out.println(usuario.getNome());
        }
    }

}
