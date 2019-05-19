package com.contatos.apicontatos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

import com.contatos.apicontatos.repository.ContatoRepository;
import com.contatos.apicontatos.repository.TelefoneRepository;

@RestController
@RequestMapping(value="/api")
public class ContatoResource {

	@Autowired
	ContatoRepository contatoRepository;
	@Autowired
	TelefoneRepository telefoneRepository;
	
	//List all contacts
	@GetMapping("/contatos")
	public List<Contato> listaContatos(){
		return contatoRepository.findAll();
	}
	
	//List contact by id
	@GetMapping("/contato/{id}")
	public Contato listaContato(@PathVariable(value="id") long id){
		return contatoRepository.findById(id);
	}
	
	//List contact by name
	@GetMapping("/contatos/{nome}")
	public List<Contato> listaContato(@PathVariable(value="nome") String nome){
		return contatoRepository.findByName(nome);
	}
	
	//List contact by name
	@GetMapping("/contatos/categoria/{categoria}")
	public List<Contato> listaContatosCategoria(@PathVariable(value="categoria") String categoria, @RequestParam String order){
		if(order.equalsIgnoreCase("desc")) {
			return contatoRepository.findByCategoryOrderByCategoriaDesc(categoria);
		} else {
			return contatoRepository.findByCategoryOrderByCategoriaAsc(categoria);
		}
	}
	
	//Create contact with or without telephone 
	@PostMapping("/contato")
	public Contato salvaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	@PostMapping("/contato/telefone")
	public Contato salvaTelefone(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	//Delete contact by id
	@DeleteMapping("/contato/{id}")
	public void apagaContato(@PathVariable(value="id") long id){
		contatoRepository.deleteById(id);
	}
	
	//Delete telephone by id
	@DeleteMapping("/contato/telefone/{id}")
	public void apagaTelefone(@PathVariable(value="id") long id){
		telefoneRepository.deleteById(id);
	}
	
	//Update contact || (contact and telephone) || (telephone)
	@PutMapping("/contato")
	public Contato atualizaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	//Update contact || (contact and telephone) || (telephone)
	@PutMapping("/contato/telefone")
	public Contato atualizaContatoTelefone(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	
	/*
	 *Delete by obj
	@DeleteMapping("/contato")
	public void apagaContato(@RequestBody Contato contato) {
		contatoRepository.delete(contato);
	}
	*/
	
	
}
