package com.desafioConductor.SGD.Entities;

import javax.persistence.*;

@Entity
@Table(name="GRUPO")
public class GrupoInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descricao;
    public static GrupoInfo DEFAULT = new GrupoInfo(null, null, null);

    public GrupoInfo() {
    }

    public GrupoInfo(Long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
