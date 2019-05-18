package com.contatos.apicontatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contatos.apicontatos.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	Contato findById(long id);

}
