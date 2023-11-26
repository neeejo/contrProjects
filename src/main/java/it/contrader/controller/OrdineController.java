package it.contrader.controller;

import it.contrader.dto.OrdineDTO;
import it.contrader.dto.OrdineDTO;
import it.contrader.service.NegozioService;

import it.contrader.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ordine")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdineController extends AbstractController<OrdineDTO>   {

    @Autowired
    private OrdineService service;

    @GetMapping("/listaOrdini")
    public List<OrdineDTO> listaOrdini(@RequestParam @Valid Long idAnagrafica){
        return service.findAllByUtente(idAnagrafica);
    }
    @PostMapping("/acquistaCarrello")
    public ResponseEntity<OrdineDTO> acquistaCarrello(@RequestBody @Valid Long idAnagrafica){
        return new ResponseEntity<>(service.acquistaCarrello(idAnagrafica), HttpStatus.OK);
    }

}
