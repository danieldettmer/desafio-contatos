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

import com.contatos.apirest.models.Contato;
import com.contatos.apirest.models.Telefone;
import com.contatos.apirest.repository.ContatoRepository;
import com.contatos.apirest.repository.TelefoneRepository;

@RestController
@RequestMapping(value="api")
public class ContatoResource {
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	//contatos
	
	@GetMapping("/contatos")
	public List<Contato> listaContatos(){
		return contatoRepository.findAll();
	}
	
	@GetMapping("/contato/{id}")
	public Contato listaContatoPorId(@PathVariable(value="id") long id){
		return contatoRepository.findById(id);
	}
	
	@GetMapping("/contatos/{nome}")
	public List<Contato> listaContatosPorNome(@PathVariable(value="nome") String nome){
		return contatoRepository.findByName(nome);
	}
	
	@PostMapping("/contato")
	public Contato salvaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	@DeleteMapping("/contato/{id}")
	public void deletaContato(@PathVariable(value="id") long id) {
		Contato contato = contatoRepository.findById(id);
		
		contatoRepository.deleteById(contato.getId());
	}
	
	@PutMapping("/contato")
	public Contato atualizaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	//telefones
	
	@DeleteMapping("/contato/telefone/{id}")
	public void deletaTelefonePorId(@PathVariable(value="id") long id) {
		Telefone telefone = telefoneRepository.findById(id);
		
		telefoneRepository.deleteById(telefone.getId());
	}
	
}
