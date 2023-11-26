package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.Anagrafica;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NegozioDTO {

  private long idnegozio;
  private String nome;
  private Anagrafica proprietario;
  private String descrizione;
  private String indirizzo;
  private String citta;
  private String provincia;


}
