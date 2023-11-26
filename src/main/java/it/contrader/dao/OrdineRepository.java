package it.contrader.dao;

import it.contrader.model.Anagrafica;
import it.contrader.model.Ordine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.sql.Date;

@Repository
@Transactional
public interface OrdineRepository extends CrudRepository<Ordine, Long> {


     List<Ordine> findAllByUtente(Anagrafica userID);


}