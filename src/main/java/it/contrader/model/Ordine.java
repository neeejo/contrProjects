package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "ordine")
public class Ordine {


    @ManyToOne
    @JoinColumn(name = "utente", referencedColumnName = "idanagrafica")
    private Anagrafica utente;

    @Column(name="data")
    private Date data;

    @Column(name="totale")
    private Double totale;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idordine")
    private Long idordine;



}