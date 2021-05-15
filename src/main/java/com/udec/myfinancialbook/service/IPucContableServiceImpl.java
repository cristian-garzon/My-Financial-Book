package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.PucContable;
import com.udec.myfinancialbook.repository.IPucContableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPucContableServiceImpl implements  IPucContableService{


    @Autowired
    private IPucContableRepo pucContableRepo;


    @Override
    public List<PucContable> list() {
        return pucContableRepo.findAll();
    }

    @Override
    public Optional<PucContable> find(int code) {
        return  pucContableRepo.findById(code);
    }
}
