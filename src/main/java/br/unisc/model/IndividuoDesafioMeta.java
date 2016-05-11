/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.model;

import java.io.Serializable;
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

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "individuo_desafio_meta")
@NamedQueries({
    @NamedQuery(name = "IndividuoDesafioMeta.findAll", query = "SELECT i FROM IndividuoDesafioMeta i"),
    @NamedQuery(name = "IndividuoDesafioMeta.findByIdindividuoDesafioMeta", query = "SELECT i FROM IndividuoDesafioMeta i WHERE i.idindividuoDesafioMeta = :idindividuoDesafioMeta")})
public class IndividuoDesafioMeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idindividuo_desafio_meta")
    private Integer idindividuoDesafioMeta;
    @JoinColumn(name = "meta_id_meta", referencedColumnName = "id_meta")
    @ManyToOne(optional = false)
    private Meta meta;
    @JoinColumn(name = "individuo_desafio_id_individuo_desafio", referencedColumnName = "id_individuo_desafio")
    @ManyToOne(optional = false)
    private IndividuoDesafio individuoDesafio;

    public IndividuoDesafioMeta() {
    }

    public IndividuoDesafioMeta(Integer idindividuoDesafioMeta) {
        this.idindividuoDesafioMeta = idindividuoDesafioMeta;
    }

    public Integer getIdindividuoDesafioMeta() {
        return idindividuoDesafioMeta;
    }

    public void setIdindividuoDesafioMeta(Integer idindividuoDesafioMeta) {
        this.idindividuoDesafioMeta = idindividuoDesafioMeta;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public IndividuoDesafio getIndividuoDesafio() {
        return individuoDesafio;
    }

    public void setIndividuoDesafio(IndividuoDesafio individuoDesafio) {
        this.individuoDesafio = individuoDesafio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idindividuoDesafioMeta != null ? idindividuoDesafioMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndividuoDesafioMeta)) {
            return false;
        }
        IndividuoDesafioMeta other = (IndividuoDesafioMeta) object;
        if ((this.idindividuoDesafioMeta == null && other.idindividuoDesafioMeta != null) || (this.idindividuoDesafioMeta != null && !this.idindividuoDesafioMeta.equals(other.idindividuoDesafioMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.IndividuoDesafioMeta[ idindividuoDesafioMeta=" + idindividuoDesafioMeta + " ]";
    }

}
