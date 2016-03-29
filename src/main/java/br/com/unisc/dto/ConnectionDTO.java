package br.com.unisc.dto;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class ConnectionDTO {

    private String nrIp;
    private Integer nrPort;
    private String nmService;
    private String nmDatabase;
    private String nmUser;
    private String cdPass;
    private EntityManager em;

    public String getNrIp() {
        return nrIp;
    }

    public void setNrIp(String nrIp) {
        this.nrIp = nrIp;
    }

    public Integer getNrPort() {
        return nrPort;
    }

    public void setNrPort(Integer nrPort) {
        this.nrPort = nrPort;
    }

    public String getNmService() {
        return nmService;
    }

    public void setNmService(String nmService) {
        this.nmService = nmService;
    }

    public String getNmDatabase() {
        return nmDatabase;
    }

    public void setNmDatabase(String nmDatabase) {
        this.nmDatabase = nmDatabase;
    }

    public String getNmUser() {
        return nmUser;
    }

    public void setNmUser(String nmUser) {
        this.nmUser = nmUser;
    }

    public String getCdPass() {
        return cdPass;
    }

    public void setCdPass(String cdPass) {
        this.cdPass = cdPass;
    }

    public String open() {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("javax.persistence.jdbc.user", nmUser);
        properties.put("javax.persistence.jdbc.password", cdPass);
        properties.put("javax.persistence.jdbc.database", nmDatabase);
        properties.put("javax.persistence.jdbc.port", nrPort.toString());

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb://localhost/myDbFile.odb;user=admin;password=admin");
            em = emf.createEntityManager(properties);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
        return "";
    }

    public void close() {
        em.close();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
