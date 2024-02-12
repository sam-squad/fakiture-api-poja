package com.samsquad.fakitureapi.repository;

import com.samsquad.fakitureapi.repository.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
