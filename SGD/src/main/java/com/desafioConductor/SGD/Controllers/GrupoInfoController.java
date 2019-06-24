package com.desafioConductor.SGD.Controllers;

import com.desafioConductor.SGD.Entities.GrupoInfo;
import com.desafioConductor.SGD.Repositories.GrupoInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupo-info")
public class GrupoInfoController {

    @Autowired
    private GrupoInfoRepo grupoInfoRepo;

    @RequestMapping(path="/all", method= RequestMethod.GET)
    @ResponseBody
    public List<GrupoInfo> get(){
        return (List<GrupoInfo>) grupoInfoRepo.findAll();
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public GrupoInfo get(Long id){
        Optional<GrupoInfo> update = grupoInfoRepo.findById(id);
        return update.orElseGet(() -> GrupoInfo.DEFAULT);
    }

    @RequestMapping(method= RequestMethod.POST)
    @ResponseBody
    public GrupoInfo insert(String titulo, String descricao){
        GrupoInfo grupoInfo = new GrupoInfo(null, titulo, descricao);
        grupoInfoRepo.save(grupoInfo);
        return grupoInfo;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public GrupoInfo update(Long id, String titulo, String descricao){
        if(id != null) {
            GrupoInfo grupoInfo = new GrupoInfo();
            Optional<GrupoInfo> update = grupoInfoRepo.findById(id);
            GrupoInfo toUpdate = update.orElseGet(() -> GrupoInfo.DEFAULT);
            grupoInfo.setId(id);
            grupoInfo.setDescricao(descricao != null? descricao : toUpdate.getDescricao());
            grupoInfo.setTitulo(titulo != null? titulo : toUpdate.getTitulo());
            grupoInfoRepo.save(grupoInfo);
            return grupoInfo;
        }
        return GrupoInfo.DEFAULT;
    }

    @RequestMapping(method= RequestMethod.DELETE)
    @ResponseBody
    public void delete(Long id){
        grupoInfoRepo.deleteById(id);
    }
}
