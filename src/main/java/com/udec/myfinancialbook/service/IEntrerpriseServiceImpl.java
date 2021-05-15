package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.Entrerprise;
import com.udec.myfinancialbook.repository.IEnterpriseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IEntrerpriseServiceImpl implements  IEntrerpriseService{


    @Autowired
    private IEnterpriseRepo enterpriseRepo;


    @Override
    public List<Entrerprise> list() {
       return enterpriseRepo.findAll();
    }

    @Override
    public Optional<Entrerprise> find(int id) {
        return enterpriseRepo.findById(id);

    }

    @Override
    public void addEntrerprise(long nit, String name, String direction, String description, String phoneNumber) {
        Entrerprise entrerprise = new Entrerprise(nit,name, description,direction,phoneNumber);
        enterpriseRepo.save(entrerprise);
    }
}
