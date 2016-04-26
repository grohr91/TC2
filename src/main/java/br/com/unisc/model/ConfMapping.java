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
@Table(name = "conf_mapping")
@NamedQueries({
    @NamedQuery(name = "ConfMapping.findAll", query = "SELECT c FROM ConfMapping c"),
    @NamedQuery(name = "ConfMapping.findByIdMapping", query = "SELECT c FROM ConfMapping c WHERE c.idMapping = :idMapping"),
    @NamedQuery(name = "ConfMapping.findByNmFieldSource", query = "SELECT c FROM ConfMapping c WHERE c.nmFieldSource = :nmFieldSource"),
    @NamedQuery(name = "ConfMapping.findByNmFieldDest", query = "SELECT c FROM ConfMapping c WHERE c.nmFieldDest = :nmFieldDest")})
public class ConfMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mapping")
    private Integer idMapping;
    @Basic(optional = false)
    @Column(name = "nm_table_source")
    private String nmTableSource;
    @Basic(optional = false)
    @Column(name = "nm_field_source")
    private String nmFieldSource;
    @Basic(optional = false)
    @Column(name = "nm_field_dest")
    private String nmFieldDest;
    @JoinColumn(name = "id_map", referencedColumnName = "id_map")
    @ManyToOne(optional = false)
    private ConfMap confMap;

    public ConfMapping() {
    }

    public ConfMapping(Integer idMapping) {
        this.idMapping = idMapping;
    }

    public ConfMapping(Integer idMapping, String nmFieldSource, String nmFieldDest) {
        this.idMapping = idMapping;
        this.nmFieldSource = nmFieldSource;
        this.nmFieldDest = nmFieldDest;
    }

    public Integer getIdMapping() {
        return idMapping;
    }

    public void setIdMapping(Integer idMapping) {
        this.idMapping = idMapping;
    }

    public String getNmFieldSource() {
        return nmFieldSource;
    }

    public void setNmFieldSource(String nmFieldSource) {
        this.nmFieldSource = nmFieldSource;
    }

    public String getNmFieldDest() {
        return nmFieldDest;
    }

    public void setNmFieldDest(String nmFieldDest) {
        this.nmFieldDest = nmFieldDest;
    }

    public ConfMap getConfMap() {
        return confMap;
    }

    public void setConfMap(ConfMap confMap) {
        this.confMap = confMap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMapping != null ? idMapping.hashCode() : 0);
        return hash;
    }

    public String getNmTableSource() {
        return nmTableSource;
    }

    public void setNmTableSource(String nmTableSource) {
        this.nmTableSource = nmTableSource;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfMapping)) {
            return false;
        }
        ConfMapping other = (ConfMapping) object;
        if ((this.idMapping == null && other.idMapping != null) || (this.idMapping != null && !this.idMapping.equals(other.idMapping))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.ConfMapping[ idMapping=" + idMapping + " ]";
    }

}
