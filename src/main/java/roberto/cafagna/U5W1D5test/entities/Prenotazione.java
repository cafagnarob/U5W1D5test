package roberto.cafagna.U5W1D5test.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_postazione", "dataDiPrenotazione"}),
        @UniqueConstraint(columnNames = {"id_utente", "dataDiPrenotazione"})
})
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column(nullable = false)
    private LocalDate dataDiPrenotazione;

    @Column(nullable = false)
    private LocalDate finePrenotazione;

    @ManyToOne
    @JoinColumn(name = "id_postazione", nullable = false)
    private Postazione postazione;


    @ManyToOne
    @JoinColumn(name = "id_utente",
            nullable = false)
    private Utente utente;

    @Setter
    @Column(nullable = false)
    private int nOccupanti;

    public Prenotazione(LocalDate dataDiPrenotazione,
                        Postazione postazione,
                        Utente utente,
                        int nOccupanti) {
        this.dataDiPrenotazione = dataDiPrenotazione;
        this.finePrenotazione = dataDiPrenotazione.plusDays(1);
        this.postazione = postazione;
        this.utente = utente;
        this.nOccupanti = nOccupanti;
    }


    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", dataDiPrenotazione=" + dataDiPrenotazione +
                ", finePrenotazione=" + finePrenotazione +
                ", postazione=" + postazione +
                ", utente=" + utente +
                ", nOccupanti=" + nOccupanti +
                '}';
    }
}
