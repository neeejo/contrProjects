package it.contrader.service;

import it.contrader.converter.ProdottoConverter;
import it.contrader.dao.ProdottoRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.NegozioDTO;
import it.contrader.dto.ProdottoDTO;
import it.contrader.model.Prodotto;
import it.contrader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService extends AbstractService<Prodotto, ProdottoDTO>{

    @Autowired
    private ProdottoConverter converter;
    @Autowired
    private ProdottoRepository repository;

    public List<String> findTypes(){ return repository.findTypes();}

    public Page<Prodotto> getAllPaginata(Pageable pageable, long idnegozio) { return ((ProdottoRepository) repository).findAllByNegozioIdnegozio(idnegozio,pageable); }

    public Page<Prodotto> getAllPaginata(Pageable pageable) { return ((ProdottoRepository) repository).findAll(pageable); }

    /*
    public Prodotto findByIdprodotto(Long idprodotto){return repository.findByIdprodotto(idprodotto);}
    public List<ProdottoDTO> findByTipologia(String tipologia){
        return converter.toDTOList(repository.findByTipologia(tipologia));}
    public List<ProdottoDTO> findByNome(String nome){
        return converter.toDTOList(repository.findByNome(nome));}
    public List<ProdottoDTO> findByPrezzoLessThan(Double prezzo){
        return converter.toDTOList(repository.findByPrezzoLessThan(prezzo));}
    public List<ProdottoDTO> findByTipologiaAndPrezzoLessThan(String tipologia, Double prezzo){
        return converter.toDTOList(repository.findByTipologiaAndPrezzoLessThan(tipologia, prezzo));}
    public List<ProdottoDTO> findByNomeAndPrezzo(String nome, Double prezzo){
        return converter.toDTOList(repository.findByNomeAndPrezzo(nome, prezzo));}
    public List<ProdottoDTO> findByNomeAndTipologia(String nome, String tipologia){
        return converter.toDTOList(repository.findByNomeAndTipologia(nome, tipologia));}

     */
}

