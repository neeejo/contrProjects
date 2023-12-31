package it.contrader.dao;

import it.contrader.model.Anagrafica;
import it.contrader.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AnagraficaRepository  extends CrudRepository<Anagrafica, Long> {

    Anagrafica findByUser(User user);
    

    Anagrafica findByUserId (long id);


    Page<Anagrafica> findAllByUserNotNull(Pageable pageable);


}