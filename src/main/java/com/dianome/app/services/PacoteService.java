package com.dianome.app.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dianome.app.repositories.PacoteRepository;
import com.dianome.app.models.PacoteModel;
import java.util.Optional;


@Service
public class PacoteService {

    @Autowired
    PacoteRepository pacoteRepository;

    public PacoteModel save(PacoteModel pacoteModel) {
        return pacoteRepository.save(pacoteModel);
    }

    public Iterable<PacoteModel> getAll(){
        return pacoteRepository.findAll();
    }

    public Optional<PacoteModel> findById(long id){
        return pacoteRepository.findById(id);
    }

    @Transactional
    public void delete(PacoteModel pacoteModel){
        pacoteRepository.delete(pacoteModel);
    }
}
