package com.desafioConductor.SGD.Controllers;

import com.desafioConductor.SGD.Entities.Grupos;
import com.desafioConductor.SGD.Repositories.GruposRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupos")
public class GruposController {

    @Autowired
    private GruposRepo gruposRepo;

    @RequestMapping(path="/all", method= RequestMethod.GET)
    @ResponseBody
    public List<Grupos> get(){
        return (List<Grupos>)gruposRepo.findAll();
    }

    @RequestMapping(path="/all-by-user-id", method= RequestMethod.GET)
    @ResponseBody
    public List<Grupos> getAllByUserId(Long id){
        List <Grupos> all = (List<Grupos>)gruposRepo.findAll();
        List <Grupos> byUser = new ArrayList<>();

        for (Grupos grupo : all){
            if(grupo.getId().equals(id))
                byUser.add(grupo);
        }
        return byUser;
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public Grupos get(Long id){
        Optional<Grupos> update = gruposRepo.findById(id);
        return update.orElseGet(() -> Grupos.DEFAULT);
    }

    @RequestMapping(method= RequestMethod.POST)
    @ResponseBody
    public Grupos insert(Long idGrupo, Long idContato){
        Grupos grupo = new Grupos(null, idGrupo, idContato);
        gruposRepo.save(grupo);
        return grupo;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Grupos update(Long id, Long idGrupo, Long idContato){
        if(id != null) {
            Grupos grupo = new Grupos();
            Optional<Grupos> update = gruposRepo.findById(id);
            Grupos toUpdate = update.orElseGet(() -> Grupos.DEFAULT);
            grupo.setId(id);
            grupo.setIdGrupo(idGrupo != null? idGrupo : toUpdate.getIdGrupo());
            grupo.setIdContato(idContato != null? idContato : toUpdate.getIdContato());
            gruposRepo.save(grupo);
            return grupo;
        }
        return Grupos.DEFAULT;
    }

    @RequestMapping(method= RequestMethod.DELETE)
    @ResponseBody
    public void delete(Long id){
        gruposRepo.deleteById(id);
    }
}
