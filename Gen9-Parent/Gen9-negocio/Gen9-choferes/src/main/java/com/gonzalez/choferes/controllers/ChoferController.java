package com.gonzalez.choferes.controllers;

import com.gonzalez.choferes.models.Chofer;
import com.gonzalez.choferes.services.ChoferesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/choferes")
@RestController
public class ChoferController {

    @Autowired
    ChoferesService choferesService;


    @GetMapping
    public ResponseEntity<List<Chofer>> listar(){
        List<Chofer> choferes = this.choferesService.getAll();
        if(choferes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(choferes);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(name="id") Long id){
        Optional<Chofer> c = choferesService.findById(id);
        if(c.isPresent()){
            return ResponseEntity.ok(c.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping
    public ResponseEntity<?> post(@RequestBody Chofer c){
        Chofer save = choferesService.save(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }




}
