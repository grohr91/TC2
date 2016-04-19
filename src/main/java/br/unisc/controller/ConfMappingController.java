package br.unisc.controller;

import br.com.unisc.model.ConfMap;
import br.com.unisc.model.ConfMapping;
import java.util.List;
import javax.persistence.EntityManager;

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

}
