package br.unisc.dto;

import br.unisc.model.Desafio;
import br.unisc.model.Individuo;
import br.unisc.model.IndividuoDesafio;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author m68663 - Guilherme Rohr
 */
@Entity
@Table(name = "vw_individuo_desafio")
public class VwIndividuoDesafioDTO {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_individuo")
    private Integer idIndividuo;
    @Column(name = "id_desafio")
    private Integer idDesafio;
    @Column(name = "nm_desafio")
    private String nmDesafio;
    @Column(name = "vl_atingido")
    private Float vlAtingido;
    @Column(name = "sg_atingido")
    private Character sgAtingido;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_atingido")
    private Date dtAtingido;

    public Integer getIdIndividuo() {
        return idIndividuo;
    }

    public void setIdIndividuo(Integer idIndividuo) {
        this.idIndividuo = idIndividuo;
    }

    public Integer getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(Integer idDesafio) {
        this.idDesafio = idDesafio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmDesafio() {
        return nmDesafio;
    }

    public void setNmDesafio(String nmDesafio) {
        this.nmDesafio = nmDesafio;
    }

    public Float getVlAtingido() {
        return vlAtingido;
    }

    public void setVlAtingido(Float vlAtingido) {
        this.vlAtingido = vlAtingido;
    }

    public Character getSgAtingido() {
        return sgAtingido;
    }

    public void setSgAtingido(Character sgAtingido) {
        this.sgAtingido = sgAtingido;
    }

    public Date getDtAtingido() {
        return dtAtingido;
    }

    public void setDtAtingido(Date dtAtingido) {
        this.dtAtingido = dtAtingido;
    }

    public IndividuoDesafio toIndividuoDesafio() {
        IndividuoDesafio id = new IndividuoDesafio();
        Individuo i = new Individuo(idIndividuo);
        Desafio d = new Desafio(idDesafio, nmDesafio);

        id.setIndividuo(i);
        id.setDesafio(d);
        id.setDtAtingido(dtAtingido);
        id.setSgAtingido(sgAtingido);
        id.setVlAtingido(vlAtingido);
        return id;
    }

}
