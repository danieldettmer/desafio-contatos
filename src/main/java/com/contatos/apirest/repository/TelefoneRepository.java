package com.contatos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.contatos.apirest.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone,Long> {

	Telefone findById(long id);
	Telefone deleteById(long id);
}
