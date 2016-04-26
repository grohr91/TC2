package br.unisc.action;

import br.unisc.controller.TableDTOController;
import br.unisc.dto.ConnectionDTO;
import br.unisc.util.EMAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class TableAction extends ActionSupport implements EMAware {

    private EntityManager em;
    private ConnectionDTO connection;
    private String dsMessage;
    private String nmTable;
    private List<String> columnList;
    private Map<String, Object> sessionMap;

    public String loadTableByNmTable() {
        try {
            sessionMap = ActionContext.getContext().getSession();
            connection = (ConnectionDTO) sessionMap.get("CURRENT_CONNECTION");
            connection.open();
            LinkedHashMap<Integer, String> columns = new TableDTOController(connection.getEm())
                    .findColumnByNmTable(nmTable, connection.getDbType());
            columnList = new ArrayList<String>(columns.values());
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

    public List<String> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<String> columnList) {
        this.columnList = columnList;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getNmTable() {
        return nmTable;
    }

    public void setNmTable(String nmTable) {
        this.nmTable = nmTable;
    }

}
