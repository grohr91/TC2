/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.model;

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
@Table(name = "grupo_desafio")
@NamedQueries({
    @NamedQuery(name = "GrupoDesafio.findAll", query = "SELECT g FROM GrupoDesafio g"),
    @NamedQuery(name = "GrupoDesafio.findByIdGrupoDesafio", query = "SELECT g FROM GrupoDesafio g WHERE g.idGrupoDesafio = :idGrupoDesafio"),
    @NamedQuery(name = "GrupoDesafio.findBySgStatus", query = "SELECT g FROM GrupoDesafio g WHERE g.sgStatus = :sgStatus"),
    @NamedQuery(name = "GrupoDesafio.findByDtInicio", query = "SELECT g FROM GrupoDesafio g WHERE g.dtInicio = :dtInicio"),
    @NamedQuery(name = "GrupoDesafio.findByDtFim", query = "SELECT g FROM GrupoDesafio g WHERE g.dtFim = :dtFim"),
    @NamedQuery(name = "GrupoDesafio.findByXpTotalGanho", query = "SELECT g FROM GrupoDesafio g WHERE g.xpTotalGanho = :xpTotalGanho")})
public class GrupoDesafio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo_desafio")
    private Integer idGrupoDesafio;
    @Column(name = "sg_status")
    private Character sgStatus;
    @Column(name = "dt_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInicio;
    @Column(name = "dt_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFim;
    @Basic(optional = false)
    @Column(name = "xp_total_ganho")
    private int xpTotalGanho;
    @Column(name = "vl_atingido")
    private Float vlAtingido;
    @Column(name = "sg_atingido")
    private Character sgAtingido;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_atingido")
    private Date dtAtingido;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false)
    private Grupo grupo;
    @JoinColumn(name = "id_desafio", referencedColumnName = "id_desafio")
    @ManyToOne(optional = false)
    private Desafio desafio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoDesafio")
    private List<GrupoDesafioMeta> grupoDesafioMetaList;

    public GrupoDesafio() {
    }

    public GrupoDesafio(Integer idGrupoDesafio) {
        this.idGrupoDesafio = idGrupoDesafio;
    }

    public GrupoDesafio(Grupo g, Desafio d) {
        this.grupo = g;
        this.desafio = d;
    }

    public Integer getIdGrupoDesafio() {
        return idGrupoDesafio;
    }

    public void setIdGrupoDesafio(Integer idGrupoDesafio) {
        this.idGrupoDesafio = idGrupoDesafio;
    }

    public Character getSgStatus() {
        return sgStatus;
    }

    public void setSgStatus(Character sgStatus) {
        this.sgStatus = sgStatus;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public int getXpTotalGanho() {
        return xpTotalGanho;
    }

    public void setXpTotalGanho(int xpTotalGanho) {
        this.xpTotalGanho = xpTotalGanho;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Desafio getDesafio() {
        return desafio;
    }

    public void setDesafio(Desafio desafio) {
        this.desafio = desafio;
    }

    public Float getVlAtingido() {
        return vlAtingido;
    }

    public void setVlAtingido(Float vlAtingido) {
        this.vlAtingido = vlAtingido;
    }

    public Character getSgAtingido() {
        return sgAtingido;
    }

    public void setSgAtingido(Character sgAtingido) {
        this.sgAtingido = sgAtingido;
    }

    public Date getDtAtingido() {
        return dtAtingido;
    }

    public void setDtAtingido(Date dtAtingido) {
        this.dtAtingido = dtAtingido;
    }

    public List<GrupoDesafioMeta> getGrupoDesafioMetaList() {
        return grupoDesafioMetaList;
    }

    public void setGrupoDesafioMetaList(List<GrupoDesafioMeta> grupoDesafioMetaList) {
        this.grupoDesafioMetaList = grupoDesafioMetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoDesafio != null ? idGrupoDesafio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoDesafio)) {
            return false;
        }
        GrupoDesafio other = (GrupoDesafio) object;
        if ((this.idGrupoDesafio == null && other.idGrupoDesafio != null) || (this.idGrupoDesafio != null && !this.idGrupoDesafio.equals(other.idGrupoDesafio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.GrupoDesafio[ idGrupoDesafio=" + idGrupoDesafio + " ]";
    }

}
