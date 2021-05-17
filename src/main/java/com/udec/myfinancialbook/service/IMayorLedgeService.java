package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.BookDay;
import com.udec.myfinancialbook.model.mayorLedge;

import java.util.List;

public interface IMayorLedgeService {
    public List<mayorLedge> list(int id_enterprise);
    public boolean find(List<mayorLedge> mayorLedges, int code);
    public int findindex(List<mayorLedge> mayorLedges, int code);
    public void update(List<mayorLedge> mayorLedges,int code , List<BookDay> bookDays, int index2);
}
