/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unisc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "individuo")
@NamedQueries({
    @NamedQuery(name = "Individuo.findAll", query = "SELECT i FROM Individuo i"),
    @NamedQuery(name = "Individuo.findByIdIndividuo", query = "SELECT i FROM Individuo i WHERE i.idIndividuo = :idIndividuo"),
    @NamedQuery(name = "Individuo.findByIdIndividuoSg", query = "SELECT i FROM Individuo i WHERE i.idIndividuoSg = :idIndividuoSg"),
    @NamedQuery(name = "Individuo.findByNmIndividuo", query = "SELECT i FROM Individuo i WHERE i.nmIndividuo = :nmIndividuo"),
    @NamedQuery(name = "Individuo.findByDtNascimento", query = "SELECT i FROM Individuo i WHERE i.dtNascimento = :dtNascimento"),
    @NamedQuery(name = "Individuo.findByXpAtual", query = "SELECT i FROM Individuo i WHERE i.xpAtual = :xpAtual"),
    @NamedQuery(name = "Individuo.findByQtDesafiosConcluidos", query = "SELECT i FROM Individuo i WHERE i.qtDesafiosConcluidos = :qtDesafiosConcluidos"),
    @NamedQuery(name = "Individuo.findByQtMetasConcluidas", query = "SELECT i FROM Individuo i WHERE i.qtMetasConcluidas = :qtMetasConcluidas"),
    @NamedQuery(name = "Individuo.findByQtEmblemas", query = "SELECT i FROM Individuo i WHERE i.qtEmblemas = :qtEmblemas"),
    @NamedQuery(name = "Individuo.findByQtItens", query = "SELECT i FROM Individuo i WHERE i.qtItens = :qtItens"),
    @NamedQuery(name = "Individuo.findByQtVida", query = "SELECT i FROM Individuo i WHERE i.qtVida = :qtVida")})
public class Individuo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_individuo")
    private Integer idIndividuo;
    @Column(name = "id_individuo_sg")
    private Integer idIndividuoSg;
    @Basic(optional = false)
    @Column(name = "nm_individuo")
    private String nmIndividuo;
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    @Column(name = "xp_atual")
    private Integer xpAtual;
    @Column(name = "qt_desafios_concluidos")
    private Integer qtDesafiosConcluidos;
    @Column(name = "qt_metas_concluidas")
    private Integer qtMetasConcluidas;
    @Column(name = "qt_emblemas")
    private Integer qtEmblemas;
    @Column(name = "qt_itens")
    private Integer qtItens;
    @Column(name = "qt_vida")
    private Integer qtVida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIndividuo")
    private List<IndividuoDesafio> individuoDesafioList;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false)
    private Grupo idGrupo;

    public Individuo() {
    }

    public Individuo(Integer idIndividuo) {
        this.idIndividuo = idIndividuo;
    }

    public Individuo(Integer idIndividuo, String nmIndividuo) {
        this.idIndividuo = idIndividuo;
        this.nmIndividuo = nmIndividuo;
    }

    public Integer getIdIndividuo() {
        return idIndividuo;
    }

    public void setIdIndividuo(Integer idIndividuo) {
        this.idIndividuo = idIndividuo;
    }

    public Integer getIdIndividuoSg() {
        return idIndividuoSg;
    }

    public void setIdIndividuoSg(Integer idIndividuoSg) {
        this.idIndividuoSg = idIndividuoSg;
    }

    public String getNmIndividuo() {
        return nmIndividuo;
    }

    public void setNmIndividuo(String nmIndividuo) {
        this.nmIndividuo = nmIndividuo;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Integer getXpAtual() {
        return xpAtual;
    }

    public void setXpAtual(Integer xpAtual) {
        this.xpAtual = xpAtual;
    }

    public Integer getQtDesafiosConcluidos() {
        return qtDesafiosConcluidos;
    }

    public void setQtDesafiosConcluidos(Integer qtDesafiosConcluidos) {
        this.qtDesafiosConcluidos = qtDesafiosConcluidos;
    }

    public Integer getQtMetasConcluidas() {
        return qtMetasConcluidas;
    }

    public void setQtMetasConcluidas(Integer qtMetasConcluidas) {
        this.qtMetasConcluidas = qtMetasConcluidas;
    }

    public Integer getQtEmblemas() {
        return qtEmblemas;
    }

    public void setQtEmblemas(Integer qtEmblemas) {
        this.qtEmblemas = qtEmblemas;
    }

    public Integer getQtItens() {
        return qtItens;
    }

    public void setQtItens(Integer qtItens) {
        this.qtItens = qtItens;
    }

    public Integer getQtVida() {
        return qtVida;
    }

    public void setQtVida(Integer qtVida) {
        this.qtVida = qtVida;
    }

    public List<IndividuoDesafio> getIndividuoDesafioList() {
        return individuoDesafioList;
    }

    public void setIndividuoDesafioList(List<IndividuoDesafio> individuoDesafioList) {
        this.individuoDesafioList = individuoDesafioList;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIndividuo != null ? idIndividuo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Individuo)) {
            return false;
        }
        Individuo other = (Individuo) object;
        if ((this.idIndividuo == null && other.idIndividuo != null) || (this.idIndividuo != null && !this.idIndividuo.equals(other.idIndividuo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.Individuo[ idIndividuo=" + idIndividuo + " ]";
    }

}
