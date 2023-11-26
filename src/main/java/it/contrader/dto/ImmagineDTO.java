package it.contrader.dto;

import it.contrader.model.Prodotto;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ImmagineDTO {

    private long idimmagine;

    private byte[] picBytes;

    private ProdottoDTO idprodotto;

    private UserDTO iduser;





}
