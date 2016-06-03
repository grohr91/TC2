package br.unisc.action;

import br.unisc.controller.DownloadController;
import br.unisc.model.Desafio;
import br.unisc.model.Grupo;
import br.unisc.model.GrupoDesafio;
import br.unisc.model.GrupoIndividuo;
import br.unisc.model.Individuo;
import br.unisc.model.IndividuoDesafio;
import br.unisc.util.EMAware;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class DownloadAction extends ActionSupport implements EMAware {

    private EntityManager em;
    private String dsMessage;
    private List<Individuo> individuoList;
    private List<IndividuoDesafio> individuoDesafioList;
    private List<Grupo> grupoList;
    private List<GrupoIndividuo> grupoIndividuoList;
    private List<GrupoDesafio> grupoDesafioList;
    private List<Desafio> desafioList;

    public String individuo() throws Exception {
        try {
            individuoList = new DownloadController(em).findAllIndividuo();
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
            return ERROR;
        }
        return SUCCESS;
    }

    public String grupo() throws Exception {
        try {
            grupoList = new DownloadController(em).findAllGrupo();
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
            return ERROR;
        }
        return SUCCESS;
    }

    public String desafio() throws Exception {
        try {
            desafioList = new DownloadController(em).findAllDesafio();
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
            return ERROR;
        }
        return SUCCESS;
    }

    public String grupoIndividuo() throws Exception {
        try {
            grupoIndividuoList = new DownloadController(em).findAllGrupoIndividuo();
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
            return ERROR;
        }
        return SUCCESS;
    }

    public String individuoDesafio() throws Exception {
        try {
            individuoDesafioList = new DownloadController(em).findAllIndividuoDesafio();
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
            return ERROR;
        }
        return SUCCESS;
    }

    public String grupoDesafio() throws Exception {
        try {
            grupoDesafioList = new DownloadController(em).findAllGrupoDesafio();
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
            return ERROR;
        }
        return SUCCESS;
    }

    /**
     * TODO!
     *
     * @return
     * @throws Exception
     */
    public String descricaoSituacao() throws Exception {
        try {
            individuoList = new DownloadController(em).findAllIndividuo();
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
            return ERROR;
        }
        return SUCCESS;
    }

    public String getDsMessage() {
        if (dsMessage != null && !dsMessage.isEmpty()) {
            dsMessage = "<div class=\"alert alert-danger\" role=\"alert\">"
                    + dsMessage + "</div>";
        }
        return dsMessage;
    }

    public void setDsMessage(String dsMessage) {
        this.dsMessage = dsMessage;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Individuo> getIndividuoList() {
        return individuoList;
    }

    public void setIndividuoList(List<Individuo> individuoList) {
        this.individuoList = individuoList;
    }

    public List<IndividuoDesafio> getIndividuoDesafioList() {
        return individuoDesafioList;
    }

    public void setIndividuoDesafioList(List<IndividuoDesafio> individuoDesafioList) {
        this.individuoDesafioList = individuoDesafioList;
    }

    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    public List<GrupoIndividuo> getGrupoIndividuoList() {
        return grupoIndividuoList;
    }

    public void setGrupoIndividuoList(List<GrupoIndividuo> grupoIndividuoList) {
        this.grupoIndividuoList = grupoIndividuoList;
    }

    public List<GrupoDesafio> getGrupoDesafioList() {
        return grupoDesafioList;
    }

    public void setGrupoDesafioList(List<GrupoDesafio> grupoDesafioList) {
        this.grupoDesafioList = grupoDesafioList;
    }

    public List<Desafio> getDesafioList() {
        return desafioList;
    }

    public void setDesafioList(List<Desafio> desafioList) {
        this.desafioList = desafioList;
    }

}
