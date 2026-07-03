package roberto.cafagna.U5W1D5test.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roberto.cafagna.U5W1D5test.Enum.StatoPostazione;
import roberto.cafagna.U5W1D5test.Enum.TipoPostazione;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String codiceUnivoco;

    @Setter
    @Column
    private String descrizione;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPostazione tipoPostazione;


    @Setter
    @Column(nullable = false)
    private int nMaxOccupanti;


    @ManyToOne
    @JoinColumn(name = "id_edificio", nullable = false)
    private Edificio edificio;


    public Postazione(String descrizione,
                      TipoPostazione tipoPostazione, StatoPostazione statoPostazione,
                      int nMaxOccupanti, Edificio edificio) {
        this.codiceUnivoco = UUID.randomUUID().toString();
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.nMaxOccupanti = nMaxOccupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", nMaxOccupanti=" + nMaxOccupanti +
                ", edificio=" + edificio +
                '}';
    }
}
