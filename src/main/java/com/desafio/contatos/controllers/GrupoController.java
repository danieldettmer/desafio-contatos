package com.desafio.contatos.controllers;

import com.desafio.contatos.models.Grupo;
import com.desafio.contatos.repositories.ContatoRepository;
import com.desafio.contatos.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GrupoController {

    @Autowired
    private GrupoRepository gRepository;

    @Autowired
    private ContatoRepository cRepository;

    @GetMapping("/contatos/grupos")
    public List<Grupo> listarGrupos() {
        return gRepository.findAll();
    }

    @PostMapping("/contatos/grupos")
    public Grupo criarGrupo(@RequestBody Grupo grupo) {
        return gRepository.save(grupo);
    }

    @GetMapping("/contatos/grupos/{id}")
    public ResponseEntity<?> buscarGrupoId(@PathVariable(value="id") Long id) {
        return gRepository.findById(id)
                .map(ResponseEntity::ok).orElse( ResponseEntity.notFound().build());
    }

    @PutMapping("/contatos/grupos/{id}")
    public ResponseEntity<?> atualizarGrupo(
            @PathVariable(value="id") Long id,
            @RequestBody Grupo grupo) {
        return gRepository.findById(id)
                .map(g -> {
                    g.setNome(grupo.getNome());
                    return ResponseEntity.ok(gRepository.save(g));
                }).orElse( ResponseEntity.notFound().build());
    }

    @DeleteMapping("/contatos/grupos/{id}")
    public ResponseEntity<?> excluirGrupo(@PathVariable(value="id") Long id) {
        return gRepository.findById(id)
                .map(record -> {
                    gRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/contatos/{contato_id}/grupos/{grupo_id}")
    public ResponseEntity<?> adicionarContatoGrupo(
            @PathVariable(value="contato_id") Long contato_id,
            @PathVariable(value="grupo_id") Long grupo_id) {
        return cRepository.findById(contato_id)
                .map(c -> {
                    if (gRepository.existsById(grupo_id)) {
                        c.getGrupos().add(gRepository.findById(grupo_id).get());
                        return ResponseEntity.ok(cRepository.save(c));
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).orElse( ResponseEntity.notFound().build());
    }

    @DeleteMapping("/contatos/{contato_id}/grupos/{grupo_id}")
    public ResponseEntity<?> removerContatoGrupo(
            @PathVariable(value="contato_id") Long contato_id,
            @PathVariable(value="grupo_id") Long grupo_id) {
        return cRepository.findById(contato_id)
                .map(c -> {
                    if (gRepository.existsById(grupo_id)) {
                        c.getGrupos().remove(gRepository.findById(grupo_id).get());
                        return ResponseEntity.ok(cRepository.save(c));
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).orElse( ResponseEntity.notFound().build());
    }

}
