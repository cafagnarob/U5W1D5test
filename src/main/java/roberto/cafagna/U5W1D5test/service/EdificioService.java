package roberto.cafagna.U5W1D5test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import roberto.cafagna.U5W1D5test.entities.Edificio;
import roberto.cafagna.U5W1D5test.exception.NotFoundException;
import roberto.cafagna.U5W1D5test.exception.ValidationException;
import roberto.cafagna.U5W1D5test.repository.EdificioRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EdificioService {
    private final EdificioRepository edificioRepository;

    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public Edificio findById(long edificioId) {
        Optional<Edificio> fromDB = this.edificioRepository.findById(edificioId);
        if (fromDB.isPresent()) {
            System.out.println(fromDB);
            return fromDB.get();
        } else throw new NotFoundException(edificioId);
    }

    public void saveNewEdificio(Edificio newEdificio) {
        if (newEdificio.getNome().length() < 3)
            throw new ValidationException("nome troppo corto, inserire un nome valido");

        Optional<Edificio> fromQuery = this.edificioRepository.findByIndirizzo(newEdificio.getIndirizzo());
        if (fromQuery.isPresent())
            throw new ValidationException("L' indirizzo" + newEdificio.getIndirizzo() + " è già nel DB");

        this.edificioRepository.save(newEdificio);
        log.info("L'elemento " + newEdificio.getNome() + " in " + newEdificio.getIndirizzo() + " è stato salvato correttamente");
    }

    public List<Edificio> findAll() {
        List<Edificio> listaFromDB = this.edificioRepository.findAll();
        listaFromDB.forEach(System.out::println);
        return listaFromDB;
    }

    public void findByIdAndDelete(long edificioId) {
        Edificio fromDB = this.findById(edificioId);
        this.edificioRepository.delete(fromDB);
        log.info("L'elemento con ID: " + edificioId + " è stato eliminato correttamente");
    }

    public void findByIdAndUpdate(long edificioId, String nome) {
        Edificio fromDB = this.findById(edificioId);
        fromDB.setNome(nome);

        this.edificioRepository.save(fromDB);
        log.info("L'elemento con ID: " + fromDB.getId() + " è stato modificato correttamente");
    }
}
