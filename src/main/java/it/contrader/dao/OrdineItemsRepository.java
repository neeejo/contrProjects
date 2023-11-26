package it.contrader.dao;


import it.contrader.model.Anagrafica;
import it.contrader.model.OrdineItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrdineItemsRepository extends CrudRepository<OrdineItems, Long> {



    List<OrdineItems> findAllByAnagraficaUtenteIdAnagraficaAndIdordineIsNull(Long idAnagrafica);

    List<OrdineItems> findAllByAnagraficaUtenteIdAnagraficaAndIdordineIsNotNull(Long idAnagrafica);


}
