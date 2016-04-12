package br.unisc.action;

import br.com.unisc.model.ConfMapping;
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
    private String dsMessage;
    private List<ConfMapping> mappingList;

    public String main() throws Exception {
        try {
            connection = new ConnectionDTO();
            connection.setNrIp("127.0.0.1");
            connection.setNrPort(3306);
            connection.setNmDatabase("tc2");
            connection.setNmUser("root");
            connection.setCdPass("root");
            connection.setNmService("");
        } catch (Exception ex) {
            ex.printStackTrace();
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
            schema = schemaDTOController.loadByNmSchema("tc2");
            mappingList = new ArrayList<ConfMapping>();
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

    public List<ConfMapping> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<ConfMapping> mappingList) {
        this.mappingList = mappingList;
    }

}
