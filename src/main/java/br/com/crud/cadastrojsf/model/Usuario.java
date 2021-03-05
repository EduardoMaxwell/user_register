package br.com.crud.cadastrojsf.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 4233695007708232230L;

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "cpf_usuario", nullable = false)
    private String cpf;
    @Column(name = "telefone_usuario", nullable = false)
    private String telefone;
    @Column(name = "nome_usuario", nullable = false)
    private String nome;

    public Usuario() {
    }

    public Usuario(String cpf, String telefone, String nome) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return getId().equals(usuario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
