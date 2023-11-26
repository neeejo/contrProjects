package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.contrader.converter.NegozioConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import it.contrader.model.Anagrafica;
import it.contrader.converter.AnagraficaConverter;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.NegozioDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Negozio;
import it.contrader.service.AnagraficaService;
import it.contrader.converter.AnagraficaConverter;
import it.contrader.service.NegozioService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/negozio")
@CrossOrigin(origins = "http://localhost:4200")
public class NegozioController extends AbstractController<NegozioDTO> {

    @Autowired
    private NegozioService nService;
    @GetMapping("/nByProprietario")
    public List<NegozioDTO> nByProprietario (@RequestParam @Valid Long id) {
        return nService.findByProprietario(id);
    }

}
