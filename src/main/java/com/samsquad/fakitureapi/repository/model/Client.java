package com.samsquad.fakitureapi.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
