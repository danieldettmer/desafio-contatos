package com.desafio.contatos.repositories;

import com.desafio.contatos.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Long> { }
