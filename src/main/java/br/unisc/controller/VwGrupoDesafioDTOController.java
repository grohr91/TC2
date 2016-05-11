package br.unisc.controller;

import br.unisc.dto.ConnectionDTO;
import br.unisc.dto.VwGrupoDesafioDTO;
import br.unisc.model.Desafio;
import br.unisc.model.Grupo;
import br.unisc.model.GrupoDesafio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class VwGrupoDesafioDTOController {

    protected EntityManager em;
    protected ConnectionDTO conn;

    public VwGrupoDesafioDTOController(EntityManager em, ConnectionDTO c) {
        this.em = em;
        this.conn = c;
    }

    public List<VwGrupoDesafioDTO> findGrupoDesafio() {
        Query q = conn.getEm().createNativeQuery("SELECT * FROM vw_grupo_desafio "
                + "ORDER BY id_grupo", VwGrupoDesafioDTO.class);
        return q.getResultList();
    }

    public GrupoDesafio insertOrUpdate(VwGrupoDesafioDTO obj) {
        GrupoDesafio gdVw = obj.toGrupoDesafio();
        Desafio d = em.merge(gdVw.getDesafio());
        em.flush();

        GrupoDesafio gd = findGrupoDesafio(gdVw.getGrupo(), d);
        gd.setVlAtingido(gdVw.getVlAtingido());
        gd.setSgAtingido(gdVw.getSgAtingido());
        gd.setDtAtingido(gdVw.getDtAtingido());

        gd = em.merge(gd);
        em.flush();
        return gd;
    }

    public GrupoDesafio findGrupoDesafio(Grupo g, Desafio d) {
        Query q = em.createNamedQuery("SELECT * FROM grupo_desafio "
                + "WHERE id_grupo = ?1 AND id_desafio = ?2", GrupoDesafio.class);
        q.setParameter(1, g.getIdGrupo());
        q.setParameter(2, d.getIdDesafio());
        List<GrupoDesafio> grupoDesafioList = q.getResultList();

        //Do not exists in DB, return a new one
        if (grupoDesafioList.isEmpty()) {
            GrupoDesafio gd = new GrupoDesafio(g, d);
            return gd;
        }
        return grupoDesafioList.get(0);
    }

}
