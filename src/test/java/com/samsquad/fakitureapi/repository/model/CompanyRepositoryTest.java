package com.samsquad.fakitureapi.repository.model;

import com.samsquad.fakitureapi.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testAddCompany() {
        // Given
        Company company = new Company();
        company.setCompanyName("Test Company");
        company.setCompanyAddresse("Test Address");
        company.setCompanyCodePostal("12345");
        company.setCompanyContact("Test Contact");

        // When
        Company savedCompany = companyRepository.save(company);

        // Then
        assertNotNull(savedCompany);
        assertNotNull(savedCompany.getCompanyNumber());
        assertEquals("Test Company", savedCompany.getCompanyName());
    }

}

