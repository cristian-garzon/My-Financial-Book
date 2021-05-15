package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.PucContable;

import java.util.List;
import java.util.Optional;

public interface IPucContableService {
    public List<PucContable> list();
    public Optional<PucContable> find(int code);
}
