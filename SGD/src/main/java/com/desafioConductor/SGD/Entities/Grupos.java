package com.desafioConductor.SGD.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grupos {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private Long idGrupo;
    private Long idContato;
    public static Grupos DEFAULT = new Grupos(null, null, null);

    public Grupos() {
    }

    public Grupos(Long id, Long idGrupo, Long idContato) {
        this.id = id;
        this.idGrupo = idGrupo;
        this.idContato = idContato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public static Grupos getDEFAULT() {
        return DEFAULT;
    }

    public static void setDEFAULT(Grupos DEFAULT) {
        Grupos.DEFAULT = DEFAULT;
    }
}
