package com.udec.myfinancialbook.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "puc_contable")
public class PucContable implements Serializable {

    @Id
    private Integer codigo_id;
    private String concepto;
    private String naturaleza;

    public Integer getCod_contable() {
        return codigo_id;
    }

    public void setCod_contable(Integer cod_contable) {
        this.codigo_id = cod_contable;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }
}
