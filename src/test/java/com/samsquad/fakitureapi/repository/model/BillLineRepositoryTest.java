package com.samsquad.fakitureapi.repository.model;

import com.samsquad.fakitureapi.repository.BillLineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BillLineRepositoryTest {

    @Autowired
    private BillLineRepository billLineRepository;

    @Test
    public void testAddBillLine() {
        // Given
        BillLine billLine = new BillLine();
        billLine.setProductServiceDesignation("Test Product");
        billLine.setQuantity(1);
        billLine.setUnit("pcs");
        billLine.setUnitPrice(10.0);
        billLine.setPercentageVatLine("20%");
        billLine.setVatCalculatedLine(2.0);
        billLine.setTotalTtcCalculatedLine(12.0);
        billLine.setBillNumber(1);

        // When
        BillLine savedBillLine = billLineRepository.save(billLine);

        // Then
        assertNotNull(savedBillLine);
        assertNotNull(savedBillLine.getBillLineNumber());
        assertEquals("Test Product", savedBillLine.getProductServiceDesignation());
        // Add more assertions as needed
    }

    @Test
    public void testFindByBillNumber() {
        // Given
        BillLine billLine1 = new BillLine();
        billLine1.setProductServiceDesignation("Test Product 1");
        billLine1.setQuantity(1);
        billLine1.setUnit("pcs");
        billLine1.setUnitPrice(10.0);
        billLine1.setPercentageVatLine("20%");
        billLine1.setVatCalculatedLine(2.0);
        billLine1.setTotalTtcCalculatedLine(12.0);
        billLine1.setBillNumber(1);
        billLineRepository.save(billLine1);

        BillLine billLine2 = new BillLine();
        billLine2.setProductServiceDesignation("Test Product 2");
        billLine2.setQuantity(2);
        billLine2.setUnit("pcs");
        billLine2.setUnitPrice(15.0);
        billLine2.setPercentageVatLine("15%");
        billLine2.setVatCalculatedLine(4.5);
        billLine2.setTotalTtcCalculatedLine(34.5);
        billLine2.setBillNumber(1);
        billLineRepository.save(billLine2);

        // When
        List<BillLine> foundBillLines = billLineRepository.findByBillNumber(1);

        // Then
        assertEquals(2, foundBillLines.size());
    }

}

