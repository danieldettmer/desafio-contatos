package com.desafio.contatos.controllers;

import com.desafio.contatos.models.Categoria;
import com.desafio.contatos.repositories.CategoriaRepository;
import com.desafio.contatos.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriasController {

    @Autowired
    private TelefoneRepository tRepository;

    @Autowired
    private CategoriaRepository caRepository;

    @GetMapping("/contatos/telefones/categorias")
    public List<Categoria> listarCategorias() {
        return caRepository.findAll();
    }

    @PostMapping("/contatos/telefones/categorias")
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return caRepository.save(categoria);
    }

    @GetMapping("/contatos/telefones/categorias/{id}")
    public ResponseEntity<?> buscarCategoriaId(@PathVariable(value="id") Long id) {
        return caRepository.findById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/contatos/telefones/categorias/{id}")
    public ResponseEntity<?> atualizarCategoria(
            @PathVariable(value="id") Long id,
            @RequestBody Categoria categoria) {
        return caRepository.findById(id)
                .map(c -> {
                    c.setNome(categoria.getNome());
                    return ResponseEntity.ok(caRepository.save(c));
                }).orElse( ResponseEntity.notFound().build());
    }

    @DeleteMapping("/contatos/telefones/categorias/{id}")
    public ResponseEntity<?> excluirCategoria(@PathVariable(value="id") Long id) {
        return caRepository.findById(id)
                .map(record -> {
                    caRepository.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/contatos/telefones/{telefone_id}/categorias/{categoria_id}")
    public ResponseEntity<?> vincularCategoriaTelefone(
            @PathVariable(value="telefone_id") Long telefone_id,
            @PathVariable(value="categoria_id") Long categoria_id) {
        return tRepository.findById(telefone_id)
                .map(t -> {
                    if (caRepository.existsById(categoria_id)) {
                        t.setCategoria(caRepository.findById(categoria_id).get());
                        return ResponseEntity.ok(tRepository.save(t));
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).orElse(ResponseEntity.notFound().build());
    }

}
