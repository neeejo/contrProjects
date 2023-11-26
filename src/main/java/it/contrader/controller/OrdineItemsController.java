package it.contrader.controller;

import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.OrdineDTO;
import it.contrader.dto.OrdineDTO;
import it.contrader.dto.OrdineItemsDTO;
import it.contrader.model.Anagrafica;
import it.contrader.service.NegozioService;

import it.contrader.service.OrdineItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ordineitems")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdineItemsController extends AbstractController<OrdineItemsDTO>   {

    @Autowired
    OrdineItemsService service;



    @GetMapping("/pendingList")
    public List<OrdineItemsDTO> pendingList(@RequestParam @Valid Long idanagrafica){
        return service.findAllByAnagrafica(idanagrafica);
    }

    @GetMapping("/dettaglioList")
    public List<OrdineItemsDTO> dettaglioList(@RequestParam @Valid Long idanagrafica) {
        return service.findAllByAnagraficaUtenteIdAnagraficaAndIdordineIsNotNull(idanagrafica);
    }





}
