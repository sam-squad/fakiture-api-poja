package com.samsquad.fakitureapi.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billNumber;
    private String billType;
    private Timestamp billDate;
    private Timestamp saleServiceDateBill;
    private Timestamp paymentDate;
    private String paymentModalityDaysBill;
    private String paymentMethod;
    private String paymentIssuedBy;
    private Double totalTtcFixed;
    private int userNumber;
    private int clientNumber;
    private int companyNumber;
}

