package it.contrader.controller;


import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.User;
import it.contrader.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/anagrafica")
@CrossOrigin(origins = "http://localhost:4200")
public class AnagraficaController extends AbstractController<AnagraficaDTO> {


    @Autowired
    private AnagraficaService anagraficaService;

    @GetMapping ("/findByUserId")
    public AnagraficaDTO findByUserId(long id) { return anagraficaService.findByUserId(id); }

    @GetMapping("getAllPaginata")
    public ResponseEntity<Page<Anagrafica>> getall(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber ) {
        return new ResponseEntity<>(anagraficaService.getAllPaginata(PageRequest.of(pageNumber, pageSize)), HttpStatus.OK);
    }

}
