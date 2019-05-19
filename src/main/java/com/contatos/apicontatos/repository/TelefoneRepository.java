package com.contatos.apicontatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contatos.apicontatos.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
	
}
