package it.contrader.converter;

import it.contrader.dto.OrdineDTO;
import it.contrader.dto.OrdineItemsDTO;
import it.contrader.model.Ordine;
import it.contrader.model.OrdineItems;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdineItemsConverter extends AbstractConverter<OrdineItems, OrdineItemsDTO> {

    @Override
    public OrdineItems toEntity(OrdineItemsDTO ordineitemsDTO){
        return ordineitemsDTO!=null?OrdineItems.builder()
                .idordineItems(ordineitemsDTO.getIdordineItems())
                .idordine(ordineitemsDTO.getOrdine())
                .idprodotto(ordineitemsDTO.getProdotto())
                .anagraficaUtente(ordineitemsDTO.getAnagrafica())
                .quantita(ordineitemsDTO.getQuantita())
                .prezzo(ordineitemsDTO.getPrezzo())
                .datetime(ordineitemsDTO.getDatetime())
                .build():null;
    }

    @Override
    public OrdineItemsDTO toDTO(OrdineItems ordineitems){
        return ordineitems!=null?OrdineItemsDTO.builder()
                .idordineItems(ordineitems.getIdordineItems())
                .ordine(ordineitems.getIdordine())
                .prodotto(ordineitems.getIdprodotto())
                .anagrafica(ordineitems.getAnagraficaUtente())
                .quantita(ordineitems.getQuantita())
                .prezzo(ordineitems.getPrezzo())
                .datetime(ordineitems.getDatetime())
                .build():null;
    }

}