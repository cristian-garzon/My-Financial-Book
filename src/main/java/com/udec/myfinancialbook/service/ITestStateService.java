package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.TestState;
import com.udec.myfinancialbook.model.mayorLedge;

import java.util.List;

public interface ITestStateService {
   public List<TestState> list(int id_enterprise);
   public int clasification(int index, List<mayorLedge> mayor);
   public boolean State(int index);
}
