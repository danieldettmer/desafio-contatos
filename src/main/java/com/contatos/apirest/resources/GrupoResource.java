package com.contatos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.apirest.models.Grupo;
import com.contatos.apirest.repository.GrupoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api")
@Api(value="API REST Contatos")
@CrossOrigin(origins="*")
public class GrupoResource {
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@GetMapping("/grupos")
	@ApiOperation(value="Retorna a lista de todos os grupos")
	public List<Grupo> listaGrupos(){
		return grupoRepository.findAll();
	}
	
	@GetMapping("/grupo/{id}")
	@ApiOperation(value="Retorna um único grupo a partir de seu número identificador")
	public Grupo listaGrupoPorId(@PathVariable(value="id") long id){
		return grupoRepository.findById(id);
	}
	
	@PostMapping("/grupo")
	@ApiOperation(value="Salva um grupo")
	public Grupo salvaGrupo(@RequestBody Grupo grupo) {
		return grupoRepository.save(grupo);
	}
	
	@DeleteMapping("/grupo/{id}")
	@ApiOperation(value="Remove um grupo a partir de seu número identificador")
	public void deletaGrupo(@PathVariable(value="id") long id) {
		Grupo grupo = grupoRepository.findById(id);
		grupoRepository.deleteById(grupo.getId());
	}
	
	@PutMapping("/grupo")
	@ApiOperation(value="Atualiza um grupo")
	public Grupo atualizaGrupo(@RequestBody Grupo grupo) {
		return grupoRepository.save(grupo);
	}
}
