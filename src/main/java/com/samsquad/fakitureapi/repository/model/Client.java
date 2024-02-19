package com.samsquad.fakitureapi.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientNumber;
    private String companyNameClient;
    private String clientAddress;
    private String clientPostalCode;
    private String clientCountry;
}
