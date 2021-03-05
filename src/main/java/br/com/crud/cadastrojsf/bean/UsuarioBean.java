package br.com.crud.cadastrojsf.bean;

import br.com.crud.cadastrojsf.dao.UsuarioDAO;
import br.com.crud.cadastrojsf.model.Usuario;
import org.omnifaces.util.Messages;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class UsuarioBean implements Serializable {
    private static final long serialVersionUID = 3904588601441954205L;
    @Inject
    private Usuario usuario;
    private List<Usuario> usuarios = new ArrayList<>();
    UsuarioDAO dao = new UsuarioDAO();

    public String salva() {
        dao.save(usuario);
        Messages.addGlobalInfo("Usuário Salvo");
        usuario = new Usuario();
        return "index?faces-redirect=true";
    }

    public UsuarioBean() {
        this.usuario = new Usuario();
    }

    public void deleta(Usuario usuario) {
        dao.delete(usuario);
        Messages.addGlobalWarn("Usuário Excluído");
    }

    public List<Usuario> lista() {
        return this.usuarios = dao.getAllUsers();
    }

    public String atualiza(Usuario usuario) {
        this.usuario = usuario;
        dao.update(usuario);
        usuario = new Usuario();
        Messages.addGlobalInfo("Usuário Atualizado");
        return "cadastro?faces-redirect=true";
    }

    public String cancela() {
        this.usuario = new Usuario();
        return "index?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
