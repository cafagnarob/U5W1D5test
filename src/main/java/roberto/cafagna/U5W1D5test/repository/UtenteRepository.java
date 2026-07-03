package roberto.cafagna.U5W1D5test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roberto.cafagna.U5W1D5test.entities.Utente;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Optional<Utente> findByUserName(String userName);

    Optional<Utente> findByEmail(String email);

    boolean existsByUserName(String userName);

    boolean existsByUserNameAndIdNot(String userName, long id);

    boolean existsByEmailAndIdNot(String email, long id);


}
