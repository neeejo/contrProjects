package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "immagine")
public class Immagine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idimmagine")
    private Long id;
    @Column(name = "picbytes", length = 50000000)
    private byte[] picByte;

    @ManyToOne
    @JoinColumn(name = "idprodotto", referencedColumnName = "idprodotto")
    private Prodotto prodotto;
    @ManyToOne
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    private User user;

}
