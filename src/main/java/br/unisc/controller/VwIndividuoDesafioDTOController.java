package br.unisc.controller;

import br.unisc.dto.ConnectionDTO;
import br.unisc.dto.VwIndividuoDesafioDTO;
import br.unisc.model.Desafio;
import br.unisc.model.Individuo;
import br.unisc.model.IndividuoDesafio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class VwIndividuoDesafioDTOController {

    protected EntityManager em;
    protected ConnectionDTO conn;

    public VwIndividuoDesafioDTOController(EntityManager em, ConnectionDTO c) {
        this.em = em;
        this.conn = c;
    }

    public List<VwIndividuoDesafioDTO> findIndividuoDesafio() {
        Query q = conn.getEm().createNativeQuery("SELECT * FROM vw_individuo_desafio "
                + "ORDER BY id_individuo ", VwIndividuoDesafioDTO.class);
        return q.getResultList();
    }

    public IndividuoDesafio insertOrUpdate(VwIndividuoDesafioDTO obj) {
        IndividuoDesafio idVw = obj.toIndividuoDesafio();
        Desafio d = em.merge(idVw.getDesafio());
        em.flush();

        IndividuoDesafio id = findIndividuoDesafio(idVw.getIndividuo(), d);
        id.setVlAtingido(idVw.getVlAtingido());
        id.setSgAtingido(idVw.getSgAtingido());
        id.setDtAtingido(idVw.getDtAtingido());

        id = em.merge(id);
        em.flush();
        return id;
    }

    public IndividuoDesafio findIndividuoDesafio(Individuo i, Desafio d) {
        Query q = em.createNativeQuery("SELECT * FROM individuo_desafio "
                + "WHERE id_individuo = ?1 AND id_desafio = ?2", IndividuoDesafio.class);
        q.setParameter(1, i.getIdIndividuo());
        q.setParameter(2, d.getIdDesafio());
        List<IndividuoDesafio> individuoDesafioList = q.getResultList();

        //Do not exists in DB, return a new one
        if (individuoDesafioList.isEmpty()) {
            IndividuoDesafio id = new IndividuoDesafio(i, d);
            return id;
        }
        return individuoDesafioList.get(0);
    }

}
