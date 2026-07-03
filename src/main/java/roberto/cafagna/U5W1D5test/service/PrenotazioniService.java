package roberto.cafagna.U5W1D5test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import roberto.cafagna.U5W1D5test.Enum.StatoPostazione;
import roberto.cafagna.U5W1D5test.entities.Postazione;
import roberto.cafagna.U5W1D5test.entities.Prenotazione;
import roberto.cafagna.U5W1D5test.exception.NotFoundException;
import roberto.cafagna.U5W1D5test.exception.ValidationException;
import roberto.cafagna.U5W1D5test.repository.PostazioniRepository;
import roberto.cafagna.U5W1D5test.repository.PrenotazioneRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PrenotazioniService {
    private final PostazioniRepository postazioniRepository;
    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioniService(PostazioniRepository postazioniRepository, PrenotazioneRepository prenotazioneRepository) {
        this.postazioniRepository = postazioniRepository;
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public Prenotazione findById(long prenotazioneId) {
        Optional<Prenotazione> fromDB = this.prenotazioneRepository.findById(prenotazioneId);
        if (fromDB.isPresent()) {
            System.out.println(fromDB);
            return fromDB.get();
        } else throw new NotFoundException(prenotazioneId);
    }

    public List<Prenotazione> findAll() {
        List<Prenotazione> listaFromDB = this.prenotazioneRepository.findAll();
        listaFromDB.forEach(System.out::println);
        return listaFromDB;
    }

    public void saveNewPrenotazione(Prenotazione newPrenotazione) {
        Postazione postazione = newPrenotazione.getPostazione();
        if (postazione.getStatoPostazione() == StatoPostazione.OCCUPATO)
            throw new ValidationException("La postazione con ID: " + postazione.getId() + " non è disponibile (stato OCCUPATO)");

        boolean existsFromDB = this.prenotazioneRepository.existsByUtenteIdAndDataDiPrenotazione
                (newPrenotazione.getUtente().getId(), newPrenotazione.getDataDiPrenotazione());
        if (existsFromDB)
            throw new ValidationException("Una prenotazione in data: " + newPrenotazione.getDataDiPrenotazione() +
                    "a nome dell' utente " + newPrenotazione.getUtente().getUserName() + "è già registrata a DB");

        boolean existFromDB2 = this.prenotazioneRepository.existsByPostazioneIdAndDataDiPrenotazione
                (newPrenotazione.getPostazione().getId(), newPrenotazione.getDataDiPrenotazione());
        if (existFromDB2)
            throw new ValidationException("La postazione con ID: "
                    + newPrenotazione.getPostazione().getId() +
                    "è gia prenotata in data " + newPrenotazione.getDataDiPrenotazione());
        if (newPrenotazione.getNOccupanti() > newPrenotazione.getPostazione().getNMaxOccupanti())
            throw new ValidationException("Numero occupanti superiore alla capienza massima della postazione");

        this.prenotazioneRepository.save(newPrenotazione);
        if (newPrenotazione.getDataDiPrenotazione().isEqual(LocalDate.now())) {
            postazione.setStatoPostazione(StatoPostazione.OCCUPATO);
            this.postazioniRepository.save(postazione);
            log.info("La postazione con ID: " + postazione.getId() + " è stata impostata come OCCUPATO");
        }
        log.info("La prenotazione di " + newPrenotazione.getUtente().getNome() + " il " + newPrenotazione.getDataDiPrenotazione() + " è stato salvato correttamente");
    }


    public void findByIdAndDelete(long prenotazioneId) {
        Prenotazione fromDB = this.findById(prenotazioneId);
        Postazione postazione = fromDB.getPostazione();
        this.prenotazioneRepository.delete(fromDB);
        if (fromDB.getDataDiPrenotazione().isEqual(LocalDate.now())) {
            postazione.setStatoPostazione(StatoPostazione.LIBERO);
            this.postazioniRepository.save(postazione);
        }
        log.info("L'elemento con ID: " + prenotazioneId + " è stato eliminato correttamente");
    }

    public void findByIdAndUpdateNOccupantiAndData(long prenotazioneId, int nOccupanti,
                                                   LocalDate dataDiPrenotazione) {
        Prenotazione fromDB = this.findById(prenotazioneId);
        if (nOccupanti > fromDB.getPostazione().getNMaxOccupanti())
            throw new ValidationException("Troppi partecipanti per questa postazione");
        boolean conflitto = this.prenotazioneRepository
                .existsByPostazioneIdAndDataDiPrenotazioneAndIdNot(
                        fromDB.getPostazione().getId(), dataDiPrenotazione, fromDB.getId());

        if (conflitto)
            throw new ValidationException("Non è possibile modificare la prenotazione poiché la postazione "
                    + fromDB.getPostazione().getId() + " in data " + dataDiPrenotazione + " è già prenotata");

        fromDB.setNOccupanti(nOccupanti);
        fromDB.setDataDiPrenotazione(dataDiPrenotazione);
        this.prenotazioneRepository.save(fromDB);
        log.info("L'elemento con ID: " + fromDB.getId() + " è stato modificato correttamente");
    }

    public List<Prenotazione> findByUtenteId(long utenteId) {
        return this.prenotazioneRepository.findByUtenteId(utenteId);
    }
}
