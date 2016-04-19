package br.unisc.action;

import br.com.unisc.model.ConfMap;
import br.com.unisc.model.ConfMapping;
import br.unisc.controller.ConfMappingController;
import br.unisc.controller.SchemaDTOController;
import br.unisc.dto.ConnectionDTO;
import br.unisc.dto.SchemaDTO;
import br.unisc.util.EMAware;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
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
    private List<ConfMap> confMapList;
    private List<ConfMapping> confMappingList;

    public String main() throws Exception {
        try {
            connection = new ConnectionDTO();
            connection.setNrIp("127.0.0.1");
            connection.setNrPort(5432);
            connection.setNmDatabase("ideatennis");
            connection.setNmUser("postgres");
            connection.setCdPass("postgres");
            connection.setNmService("");
            confMapList = new ConfMappingController(em).findAll();
            confMapList.add(new ConfMap(0, "New One"));
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
        } catch (Exception ex) {
            ex.printStackTrace();
            dsMessage = "Something wrong occoured";
        }
        return SUCCESS;
    }

    public String loadDatabase() {
        try {
            //passa conexão do BD TC2
            SchemaDTOController schemaDTOController = new SchemaDTOController(em);
            
            //busca nomes de todas tabelas do BD
            schema = schemaDTOController.loadByNmSchema("tc2", ConnectionDTO.MYSQL);
            confMappingList = new ArrayList<ConfMapping>();
            
            //busca nomes de todas tabelas do BD configurado
            schemaExport = schemaDTOController.loadByNmSchema(
                    connection.getNmDatabase(), connection.getDbType());
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

}
