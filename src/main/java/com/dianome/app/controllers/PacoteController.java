package com.dianome.app.controllers;

import com.dianome.app.dtos.PacoteDto;
import com.dianome.app.models.PacoteModel;
import com.dianome.app.services.PacoteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@CrossOrigin(origins ="*",maxAge = 3600)
@RequestMapping(path = "/pacotes")

public class PacoteController {

    // Injeção de dependências
   @Autowired
   PacoteService pacoteService;



   // Implantando os método CRUD
   @Transactional
   @PostMapping(value = "/cadastrar")
   public ResponseEntity<Object> savePacote(@RequestBody @Valid PacoteDto pacoteDto){
       var pacoteModel = pacoteDto.transformToModel();
       return ResponseEntity.status(HttpStatus.CREATED).body(pacoteService.save(
               pacoteModel));
   }

  @Transactional
  @GetMapping
  public ResponseEntity<Object> getPacotes(){
      return ResponseEntity.status(HttpStatus.OK).body(pacoteService.getAll());
  }

   @GetMapping(value = "/{id}")
   public ResponseEntity<Object> getOnePacote(@PathVariable(value = "id") long id){
       Optional<PacoteModel> pacoteModelOptional = pacoteService.findById(id);
       if (pacoteModelOptional.isEmpty()){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacote não encontrado!");
       }
       return ResponseEntity.status(HttpStatus.OK).body(pacoteModelOptional.get());
   }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePacote(@PathVariable(value = "id") long id,
                                                    @RequestBody @Valid PacoteDto pacoteDto){

       Optional<PacoteModel> pacoteModelOptional = pacoteService.findById(id);
        if (!pacoteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacote não localizado!");
        }
        var pacoteModel = pacoteDto.transformToModel();
        pacoteModel.setId(pacoteModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pacoteService.save(pacoteModel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletePacote(@PathVariable(value = "id") long id){
        Optional<PacoteModel> pacoteModelOptional = pacoteService.findById(id);
        if (!pacoteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacote não encontrado!");
        }
        pacoteService.delete(pacoteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pacote excluído com sucesso!");
    }

}