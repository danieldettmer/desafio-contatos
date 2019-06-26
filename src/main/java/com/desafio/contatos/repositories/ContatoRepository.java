package com.desafio.contatos.repositories;

import com.desafio.contatos.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    @Query(value = "SELECT * FROM contatos c WHERE c.nome LIKE %?1%", nativeQuery = true)
    public List<Contato> buscarPorNome(String nome);

    @Query(value = "SELECT * FROM contatos c WHERE c.email LIKE %?1%", nativeQuery = true)
    public List<Contato> buscarPorEmail(String email);
}