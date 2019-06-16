package com.contatos.apirest.models;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="TELEFONE")
@Table(name="TELEFONE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Telefone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String numeroDDD;
	
	private String numeroTelefone;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contato_id")
	private Contato contato;
	
	public Telefone() {}
	
	public Telefone(String numeroDDD, String numeroTelefone, Contato contato) {
		this.numeroDDD = numeroDDD;
		this.numeroTelefone = numeroTelefone;
		this.contato = contato;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroDDD() {
		return numeroDDD;
	}

	public void setNumeroDDD(String numeroDDD) {
		this.numeroDDD = numeroDDD;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
}
