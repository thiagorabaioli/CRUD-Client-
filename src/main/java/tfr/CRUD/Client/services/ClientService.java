package tfr.CRUD.Client.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tfr.CRUD.Client.dto.ClientDTO;
import tfr.CRUD.Client.entities.Client;
import tfr.CRUD.Client.repositories.ClientRepository;
import tfr.CRUD.Client.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    @Transactional(readOnly = true)
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
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity = repo.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        if(!repo.existsById(id)){
            throw new ObjectNotFoundException("id inválido");
        }
        Client entity = repo.getReferenceById(id);
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity = repo.save(entity);
        entity = repo.save(entity);
        return new ClientDTO(entity);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete (Long id){
        if(!repo.existsById(id)){
            throw new ObjectNotFoundException("Não é possivel deletar, objeto não encontrado id: " + id);
        }
        repo.deleteById(id);
    }

}
