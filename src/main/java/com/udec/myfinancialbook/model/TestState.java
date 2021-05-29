package com.udec.myfinancialbook.model;

public class TestState {

    //atributes

    private String clasificacion;
    private String concept;
    private double total;
    //if is true the balance is debit
    private boolean balance;
    //if is true is  state financial,false is State of income
    private boolean state;

    public TestState(String clasificacion, String concept, double total, boolean balance, boolean state) {
        this.clasificacion = clasificacion;
        this.concept = concept;
        this.total = total;
        this.balance = balance;
        this.state = state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setBalance(boolean balance) {
        this.balance = balance;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getConcept() {
        return concept;
    }

    public double getTotal() {
        return total;
    }

    public boolean isBalance() {
        return balance;
    }
}
