package br.unisc.controller;

import br.com.unisc.model.ConfMapping;
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

}
