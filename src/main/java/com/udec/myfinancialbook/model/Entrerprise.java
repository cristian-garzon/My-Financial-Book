package com.udec.myfinancialbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Entrerprise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NIT")
    private long nit;

    private String name;

    private String description;

    private String direction;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "enterprise",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookDay> listBookday;

    public Entrerprise(){
        this.listBookday = new ArrayList<>();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<BookDay> getListaJournal() {
        return listBookday;
    }

    public void setListaJournal(List<BookDay> listaJournal) {
        this.listBookday = listaJournal;
    }

    //Añadir libro diario
    public void addJournal(BookDay journal){
        this.listBookday.add(journal);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public long getNit() {
        return nit;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Entrerprise(long nit, String name, String description, String direction, String phoneNumber) {
        this.nit = nit;
        this.name = name;
        this.description = description;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
    }

    public Entrerprise(int id, long nit, String name, String description, String direction, String phoneNumber) {
        this.id = id;
        this.nit = nit;
        this.name = name;
        this.description = description;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private static final long serialVersionUID = 1L;
}

