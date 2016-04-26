package br.unisc.action;

import br.com.unisc.model.ConfMap;
import br.com.unisc.model.ConfMapping;
import br.unisc.controller.ConfMapController;
import br.unisc.controller.ConfMappingController;
import br.unisc.dto.ConnectionDTO;
import br.unisc.util.EMAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class ConfMapAction extends ActionSupport implements EMAware {

    private EntityManager em;
    private ConnectionDTO connection;
    private String dsMessage;

    private ConfMap confMap;
    private List<ConfMapping> mappingList;
    private Map<String, Object> sessionMap;

    public String save() {
        try {
            sessionMap = ActionContext.getContext().getSession();
            connection = (ConnectionDTO) sessionMap.get("CURRENT_CONNECTION");
            connection.open();
            //logica de salvar aqui
            ConfMapController cmc = new ConfMapController(em);
            confMap = cmc.save(confMap);

            ConfMappingController cmc1 = new ConfMappingController(em);
            mappingList = cmc1.saveList(mappingList, confMap);
            connection.close();
            return SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
        }
        return ERROR;
    }

    public ConnectionDTO getConnection() {
        return connection;
    }

    public void setConnection(ConnectionDTO connection) {
        this.connection = connection;
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

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<ConfMapping> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<ConfMapping> mappingList) {
        this.mappingList = mappingList;
    }

    public ConfMap getConfMap() {
        return confMap;
    }

    public void setConfMap(ConfMap confMap) {
        this.confMap = confMap;
    }

}
