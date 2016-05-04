/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.controller;

import br.unisc.dto.ConnectionDTO;
import br.unisc.dto.SchemaDTO;
import br.unisc.dto.TableDTO;
import br.unisc.util.DatabaseAware;
import java.util.LinkedHashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class TableDTOController implements DatabaseAware {

    protected EntityManager em;

    public TableDTOController(EntityManager em) {
        this.em = em;
    }

    public LinkedHashMap<Integer, TableDTO> findTableBySchema(SchemaDTO schema) {
        Query q = null;
        if (ConnectionDTO.MYSQL == schema.getDbType()) {
            q = em.createNativeQuery(MYSQL_TABLES_QUERY);
        } else {
            q = em.createNativeQuery(POSTGRES_TABLES_QUERY);
        }
        q.setParameter(1, schema.getNmSchema());
        List<Object> result = q.getResultList();

        LinkedHashMap<Integer, TableDTO> tableList = new LinkedHashMap<Integer, TableDTO>();

        int i = 0;
        for (Object o : result) {
            if (isMySchemaTables(schema, o.toString())) {
                continue;
            }
            TableDTO t = new TableDTO(o.toString());

            if (schema.getNmSchema().equals("tc2")) {
                t.setColumnList(findColumnByNmTable(t.getNmTable(), schema.getDbType()));
            }
            tableList.put(i++, t);
        }
        return tableList;
    }

    public LinkedHashMap<Integer, String> findColumnByNmTable(String nmTable, int dbType) {
        LinkedHashMap<Integer, String> columnList = new LinkedHashMap<Integer, String>();
        if (nmTable == null || nmTable.isEmpty()) {
            return columnList;
        }

        Query q = null;
        if (ConnectionDTO.MYSQL == dbType) {
            q = em.createNativeQuery(MYSQL_TABLE_FIELD_QUERY);
        } else {
            q = em.createNativeQuery(POSTGRES_TABLE_FIELD_QUERY);
        }
        q.setParameter(1, nmTable);
        List<String> result = q.getResultList();

        int i = 0;
        for (String c : result) {
            columnList.put(i++, c);
        }
        return columnList;
    }

    private boolean isMySchemaTables(SchemaDTO schema, String table) {
        return (("tc2".equals(schema.getNmSchema())
                && (table.startsWith("conf_") || table.startsWith("param")
                || table.startsWith("individuo_") || table.startsWith("grupo_")))
                || (!"tc2".equals(schema.getNmSchema()) && !table.startsWith("vw_")));
    }

}
