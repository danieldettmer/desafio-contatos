package com.contatos.apicontatos.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="CONTATO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name="CONTATO")
public class Contato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String nome;
	
	//Categoria Criar pesquisa por filtro, rota categoria
	private String categoria;
	// Grupos many to many avaliar
	
//	@ManyToMany
//	@JoinTable(name="grupos_contatos",joinColumns = 
//		{@JoinColumn(name="contato_id")}, inverseJoinColumns =
//			{@JoinColumn(name="grupo_id")})
//	private List<Grupo> grupos;
	
	@NotNull
//	private String telefone;
	
	@OneToMany(mappedBy = "contato", targetEntity = Telefone.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Telefone> telefones;
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

//	public List<Grupo> getGrupos() {
//		return grupos;
//	}
//
//	public void setGrupos(List<Grupo> grupos) {
//		this.grupos = grupos;
//	}

	
	
	
	/*
	 * public String getTelefone() { return telefone; }
	 * 
	 * public void setTelefone(String telefone) { this.telefone = telefone; }
	 */

}
