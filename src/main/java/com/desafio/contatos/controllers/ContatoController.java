package com.desafio.contatos.controllers;

import com.desafio.contatos.models.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desafio.contatos.repositories.ContatoRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContatoController {

    @Autowired
    private ContatoRepository cRepository;

    @GetMapping("/contatos")
    public List<Contato> listarContatos() {
        return cRepository.findAll();
    }

    @PostMapping("/contatos")
    public Contato criarContato(@RequestBody Contato contato) {
        contato.getTelefones().forEach(t -> t.setContato(contato));
        return cRepository.save(contato);
    }

    @GetMapping("/contatos/{id}")
    public Contato buscarContatoId(@PathVariable(value="id") Long id) {
        return cRepository.findById(id).get();
    }

    @PutMapping("/contatos/{id}")
    public Contato atualizarContato(@PathVariable(value="id") Long id,
                                   @RequestBody Contato contato) {
        Contato c = cRepository.findById(id).get();
        c.setNome(contato.getNome());
        c.setEmail(contato.getEmail());
        c.setTelefones(contato.getTelefones());
        return cRepository.save(c);
    }

    @DeleteMapping("/contatos/{id}")
    public ResponseEntity<?> excluirContato(@PathVariable(value="id") Long id) {
        return cRepository.findById(id)
                .map(record -> {
                    cRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/contatos/buscar")
    public List<Contato> buscarContatoFiltros(
            @RequestParam(name = "nome", required=false) String nome,
            @RequestParam(name = "email", required=false) String email) {
        List<Contato> contatos = new ArrayList<>();
        if (nome != null) {
            contatos = cRepository.buscarPorNome(nome);
        }else if(email != null) {
            contatos = cRepository.buscarPorEmail(email);
        }
        return contatos;
    }

}