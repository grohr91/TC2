package br.com.unisc.action;

import br.com.unisc.dto.ConnectionDTO;
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
            connection.setNmDatabase("test");
            connection.setNmUser("root");
            connection.setCdPass("root");
            connection.setNmService("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    public String testConnection() {
        dsMessage = connection.open();
        connection.close();
        if (dsMessage.isEmpty()) {
            return SUCCESS;
        }
        return ERROR;
    }

    public ConnectionDTO getConnection() {
        return connection;
    }

    public void setConnection(ConnectionDTO connection) {
        this.connection = connection;
    }

}
