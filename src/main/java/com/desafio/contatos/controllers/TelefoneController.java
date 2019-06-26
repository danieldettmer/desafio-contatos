package com.desafio.contatos.controllers;

import com.desafio.contatos.models.Contato;
import com.desafio.contatos.models.Telefone;
import com.desafio.contatos.repositories.ContatoRepository;
import com.desafio.contatos.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelefoneController {

    @Autowired
    private ContatoRepository cRepository;

    @Autowired
    private TelefoneRepository tRepository;

    @GetMapping("/contatos/{id}/telefones")
    public List<Telefone> telefonesContato(@PathVariable(value="id") Long id) {
        Contato c = cRepository.findById(id).get();
        return c.getTelefones();
    }

    @PostMapping("/contatos/{id}/telefones")
    public List<Telefone> criarTelefone(@PathVariable(value="id") Long id,
                                        @RequestBody List<Telefone> telefones) {
        Contato c = cRepository.findById(id).get();
        telefones.forEach(t -> t.setContato(c));
//        c.setTelefones(telefones);
        return tRepository.saveAll(telefones);
    }

}
