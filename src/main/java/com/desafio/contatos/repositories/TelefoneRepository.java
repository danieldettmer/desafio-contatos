package com.desafio.contatos.repositories;

import com.desafio.contatos.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {}
