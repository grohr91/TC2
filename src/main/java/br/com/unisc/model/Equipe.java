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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "equipe")
@NamedQueries({
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e"),
    @NamedQuery(name = "Equipe.findByIdEquipe", query = "SELECT e FROM Equipe e WHERE e.idEquipe = :idEquipe")})
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_equipe")
    private Integer idEquipe;
    @Column(name = "nm_equipe")
    private String nmEquipe;

    public Equipe() {
    }

    public Equipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Integer getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNmEquipe() {
        return nmEquipe;
    }

    public void setNmEquipe(String nmEquipe) {
        this.nmEquipe = nmEquipe;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.idEquipe == null && other.idEquipe != null) || (this.idEquipe != null && !this.idEquipe.equals(other.idEquipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.Equipe[ idEquipe=" + idEquipe + " ]";
    }

}
