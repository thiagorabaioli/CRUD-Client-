package tfr.CRUD.Client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfr.CRUD.Client.dto.ClientDTO;
import tfr.CRUD.Client.entities.Client;
import tfr.CRUD.Client.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable  Long id){
        ClientDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }
}
