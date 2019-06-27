package com.desafio.contatos.controllers;

import com.desafio.contatos.models.Contato;
import com.desafio.contatos.models.Telefone;
import com.desafio.contatos.repositories.ContatoRepository;
import com.desafio.contatos.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelefoneController {

    @Autowired
    private ContatoRepository cRepository;

    @Autowired
    private TelefoneRepository tRepository;

    @GetMapping("/contatos/{id}/telefones")
    public ResponseEntity<?> telefonesContato(@PathVariable(value="id") Long id) {
        return cRepository.findById(id)
                .map(c -> ResponseEntity.ok(c.getTelefones()))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/contatos/{id}/telefones")
    public List<Telefone> criarTelefoneContato(
            @PathVariable(value="id") Long id,
            @RequestBody List<Telefone> telefones) {
        Contato c = cRepository.findById(id).get();
        telefones.forEach(t -> t.setContato(c));
        return tRepository.saveAll(telefones);
    }

    @GetMapping("/contatos/telefones/{id}")
    public ResponseEntity<?> buscarTelefoneId(@PathVariable(value="id") Long id) {
        return tRepository.findById(id)
                .map(ResponseEntity::ok).orElse( ResponseEntity.notFound().build());
    }

    @PutMapping("/contatos/telefones/{id}")
    public ResponseEntity<?> atualizarTelefone(
            @PathVariable(value="id") Long id,
            @RequestBody Telefone telefone) {

        return tRepository.findById(id)
                .map(t -> {
                    t.setNumero(telefone.getNumero());
                    t.setCategoria(telefone.getCategoria());
                    return ResponseEntity.ok(tRepository.save(t));
                }).orElse( ResponseEntity.notFound().build());
    }

    @DeleteMapping("/contatos/telefones/{id}")
    public ResponseEntity<?> excluirTelefone(@PathVariable(value="id") Long id) {
        return tRepository.findById(id)
                .map(record -> {
                    tRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
