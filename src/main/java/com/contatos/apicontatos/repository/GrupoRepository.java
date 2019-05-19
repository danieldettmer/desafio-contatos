package com.contatos.apicontatos.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.contatos.apicontatos.models.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{
	
	Grupo findById(long id);
	
}
