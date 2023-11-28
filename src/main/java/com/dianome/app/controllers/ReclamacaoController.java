package com.dianome.app.controllers;

import com.dianome.app.dtos.ReclamacaoDto;
import com.dianome.app.models.ReclamacaoModel;
import com.dianome.app.services.ReclamacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@CrossOrigin(origins ="*",maxAge = 3600)
@RequestMapping(path = "/reclamacoes")

public class ReclamacaoController {

    // Injeção de dependências
    @Autowired
    ReclamacaoService reclamacaoService;

    // Implantando os métodos CRUD
    @Transactional
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Object> saveReclamacao(@RequestBody @Valid ReclamacaoDto reclamacaoDto){
        var reclamacaoModel = reclamacaoDto.transformToModel();
        return ResponseEntity.status(HttpStatus.CREATED).body(reclamacaoService.save(
                reclamacaoModel));
    }

    @Transactional
    @GetMapping
    public ResponseEntity<Object> getReclamacoes(){
        return ResponseEntity.status(HttpStatus.OK).body(reclamacaoService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOneReclamacao(@PathVariable(value = "id") long id){
        Optional<ReclamacaoModel> reclamacaoModelOptional = reclamacaoService.findById(id);
        if (reclamacaoModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reclamação não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(reclamacaoModelOptional.get());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateReclamacao(@PathVariable(value = "id") long id,
                                                   @RequestBody @Valid ReclamacaoDto reclamacaoDto){
        Optional<ReclamacaoModel> reclamacaoModelOptional = reclamacaoService.findById(id);
        if (!reclamacaoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reclamação não localizada!");
        }
        var reclamacaoModel = reclamacaoDto.transformToModel();
        reclamacaoModel.setId(reclamacaoModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(reclamacaoService.save(reclamacaoModel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteReclamcao(@PathVariable(value = "id") long id){
        Optional<ReclamacaoModel> reclamacaoModelOptional = reclamacaoService.findById(id);
        if (!reclamacaoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reclamação não encontrada!");
        }
        reclamacaoService.delete(reclamacaoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Reclamação excluída com sucesso!");
    }
}
