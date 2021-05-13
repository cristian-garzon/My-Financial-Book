package com.udec.myfinancialbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "libros_diarios")
public class BookDay implements Serializable {

    //atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long code;
    private double debit;
    private double credit;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;

    // Muchos libros estan asociados a 1 sola empresa
    @ManyToOne(fetch = FetchType.LAZY)
    private Entrerprise enterprise;

    // Muchos libros pueden tener el mismo PUC, pero el PUC un libro solo lleva 1 PUC
    @ManyToOne(fetch = FetchType.LAZY)
    private PucContable puc_contable;

    @PrePersist
    public void prePersist(){
        this.date = new Date();
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }


    public double isDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double isCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Entrerprise getBusiness() {
        return enterprise;
    }

    public void setBusiness(Entrerprise business) {
        this.enterprise = business;
    }

    private static final long serialVersionUID = 1L;
}

