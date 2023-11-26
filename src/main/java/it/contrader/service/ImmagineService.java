package it.contrader.service;

import it.contrader.converter.ProdottoConverter;
import it.contrader.dao.ImmagineRepository;
import it.contrader.dto.ImmagineDTO;
import it.contrader.dto.ProdottoDTO;
import it.contrader.model.Immagine;
import it.contrader.model.Prodotto;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImmagineService extends AbstractService<Immagine, ImmagineDTO>{
    @Autowired
    private ImmagineRepository immagineRepository;

    @Autowired
    private ProdottoConverter prodottoConverter;




    public Immagine uploadImmagine(ImmagineDTO immagineDTO) throws IOException {

        Immagine immagine = new Immagine();
        immagine.setPicByte(immagineDTO.getPicBytes());
        immagine.setProdotto(prodottoConverter.toEntity(immagineDTO.getIdprodotto()));
        immagineRepository.save(immagine);
        return immagine;

    }


    public List<Immagine> getImmagineProdotto(Long id) {
        return immagineRepository.findAllByProdottoIdprodotto(id);
    }
}
