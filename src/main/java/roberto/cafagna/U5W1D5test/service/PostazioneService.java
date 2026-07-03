package roberto.cafagna.U5W1D5test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import roberto.cafagna.U5W1D5test.Enum.TipoPostazione;
import roberto.cafagna.U5W1D5test.entities.Postazione;
import roberto.cafagna.U5W1D5test.exception.NotFoundException;
import roberto.cafagna.U5W1D5test.exception.ValidationException;
import roberto.cafagna.U5W1D5test.repository.PostazioniRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostazioneService {
    private final PostazioniRepository postazioniRepository;

    public PostazioneService(PostazioniRepository postazioniRepository) {
        this.postazioniRepository = postazioniRepository;
    }


    public Postazione findById(long postazioneId) {
        Optional<Postazione> fromDB = this.postazioniRepository.findById(postazioneId);
        if (fromDB.isPresent()) {
            System.out.println(fromDB);
            return fromDB.get();
        } else throw new NotFoundException(postazioneId);
    }

    public List<Postazione> findAll() {
        List<Postazione> listaFromDB = this.postazioniRepository.findAll();
        listaFromDB.forEach(System.out::println);
        return listaFromDB;
    }

    public void findByIdAndDelete(long postazioneId) {
        Postazione fromDB = this.findById(postazioneId);
        this.postazioniRepository.delete(fromDB);
        log.info("L'elemento con ID: " + postazioneId + " è stato eliminato correttamente");
    }

    public void saveNewPostazione(Postazione newPostazione) {
        if (newPostazione.getDescrizione().length() < 3)
            throw new ValidationException("descrizione troppo corta, inserire una descrizione valido");

        if (newPostazione.getNMaxOccupanti() <= 0)
            throw new ValidationException("inserire un numero massimo di occupanti valido");

        if (newPostazione.getTipoPostazione() == TipoPostazione.PRIVATO
                && newPostazione.getNMaxOccupanti() != 1) {
            throw new ValidationException("Una postazione PRIVATO deve avere esattamente 1 occupante massimo");
        }

        if (newPostazione.getEdificio() == null) {
            throw new ValidationException("È necessario specificare un edificio valido");
        }

        if (newPostazione.getNMaxOccupanti() > 500) {
            throw new ValidationException("Numero massimo occupanti non plausibile");
        }

        this.postazioniRepository.save(newPostazione);
        log.info("L'elemento " + newPostazione.getId() + " è stato salvato correttamente");
    }

    public void findByIdAndUpdate(long postazioneId,
                                  String descrizione, TipoPostazione tipo,
                                  int nMaxOcc) {
        Postazione fromDB = this.findById(postazioneId);
        if (descrizione.length() < 3)
            throw new ValidationException("descrizione troppo corta, inserire una descrizione valido");

        if (nMaxOcc <= 0)
            throw new ValidationException("inserire un numero massimo di occupanti valido");

        if (tipo == TipoPostazione.PRIVATO && nMaxOcc != 1)
            throw new ValidationException("Una postazione PRIVATO deve avere esattamente 1 occupante massimo");
        if (nMaxOcc > 500) {
            throw new ValidationException("Numero massimo occupanti non plausibile");
        }


        fromDB.setDescrizione(descrizione);
        fromDB.setTipoPostazione(tipo);
        fromDB.setNMaxOccupanti(nMaxOcc);

        this.postazioniRepository.save(fromDB);
        log.info("L'elemento con ID: " + fromDB.getId() + " è stato modificato correttamente");
    }

    public List<Postazione> cercaPerTipoECitta(TipoPostazione tipo, String citta) {
        return this.postazioniRepository.findByTipoAndCitta(tipo, citta);
    }


}
