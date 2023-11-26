package it.contrader.model;

import javax.persistence.Entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Negozio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idnegozio;

    @Column(unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name="proprietario", referencedColumnName = "idanagrafica")
    private Anagrafica proprietario;

    private String descrizione;

    private String indirizzo;

    private String citta;

    private String provincia;
}
