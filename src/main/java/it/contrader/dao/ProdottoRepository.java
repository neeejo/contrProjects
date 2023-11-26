package it.contrader.dao;

import it.contrader.dto.NegozioDTO;
import it.contrader.dto.ProdottoDTO;
import it.contrader.model.Prodotto;
import it.contrader.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public interface ProdottoRepository extends CrudRepository<Prodotto, Long> {

    /*
    PIETRO
    NON RICONOSCE IL METODO
    */
    @Query("SELECT DISTINCT tipologia FROM Prodotto")
    List<String> findTypes();

    Page<Prodotto> findAll(Pageable pageable);

    Page<Prodotto> findAllByNegozioIdnegozio( long idnegozio, Pageable pageable);

    /*
    Prodotto findByIdprodotto(Long idprodotto);

    @Query("SELECT p FROM Prodotto p WHERE nome like ?1")
    List<Prodotto> findByNome(String nome);

    List<Prodotto> findByTipologia(String tipologia);

    List<Prodotto> findByPrezzoLessThan(Double prezzo);

    public List<Prodotto> findByTipologiaAndPrezzoLessThan(String tipologia, Double prezzo);

    @Query("SELECT p FROM Prodotto p WHERE nome like ?1 AND prezzo <?2")
    public List<Prodotto> findByNomeAndPrezzo(String nome, Double prezzo);

    @Query("SELECT p FROM Prodotto p WHERE nome like ?1 AND tipologia =?2")
    public List<Prodotto> findByNomeAndTipologia(String nome, String tipologia);
    */
}

