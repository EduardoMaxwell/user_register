package br.com.crud.cadastrojsf.test;

import br.com.crud.cadastrojsf.JPAUtil;
import br.com.crud.cadastrojsf.dao.UsuarioDAO;
import br.com.crud.cadastrojsf.model.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("014.658.978-98", "95991447393", "Eduardo");
        UsuarioDAO dao = new UsuarioDAO();
        dao.save(usuario);
//
//        Usuario userById = dao.getUserById(usuario.getId());
//        userById.setNome("Maxwell");
//        userById.setCpf("12121515454");
//        userById.setTelefone("959599949");
//
//        dao.save(userById);
//
//        dao.delete(userById);
        List<Usuario> users = dao.getAllUsers();
        for (Usuario usuario1 : users) {

            System.out.println(usuario1.getId() + " | " + usuario1.getNome());
        }

    }
}
