package it.contrader.dto;


import it.contrader.model.Anagrafica;
import it.contrader.model.Ordine;
import it.contrader.model.Prodotto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdineItemsDTO {


    private long idordineItems;

    private Ordine ordine;

    private Prodotto prodotto;

    private Anagrafica anagrafica;

    private double quantita;

    private double prezzo;

    private Date datetime;

}



