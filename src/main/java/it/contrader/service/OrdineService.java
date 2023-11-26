package it.contrader.service;

import it.contrader.converter.AnagraficaConverter;
import it.contrader.converter.OrdineConverter;
import it.contrader.dao.OrdineItemsRepository;
import it.contrader.dao.OrdineRepository;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.OrdineDTO;
//import it.contrader.dto.OrdineSummaryDTO;
//import it.contrader.dto.ProdottoStatsDTO;
import it.contrader.dto.OrdineItemsDTO;
import it.contrader.model.Ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrdineService extends AbstractService<Ordine, OrdineDTO> {

    @Autowired
    private OrdineConverter converter;

    @Autowired
    private OrdineRepository repository;

    @Autowired
    private OrdineItemsService ordineItemsService;

    @Autowired
    AnagraficaConverter aConverter;

    @Autowired
    AnagraficaService aService;

    public List<OrdineDTO> findAllByUtente(Long idAnagrafica) {
        return converter.toDTOList(repository.findAllByUtente(aConverter.toEntity(aService.read(idAnagrafica))));
    }

    public OrdineDTO acquistaCarrello(Long idAnagrafica) {
        List<OrdineItemsDTO> prodottiCarrello = ordineItemsService.findAllByAnagrafica(idAnagrafica);
        AnagraficaDTO aDTO = aService.findById(idAnagrafica);
        Double sum = 0.0;
        for (OrdineItemsDTO p: prodottiCarrello) {
            sum += p.getPrezzo();
        }
        OrdineDTO insertedOrdine = this.insert(new OrdineDTO(aConverter.toEntity(aDTO), Date.valueOf(LocalDate.now()), sum));
        for (OrdineItemsDTO p : prodottiCarrello) {
            p.setOrdine(converter.toEntity(insertedOrdine));
            ordineItemsService.update(p);
        }

        return insertedOrdine;
    }

}