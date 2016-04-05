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
public class TableDTO {

    private String nmTable;
    private LinkedHashMap<Integer, String> columns;

    public TableDTO(String nm) {
        this.nmTable = nm;
    }

    public String getNmTable() {
        return nmTable;
    }

    public void setNmTable(String nmTable) {
        this.nmTable = nmTable;
    }

    public LinkedHashMap<Integer, String> getColumns() {
        return columns;
    }

    public void setColumns(LinkedHashMap<Integer, String> columns) {
        this.columns = columns;
    }

}
