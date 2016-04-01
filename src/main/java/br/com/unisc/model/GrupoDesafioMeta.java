/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unisc.model;

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
@Table(name = "grupo_desafio_meta")
@NamedQueries({
    @NamedQuery(name = "GrupoDesafioMeta.findAll", query = "SELECT g FROM GrupoDesafioMeta g"),
    @NamedQuery(name = "GrupoDesafioMeta.findByIdGrupoDesafioMeta", query = "SELECT g FROM GrupoDesafioMeta g WHERE g.idGrupoDesafioMeta = :idGrupoDesafioMeta")})
public class GrupoDesafioMeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo_desafio_meta")
    private Integer idGrupoDesafioMeta;
    @JoinColumn(name = "meta_id_meta", referencedColumnName = "id_meta")
    @ManyToOne(optional = false)
    private Meta metaIdMeta;
    @JoinColumn(name = "grupo_desafio_id_grupo_desafio", referencedColumnName = "id_grupo_desafio")
    @ManyToOne(optional = false)
    private GrupoDesafio grupoDesafioIdGrupoDesafio;

    public GrupoDesafioMeta() {
    }

    public GrupoDesafioMeta(Integer idGrupoDesafioMeta) {
        this.idGrupoDesafioMeta = idGrupoDesafioMeta;
    }

    public Integer getIdGrupoDesafioMeta() {
        return idGrupoDesafioMeta;
    }

    public void setIdGrupoDesafioMeta(Integer idGrupoDesafioMeta) {
        this.idGrupoDesafioMeta = idGrupoDesafioMeta;
    }

    public Meta getMetaIdMeta() {
        return metaIdMeta;
    }

    public void setMetaIdMeta(Meta metaIdMeta) {
        this.metaIdMeta = metaIdMeta;
    }

    public GrupoDesafio getGrupoDesafioIdGrupoDesafio() {
        return grupoDesafioIdGrupoDesafio;
    }

    public void setGrupoDesafioIdGrupoDesafio(GrupoDesafio grupoDesafioIdGrupoDesafio) {
        this.grupoDesafioIdGrupoDesafio = grupoDesafioIdGrupoDesafio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoDesafioMeta != null ? idGrupoDesafioMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoDesafioMeta)) {
            return false;
        }
        GrupoDesafioMeta other = (GrupoDesafioMeta) object;
        if ((this.idGrupoDesafioMeta == null && other.idGrupoDesafioMeta != null) || (this.idGrupoDesafioMeta != null && !this.idGrupoDesafioMeta.equals(other.idGrupoDesafioMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.GrupoDesafioMeta[ idGrupoDesafioMeta=" + idGrupoDesafioMeta + " ]";
    }
    
}
