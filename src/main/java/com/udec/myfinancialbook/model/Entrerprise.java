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
    private Long id;

    @Column(name = "NIT")
    private Long nit;

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


    /*
    public void filterValues(){
        double sumDebit = 0, sumCredit = 0;
        for(int i = 0; i < listJournal.size(); i++){
            for(int j = 0; j < listJournal.size(); j++){
                if( listJournal.get(i).getCode().equals(listJournal.get(j).getCode()) &&
                        listJournal.get(i).getConcept().equals(listJournal.get(j).getConcept())){
                    if(listJournal.get(j).isDebit() && !(listJournal.get(j).isCredit())){
                        listLegder.add(new Ledger());
                        sumDebit += listJournal.get(j).getBalance();
                    }else if(listJournal.get(j).isCredit() && !(listJournal.get(j).isDebit())){
                        listLegder.add(new Ledger());
                        sumCredit += listJournal.get(j).getBalance();
                    }
                }
            }
        }
    }
     */
    private static final long serialVersionUID = 1L;
}

   /*
            if(listJournal.get(i).getCode().equals(listJournal.get(i+1).getCode()) &&
                    listJournal.get(i).getConcept().equals(listJournal.get(i+1).getConcept())){
                this.listLegder.add(Arrays.asList(new L));
            }
             */
