package com.dianome.app.controllers;

import com.dianome.app.models.EntregadorModel;
import com.dianome.app.services.EntregadorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dianome.app.dtos.EntregadorDto;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@RestController
@CrossOrigin(origins ="*",maxAge = 3600)
@RequestMapping(path ="/entregadores")

public class EntregadorController {
    // Injeção de dependências
    @Autowired
    EntregadorService entregadorService;

    // Implantando os métodos CRUD
    @Transactional
    @PostMapping(value ="/cadastrar")
    public ResponseEntity<Object> saveEntregador(@RequestBody @Valid  EntregadorDto entregadorDto){
      var entregadorModel = entregadorDto.transformToModel();
        entregadorModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(entregadorService.save(
                entregadorModel));
    }

    @Transactional
    @GetMapping
    public ResponseEntity<Object> getEntregadores(){
        return ResponseEntity.status(HttpStatus.OK).body(entregadorService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOneEntregador(@PathVariable(value = "id") long id){
        Optional<EntregadorModel> entregadorModelOptional = entregadorService.findById(id);
        if (entregadorModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entregadorModelOptional.get());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEntregador(@PathVariable(value = "id") long id,
                                                    @RequestBody @Valid EntregadorDto entregadorDto){
        Optional<EntregadorModel> entregadorModelOptional = entregadorService.findById(id);
        if (!entregadorModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não localizado!");
        }
        var entregadorModel = entregadorDto.transformToModel();
        entregadorModel.setId(entregadorModelOptional.get().getId());
        entregadorModel.setDataRegistro(entregadorModelOptional.get().getDataRegistro());
        return ResponseEntity.status(HttpStatus.OK).body(entregadorService.save(entregadorModel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEntregador(@PathVariable(value = "id") long id){
        Optional<EntregadorModel> entregadorModelOptional = entregadorService.findById(id);
        if (!entregadorModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado!");
        }
        entregadorService.delete(entregadorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Entregador excluído com sucesso!");
    }
}




















