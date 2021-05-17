package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.BookDay;
import com.udec.myfinancialbook.model.mayorLedge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IMayorLedgeServiceimpl implements IMayorLedgeService{


    @Autowired
    private IPucContableService pucContableService;

    @Autowired
    private IBookDayService bookDayService;

    //si es true significa que la naturaleza es debit
    @Override
    public List<mayorLedge> list(int id_enterprise) {
        List<BookDay> listBookDay = bookDayService.list(id_enterprise);
        ArrayList<mayorLedge> mayorLedges = new ArrayList<>();
        boolean balance;
        for (int i = 0; i < listBookDay.size(); i++){
            int code = listBookDay.get(i).getCode();
            if(find(mayorLedges,code)){
                update(mayorLedges, code,listBookDay,i);
            } else {
                if(listBookDay.get(i).getCredit() >= listBookDay.get(i).getDebit()) balance = false;
                else balance = true;
                mayorLedges.add(new mayorLedge(code,pucContableService.find(code).get().getConcepto(), listBookDay.get(i).getCredit()-listBookDay.get(i).getDebit(), balance));
            }

        }
        return mayorLedges;
    }

    @Override
    public boolean find(List<mayorLedge> mayorLedges, int code) {
        int count = 0;
        for (int i = 0; i < mayorLedges.size(); i++){
            if(mayorLedges.get(i).getCode() == code) count++;
            if (count >= 1) return true;
        }
        return false;
    }

    @Override
    public int findindex(List<mayorLedge> mayorLedges, int code) {
        int count = 0;
        for (int i = 0; i < mayorLedges.size(); i++){
            if(mayorLedges.get(i).getCode() == code) count++;
            if (count >= 1) return i;
        }
        return 0;
    }


    @Override
    public void update(List<mayorLedge> mayorLedges, int code, List<BookDay> bookDays, int index2) {
        int index = findindex(mayorLedges, code);
        double credit = bookDays.get(index2).getCredit();
        double debit = bookDays.get(index2).getDebit();
        if(!mayorLedges.get(index).isBalance()){
            mayorLedges.get(index).setTotal(mayorLedges.get(index).getTotal()+credit-debit);
            if(mayorLedges.get(index).getTotal() < 0){
                mayorLedges.get(index).setTotal(-mayorLedges.get(index).getTotal());
                mayorLedges.get(index).setBalance(true);
            }
        } else {
            mayorLedges.get(index).setTotal(mayorLedges.get(index).getTotal()+debit-credit);
            if(mayorLedges.get(index).getTotal() < 0){
                mayorLedges.get(index).setTotal(-mayorLedges.get(index).getTotal());
                mayorLedges.get(index).setBalance(false);
            }
        }



    }


}
