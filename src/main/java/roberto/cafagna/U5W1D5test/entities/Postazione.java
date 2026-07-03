package roberto.cafagna.U5W1D5test.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roberto.cafagna.U5W1D5test.Enum.StatoPostazione;
import roberto.cafagna.U5W1D5test.Enum.TipoPostazione;

@Entity
@NoArgsConstructor
@Getter
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column
    private String descrizione;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPostazione tipoPostazione;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatoPostazione statoPostazione;


    @Setter
    @Column(nullable = false)
    private int nMaxOccupanti;


    @ManyToOne
    @JoinColumn(name = "id_edificio", nullable = false)
    private Edificio edificio;


    public Postazione(String descrizione, Edificio edificio,
                      TipoPostazione tipoPostazione, int nMaxOccupanti,
                      StatoPostazione statoPostazione) {
        this.descrizione = descrizione;
        this.edificio = edificio;
        this.tipoPostazione = tipoPostazione;
        this.nMaxOccupanti = nMaxOccupanti;
        this.statoPostazione = statoPostazione;
    }


}
