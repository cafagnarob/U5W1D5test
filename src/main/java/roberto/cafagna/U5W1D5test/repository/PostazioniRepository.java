package roberto.cafagna.U5W1D5test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import roberto.cafagna.U5W1D5test.Enum.TipoPostazione;
import roberto.cafagna.U5W1D5test.entities.Postazione;

import java.util.List;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, Long> {

    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione = :tipo AND p.edificio.citta = :citta")
    List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta);
}
