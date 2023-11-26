package it.contrader.dao;

import javax.transaction.Transactional;

import it.contrader.model.Anagrafica;
import it.contrader.model.Negozio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

import java.util.List;
import java.util.Optional;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD.
 * Definisce il metodo di login.
 *
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @see CrudRepository
 *
 */
@Repository
@Transactional
public interface NegozioRepository extends CrudRepository<Negozio, Long>{


    public List<Negozio> findByProprietarioIdAnagrafica(Long idanagrafica);



}
