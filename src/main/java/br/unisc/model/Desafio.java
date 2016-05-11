/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "desafio")
@NamedQueries({
    @NamedQuery(name = "Desafio.findAll", query = "SELECT d FROM Desafio d"),
    @NamedQuery(name = "Desafio.findByIdDesafio", query = "SELECT d FROM Desafio d WHERE d.idDesafio = :idDesafio"),
    @NamedQuery(name = "Desafio.findByNmDesafio", query = "SELECT d FROM Desafio d WHERE d.nmDesafio = :nmDesafio"),
    @NamedQuery(name = "Desafio.findByNrNivelNecessario", query = "SELECT d FROM Desafio d WHERE d.nrNivelNecessario = :nrNivelNecessario")})
public class Desafio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_desafio")
    private Integer idDesafio;
    @Column(name = "nm_desafio")
    private String nmDesafio;
    @Basic(optional = false)
    @Column(name = "nr_nivel_necessario")
    private int nrNivelNecessario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desafio")
    private List<IndividuoDesafio> individuoDesafioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desafio")
    private List<GrupoDesafio> grupoDesafioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desafio")
    private List<Meta> metaList;

    public Desafio() {
    }

    public Desafio(Integer idDesafio) {
        this.idDesafio = idDesafio;
    }

    public Desafio(Integer idDesafio, String nmDesafio) {
        this.idDesafio = idDesafio;
        this.nmDesafio = nmDesafio;
    }

    public Integer getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(Integer idDesafio) {
        this.idDesafio = idDesafio;
    }

    public String getNmDesafio() {
        return nmDesafio;
    }

    public void setNmDesafio(String nmDesafio) {
        this.nmDesafio = nmDesafio;
    }

    public int getNrNivelNecessario() {
        return nrNivelNecessario;
    }

    public void setNrNivelNecessario(int nrNivelNecessario) {
        this.nrNivelNecessario = nrNivelNecessario;
    }

    public List<IndividuoDesafio> getIndividuoDesafioList() {
        return individuoDesafioList;
    }

    public void setIndividuoDesafioList(List<IndividuoDesafio> individuoDesafioList) {
        this.individuoDesafioList = individuoDesafioList;
    }

    public List<GrupoDesafio> getGrupoDesafioList() {
        return grupoDesafioList;
    }

    public void setGrupoDesafioList(List<GrupoDesafio> grupoDesafioList) {
        this.grupoDesafioList = grupoDesafioList;
    }

    public List<Meta> getMetaList() {
        return metaList;
    }

    public void setMetaList(List<Meta> metaList) {
        this.metaList = metaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesafio != null ? idDesafio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desafio)) {
            return false;
        }
        Desafio other = (Desafio) object;
        if ((this.idDesafio == null && other.idDesafio != null) || (this.idDesafio != null && !this.idDesafio.equals(other.idDesafio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.Desafio[ idDesafio=" + idDesafio + " ]";
    }

}
