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
    private LinkedHashMap<Integer, TableDTO> tableList;

    public SchemaDTO(String nmSchema) {
        this.nmSchema = nmSchema;
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

}
