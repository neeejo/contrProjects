package it.contrader.converter;

//import it.contrader.dto.OrdineDTO;
import it.contrader.dto.ProdottoDTO;
//import it.contrader.model.Ordine;
import it.contrader.model.Prodotto;
import it.contrader.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProdottoConverter extends AbstractConverter<Prodotto, ProdottoDTO>{

    @Override
    public Prodotto toEntity(ProdottoDTO prodottoDTO) {
        return prodottoDTO != null ? Prodotto.builder()
                .idprodotto(prodottoDTO.getIdprodotto())
                .nome(prodottoDTO.getNome())
                .negozio(prodottoDTO.getNegozio())
                .prezzo(prodottoDTO.getPrezzo())
                .descrizione(prodottoDTO.getDescrizione())
                .tipologia(prodottoDTO.getTipologia())
                .quantita(prodottoDTO.getQuantita())
                .codiceprodotto(prodottoDTO.getCodiceprodotto())
                .build() : null;
    }

    @Override
    public ProdottoDTO toDTO(Prodotto prodotto) {
        return prodotto != null ? ProdottoDTO.builder()
                .idprodotto(prodotto.getIdprodotto())
                .nome(prodotto.getNome())
                .negozio(prodotto.getNegozio())
                .prezzo(prodotto.getPrezzo())
                .descrizione(prodotto.getDescrizione())
                .tipologia(prodotto.getTipologia())
                .quantita(prodotto.getQuantita())
                .codiceprodotto(prodotto.getCodiceprodotto())
                .build() : null;
    }

}

