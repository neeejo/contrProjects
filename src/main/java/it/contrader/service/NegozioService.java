package it.contrader.service;

import it.contrader.converter.AnagraficaConverter;
import it.contrader.converter.NegozioConverter;
import it.contrader.dao.NegozioRepository;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.NegozioDTO;
import it.contrader.exceptions.InvalidCredentialsException;
import it.contrader.model.Anagrafica;
import it.contrader.model.Negozio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

import java.util.List;

@Service
public class NegozioService extends AbstractService<Negozio,NegozioDTO> {

    @Autowired
    private NegozioRepository repository;
    @Autowired
    private NegozioConverter converter;
    @Autowired
    private AnagraficaConverter aConverter;


    public List<NegozioDTO> findByProprietario(Long idanagrafica) {
        return converter.toDTOList(repository.findByProprietarioIdAnagrafica(idanagrafica));
    }




}
