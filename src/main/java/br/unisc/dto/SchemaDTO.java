/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.dto;

import java.util.LinkedHashMap;

/**
 *
 * @author Guilherme Rohr - m68663
 */
public class SchemaDTO {

    private String nmSchema;
    private int dbType;
    private LinkedHashMap<Integer, TableDTO> tableList;

    public static final int POSTGRESQL = 0;
    public static final int MYSQL = 1;

    public SchemaDTO(String nmSchema, int dbType) {
        this.nmSchema = nmSchema;
        this.dbType = dbType;
    }

    public LinkedHashMap<Integer, TableDTO> getTableList() {
        return tableList;
    }

    public void setTableList(LinkedHashMap<Integer, TableDTO> tableList) {
        this.tableList = tableList;
    }

    public String getNmSchema() {
        return nmSchema;
    }

    public void setNmSchema(String nmSchema) {
        this.nmSchema = nmSchema;
    }

    public int getDbType() {
        return dbType;
    }

    public void setDbType(int dbType) {
        this.dbType = dbType;
    }

}
