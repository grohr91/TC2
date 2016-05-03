package br.unisc.controller;

import br.com.unisc.model.ConfMap;
import br.com.unisc.model.ConfMapping;
import br.unisc.dto.ConnectionDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class ConfMappingController {

    protected EntityManager em;

    public ConfMappingController(EntityManager em) {
        this.em = em;
    }

    public ConfMapping save(ConfMapping confMapping) {
        em.persist(confMapping);
        em.flush();
        return confMapping;
    }

    public List<ConfMap> findAll() {
        return em.createNamedQuery("ConfMap.findAll", ConfMap.class)
                .getResultList();
    }

    public List<ConfMapping> saveList(List<ConfMapping> mappingList, ConfMap confMap) {
        for (ConfMapping cm : mappingList) {
            if (cm.getNmFieldSource() == null || cm.getNmFieldSource().isEmpty()) {
                cm.setNmFieldSource("");
                cm.setNmTableSource("");
            }
            cm.setConfMap(confMap);
            cm = save(cm);
        }

        return mappingList;
    }

    public void removeAllByConfMapp(Integer idMap) {
        Query q = em.createNativeQuery("DELETE FROM conf_mapping "
                + "WHERE id_map = ?1");
        q.setParameter(1, idMap);
        q.executeUpdate();
        em.flush();
    }

    public List<ConfMapping> findByConfMap(Integer idMap) {
        Query q = em.createNativeQuery("SELECT * FROM conf_mapping "
                + "WHERE id_map = ?1 ORDER BY id_mapping", ConfMapping.class);
        q.setParameter(1, idMap);
        return q.getResultList();
    }

    public void populateColumnList(List<ConfMapping> confMappingList,
            ConnectionDTO conn) {
        if (confMappingList != null) {
            TableDTOController tc = new TableDTOController(conn.getEm());
            for (ConfMapping cm : confMappingList) {
                cm.setColumnList(
                        tc.findColumnByNmTable(cm.getNmTableSource(),
                                conn.getDbType()));
            }
        }
    }

}
