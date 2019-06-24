package com.desafioConductor.SGD.Controllers;

import com.desafioConductor.SGD.Entities.Telefone;
import com.desafioConductor.SGD.Repositories.TelefoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    @Autowired
    private TelefoneRepo telefoneRepo;

    @RequestMapping(path="/all", method= RequestMethod.GET)
    @ResponseBody
    public List<Telefone> get(){
        return (List<Telefone>)telefoneRepo.findAll();
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public Telefone get(@RequestParam(defaultValue = "0") Long id){
        Optional<Telefone> telefone = telefoneRepo.findById(id);
        return telefone.orElse(Telefone.DEFAULT);
    }

    @RequestMapping(path="/all-by-user-id",method= RequestMethod.GET)
    @ResponseBody
    public List<Telefone> getAllByUserId(Long id){
        List<Telefone> telefones = (List<Telefone>) telefoneRepo.findAll();
        List <Telefone> telefonesByUser = new ArrayList<>();
        for(Telefone telefone : telefones){
            if(telefone.getIdContato().equals(id))
                telefonesByUser.add(telefone);
        }
         return telefonesByUser;
    }

    @RequestMapping(method= RequestMethod.POST)
    @ResponseBody
    public Telefone insert(Long idContato, String numeroTelefone){
        Telefone telefone = new Telefone(null, idContato, numeroTelefone);
        telefoneRepo.save(telefone);
        return telefone;
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ResponseBody
    public Telefone update(Long id, Long idContato, String numeroTelefone){
        if(id != null){
            Telefone telefone = new Telefone();
            Optional<Telefone> toUpdate = telefoneRepo.findById(id);
            Telefone update = toUpdate.orElseGet(() -> Telefone.DEFAULT);
            telefone.setId(id);
            telefone.setNumero(numeroTelefone != null? numeroTelefone : update.getNumero());
            telefone.setIdContato(idContato != null? idContato : update.getIdContato());
            telefoneRepo.save(telefone);
            return telefone;
        }
        return Telefone.DEFAULT;
    }

    @RequestMapping(method= RequestMethod.DELETE)
    @ResponseBody
    public void delete(Long id){
        telefoneRepo.deleteById(id);
    }
}
