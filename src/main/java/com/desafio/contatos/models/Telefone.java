package com.desafio.contatos.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "telefones")
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String numero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contato_id")
    @JsonBackReference(value = "contato")
    private Contato contato;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

}
