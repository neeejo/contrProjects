package it.contrader.dto;

import it.contrader.model.Anagrafica;
import it.contrader.model.Prodotto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdineDTO {

    private Anagrafica utente;

    private Date data;

    private Double totale;

    private Long idordine;

    public OrdineDTO(Anagrafica anagrafica, Date d, Double tot){
        this.utente = anagrafica;
        this.data = d;
        this.totale = tot;
    }


}