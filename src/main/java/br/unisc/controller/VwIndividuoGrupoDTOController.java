package br.unisc.controller;

import br.unisc.dto.ConnectionDTO;
import br.unisc.dto.VwIndividuoGrupoDTO;
import br.unisc.model.Grupo;
import br.unisc.model.GrupoIndividuo;
import br.unisc.model.Individuo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class VwIndividuoGrupoDTOController {

    protected EntityManager em;
    protected ConnectionDTO conn;

    public VwIndividuoGrupoDTOController(EntityManager em, ConnectionDTO c) {
        this.em = em;
        this.conn = c;
    }

    public List<VwIndividuoGrupoDTO> findIndividuoGrupo() {
        Query q = conn.getEm().createNativeQuery("SELECT * FROM vw_individuo_grupo "
                + "ORDER BY id_individuo", VwIndividuoGrupoDTO.class);
        return q.getResultList();
    }

    public Individuo insertOrUpdate(VwIndividuoGrupoDTO obj) {
        Grupo g = em.merge(obj.toIndividuo().getGrupo());
        Individuo i = em.merge(obj.toIndividuo());
        em.flush();

        GrupoIndividuo gi = findIndividuoGrupo(g, i);
        gi = em.merge(gi);

        em.flush();
        return i;
    }

    public GrupoIndividuo findIndividuoGrupo(Grupo g, Individuo i) {
        Query q = em.createNamedQuery("SELECT * FROM grupo_individuo "
                + "WHERE id_grupo = ?1 AND id_individuo = ?2", GrupoIndividuo.class);
        q.setParameter(1, g.getIdGrupo());
        q.setParameter(2, i.getIdIndividuo());
        List<GrupoIndividuo> grupoIndividuoList = q.getResultList();

        //Do not exists in DB, return a new one
        if (grupoIndividuoList.isEmpty()) {
            GrupoIndividuo gi = new GrupoIndividuo(g, i);
            return gi;
        }
        return grupoIndividuoList.get(0);
    }

}
