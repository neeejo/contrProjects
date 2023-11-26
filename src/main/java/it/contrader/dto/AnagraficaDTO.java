package it.contrader.dto;


import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AnagraficaDTO {

    private long idAnagrafica;

    private User user;

    private String nome;

    private String cognome;

    private String citta;

    private String residenza;

    private String provincia;

    private String nazione;

    private Date datanascita;

    private Boolean genere;

    private Date datacreazione;


}