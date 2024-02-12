package com.samsquad.fakitureapi.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int companyNumber;
    private String companyName;
    private String companyAddresse;
    private String companyCodePostal;
    private String companyContact;
}
