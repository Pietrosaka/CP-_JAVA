package com.example.cp3_java.controller;

import com.example.cp3_java.DTO.BrinquedoDTO;
import com.example.cp3_java.exception.BrinquedoNotFoundException;
import com.example.cp3_java.model.Brinquedo;
import com.example.cp3_java.service.BrinquedoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    BrinquedoService brinquedoService;

    @PostMapping
    public ResponseEntity<Brinquedo> adicionarBrinquedo(@RequestBody @Valid BrinquedoDTO brinquedo){
        Brinquedo brinquedo1 = brinquedoService.adicionarBrinquedo(brinquedo);
        return ResponseEntity.ok(brinquedo1);
    }

    @GetMapping
    public ResponseEntity<List<Brinquedo>> retornaTodos(){
        return ResponseEntity.ok(brinquedoService.retornarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> buscarPorId(@PathVariable Long id){
        return brinquedoService.retornarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> atualizarPorId(@PathVariable Long id, @RequestBody BrinquedoDTO brinquedoNovoDTO) {
        try {
            Brinquedo atualizado = brinquedoService.atualizarBrinquedoPorId(id, brinquedoNovoDTO);
            return ResponseEntity.ok(atualizado);
        } catch (BrinquedoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Brinquedo> deletarPorId(@PathVariable Long id){
        try {
            brinquedoService.deletarBrinquedoPorId(id);
            return ResponseEntity.noContent().build();
        } catch (BrinquedoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
