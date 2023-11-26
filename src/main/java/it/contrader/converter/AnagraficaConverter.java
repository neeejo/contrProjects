package it.contrader.converter;


import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.Anagrafica;
import org.springframework.stereotype.Component;

@Component
public class AnagraficaConverter extends AbstractConverter<Anagrafica, AnagraficaDTO> {
    @Override
    public Anagrafica toEntity(AnagraficaDTO anagraficaDTO) {
        Anagrafica anagrafica = null;
        if (anagraficaDTO != null) {
            anagrafica = new Anagrafica(anagraficaDTO.getIdAnagrafica(), anagraficaDTO.getUser(), anagraficaDTO.getNome(), anagraficaDTO.getCognome(),anagraficaDTO.getCitta(), anagraficaDTO.getResidenza(),  anagraficaDTO.getProvincia(),  anagraficaDTO.getNazione(),  anagraficaDTO.getDatanascita(),  anagraficaDTO.getGenere(),  anagraficaDTO.getDatacreazione());
        }
        return anagrafica;
    }

    @Override
    public AnagraficaDTO toDTO(Anagrafica anagrafica) {
        AnagraficaDTO anagraficaDTO = null;
        if (anagrafica != null) {
            anagraficaDTO = new AnagraficaDTO(anagrafica.getIdAnagrafica(), anagrafica.getUser(), anagrafica.getNome(), anagrafica.getCognome(), anagrafica.getCitta(), anagrafica.getResidenza(), anagrafica.getProvincia(), anagrafica.getNazione(), anagrafica.getDatanascita(),anagrafica.getGenere(), anagrafica.getDatacreazione());

        }
        return anagraficaDTO;
    }

}