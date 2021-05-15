package com.udec.myfinancialbook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "libros_diarios")
public class BookDay implements Serializable {

    //atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int code;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonIgnore
    public Entrerprise getBusiness() {
        return enterprise;
    }

    public void setBusiness(Entrerprise business) {
        this.enterprise = business;
    }

    public BookDay(int code, double debit, double credit, String description, Entrerprise enterprise, PucContable puc_contable) {
        this.code = code;
        this.debit = debit;
        this.credit = credit;
        this.description = description;
        this.date = new Date();
        this.enterprise = enterprise;
        this.puc_contable = puc_contable;
    }

    public BookDay(int id, int code, double debit, double credit, String description, Date date, Entrerprise enterprise, PucContable puc_contable) {
        this.id = id;
        this.code = code;
        this.debit = debit;
        this.credit = credit;
        this.description = description;
        this.date = date;
        this.enterprise = enterprise;
        this.puc_contable = puc_contable;
    }

    public BookDay(){

    }
    private static final long serialVersionUID = 1L;
}

