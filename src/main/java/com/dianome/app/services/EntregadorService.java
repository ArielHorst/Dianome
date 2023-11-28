package com.dianome.app.services;

import com.dianome.app.models.EntregadorModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dianome.app.repositories.EntregadorRepository;
import java.util.Optional;



@Service
public class EntregadorService {

    @Autowired
    EntregadorRepository entregadorRepository;

    public EntregadorModel save(EntregadorModel entregadorModel) {

        return entregadorRepository.save(entregadorModel);
    }

    public Iterable <EntregadorModel> getAll(){
        return entregadorRepository.findAll();
    }

    public Optional<EntregadorModel> findById(long id){
        return entregadorRepository.findById(id);
    }

    @Transactional
    public void delete (EntregadorModel entregadorModel){
        entregadorRepository.delete(entregadorModel);
    }
}
