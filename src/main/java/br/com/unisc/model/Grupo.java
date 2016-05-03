/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unisc.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "grupo")
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByIdGrupo", query = "SELECT g FROM Grupo g WHERE g.idGrupo = :idGrupo"),
    @NamedQuery(name = "Grupo.findByNmGrupo", query = "SELECT g FROM Grupo g WHERE g.nmGrupo = :nmGrupo"),
    @NamedQuery(name = "Grupo.findByXpAtual", query = "SELECT g FROM Grupo g WHERE g.xpAtual = :xpAtual"),
    @NamedQuery(name = "Grupo.findByQtDesafiosConcluidos", query = "SELECT g FROM Grupo g WHERE g.qtDesafiosConcluidos = :qtDesafiosConcluidos"),
    @NamedQuery(name = "Grupo.findByQtMetasContluidas", query = "SELECT g FROM Grupo g WHERE g.qtMetasContluidas = :qtMetasContluidas"),
    @NamedQuery(name = "Grupo.findByQtEmblemas", query = "SELECT g FROM Grupo g WHERE g.qtEmblemas = :qtEmblemas"),
    @NamedQuery(name = "Grupo.findByQtItens", query = "SELECT g FROM Grupo g WHERE g.qtItens = :qtItens"),
    @NamedQuery(name = "Grupo.findByVlDinheiro", query = "SELECT g FROM Grupo g WHERE g.vlDinheiro = :vlDinheiro")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Basic(optional = false)
    @Column(name = "nm_grupo")
    private String nmGrupo;
    @Column(name = "xp_atual")
    private Integer xpAtual;
    @Column(name = "qt_desafios_concluidos")
    private Integer qtDesafiosConcluidos;
    @Column(name = "qt_metas_contluidas")
    private Integer qtMetasContluidas;
    @Column(name = "qt_emblemas")
    private Integer qtEmblemas;
    @Column(name = "qt_itens")
    private Integer qtItens;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_dinheiro")
    private Double vlDinheiro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
    private List<GrupoDesafio> grupoDesafioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
    private List<Individuo> individuoList;

    public Grupo() {
    }

    public Grupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Grupo(Integer idGrupo, String nmGrupo) {
        this.idGrupo = idGrupo;
        this.nmGrupo = nmGrupo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNmGrupo() {
        return nmGrupo;
    }

    public void setNmGrupo(String nmGrupo) {
        this.nmGrupo = nmGrupo;
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

    public Integer getQtMetasContluidas() {
        return qtMetasContluidas;
    }

    public void setQtMetasContluidas(Integer qtMetasContluidas) {
        this.qtMetasContluidas = qtMetasContluidas;
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

    public Double getVlDinheiro() {
        return vlDinheiro;
    }

    public void setVlDinheiro(Double vlDinheiro) {
        this.vlDinheiro = vlDinheiro;
    }

    public List<GrupoDesafio> getGrupoDesafioList() {
        return grupoDesafioList;
    }

    public void setGrupoDesafioList(List<GrupoDesafio> grupoDesafioList) {
        this.grupoDesafioList = grupoDesafioList;
    }

    public List<Individuo> getIndividuoList() {
        return individuoList;
    }

    public void setIndividuoList(List<Individuo> individuoList) {
        this.individuoList = individuoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.Grupo[ idGrupo=" + idGrupo + " ]";
    }
    
}
