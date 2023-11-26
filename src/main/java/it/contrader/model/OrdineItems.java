package it.contrader.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "ordine_items")
public class OrdineItems {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idordine_items")
    private Long idordineItems;

    @ManyToOne
    @JoinColumn(name="ordine", referencedColumnName = "idordine")
    private Ordine idordine;

    @ManyToOne
    @JoinColumn(name="prodotto", referencedColumnName = "idprodotto")
    private Prodotto idprodotto;

    @ManyToOne
    @JoinColumn(name="anagrafica_utente", referencedColumnName = "idanagrafica")
    private Anagrafica anagraficaUtente;

    @Column(name="quantita")
    private Double quantita;

    @Column(name="prezzo")
    private Double prezzo;

    @Column(name="datetime")
    private Date datetime;







}





