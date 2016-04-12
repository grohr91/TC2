package br.unisc.controller;

import br.com.unisc.model.ConfMap;
import javax.persistence.EntityManager;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class ConfMapController {

    protected EntityManager em;

    public ConfMapController(EntityManager em) {
        this.em = em;
    }
    
    public ConfMap save(ConfMap confMap){
        em.persist(confMap);
        em.flush();
        return confMap;
    }

}
