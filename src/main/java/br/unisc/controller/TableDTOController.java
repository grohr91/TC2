/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.controller;

import br.unisc.dto.TableDTO;
import java.util.LinkedHashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class TableDTOController  {

    protected EntityManager em;
    
    public TableDTOController(EntityManager em) {
        this.em = em;
    }

    public LinkedHashMap<Integer, TableDTO> findTableByNmSchema(String nmSchema) {
        Query q = em.createNativeQuery("select * "
                + "from information_schema.tables "
                + "where TABLE_SCHEMA = ?1 "
                + "order by table_name ");
        q.setParameter(1, nmSchema);
        List<Object[]> result = q.getResultList();

        LinkedHashMap<Integer, TableDTO> tableList = new LinkedHashMap<Integer, TableDTO>();

        int i = 0;
        for (Object o[] : result) {
            TableDTO t = new TableDTO(o[2].toString());
            t.setColumnList(findColumnByNmTable(t.getNmTable()));
            tableList.put(i++, t);
        }
        return tableList;
    }

    public LinkedHashMap<Integer, String> findColumnByNmTable(String nmTable) {
        Query q = em.createNativeQuery("SELECT COLUMN_NAME from information_schema.COLUMNS "
                + "WHERE TABLE_NAME = ?1 "
                + "ORDER BY COLUMN_KEY = 'PRI' DESC, COLUMN_NAME");
        q.setParameter(1, nmTable);
        List<String> result = q.getResultList();

        LinkedHashMap<Integer, String> columnList = new LinkedHashMap<Integer, String>();

        int i = 0;
        for (String c : result) {
            columnList.put(i++, c);
        }
        return columnList;
    }

}
