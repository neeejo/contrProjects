package it.contrader.controller;

import it.contrader.dto.ImmagineDTO;
import it.contrader.dto.ProdottoDTO;
import it.contrader.model.Immagine;
import it.contrader.model.Prodotto;
import it.contrader.model.User;
import it.contrader.service.ImmagineService;
import it.contrader.service.ProdottoService;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.util.Arrays.setAll;

@RestController
@RequestMapping("/prodotto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdottoController  extends AbstractController<ProdottoDTO> {

    @Autowired
    private ProdottoService service;

    @Autowired
    private ImmagineService immagineService;

    @GetMapping("/tipi")
    public List<String> types(){
        return service.findTypes();
    }

    @GetMapping("getAllPaginataByNegozio")
    public ResponseEntity<Page<Prodotto>> getall( @RequestParam("idnegozio") long idnegozio, @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        return new ResponseEntity<>(service.getAllPaginata(PageRequest.of(pageNumber, pageSize), idnegozio), HttpStatus.OK);
    }

    @GetMapping("getAllPaginata")
    public ResponseEntity<Page<Prodotto>> getall(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        return new ResponseEntity<>(service.getAllPaginata(PageRequest.of(pageNumber, pageSize)), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("idprodotto") long id) {
        service.delete(id);
    }

    @PostMapping(value = "/uploadImmagineProdotto")
    public Immagine uploadImmagineProdotto(@RequestPart MultipartFile picBytes, @RequestParam Long idp) throws IOException {
        ImmagineDTO iDTO = new ImmagineDTO();
        iDTO.setIdprodotto(service.read(idp));
        iDTO.setPicBytes(picBytes.getBytes());
        return immagineService.uploadImmagine(iDTO);
    }

    @GetMapping(value = "/getImmagineProdotto", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Immagine> getImmagineProdotto(@RequestParam Long idp){
        return immagineService.getImmagineProdotto(idp);
    }


    /*
    PIETRO
    E' TUTTO INUUUUUTILEEEEE
    */
    /*
    @GetMapping ("/filter")
    public String filter(HttpServletRequest request, @RequestParam("tipologia") String tipologia, @RequestParam("costo") Double costo,
                         @RequestParam("nome") String nome){

        if (costo==0 && nome.equals("") && tipologia.equals("0")) {
            setAll(request);
            return "prodotto/readprodottiuser";
        }else if (costo==0 && nome.equals("")){
            List<ProdottoDTO> prodotti = service.findByTipologia(tipologia);
            request.getSession().setAttribute("prodotti", prodotti);
            return "prodotto/readprodottiuser";
        }else if(tipologia.equals("0") && nome.equals("")){
            List<ProdottoDTO> prodotti = service.findByPrezzoLessThan(costo);
            request.getSession().setAttribute("prodotti", prodotti);
            return "prodotto/readprodottiuser";
        }else if(costo==0 && tipologia.equals("0")){
            //List<ProdottoDTO> prodotti = service.findByNomeLike("%"+nome+"%");
            //request.getSession().setAttribute("prodotti", prodotti);
            return "prodotto/readprodottiuser";
        }else if(nome.equals("")){
            //List<ProdottoDTO> prodotti = service.findByTipologiaAndPrezzoLessThan(tipologia, costo);
            //request.getSession().setAttribute("prodotti", prodotti);
            return "prodotto/readprodottiuser";
        }else if(tipologia.equals("0")) {
            List<ProdottoDTO> prodotti = service.findByNomeAndPrezzo("%"+nome+"%", costo);
            request.getSession().setAttribute("prodotti", prodotti);
            return "prodotto/readprodottiuser";
        }else if(costo==0) {
            List<ProdottoDTO> prodotti = service.findByNomeAndTipologia("%"+nome+"%", tipologia);
            request.getSession().setAttribute("prodotti", prodotti);
            return "prodotto/readprodottiuser";
        }else{
            setAll(request);
            return "prodotto/readprodottiuser";
        }
    }

    PIETRO
    NON CREDO SERVA

    private void setAll(HttpServletRequest request) {
        request.getSession().setAttribute("prodotti", service.getAll());
    }
    */
}