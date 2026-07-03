package roberto.cafagna.U5W1D5test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roberto.cafagna.U5W1D5test.entities.Edificio;

import java.util.Optional;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

    Optional<Edificio> findByIndirizzo(String indirizzo);

}
