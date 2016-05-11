package br.unisc.controller;

import javax.persistence.EntityManager;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class SchemaDTOController {

    protected EntityManager em;
    

    public SchemaDTOController(EntityManager em) {
        this.em = em;
    }
}
