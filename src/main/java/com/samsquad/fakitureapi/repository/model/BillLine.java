package com.samsquad.fakitureapi.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BillLine")
public class BillLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billLineNumber;
    private String productServiceDesignation;
    private int quantity;
    private String unit;
    private Double unitPrice;
    private String percentageVatLine;
    private Double VatCalculatedLine;
    private Double totalTtcCalculatedLine;
    private int billNumber;

}

