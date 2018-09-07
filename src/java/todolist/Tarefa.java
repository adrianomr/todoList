/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tarefa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarefa.findAll", query = "SELECT t FROM Tarefa t")
    , @NamedQuery(name = "Tarefa.findById", query = "SELECT t FROM Tarefa t WHERE t.id = :id")
    , @NamedQuery(name = "Tarefa.findByNome", query = "SELECT t FROM Tarefa t WHERE t.nome = :nome")
    , @NamedQuery(name = "Tarefa.findByTempoestimado", query = "SELECT t FROM Tarefa t WHERE t.tempoestimado = :tempoestimado")
    , @NamedQuery(name = "Tarefa.findByTemporealizado", query = "SELECT t FROM Tarefa t WHERE t.temporealizado = :temporealizado")
    , @NamedQuery(name = "Tarefa.findByDescricao", query = "SELECT t FROM Tarefa t WHERE t.descricao = :descricao")})
public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tempoestimado")
    private BigInteger tempoestimado;
    @Column(name = "temporealizado")
    private BigInteger temporealizado;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioId;
    @OneToMany(mappedBy = "tarefaId")
    private Collection<Tarefatempo> tarefatempoCollection;

    public Tarefa() {
    }

    public Tarefa(Integer id) {
        this.id = id;
    }

    public Tarefa(Integer id, String nome, BigInteger tempoestimado) {
        this.id = id;
        this.nome = nome;
        this.tempoestimado = tempoestimado;
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

    public BigInteger getTempoestimado() {
        return tempoestimado;
    }

    public void setTempoestimado(BigInteger tempoestimado) {
        this.tempoestimado = tempoestimado;
    }

    public BigInteger getTemporealizado() {
        return temporealizado;
    }

    public void setTemporealizado(BigInteger temporealizado) {
        this.temporealizado = temporealizado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    public Collection<Tarefatempo> getTarefatempoCollection() {
        return tarefatempoCollection;
    }

    public void setTarefatempoCollection(Collection<Tarefatempo> tarefatempoCollection) {
        this.tarefatempoCollection = tarefatempoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarefa)) {
            return false;
        }
        Tarefa other = (Tarefa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "todolist.Tarefa[ id=" + id + " ]";
    }
    
}
