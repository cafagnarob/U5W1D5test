package roberto.cafagna.U5W1D5test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roberto.cafagna.U5W1D5test.entities.Prenotazione;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> findByDataDiPrenotazione(LocalDate data);

    List<Prenotazione> findByUtenteId(long id);

    List<Prenotazione> findByPostazioneId(long postazioneId);

    boolean existsByUtenteIdAndDataDiPrenotazione(long utenteId, LocalDate data);

    boolean existsByPostazioneIdAndDataDiPrenotazione(long postazioneId, LocalDate data);

    boolean existsByPostazioneIdAndDataDiPrenotazioneAndIdNot(long postazioneId, LocalDate data, long id);
}
