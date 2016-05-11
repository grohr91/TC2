package br.unisc.controller;

import br.unisc.dto.ConnectionDTO;
import br.unisc.dto.VwGrupoDesafioDTO;
import br.unisc.dto.VwIndividuoDesafioDTO;
import br.unisc.dto.VwIndividuoGrupoDTO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class GamificationController {

    protected EntityManager em;
    protected ConnectionDTO conn;

    public GamificationController(EntityManager em, ConnectionDTO c) {
        this.em = em;
        this.conn = c;
    }

    /**
     * Insert or update all players and their respected groups
     *
     * @return
     */
    public String processVwIndividuoGrupo() {
        VwIndividuoGrupoDTOController igc = new VwIndividuoGrupoDTOController(em, conn);
        List<VwIndividuoGrupoDTO> individuoGrupoList = igc.findIndividuoGrupo();
        int countRight = 0;
        int countWrong = 0;
        for (VwIndividuoGrupoDTO ig : individuoGrupoList) {
            try {
                igc.insertOrUpdate(ig);
                countRight++;
            } catch (Exception ex) {
                countWrong++;
            }
        }
        System.out.println("Players inserted or merged: " + countRight + " of " + individuoGrupoList.size());
        System.out.println("Players not treated: " + countWrong + " of " + individuoGrupoList.size());
        return ("Players inserted or merged: " + countRight + " of " + individuoGrupoList.size());
    }

    /**
     * Insert new challanges to players
     *
     * @return
     */
    public String processVwIndividuoDesafio() {
        VwIndividuoDesafioDTOController idc = new VwIndividuoDesafioDTOController(em, conn);
        List< VwIndividuoDesafioDTO> individuoDesafioList = idc.findIndividuoDesafio();
        int countRight = 0;
        int countWrong = 0;
        for (VwIndividuoDesafioDTO id : individuoDesafioList) {
            try {
                idc.insertOrUpdate(id);
                countRight++;
            } catch (Exception ex) {
                countWrong++;
            }
        }
        System.out.println("Player Challanges inserted or merged: " + countRight + " of " + individuoDesafioList.size());
        System.out.println("Player Challanges not treated: " + countWrong + " of " + individuoDesafioList.size());
        return ("Player Challanges inserted or merged: " + countRight + " of " + individuoDesafioList.size());
    }

    /**
     * Insert new challanges to player groups
     *
     * @return
     */
    public String processVwGrupoDesafio() {
        VwGrupoDesafioDTOController igc = new VwGrupoDesafioDTOController(em, conn);
        List< VwGrupoDesafioDTO> grupoDesafioList = igc.findGrupoDesafio();
        int countRight = 0;
        int countWrong = 0;
        for (VwGrupoDesafioDTO gd : grupoDesafioList) {
            try {
                igc.insertOrUpdate(gd);
                countRight++;
            } catch (Exception ex) {
                countWrong++;
            }
        }
        System.out.println("Group Challanges inserted or merged: " + countRight + " of " + grupoDesafioList.size());
        System.out.println("Group Challanges not treated: " + countWrong + " of " + grupoDesafioList.size());
        return ("Group Challanges inserted or merged: " + countRight + " of " + grupoDesafioList.size());
    }

}
