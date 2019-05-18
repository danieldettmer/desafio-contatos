package com.contatos.apicontatos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.apicontatos.models.Contato;
import com.contatos.apicontatos.models.Telefone;
import com.contatos.apicontatos.repository.ContatoRepository;
import com.contatos.apicontatos.repository.TelefoneRepository;

@RestController
@RequestMapping(value="/api")
public class ContatoResource {

	@Autowired
	ContatoRepository contatoRepository;
	@Autowired
	TelefoneRepository telefoneRepository;
	
	@GetMapping("/contatos")
	public List<Contato> listaContatos(){
		return contatoRepository.findAll();
	}
	
	@GetMapping("/contato/{id}")
	public Contato listaContato(@PathVariable(value="id") long id){
		return contatoRepository.findById(id);
	}
	
	@PostMapping("/contato")
	public Contato salvaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	@PostMapping("/contato/telefone")
//	public void action(@RequestParam(value = "param[]") String[] paramValues){
//		System.out.println(paramValues);
//	}
	public Contato salvaTelefoneContato(@RequestBody Contato contato) {
//		System.out.println(contato);
		return contato;
//		return telefoneRepository.save(contato);
	}
	
	@DeleteMapping("/contato/{id}")
	public void apagaContato(@PathVariable(value="id") long id){
		contatoRepository.deleteById(id);
	}
	
	/*
	 *Delete 2
	@DeleteMapping("/contato")
	public void apagaContato(@RequestBody Contato contato) {
		contatoRepository.delete(contato);
	}
	*/
	
	@PutMapping("/contato")
	public Contato atualizaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
}
