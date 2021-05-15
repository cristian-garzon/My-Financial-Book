package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.Entrerprise;

import java.util.List;
import java.util.Optional;

public interface IEntrerpriseService {
    public List<Entrerprise> list();
    public Optional<Entrerprise> find(int id);
    public void addEntrerprise(long nit, String name, String direction, String description, String phoneNumber);
}
