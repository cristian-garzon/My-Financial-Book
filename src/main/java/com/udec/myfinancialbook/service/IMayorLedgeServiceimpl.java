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


    @Override
    public List<mayorLedge> list() {
        return null;
    }


    /*
    @Override
    public List<mayorLedge> list() {
        List<BookDay> listBookDay = bookDayService.list();
        ArrayList<mayorLedge> mayorLedges = new ArrayList<>();
        for (int i = 0; i < listBookDay.size(); i++){
            int code = listBookDay.get(i).getCode();
            mayorLedges.add(new mayorLedge(code,pucContableService.find(code).get().getConcepto(), 0, true));
        }
        return mayorLedges;
    }


     */
}
