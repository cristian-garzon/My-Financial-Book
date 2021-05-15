package com.udec.myfinancialbook.repository;

import com.udec.myfinancialbook.model.Entrerprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnterpriseRepo extends JpaRepository<Entrerprise,Integer> {
}
