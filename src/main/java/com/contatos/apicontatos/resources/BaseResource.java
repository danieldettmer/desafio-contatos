package com.contatos.apicontatos.resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.apicontatos.models.Contato;
import com.contatos.apicontatos.models.Grupo;
import com.contatos.apicontatos.models.Telefone;
import com.contatos.apicontatos.repository.ContatoRepository;
import com.contatos.apicontatos.repository.GrupoRepository;
import com.contatos.apicontatos.repository.TelefoneRepository;

@RestController
@RequestMapping(value="/api")
public class BaseResource {
//	@PersistenceContext
//	EntityManager manager;

	@Autowired
	ContatoRepository contatoRepository;
	@Autowired
	TelefoneRepository telefoneRepository;
	@Autowired
	GrupoRepository grupoRepository;
	
	
	@GetMapping("/base")
	public void populate() {
		
		
		Contato c1 = new Contato("contato primeiro", "aaaa", new ArrayList<Telefone>());
		Contato c2 = new Contato("contato segundo", "aabb", new ArrayList<Telefone>());
		Contato c3 = new Contato("contato terceiro", "bbbb", new ArrayList<Telefone>());
		
		Telefone t1 = new Telefone("123", c1);
		Telefone t2 = new Telefone("321", c2);
		
		ArrayList<Contato> lc1 = new ArrayList<Contato>();
		ArrayList<Contato> lc2 = new ArrayList<Contato>();

		lc2.add(c1);
		lc2.add(c2);
		
		Grupo g1 = new Grupo("con","",lc1);
		Grupo g2 = new Grupo("con2","",lc2);
		
		contatoRepository.save(c1);
		contatoRepository.save(c2);
		contatoRepository.save(c3);
		
		telefoneRepository.save(t1);
		telefoneRepository.save(t2);
		
		grupoRepository.save(g1);
		grupoRepository.save(g2);
	        
	}
}
