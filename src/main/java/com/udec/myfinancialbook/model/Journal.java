package com.udec.myfinancialbook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Journal {

    //atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private long code;
    @Column(nullable = false)
    private String concept;
    @Column(nullable = true)
    private long debit;
    @Column(nullable = true)
    private long credit;

    //getters

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }


    public long getCode() {
        return code;
    }

    public String getConcept() {
        return concept;
    }

    public long getDebit() {
        return debit;
    }

    public long getCredit() {
        return credit;
    }

    //Setters

    public void setDate(Date date) {
        this.date = date;
    }


    public void setCode(long code) {
        this.code = code;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public void setDebit(long debit) {
        this.debit = debit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }
}
