package com.contatos.apirest.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

@Entity
@Table(name="CONTATO")
public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private BigInteger telefone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigInteger getTelefone() {
		return telefone;
	}

	public void setTelefone(BigInteger telefone) {
		this.telefone = telefone;
	}
	
}
