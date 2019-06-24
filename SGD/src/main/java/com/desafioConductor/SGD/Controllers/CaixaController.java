package com.desafioConductor.SGD.Controllers;

import com.desafioConductor.SGD.Entities.Caixa;
import com.desafioConductor.SGD.Repositories.CaixaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/caixa")
public class CaixaController {

    @Autowired
    private CaixaRepo caixaRepo;

    @RequestMapping(path="/all", method= RequestMethod.GET)
    @ResponseBody
    public List<Caixa> get(){
        return (List<Caixa>)caixaRepo.findAll();
    }

    @RequestMapping(path="/all-by-user-id", method= RequestMethod.GET)
    @ResponseBody
    public List<Caixa> getAllByUserId(Long id){
        List<Caixa> all = (List<Caixa>) caixaRepo.findAll();
        List<Caixa> byUser = new ArrayList<>();

        for(Caixa caixa : all){
            if(caixa.getId().equals(id))
                byUser.add(caixa);
        }

        return byUser;
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public Caixa get(Long id){
        Optional<Caixa> caixa = caixaRepo.findById(id);
        return caixa.orElseGet(() -> Caixa.DEFAULT);
    }

    @RequestMapping(method= RequestMethod.POST)
    @ResponseBody
    public Caixa insert(Long idContato, Double valor, Date data, String titulo, String descricao){
        Caixa caixa = new Caixa(null, idContato, valor, data, titulo, descricao);
        caixaRepo.save(caixa);
        return caixa;
    }

    @RequestMapping(method= RequestMethod.PUT)
    @ResponseBody
    public Caixa update(Long id, Long idContato, Double valor, Date data, String titulo, String descricao){
        if(id != null){
            Caixa caixa = new Caixa();
            Optional<Caixa> update = caixaRepo.findById(id);
            Caixa elementToUpdate = update.orElseGet(() -> Caixa.DEFAULT);
            caixa.setId(id);
            caixa.setIdContato(idContato != null? idContato: elementToUpdate.getIdContato());
            caixa.setValor(valor != null? valor: elementToUpdate.getValor());
            caixa.setTitulo(titulo != null ? titulo : elementToUpdate.getTitulo());
            caixa.setDescricao(descricao != null? descricao : elementToUpdate.getDescricao());
            caixa.setData(data != null? data : elementToUpdate.getData());
            caixaRepo.save(caixa);
        }
        return Caixa.DEFAULT;
    }

    @RequestMapping(method= RequestMethod.DELETE)
    @ResponseBody
    public void delete(Long id){
        caixaRepo.deleteById(id);
    }
}
