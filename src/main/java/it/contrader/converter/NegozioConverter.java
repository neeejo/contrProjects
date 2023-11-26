package it.contrader.converter;

import it.contrader.dto.NegozioDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Negozio;
import it.contrader.model.User;
import org.springframework.stereotype.Component;

@Component
public class NegozioConverter extends AbstractConverter<Negozio, NegozioDTO> {

    @Override
    public Negozio toEntity(NegozioDTO negozioDTO) {
        return negozioDTO != null ? Negozio.builder()
                .idnegozio(negozioDTO.getIdnegozio())
                .nome(negozioDTO.getNome())
                .descrizione(negozioDTO.getDescrizione())
                .proprietario(negozioDTO.getProprietario())
                .descrizione(negozioDTO.getDescrizione())
                .indirizzo(negozioDTO.getIndirizzo())
                .citta(negozioDTO.getCitta())
                .provincia(negozioDTO.getProvincia())
                .build() : null;

    }

    @Override
    public NegozioDTO toDTO(Negozio negozio) {
        return negozio != null ? NegozioDTO.builder()
                .idnegozio(negozio.getIdnegozio())
                .nome(negozio.getNome())
                .proprietario(negozio.getProprietario())
                .descrizione(negozio.getDescrizione())
                .indirizzo(negozio.getIndirizzo())
                .citta(negozio.getCitta())
                .provincia(negozio.getProvincia())
                .build() : null;
    }

}