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
class TableDTO {

    private String nmTable;
    private LinkedHashMap<Integer, String> columns;

    public TableDTO(String nm) {
        this.nmTable = nm;
    }

    public LinkedHashMap<Integer, String> getColumns() {
        return columns;
    }

    public String getNmTable() {
        return nmTable;
    }

    public void setNmTable(String nmTable) {
        this.nmTable = nmTable;
    }

}
