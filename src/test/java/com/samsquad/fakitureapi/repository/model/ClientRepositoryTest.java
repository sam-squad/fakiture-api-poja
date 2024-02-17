package com.samsquad.fakitureapi.repository.model;

import com.samsquad.fakitureapi.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;
    @Test
    public void testAddClient() {
        // Given
        Client client = new Client();
        client.setCompanyNameClient("Test Company");
        client.setClientAddress("Test Address");
        client.setClientPostalCode("12345");
        client.setClientCountry("Test Country");

        // When
        Client savedClient = clientRepository.save(client);

        // Then
        assertNotNull(savedClient);
        assertNotNull(savedClient.getClientNumber());
        assertEquals("Test Company", savedClient.getCompanyNameClient());
    }
}
