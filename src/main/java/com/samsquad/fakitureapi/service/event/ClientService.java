package com.samsquad.fakitureapi.service.event;

import com.samsquad.fakitureapi.repository.ClientRepository;
import com.samsquad.fakitureapi.repository.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientByClientNumber(Integer clientNumber) throws ChangeSetPersister.NotFoundException {
        return clientRepository.findById(clientNumber).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void deleteClientByClientNumber(Integer clientNumber) {
        clientRepository.deleteById(clientNumber);
    }

    public Client updateClient(Integer clientNumber) throws ChangeSetPersister.NotFoundException {
        Client client = clientRepository.findById(clientNumber).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return clientRepository.save(client);
    }
}
