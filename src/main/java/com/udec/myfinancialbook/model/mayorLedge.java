package com.udec.myfinancialbook.model;

public class mayorLedge {


    //atibuttes

    private  int code;
    private String concept;
    private double total;
    private boolean balance;

    //constructor


    public mayorLedge(int code, String concept, double total, boolean balance) {
        this.code = code;
        this.concept = concept;
        this.total = total;
        this.balance = balance;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getCode() {
        return code;
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
