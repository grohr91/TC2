package br.unisc.controller;

import br.unisc.dto.ConnectionDTO;
import br.unisc.model.Desafio;
import br.unisc.model.Grupo;
import br.unisc.model.GrupoDesafio;
import br.unisc.model.GrupoIndividuo;
import br.unisc.model.Individuo;
import br.unisc.model.IndividuoDesafio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class DownloadController {

    protected EntityManager em;
    protected ConnectionDTO conn;

    public DownloadController(EntityManager em) {
        this.em = em;
    }

    public List<Individuo> findAllIndividuo() {
        Query q = em.createNativeQuery("SELECT * FROM individuo ORDER BY nm_individuo", Individuo.class);
        return q.getResultList();
    }

    public List<Grupo> findAllGrupo() {
        Query q = em.createNativeQuery("SELECT * FROM grupo ORDER BY nm_grupo", Grupo.class);
        return q.getResultList();
    }

    public List<GrupoIndividuo> findAllGrupoIndividuo() {
        Query q = em.createNativeQuery("SELECT * FROM grupo_individuo ORDER BY id_grupo_individuo", GrupoIndividuo.class);
        return q.getResultList();
    }

    public List<IndividuoDesafio> findAllIndividuoDesafio() {
        Query q = em.createNativeQuery("SELECT * FROM grupo_individuo ORDER BY id_grupo_individuo", GrupoIndividuo.class);
        return q.getResultList();
    }

    public List<GrupoDesafio> findAllGrupoDesafio() {
        Query q = em.createNativeQuery("SELECT * FROM grupo_desafio ORDER BY id_grupo_desafio", GrupoDesafio.class);
        return q.getResultList();
    }

    public List<Desafio> findAllDesafio() {
        Query q = em.createNativeQuery("SELECT * FROM desafio ORDER BY nm_desafio", Desafio.class);
        return q.getResultList();
    }
}
