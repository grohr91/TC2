package br.unisc.action;

import br.com.unisc.model.ConfMap;
import br.com.unisc.model.ConfMapping;
import br.unisc.controller.ConfMappingController;
import br.unisc.controller.SchemaDTOController;
import br.unisc.dto.ConnectionDTO;
import br.unisc.dto.SchemaDTO;
import br.unisc.util.EMAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class ConfigurationAction extends ActionSupport implements EMAware {

    private EntityManager em;
    private ConnectionDTO connection;
    private SchemaDTO schema;
    private SchemaDTO schemaExport;
    private String dsMessage;
    private ConfMap confMap;
    private List<ConfMap> confMapList;
    private List<ConfMapping> confMappingList;
    private Map<String, Object> sessionMap;

    public String main() throws Exception {
        try {
            connection = new ConnectionDTO();
            connection.setNrIp("localhost");
            connection.setNrPort(5433);
            connection.setNmDatabase("miller");
            connection.setNmUser("postgres");
            connection.setCdPass("postgres");
            connection.setNmSchema("public");
            confMapList = new ConfMappingController(em).findAll();
            confMapList.add(0, new ConfMap(0, "New One"));
        } catch (Exception ex) {
            ex.printStackTrace();
            confMapList = new ArrayList<ConfMap>();
        }
        return SUCCESS;
    }

    public String testConnection() {
        try {
            dsMessage = connection.open();
            connection.close();
            sessionMap.put("CURRENT_CONNECTION", connection);
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
        }
        return SUCCESS;
    }

    public String loadDatabase() {
        try {
            if (!validConnection()) {
                return ERROR;
            }
            //passa conexão do BD TC2
            SchemaDTOController schemaDTOController = new SchemaDTOController(em);

            //busca nomes de todas tabelas do BD
            schema = schemaDTOController.loadByNmSchema("tc2", ConnectionDTO.MYSQL);
            loadSchemaToExport();
            return SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
        }
        return ERROR;
    }

    private void loadSchemaToExport() {
        //busca nomes de todas tabelas do BD configurado
        connection.open();
        schemaExport = new SchemaDTOController(connection.getEm())
                .loadByNmSchema(connection.getNmSchema(), connection.getDbType());
        if (confMap == null || confMap.getIdMap() == null
                || confMap.getIdMap().equals(0)) {
            confMappingList = new ArrayList<ConfMapping>();
        } else {
            confMap = em.find(ConfMap.class, confMap.getIdMap());
            confMappingList = new ConfMappingController(em)
                    .findByConfMap(confMap.getIdMap());
        }
        connection.close();
    }

    private boolean validConnection() {
        sessionMap = ActionContext.getContext().getSession();
        if (connection == null) {
            connection = (ConnectionDTO) sessionMap.get("CURRENT_CONNECTION");
        } else {
            testConnection();
            if (dsMessage != null && !dsMessage.isEmpty()) {
                return false;
            }
        }

        if (connection == null) {
            dsMessage = "No connection was defined/save";
            return false;
        }

        return true;
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

    public SchemaDTO getSchema() {
        return schema;
    }

    public void setSchema(SchemaDTO schema) {
        this.schema = schema;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<ConfMap> getConfMapList() {
        return confMapList;
    }

    public void setConfMapList(List<ConfMap> confMapList) {
        this.confMapList = confMapList;
    }

    public List<ConfMapping> getConfMappingList() {
        return confMappingList;
    }

    public void setConfMappingList(List<ConfMapping> confMappingList) {
        this.confMappingList = confMappingList;
    }

    public SchemaDTO getSchemaExport() {
        return schemaExport;
    }

    public void setSchemaExport(SchemaDTO schemaExport) {
        this.schemaExport = schemaExport;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ConfMap getConfMap() {
        return confMap;
    }

    public void setConfMap(ConfMap confMap) {
        this.confMap = confMap;
    }

}
