package com.contatos.apicontatos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.contatos.apicontatos.models.Telefone;
import com.contatos.apicontatos.repository.TelefoneRepository;

@RestController
@RequestMapping(value="/api")
public class TelefoneResource {

	@Autowired
	TelefoneRepository telefoneRepository;
	
	//Implementacao Futura
	
//	@GetMapping("/telefones")
//	public List<Telefone> listaTelefones(){
//		return telefoneRepository.findAll();
//	}
	
//	@PostMapping("/telefone")
//	public Telefone salvaTelefoneContato(@RequestBody Telefone telefone) {
////		System.out.println(contato);
////		return telefone;
//		return telefoneRepository.save(telefone);
//	}
}
