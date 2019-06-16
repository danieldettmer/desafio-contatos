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

import com.contatos.apirest.models.Contato;
import com.contatos.apirest.models.Telefone;
import com.contatos.apirest.repository.ContatoRepository;
import com.contatos.apirest.repository.TelefoneRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api")
@Api(value="API REST Contatos")
@CrossOrigin(origins="*")
public class ContatoResource {
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	//contatos
	
	@GetMapping("/contatos")
	@ApiOperation(value="Retorna a lista de todos os contatos")
	public List<Contato> listaContatos(){
		return contatoRepository.findAll();
	}
	
	@GetMapping("/contato/{id}")
	@ApiOperation(value="Retorna um único contato a partir de seu número identificador")
	public Contato listaContatoPorId(@PathVariable(value="id") long id){
		return contatoRepository.findById(id);
	}
	
	@GetMapping("/contatos/{nome}")
	@ApiOperation(value="Retorna uma lista de contatos filtrada por um nome")
	public List<Contato> listaContatosPorNome(@PathVariable(value="nome") String nome){
		return contatoRepository.findByName(nome);
	}
	
	@PostMapping("/contato")
	@ApiOperation(value="Salva um contato")
	public Contato salvaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	@DeleteMapping("/contato/{id}")
	@ApiOperation(value="Remove um contato a partir do seu número identificador")
	public void deletaContato(@PathVariable(value="id") long id) {
		Contato contato = contatoRepository.findById(id);
		contatoRepository.deleteById(contato.getId());
	}
	
	@PutMapping("/contato")
	@ApiOperation(value="Atualiza um contato")
	public Contato atualizaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	//telefone
	
	@DeleteMapping("/contato/telefone/{id}")
	@ApiOperation(value="Deleta um telefone a partir do seu número identificador")
	public void deletaTelefonePorId(@PathVariable(value="id") long id) {
		Telefone telefone = telefoneRepository.findById(id);
		telefoneRepository.deleteById(telefone.getId());
	}
	
	@PostMapping("/contato/telefone")
	@ApiOperation(value="Adiciona um telefone (O valor do campo 'id' e 'contato' devem ser iguais para que o telefone referencie o contato)")
	public Contato salvaTelefone(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	@PutMapping("/contato/telefone")
	@ApiOperation(value="Atualiza um telefone (O valor do campo 'id' e 'contato' devem ser iguais para que o telefone referencie o contato)")
	public Contato atualizaTelefoneContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	//categoria
	
	@GetMapping("/contatos/categoria/{categoria}")
	@ApiOperation(value="Retorna a lista de contatos de uma categoria")
	public List<Contato> listaContatosPorCategoria(@PathVariable(value="categoria") String categoria){
		return contatoRepository.findByCategoria(categoria);
	}
}
