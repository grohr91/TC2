/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.dto;

import java.util.LinkedHashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Guilherme Rohr - m68663
 */
public class SchemaDTO {

    private EntityManager em;
    private String nmSchema;
    private LinkedHashMap<Integer, TableDTO> tableList;

    public SchemaDTO(EntityManager em, String nmSchema) {
        this.nmSchema = nmSchema;
        //busca nomes de todas tabelas do BD
        loadDBTable();

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

    private void loadDBTable() {
        Query q = em.createNamedQuery("select * "
                + "from information_schema.tables "
                + "where TABLE_SCHEMA = ?1 "
                + "order by table_name ");
        q.setParameter(1, nmSchema);
        List<Object[]> result = q.getResultList();

        tableList = new LinkedHashMap<Integer, TableDTO>();
        int i = 0;
        for (Object o[] : result) {
            TableDTO t = new TableDTO(o[0].toString());
            tableList.put(i++, t);
        }
    }

}
