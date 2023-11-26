package it.contrader.service;


import it.contrader.converter.AnagraficaConverter;
import it.contrader.dao.AnagraficaRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaService extends AbstractService<Anagrafica, AnagraficaDTO>  {

    @Autowired
    private AnagraficaConverter converter;

    @Autowired
    private AnagraficaRepository repository;


    public AnagraficaDTO findByUser(User user){
        return converter.toDTO(repository.findByUser(user));
    }

    public AnagraficaDTO findById(Long idAnagrafica) {
        return converter.toDTO(repository.findById(idAnagrafica).get());
    }

    public Page<Anagrafica> getAllPaginata(Pageable pageable) { return ((AnagraficaRepository) repository).findAllByUserNotNull(pageable); }


    public AnagraficaDTO findByUserId(Long id) {
        return converter.toDTO((repository.findByUserId(id)));
    }
}