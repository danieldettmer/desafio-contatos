package com.contatos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.contatos.apirest.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato,Long> {

	Contato findById(long id);
	Contato deleteById(long id);
}
