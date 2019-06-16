package com.contatos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contatos.apirest.models.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{
	
	Grupo findById(long id);
}
