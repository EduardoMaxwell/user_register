package br.com.crud.cadastrojsf.dao;

import br.com.crud.cadastrojsf.JPAUtil;
import br.com.crud.cadastrojsf.model.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario> {

    @Override
    public void save(Usuario usuario) {
        EntityManager manager = JPAUtil.createEntityManager();

        try {
            manager.getTransaction().begin();
            if (usuario.getId() == null) {
                manager.persist(usuario);
                System.err.println("SALVO");
            } else {
                manager.merge(usuario);
                System.err.println("ATUALIZADO");
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            manager.close();

        }
    }

    @Override
    public void delete(Usuario usuario) {
        EntityManager manager = JPAUtil.createEntityManager();
        try {
            manager.getTransaction().begin();
            usuario = manager.merge(usuario);
            manager.remove(usuario);
            manager.getTransaction().commit();
            System.err.println("REMOVIDO");

        } catch (Exception e) {
            manager.getTransaction().rollback();

        } finally {
            manager.close();

        }
    }

    @Override
    public List<Usuario> getAllUsers() {
        EntityManager manager = JPAUtil.createEntityManager();
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u").getResultList();
        return usuarios;
    }

    @Override
    public Usuario getUserById(Long id) {
        EntityManager manager = JPAUtil.createEntityManager();
        Usuario usuario = manager.find(Usuario.class, id);
        System.err.println("BUSCADO");
        return usuario;
    }

    @Override
    public void update(Usuario usuario) {
        EntityManager manager = JPAUtil.createEntityManager();
        try {
            manager.getTransaction().begin();

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();

        } finally {
            manager.close();

        }
    }
}
