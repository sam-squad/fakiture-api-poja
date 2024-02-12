package com.samsquad.fakitureapi.repository;

import com.samsquad.fakitureapi.repository.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByUsername(String companyName);
}

