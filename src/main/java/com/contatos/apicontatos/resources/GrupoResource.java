package com.contatos.apicontatos.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.contatos.apicontatos.models.Contato;
import com.contatos.apicontatos.models.Grupo;

import com.contatos.apicontatos.repository.GrupoRepository;


@RestController
@RequestMapping(value="/api")
public class GrupoResource {
	
	@Autowired
	GrupoRepository grupoRepository;
	
	//List all groups
	@GetMapping("/grupos")
	public List<Grupo> listaGrupos(){
		return grupoRepository.findAll();
	}
	
	//List group by id
	@GetMapping("/grupo/{id}")
	public Grupo listaGrupo(@PathVariable(value="id") long id){
		return grupoRepository.findById(id);
	}
	
	@PostMapping("/grupo")
	public Grupo salvaGrupo(@RequestBody Grupo grupo) {
		return grupoRepository.save(grupo);
	}
	
	@DeleteMapping("/grupo/{id}")
	public void deletaGrupo(@PathVariable(value="id") long id) {
		grupoRepository.deleteById(id);
	}
	
	@PutMapping("/grupo")
	public Grupo atualizaContatoTelefone(@RequestBody Grupo grupo) {
		return grupoRepository.save(grupo);
	}

}
