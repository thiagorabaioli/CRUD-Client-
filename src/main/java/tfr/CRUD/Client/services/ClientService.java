package tfr.CRUD.Client.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tfr.CRUD.Client.dto.ClientDTO;
import tfr.CRUD.Client.entities.Client;
import tfr.CRUD.Client.repositories.ClientRepository;
import tfr.CRUD.Client.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;
    public ClientDTO findById(Long id){
        Client entity = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        return new ClientDTO(entity);
    }

    public Page<ClientDTO> findPage(Pageable pageable){
        Page<Client> entity = repo.findAll(pageable);
        return entity.map(x -> new ClientDTO(x));
    }

    public ClientDTO insert (ClientDTO dto){
        Client entity = new Client();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity = repo.save(entity);
        return new ClientDTO(entity);
    }
}
