package it.contrader.dto;

import it.contrader.model.Negozio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdottoDTO {

    private Long idprodotto;

    private String nome;

    private Negozio negozio;

    private double prezzo;

    private String descrizione;

    private String tipologia;

    private int quantita;

    private String codiceprodotto;
}