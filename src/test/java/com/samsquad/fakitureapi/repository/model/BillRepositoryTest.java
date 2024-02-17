package com.samsquad.fakitureapi.repository.model;

import com.samsquad.fakitureapi.repository.BillRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BillRepositoryTest {

    @Autowired
    private BillRepository billRepository;

    @Test
    public void testAddBill() {
        // Given
        Bill bill = new Bill();
        bill.setBillType("Test Bill");
        bill.setBillDate(new Timestamp(System.currentTimeMillis()));

        // When
        Bill savedBill = billRepository.save(bill);

        // Then
        assertNotNull(savedBill);
        assertNotNull(savedBill.getBillNumber());
        assertEquals("Test Bill", savedBill.getBillType());
    }

    @Test
    public void testGetAllBills() {
        // Given
        Bill bill1 = new Bill();
        bill1.setBillType("Test Bill 1");
        bill1.setBillDate(new Timestamp(System.currentTimeMillis()));
        billRepository.save(bill1);

        Bill bill2 = new Bill();
        bill2.setBillType("Test Bill 2");
        bill2.setBillDate(new Timestamp(System.currentTimeMillis()));
        billRepository.save(bill2);

        // When
        List<Bill> allBills = billRepository.findAll();

        // Then
        assertEquals(2, allBills.size());
        // Add more assertions as needed
    }

}
