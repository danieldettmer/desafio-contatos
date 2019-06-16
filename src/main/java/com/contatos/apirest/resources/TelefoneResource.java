package com.contatos.apirest.resources;

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

import com.contatos.apirest.models.Telefone;
import com.contatos.apirest.repository.TelefoneRepository;

@RestController
@RequestMapping(value="api")
public class TelefoneResource {
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	@GetMapping("/telefones")
	public List<Telefone> listaTelefones(){
		return telefoneRepository.findAll();
	}
	
	@GetMapping("/telefone/{id}")
	public Telefone listaTelefonePorId(@PathVariable(value="id") long id){
		return telefoneRepository.findById(id);
	}
	
	@PostMapping("/telefone")
	public Telefone salvaTelefone(@RequestBody Telefone telefone) {
		return telefoneRepository.save(telefone);
	}
	
	@DeleteMapping("/telefone/{id}")
	public void deletaContato(@PathVariable(value="id") long id) {
		Telefone telefone = telefoneRepository.findById(id);
		
		telefoneRepository.deleteById(telefone.getId());
	}
	
	@PutMapping("/telefone")
	public Telefone atualizaTelefone(@RequestBody Telefone telefone) {
		return telefoneRepository.save(telefone);
	}
	
}
