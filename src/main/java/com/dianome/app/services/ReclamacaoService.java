package com.dianome.app.services;

import com.dianome.app.models.ReclamacaoModel;
import com.dianome.app.repositories.ReclamacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ReclamacaoService {

    @Autowired
    ReclamacaoRepository reclamacaoRepository;


    public ReclamacaoModel save(ReclamacaoModel reclamacaoModel) {
        return reclamacaoRepository.save(reclamacaoModel);
    }

    public Iterable<ReclamacaoModel> getAll(){
        return reclamacaoRepository.findAll();
    }

    public Optional<ReclamacaoModel> findById(long id){
        return reclamacaoRepository.findById(id);
    }

    @Transactional
    public void delete(ReclamacaoModel reclamacaoModel){
        reclamacaoRepository.delete(reclamacaoModel);
    }
}
