package com.contatos.apicontatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.contatos.apicontatos.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	Contato findById(long id);
	
	@Query("select  c from CONTATO c where c.nome LIKE %?1%")
	List<Contato> findByName(String name);

}
