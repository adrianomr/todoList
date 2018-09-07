/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tarefatempo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarefatempo.findAll", query = "SELECT t FROM Tarefatempo t")
    , @NamedQuery(name = "Tarefatempo.findById", query = "SELECT t FROM Tarefatempo t WHERE t.id = :id")
    , @NamedQuery(name = "Tarefatempo.findByDatainicial", query = "SELECT t FROM Tarefatempo t WHERE t.datainicial = :datainicial")
    , @NamedQuery(name = "Tarefatempo.findByDatafinal", query = "SELECT t FROM Tarefatempo t WHERE t.datafinal = :datafinal")})
public class Tarefatempo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datainicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainicial;
    @Column(name = "datafinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafinal;
    @JoinColumn(name = "tarefa_id", referencedColumnName = "id")
    @ManyToOne
    private Tarefa tarefaId;

    public Tarefatempo() {
    }

    public Tarefatempo(Integer id) {
        this.id = id;
    }

    public Tarefatempo(Integer id, Date datainicial) {
        this.id = id;
        this.datainicial = datainicial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatainicial() {
        return datainicial;
    }

    public void setDatainicial(Date datainicial) {
        this.datainicial = datainicial;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public Tarefa getTarefaId() {
        return tarefaId;
    }

    public void setTarefaId(Tarefa tarefaId) {
        this.tarefaId = tarefaId;
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
        if (!(object instanceof Tarefatempo)) {
            return false;
        }
        Tarefatempo other = (Tarefatempo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "todolist.Tarefatempo[ id=" + id + " ]";
    }
    
}
