package br.com.jc.agendaws.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "contatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contatos.findAll", query = "SELECT c FROM Contatos c")
    , @NamedQuery(name = "Contatos.findById", query = "SELECT c FROM Contatos c WHERE c.id = :id")
    , @NamedQuery(name = "Contatos.findByNome", query = "SELECT c FROM Contatos c WHERE c.nome = :nome")
    , @NamedQuery(name = "Contatos.findByEmail", query = "SELECT c FROM Contatos c WHERE c.email = :email")
    , @NamedQuery(name = "Contatos.findByTelefone", query = "SELECT c FROM Contatos c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Contatos.findByCelular", query = "SELECT c FROM Contatos c WHERE c.celular = :celular")})
public class Contatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 255)
    @Column(name = "celular")
    private String celular;

    public Contatos() {
    }

    public Contatos(Integer id) {
        this.id = id;
    }

    public Contatos(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
