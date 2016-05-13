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
@Table(name = "individuo_desafio")
@NamedQueries({
    @NamedQuery(name = "IndividuoDesafio.findAll", query = "SELECT i FROM IndividuoDesafio i"),
    @NamedQuery(name = "IndividuoDesafio.findByIdIndividuoDesafio", query = "SELECT i FROM IndividuoDesafio i WHERE i.idIndividuoDesafio = :idIndividuoDesafio"),
    @NamedQuery(name = "IndividuoDesafio.findBySgStatus", query = "SELECT i FROM IndividuoDesafio i WHERE i.sgStatus = :sgStatus"),
    @NamedQuery(name = "IndividuoDesafio.findByDtInicio", query = "SELECT i FROM IndividuoDesafio i WHERE i.dtInicio = :dtInicio"),
    @NamedQuery(name = "IndividuoDesafio.findByDtFim", query = "SELECT i FROM IndividuoDesafio i WHERE i.dtFim = :dtFim")})
public class IndividuoDesafio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_individuo_desafio")
    private Integer idIndividuoDesafio;
    @Column(name = "sg_status")
    private Character sgStatus;
    @Column(name = "dt_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInicio;
    @Column(name = "dt_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFim;
    @Column(name = "vl_atingido")
    private Float vlAtingido;
    @Column(name = "sg_atingido")
    private Character sgAtingido;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_atingido")
    private Date dtAtingido;
    @JoinColumn(name = "id_individuo", referencedColumnName = "id_individuo")
    @ManyToOne(optional = false)
    private Individuo individuo;
    @JoinColumn(name = "id_desafio", referencedColumnName = "id_desafio")
    @ManyToOne(optional = false)
    private Desafio desafio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "individuoDesafio")
    private List<IndividuoDesafioMeta> individuoDesafioMetaList;

    public IndividuoDesafio() {
    }

    public IndividuoDesafio(Integer idIndividuoDesafio) {
        this.idIndividuoDesafio = idIndividuoDesafio;
    }

    public IndividuoDesafio(Individuo i, Desafio d) {
        this.individuo = i;
        this.desafio = d;
    }

    public Integer getIdIndividuoDesafio() {
        return idIndividuoDesafio;
    }

    public void setIdIndividuoDesafio(Integer idIndividuoDesafio) {
        this.idIndividuoDesafio = idIndividuoDesafio;
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

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
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

    public List<IndividuoDesafioMeta> getIndividuoDesafioMetaList() {
        return individuoDesafioMetaList;
    }

    public void setIndividuoDesafioMetaList(List<IndividuoDesafioMeta> individuoDesafioMetaList) {
        this.individuoDesafioMetaList = individuoDesafioMetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIndividuoDesafio != null ? idIndividuoDesafio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndividuoDesafio)) {
            return false;
        }
        IndividuoDesafio other = (IndividuoDesafio) object;
        if ((this.idIndividuoDesafio == null && other.idIndividuoDesafio != null) || (this.idIndividuoDesafio != null && !this.idIndividuoDesafio.equals(other.idIndividuoDesafio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.IndividuoDesafio[ idIndividuoDesafio=" + idIndividuoDesafio + " ]";
    }

}
