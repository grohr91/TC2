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
@Table(name = "grupo_individuo")
@NamedQueries({
    @NamedQuery(name = "GrupoIndividuo.findAll", query = "SELECT g FROM GrupoIndividuo g"),
    @NamedQuery(name = "GrupoIndividuo.findByIdGrupoIndividuo", query = "SELECT g FROM GrupoIndividuo g WHERE g.idGrupoIndividuo = :idGrupoIndividuo")})
public class GrupoIndividuo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo_individuo")
    private Integer idGrupoIndividuo;
    @JoinColumn(name = "id_individuo", referencedColumnName = "id_individuo")
    @ManyToOne(optional = false)
    private Individuo individuo;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false)
    private Grupo grupo;

    public GrupoIndividuo() {
    }

    public GrupoIndividuo(Integer idGrupoIndividuo) {
        this.idGrupoIndividuo = idGrupoIndividuo;
    }

    public GrupoIndividuo(Grupo g, Individuo i) {
        this.grupo = g;
        this.individuo = i;
    }

    public Integer getIdGrupoIndividuo() {
        return idGrupoIndividuo;
    }

    public void setIdGrupoIndividuo(Integer idGrupoIndividuo) {
        this.idGrupoIndividuo = idGrupoIndividuo;
    }

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoIndividuo != null ? idGrupoIndividuo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoIndividuo)) {
            return false;
        }
        GrupoIndividuo other = (GrupoIndividuo) object;
        if ((this.idGrupoIndividuo == null && other.idGrupoIndividuo != null) || (this.idGrupoIndividuo != null && !this.idGrupoIndividuo.equals(other.idGrupoIndividuo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unisc.model.GrupoIndividuo[ idGrupoIndividuo=" + idGrupoIndividuo + " ]";
    }

}
