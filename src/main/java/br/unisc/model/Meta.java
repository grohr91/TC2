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
@Table(name = "meta")
@NamedQueries({
    @NamedQuery(name = "Meta.findAll", query = "SELECT m FROM Meta m"),
    @NamedQuery(name = "Meta.findByIdMeta", query = "SELECT m FROM Meta m WHERE m.idMeta = :idMeta"),
    @NamedQuery(name = "Meta.findByNmMeta", query = "SELECT m FROM Meta m WHERE m.nmMeta = :nmMeta"),
    @NamedQuery(name = "Meta.findBySgTipo", query = "SELECT m FROM Meta m WHERE m.sgTipo = :sgTipo"),
    @NamedQuery(name = "Meta.findByFgObrigatorio", query = "SELECT m FROM Meta m WHERE m.fgObrigatorio = :fgObrigatorio"),
    @NamedQuery(name = "Meta.findByDtDeadline", query = "SELECT m FROM Meta m WHERE m.dtDeadline = :dtDeadline"),
    @NamedQuery(name = "Meta.findByVlAtingir", query = "SELECT m FROM Meta m WHERE m.vlAtingir = :vlAtingir"),
    @NamedQuery(name = "Meta.findBySgSituacaoAtingir", query = "SELECT m FROM Meta m WHERE m.sgSituacaoAtingir = :sgSituacaoAtingir"),
    @NamedQuery(name = "Meta.findByXpReconpensa", query = "SELECT m FROM Meta m WHERE m.xpReconpensa = :xpReconpensa")})
public class Meta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_meta")
    private Integer idMeta;
    @Basic(optional = false)
    @Column(name = "nm_meta")
    private String nmMeta;
    @Basic(optional = false)
    @Column(name = "sg_tipo")
    private Character sgTipo;
    @Column(name = "fg_obrigatorio")
    private Boolean fgObrigatorio;
    @Column(name = "dt_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDeadline;
    @Column(name = "vl_atingir")
    private Double vlAtingir;
    @Column(name = "sg_situacao_atingir")
    private Character sgSituacaoAtingir;
    @Column(name = "xp_reconpensa")
    private Double xpReconpensa;
    @Column(name = "xp_adquirido")
    private Double xpAdquirido;
    @Column(name = "fg_atingiu")
    private Boolean fgAtingiu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meta")
    private List<IndividuoDesafioMeta> individuoDesafioMetaList;
    @JoinColumn(name = "id_desafio", referencedColumnName = "id_desafio")
    @ManyToOne(optional = false)
    private Desafio desafio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meta")
    private List<GrupoDesafioMeta> grupoDesafioMetaList;

    public Meta() {
    }

    public Meta(Integer idMeta) {
        this.idMeta = idMeta;
    }

    public Meta(Integer idMeta, String nmMeta, Character sgTipo) {
        this.idMeta = idMeta;
        this.nmMeta = nmMeta;
        this.sgTipo = sgTipo;
    }

    public Integer getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Integer idMeta) {
        this.idMeta = idMeta;
    }

    public String getNmMeta() {
        return nmMeta;
    }

    public void setNmMeta(String nmMeta) {
        this.nmMeta = nmMeta;
    }

    public Character getSgTipo() {
        return sgTipo;
    }

    public void setSgTipo(Character sgTipo) {
        this.sgTipo = sgTipo;
    }

    public Boolean getFgObrigatorio() {
        return fgObrigatorio;
    }

    public void setFgObrigatorio(Boolean fgObrigatorio) {
        this.fgObrigatorio = fgObrigatorio;
    }

    public Date getDtDeadline() {
        return dtDeadline;
    }

    public void setDtDeadline(Date dtDeadline) {
        this.dtDeadline = dtDeadline;
    }

    public Double getVlAtingir() {
        return vlAtingir;
    }

    public void setVlAtingir(Double vlAtingir) {
        this.vlAtingir = vlAtingir;
    }

    public Character getSgSituacaoAtingir() {
        return sgSituacaoAtingir;
    }

    public void setSgSituacaoAtingir(Character sgSituacaoAtingir) {
        this.sgSituacaoAtingir = sgSituacaoAtingir;
    }

    public Double getXpReconpensa() {
        return xpReconpensa;
    }

    public void setXpReconpensa(Double xpReconpensa) {
        this.xpReconpensa = xpReconpensa;
    }

    public List<IndividuoDesafioMeta> getIndividuoDesafioMetaList() {
        return individuoDesafioMetaList;
    }

    public void setIndividuoDesafioMetaList(List<IndividuoDesafioMeta> individuoDesafioMetaList) {
        this.individuoDesafioMetaList = individuoDesafioMetaList;
    }

    public Desafio getDesafio() {
        return desafio;
    }

    public void setDesafio(Desafio desafio) {
        this.desafio = desafio;
    }

    public Double getXpAdquirido() {
        return xpAdquirido;
    }

    public void setXpAdquirido(Double xpAdquirido) {
        this.xpAdquirido = xpAdquirido;
    }

    public Boolean getFgAtingiu() {
        return fgAtingiu;
    }

    public void setFgAtingiu(Boolean fgAtingiu) {
        this.fgAtingiu = fgAtingiu;
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
        hash += (idMeta != null ? idMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meta)) {
            return false;
        }
        Meta other = (Meta) object;
        if ((this.idMeta == null && other.idMeta != null) || (this.idMeta != null && !this.idMeta.equals(other.idMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.Meta[ idMeta=" + idMeta + " ]";
    }

}
