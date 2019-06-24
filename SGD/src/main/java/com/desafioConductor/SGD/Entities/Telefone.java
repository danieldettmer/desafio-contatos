package com.desafioConductor.SGD.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private Long idContato;
    private String numero;
    public static Telefone DEFAULT = new Telefone(null, null, null);

    public Telefone() {
    }

    public Telefone(Long id, Long idContato, String numero) {
        this.id = id;
        this.idContato = idContato;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String telefone) {
        this.numero = telefone;
    }
}
