package com.samsquad.fakitureapi.endpoint.rest.controller.model;

import com.samsquad.fakitureapi.repository.model.Client;
import com.samsquad.fakitureapi.service.event.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ClientController {
    private ClientService clientService;

    @PostMapping("/client")
    public Client addClient(@RequestBody Client client) {
        Client addedClient = clientService.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedClient).getBody();
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/client/{clientNumber}")
    public Client getClientById(@PathVariable Integer clientNumber) throws ChangeSetPersister.NotFoundException {
        return clientService.getClientByClientNumber(clientNumber);
    }
    @PutMapping("/client/{clientNumber}")
    public Client updateClient(@PathVariable Integer clientNumber) throws ChangeSetPersister.NotFoundException {
        return clientService.updateClient(clientNumber);
    }
    @DeleteMapping("/client/{clientNumber}")
    public void deleteClient(@PathVariable Integer clientNumber){
        clientService.deleteClientByClientNumber(clientNumber);
    }

}



