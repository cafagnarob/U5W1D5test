package roberto.cafagna.U5W1D5test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import roberto.cafagna.U5W1D5test.entities.Utente;
import roberto.cafagna.U5W1D5test.exception.NotFoundException;
import roberto.cafagna.U5W1D5test.exception.ValidationException;
import roberto.cafagna.U5W1D5test.repository.UtenteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UtenteService {
    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente findById(long utenteId) {
        Optional<Utente> fromDB = this.utenteRepository.findById(utenteId);
        if (fromDB.isPresent()) {
            System.out.println(fromDB);
            return fromDB.get();
        } else throw new NotFoundException(utenteId);
    }

    public List<Utente> findAll() {
        List<Utente> listaFromDB = this.utenteRepository.findAll();
        listaFromDB.forEach(System.out::println);
        return listaFromDB;
    }

    public void findByIdAndDelete(long utenteId) {
        Utente fromDB = this.findById(utenteId);
        this.utenteRepository.delete(fromDB);
        log.info("L'elemento con ID: " + utenteId + " è stato eliminato correttamente");
    }

    public void saveNewUtente(Utente newUtente) {
        if (newUtente.getNome().isEmpty())
            throw new ValidationException("nome troppo corto, inserire un nome valido");

        Optional<Utente> fromQuery = this.utenteRepository.findByUserName(newUtente.getUserName());
        if (fromQuery.isPresent())
            throw new ValidationException("L' Username" + newUtente.getUserName() + " è già in uso");

        Optional<Utente> fromQuery2 = this.utenteRepository.findByEmail(newUtente.getEmail());
        if (fromQuery2.isPresent())
            throw new ValidationException("L' email" + newUtente.getEmail() + " è già in uso");

        this.utenteRepository.save(newUtente);
        log.info("L'utente " + newUtente.getNome() + " è stato salvato correttamente");
    }

    public void findByIdAndUpdate(long utenteId, String userName, String email) {
        Utente fromDB = this.findById(utenteId);
        boolean conflitto = this.utenteRepository.existsByUserNameAndIdNot(userName, utenteId);
        if (conflitto)
            throw new ValidationException("l' userName " + userName + "è gia in uso");

        boolean formQuery = this.utenteRepository.existsByEmailAndIdNot(email, utenteId);
        if (formQuery)
            throw new ValidationException("L'email " + email + " è già in uso");

        fromDB.setUserName(userName);
        fromDB.setEmail(email);

        this.utenteRepository.save(fromDB);
        log.info("L'elemento con ID: " + fromDB.getId() + " è stato modificato correttamente");
    }

}
