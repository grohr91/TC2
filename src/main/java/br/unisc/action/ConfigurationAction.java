package br.unisc.action;

import br.unisc.dto.ConnectionDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class ConfigurationAction extends ActionSupport {

    private ConnectionDTO connection;
    private String dsMessage;

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

}
