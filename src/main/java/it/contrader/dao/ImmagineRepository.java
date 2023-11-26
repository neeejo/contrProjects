package it.contrader.dao;

import it.contrader.model.Immagine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ImmagineRepository extends CrudRepository<Immagine, Long> {

    public List<Immagine> findAllByProdottoIdprodotto(Long id);
}
