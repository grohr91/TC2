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
@Table(name = "conf_map")
@NamedQueries({
    @NamedQuery(name = "ConfMap.findAll", query = "SELECT c FROM ConfMap c ORDER BY c.nmMap"),
    @NamedQuery(name = "ConfMap.findByIdMap", query = "SELECT c FROM ConfMap c WHERE c.idMap = :idMap"),
    @NamedQuery(name = "ConfMap.findByNmMap", query = "SELECT c FROM ConfMap c WHERE c.nmMap = :nmMap")})
public class ConfMap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_map")
    private Integer idMap;
    @Basic(optional = false)
    @Column(name = "nm_map")
    private String nmMap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMap")
    private List<ConfMapping> confMappingList;

    public ConfMap() {
    }

    public ConfMap(Integer idMap) {
        this.idMap = idMap;
    }

    public ConfMap(Integer idMap, String nmMap) {
        this.idMap = idMap;
        this.nmMap = nmMap;
    }

    public Integer getIdMap() {
        return idMap;
    }

    public void setIdMap(Integer idMap) {
        this.idMap = idMap;
    }

    public String getNmMap() {
        return nmMap;
    }

    public void setNmMap(String nmMap) {
        this.nmMap = nmMap;
    }

    public List<ConfMapping> getConfMappingList() {
        return confMappingList;
    }

    public void setConfMappingList(List<ConfMapping> confMappingList) {
        this.confMappingList = confMappingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMap != null ? idMap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfMap)) {
            return false;
        }
        ConfMap other = (ConfMap) object;
        if ((this.idMap == null && other.idMap != null) || (this.idMap != null && !this.idMap.equals(other.idMap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.unisc.model.ConfMap[ idMap=" + idMap + " ]";
    }
    
}
