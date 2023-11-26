package it.contrader.service;

import it.contrader.converter.AnagraficaConverter;
import it.contrader.converter.OrdineItemsConverter;
import it.contrader.dao.OrdineItemsRepository;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.OrdineDTO;
import it.contrader.dto.OrdineItemsDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.Ordine;
import it.contrader.model.OrdineItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdineItemsService extends AbstractService<OrdineItems, OrdineItemsDTO>{



    @Autowired
    OrdineItemsRepository repo;

    @Autowired
    OrdineItemsConverter converter;

    @Autowired
    AnagraficaConverter aConverter;


    public List<OrdineItemsDTO> findAllByAnagrafica(Long idanagrafica) {
        return converter.toDTOList(repo.findAllByAnagraficaUtenteIdAnagraficaAndIdordineIsNull(idanagrafica));
    }

    public List<OrdineItemsDTO> findAllByAnagraficaUtenteIdAnagraficaAndIdordineIsNotNull(Long idanagrafica) {
        return converter.toDTOList(repo.findAllByAnagraficaUtenteIdAnagraficaAndIdordineIsNotNull(idanagrafica));
    }


}
