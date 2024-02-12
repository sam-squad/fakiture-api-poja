package com.samsquad.fakitureapi.repository;

import com.samsquad.fakitureapi.repository.model.BillLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillLineRepository extends JpaRepository<BillLine, Integer> {
    List<BillLine> findByBillNumber(int billNumber);
}
