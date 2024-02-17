package tfr.CRUD.Client.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfr.CRUD.Client.dto.ClientDTO;
import tfr.CRUD.Client.entities.Client;
import tfr.CRUD.Client.repositories.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;
    public ClientDTO findById(Long id){
        Client entity = repo.findById(id).orElse(null);
        return new ClientDTO(entity);
    }
}
