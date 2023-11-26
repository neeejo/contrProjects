package it.contrader.converter;

import it.contrader.dto.OrdineDTO;
import it.contrader.model.Ordine;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdineConverter extends AbstractConverter<Ordine, OrdineDTO> {

    @Override
    public Ordine toEntity(OrdineDTO ordineDTO){
        return ordineDTO!=null?Ordine.builder()
                .idordine(ordineDTO.getIdordine())
                .utente(ordineDTO.getUtente())
                .data(ordineDTO.getData())
                .totale(ordineDTO.getTotale())
                .build():null;
    }

    @Override
    public OrdineDTO toDTO(Ordine ordine){
        return ordine!=null?OrdineDTO.builder()
                .idordine(ordine.getIdordine())
                .utente(ordine.getUtente())
                .data(ordine.getData())
                .totale(ordine.getTotale())
                .build():null;
        }


}