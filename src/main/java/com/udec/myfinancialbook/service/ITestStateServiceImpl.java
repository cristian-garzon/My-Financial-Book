package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.PucContable;
import com.udec.myfinancialbook.model.TestState;
import com.udec.myfinancialbook.model.mayorLedge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ITestStateServiceImpl implements ITestStateService{

    @Autowired
    private IPucContableService pucContableService;

    @Autowired
    private IMayorLedgeService mayorLedgeService;

    @Override
    public List<TestState> list(int id_enterprise) {
        List<mayorLedge> listMayor = mayorLedgeService.list(id_enterprise);
        List<PucContable> puc = pucContableService.list();
        ArrayList<TestState> listTest = new ArrayList<>();
        for (int i=0; i < listMayor.size(); i++){
            String clasificacion = pucContableService.find(clasification(i, listMayor)).get().getConcepto();
            String concept = listMayor.get(i).getConcept();
            double total = listMayor.get(i).getTotal();
            boolean balance = listMayor.get(i).isBalance();
            boolean state = State(clasification(i,listMayor));
            listTest.add(new TestState(clasificacion,concept,total,balance,state));
        }
        return listTest;
    }

    @Override
    public int clasification(int index, List<mayorLedge> mayor){
            String aux = mayor.get(index).getCode()+"";
            return Integer.parseInt(String.valueOf(aux.charAt(0)));
    }

    @Override
    public boolean State(int index) {
        if(index >= 1 && index <=3) return true;
        else return false;
    }


}
