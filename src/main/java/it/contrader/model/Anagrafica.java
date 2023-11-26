package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="anagrafica")
public class Anagrafica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idanagrafica")
    private Long idAnagrafica;

    @OneToOne
    @JoinColumn(name = "idutente", referencedColumnName = "id")
    private User user;

    @Column (name="nome")
    private String nome;

    @Column (name="cognome")
    private String cognome;

    @Column(name="citta")
    private String citta;

    @Column (name="residenza")
    private String residenza;

    @Column (name="provincia")
    private String provincia;

    @Column (name="nazione")
    private String nazione;

    @Column(name="datanascita")
    private Date datanascita;

    @Column(name="genere")
    private Boolean genere;

    @Column(name="datacreazione")
    private Date datacreazione;


}