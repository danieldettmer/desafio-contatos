package com.contatos.apicontatos.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="GRUPO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name="GRUPO")
public class Grupo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private String admnistrador;
	
//	@ManyToMany(mappedBy = "grupos")
	@ManyToMany
	@JoinTable(name="grupos_contatos",joinColumns = 
		{@JoinColumn(name="grupo_id")}, inverseJoinColumns =
			{@JoinColumn(name="contato_id")})
	private List<Contato> contatos;

	
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

	public String getAdmnistrador() {
		return admnistrador;
	}

	public void setAdmnistrador(String admnistrador) {
		this.admnistrador = admnistrador;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
}
