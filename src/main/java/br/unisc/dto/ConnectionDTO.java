package br.unisc.dto;

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

    private EntityManager em;

    private String nrIp;
    private Integer nrPort;
    private String nmService;
    private String nmDatabase;
    private String nmUser;
    private String cdPass;
    private Integer dbType;

    private static final int POSTGRESQL = 1;
    private static final int MYSQL = 2;

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

    public String validateParams() {
        if (nmUser == null || nmUser.isEmpty()) {
            return "User cannot be blank";
        }
        if (cdPass == null || cdPass.isEmpty()) {
            return "Password cannot be blank";
        }
        if (nrIp == null || nrIp.isEmpty()) {
            return "Host cannot be blank";
        }
        if (nrPort == null || nrPort == 0) {
            return "Port cannot be blank";
        }
        if (nmDatabase == null || nmDatabase.isEmpty()) {
            return "Port cannot be blank";
        }
        return "";
    }

    public String open() {
        String validate = validateParams();
        if (!validate.isEmpty()) {
            return validate;
        }
        Map<String, String> properties = getMapByDbType();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceTcc", properties);
            em = emf.createEntityManager();
            em.getTransaction().begin();
        } catch (Exception ex) {
            ex.printStackTrace();
            close();
            return ex.getMessage();
        }
        return "";
    }

    public void close() {
        if (em != null && em.isOpen()) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    public void commit() {
        if (em != null && em.isOpen()) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().commit();
            }
            em.close();
        }
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Integer getDbType() {
        return dbType;
    }

    public void setDbType(Integer dbType) {
        this.dbType = dbType;
    }

    private Map<String, String> getMapByDbType() {
        Map<String, String> properties = new HashMap<String, String>();

        properties.put("eclipselink.cache.shared.default", "false");
        properties.put("eclipselink.jdbc.user", nmUser);
        properties.put("eclipselink.jdbc.password", cdPass);

        if (POSTGRESQL == dbType) {
            properties.put("eclipselink.target-database", "PostgreSQL");
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            properties.put("eclipselink.jdbc.url", "jdbc:postgresql://" + nrIp + ":" + nrPort.toString() + "/" + nmDatabase);
        } else if (MYSQL == dbType) {
            properties.put("eclipselink.target-database", "MySQL");
            properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            properties.put("eclipselink.jdbc.url", "jdbc:mysql://" + nrIp + ":" + nrPort.toString() + "/" + nmDatabase);
        }

        return properties;
    }

}
