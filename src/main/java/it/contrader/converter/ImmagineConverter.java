package it.contrader.converter;

import it.contrader.dto.ImmagineDTO;
import it.contrader.dto.ImmagineDTO;
import it.contrader.model.Immagine;
import it.contrader.model.Immagine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImmagineConverter extends AbstractConverter<Immagine,ImmagineDTO> {

    @Autowired
    ProdottoConverter converterProdotto;

    @Autowired
    UserConverter converterUser;
    @Override
    public Immagine toEntity(ImmagineDTO immagineDTO) {
        Immagine immagine = null;
        if (immagineDTO != null) {
            immagine = new Immagine(immagineDTO.getIdimmagine(), immagineDTO.getPicBytes(), converterProdotto.toEntity(immagineDTO.getIdprodotto()), converterUser.toEntity(immagineDTO.getIduser()));
        }
        return immagine;
    }

    @Override
    public ImmagineDTO toDTO(Immagine immagine) {
        ImmagineDTO immagineDTO = null;
        if (immagine != null) {
            immagineDTO = new ImmagineDTO(immagineDTO.getIdimmagine(), immagine.getPicByte(), converterProdotto.toDTO(immagine.getProdotto()), converterUser.toDTO(immagine.getUser()));

        }
        return immagineDTO;
    }
}
