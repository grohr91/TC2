package br.unisc.controller;

import br.unisc.dto.SchemaDTO;
import javax.persistence.EntityManager;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
public class SchemaDTOController {

    protected EntityManager em;

    public SchemaDTOController(EntityManager em) {
        this.em = em;
    }

    public SchemaDTO loadByNmSchema(String nmSchema) {
        SchemaDTO schema = new SchemaDTO(nmSchema);

        TableDTOController tableDTOController = new TableDTOController(em);
        schema.setTableList(
                tableDTOController.findTableByNmSchema(nmSchema));

        return schema;
    }
}
