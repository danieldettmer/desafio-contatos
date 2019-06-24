package com.desafioConductor.SGD.Controllers;

import com.desafioConductor.SGD.Entities.Contato;
import com.desafioConductor.SGD.Repositories.ContatoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoRepo contatoRepo;

    @RequestMapping(path="/all", method= RequestMethod.GET)
    @ResponseBody
    public List<Contato> get(){
        return (List<Contato>) contatoRepo.findAll();
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public Contato get(Long id){
        Optional<Contato> contato = contatoRepo.findById(id);
        return contato.orElseGet(() -> Contato.DEFAULT);
    }

    @RequestMapping(path="/find-by-param", method= RequestMethod.GET)
    @ResponseBody
    public List<Contato> findByParam(String nome, String cpf, Integer idade, String endereco){
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        List<Contato> dataToSearch = (List<Contato>) contatoRepo.findAll();
        for(Contato contato : dataToSearch){
            if(contato.getNome().equals(nome) || contato.getCpf().equals(cpf) || contato.getIdade().equals(idade) || contato.getEndereco().equals(endereco)){
                contatos.add(contato);
            }
        }
        return contatos;
    }

    @RequestMapping(method= RequestMethod.POST)
    @ResponseBody
    public Contato insert(String nome, String cpf, Integer idade, String endereco){
        Contato contato = new Contato(null, nome, cpf, idade, endereco);
        contatoRepo.save(contato);
        return contato;
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ResponseBody
    public Contato update(Long id, String nome, String cpf, Integer idade, String endereco){
        if(id != null){
            Contato contato = new Contato();
            Optional<Contato> update = contatoRepo.findById(id);
            Contato elementToUpdate = update.orElseGet(() -> Contato.DEFAULT);
            contato.setId(id);
            contato.setEndereco(endereco!= null? endereco : elementToUpdate.getEndereco());
            contato.setIdade(idade      != null? idade: elementToUpdate.getIdade());
            contato.setCpf(cpf          != null? cpf : elementToUpdate.getCpf());
            contato.setNome(nome        != null? nome : elementToUpdate.getNome());
            contatoRepo.save(contato);
            return contato;
        }
        return Contato.DEFAULT;
    }

    @RequestMapping(method= RequestMethod.DELETE)
    @ResponseBody
    public void delete(Long id){
        contatoRepo.deleteById(id);
    }
}
