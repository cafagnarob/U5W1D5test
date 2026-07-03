package roberto.cafagna.U5W1D5test.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import roberto.cafagna.U5W1D5test.Enum.TipoPostazione;
import roberto.cafagna.U5W1D5test.entities.Postazione;
import roberto.cafagna.U5W1D5test.entities.Prenotazione;
import roberto.cafagna.U5W1D5test.entities.Utente;
import roberto.cafagna.U5W1D5test.service.EdificioService;
import roberto.cafagna.U5W1D5test.service.PostazioneService;
import roberto.cafagna.U5W1D5test.service.PrenotazioniService;
import roberto.cafagna.U5W1D5test.service.UtenteService;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private final PrenotazioniService prenotazioniService;
    private final PostazioneService postazioneService;
    private final EdificioService edificioService;
    private final UtenteService utenteService;

    public Runner(PrenotazioniService prenotazioniService, PostazioneService postazioneService, EdificioService edificioService, UtenteService utenteService) {
        this.prenotazioniService = prenotazioniService;
        this.postazioneService = postazioneService;
        this.edificioService = edificioService;
        this.utenteService = utenteService;
    }

    @Override
    public void run(String... args) throws Exception {



        /*Utente u1 = new Utente("Mario_1971", "Mario", "mario1971@mail.com");
        Utente u2 = new Utente("Luca_1985", "Luca", "luca1985@mail.com");
        Utente u3 = new Utente("Giulia_1990", "Giulia", "giulia1990@mail.com");
        Utente u4 = new Utente("Anna_1988", "Anna", "anna1988@mail.com");
        Utente u5 = new Utente("Marco_1979", "Marco", "marco1979@mail.com");
        Utente u6 = new Utente("Sara_1995", "Sara", "sara1995@mail.com");
        Utente u7 = new Utente("Paolo_1982", "Paolo", "paolo1982@mail.com");
        Utente u8 = new Utente("Chiara_1993", "Chiara", "chiara1993@mail.com");
        Utente u9 = new Utente("Davide_1975", "Davide", "davide1975@mail.com");
        Utente u10 = new Utente("Elena_1998", "Elena", "elena1998@mail.com");

        this.utenteService.saveNewUtente(u1);
        this.utenteService.saveNewUtente(u2);
        this.utenteService.saveNewUtente(u3);
        this.utenteService.saveNewUtente(u4);
        this.utenteService.saveNewUtente(u5);
        this.utenteService.saveNewUtente(u6);
        this.utenteService.saveNewUtente(u7);
        this.utenteService.saveNewUtente(u8);
        this.utenteService.saveNewUtente(u9);
        this.utenteService.saveNewUtente(u10);*/


       /* Edificio e1 = new Edificio("Politecnico", "Via Dante Alighieri, 32", "Milano");
        Edificio e2 = new Edificio("Sede Centrale", "Via Roma, 15", "Milano");
        Edificio e3 = new Edificio("Torre Aziendale", "Corso Vittorio Emanuele, 88", "Torino");
        Edificio e4 = new Edificio("Business Park", "Via Garibaldi, 44", "Torino");
        Edificio e5 = new Edificio("Palazzo Uffici", "Via Manzoni, 21", "Bologna");
        Edificio e6 = new Edificio("Hub Innovazione", "Via Indipendenza, 60", "Bologna");
        Edificio e7 = new Edificio("Sede Sud", "Via Toledo, 5", "Napoli");
        Edificio e8 = new Edificio("Centro Direzionale", "Via Nazionale, 120", "Napoli");
        Edificio e9 = new Edificio("Sede Nord", "Corso Buenos Aires, 33", "Milano");
        Edificio e10 = new Edificio("Campus Est", "Via Marconi, 77", "Bologna");


        this.edificioService.saveNewEdificio(e1);
        this.edificioService.saveNewEdificio(e2);
        this.edificioService.saveNewEdificio(e3);
        this.edificioService.saveNewEdificio(e4);
        this.edificioService.saveNewEdificio(e5);
        this.edificioService.saveNewEdificio(e6);
        this.edificioService.saveNewEdificio(e7);
        this.edificioService.saveNewEdificio(e8);
        this.edificioService.saveNewEdificio(e9);
        this.edificioService.saveNewEdificio(e10);
*/

       /* Edificio e3 = this.edificioService.findById(3);
        Postazione p1 = new Postazione("fantastico openSpace con servizio bar aperto fino alle 22.00", TipoPostazione.OPENSPACE, StatoPostazione.LIBERO, 60, e3);
        Postazione p7 = new Postazione("openSpace open-plan con postazioni ergonomiche", TipoPostazione.OPENSPACE, StatoPostazione.LIBERO, 80, e3);
        Postazione p8 = new Postazione("ufficio privato con doppio monitor", TipoPostazione.PRIVATO, StatoPostazione.LIBERO, 1, e3);
        Postazione p9 = new Postazione("sala riunioni executive", TipoPostazione.SALA_RIUNIONE, StatoPostazione.LIBERO, 12, e3);

        Edificio e1 = this.edificioService.findById(1);
        Postazione p2 = new Postazione("ufficio privato con vista panoramica", TipoPostazione.PRIVATO, StatoPostazione.LIBERO, 1, e1);
        Postazione p3 = new Postazione("sala riunioni con proiettore e lavagna", TipoPostazione.SALA_RIUNIONE, StatoPostazione.LIBERO, 8, e1);

        Edificio e2 = this.edificioService.findById(2);
        Postazione p4 = new Postazione("openSpace luminoso vicino alla reception", TipoPostazione.OPENSPACE, StatoPostazione.LIBERO, 40, e2);
        Postazione p5 = new Postazione("ufficio privato silenzioso", TipoPostazione.PRIVATO, StatoPostazione.LIBERO, 1, e2);
        Postazione p6 = new Postazione("sala riunioni piccola per call video", TipoPostazione.SALA_RIUNIONE, StatoPostazione.LIBERO, 4, e2);

        Edificio e4 = this.edificioService.findById(4);
        Postazione p10 = new Postazione("openSpace vicino alla terrazza", TipoPostazione.OPENSPACE, StatoPostazione.LIBERO, 50, e4);
        Postazione p11 = new Postazione("ufficio privato con aria condizionata", TipoPostazione.PRIVATO, StatoPostazione.LIBERO, 1, e4);

        Edificio e5 = this.edificioService.findById(5);
        Postazione p12 = new Postazione("sala riunioni con schermo touch", TipoPostazione.SALA_RIUNIONE, StatoPostazione.LIBERO, 6, e5);
        Postazione p13 = new Postazione("openSpace collaborativo open-desk", TipoPostazione.OPENSPACE, StatoPostazione.LIBERO, 35, e5);

        Edificio e6 = this.edificioService.findById(6);
        Postazione p14 = new Postazione("ufficio privato con parete insonorizzata", TipoPostazione.PRIVATO, StatoPostazione.LIBERO, 1, e6);
        Postazione p15 = new Postazione("sala riunioni per board meeting", TipoPostazione.SALA_RIUNIONE, StatoPostazione.LIBERO, 15, e6);

        Edificio e7 = this.edificioService.findById(7);
        Postazione p16 = new Postazione("openSpace con angolo relax e caffetteria", TipoPostazione.OPENSPACE, StatoPostazione.LIBERO, 90, e7);

        Edificio e8 = this.edificioService.findById(8);
        Postazione p17 = new Postazione("ufficio privato piano alto", TipoPostazione.PRIVATO, StatoPostazione.LIBERO, 1, e8);
        Postazione p18 = new Postazione("sala riunioni con impianto audio professionale", TipoPostazione.SALA_RIUNIONE, StatoPostazione.LIBERO, 10, e8);

        Edificio e9 = this.edificioService.findById(9);
        Postazione p19 = new Postazione("openSpace moderno con postazioni standing desk", TipoPostazione.OPENSPACE, StatoPostazione.LIBERO, 45, e9);

        Edificio e10 = this.edificioService.findById(10);
        Postazione p20 = new Postazione("sala riunioni raccolta per brainstorming", TipoPostazione.SALA_RIUNIONE, StatoPostazione.LIBERO, 5, e10);

        this.postazioneService.saveNewPostazione(p1);
        this.postazioneService.saveNewPostazione(p2);
        this.postazioneService.saveNewPostazione(p3);
        this.postazioneService.saveNewPostazione(p4);
        this.postazioneService.saveNewPostazione(p5);
        this.postazioneService.saveNewPostazione(p6);
        this.postazioneService.saveNewPostazione(p7);
        this.postazioneService.saveNewPostazione(p8);
        this.postazioneService.saveNewPostazione(p9);
        this.postazioneService.saveNewPostazione(p10);
        this.postazioneService.saveNewPostazione(p11);
        this.postazioneService.saveNewPostazione(p12);
        this.postazioneService.saveNewPostazione(p13);
        this.postazioneService.saveNewPostazione(p14);
        this.postazioneService.saveNewPostazione(p15);
        this.postazioneService.saveNewPostazione(p16);
        this.postazioneService.saveNewPostazione(p17);
        this.postazioneService.saveNewPostazione(p18);
        this.postazioneService.saveNewPostazione(p19);
        this.postazioneService.saveNewPostazione(p20);*/


       /* Postazione p1 = this.postazioneService.findById(1);
        Postazione p2 = this.postazioneService.findById(2);
        Postazione p3 = this.postazioneService.findById(3);
        Postazione p4 = this.postazioneService.findById(4);
        Postazione p5 = this.postazioneService.findById(5);
        Postazione p6 = this.postazioneService.findById(6);
        Postazione p7 = this.postazioneService.findById(7);
        Postazione p8 = this.postazioneService.findById(8);
        Postazione p9 = this.postazioneService.findById(9);
        Postazione p10 = this.postazioneService.findById(10);
        Postazione p11 = this.postazioneService.findById(11);
        Postazione p12 = this.postazioneService.findById(12);
        Postazione p13 = this.postazioneService.findById(13);
        Postazione p14 = this.postazioneService.findById(14);
        Postazione p15 = this.postazioneService.findById(15);
        Postazione p16 = this.postazioneService.findById(16);
        Postazione p17 = this.postazioneService.findById(17);
        Postazione p18 = this.postazioneService.findById(18);
        Postazione p19 = this.postazioneService.findById(19);
        Postazione p20 = this.postazioneService.findById(20);

        Utente u1 = this.utenteService.findById(1);
        Utente u2 = this.utenteService.findById(2);
        Utente u3 = this.utenteService.findById(3);
        Utente u4 = this.utenteService.findById(4);
        Utente u5 = this.utenteService.findById(5);
        Utente u6 = this.utenteService.findById(6);
        Utente u7 = this.utenteService.findById(7);
        Utente u8 = this.utenteService.findById(8);
        Utente u9 = this.utenteService.findById(9);
        Utente u10 = this.utenteService.findById(10);

        Prenotazione pre1 = new Prenotazione(LocalDate.now(), p1, u1, 20);
        Prenotazione pre2 = new Prenotazione(LocalDate.now().plusDays(1), p6, u3, 3);
        Prenotazione pre3 = new Prenotazione(LocalDate.now().plusDays(2), p11, u5, 1);
        Prenotazione pre4 = new Prenotazione(LocalDate.now().minusDays(1), p2, u7, 1);
        Prenotazione pre5 = new Prenotazione(LocalDate.now().plusDays(3), p9, u2, 6);
        Prenotazione pre6 = new Prenotazione(LocalDate.now().minusDays(2), p14, u9, 1);
        Prenotazione pre7 = new Prenotazione(LocalDate.now().plusDays(4), p4, u4, 25);
        Prenotazione pre8 = new Prenotazione(LocalDate.now().plusDays(5), p17, u6, 1);
        Prenotazione pre9 = new Prenotazione(LocalDate.now().minusDays(3), p12, u10, 4);
        Prenotazione pre10 = new Prenotazione(LocalDate.now().plusDays(6), p7, u8, 30);
        Prenotazione pre11 = new Prenotazione(LocalDate.now().plusDays(7), p3, u1, 5);
        Prenotazione pre12 = new Prenotazione(LocalDate.now().minusDays(4), p18, u3, 8);
        Prenotazione pre13 = new Prenotazione(LocalDate.now().plusDays(8), p5, u5, 1);
        Prenotazione pre14 = new Prenotazione(LocalDate.now().plusDays(9), p20, u7, 4);
        Prenotazione pre15 = new Prenotazione(LocalDate.now().minusDays(5), p10, u2, 20);
        Prenotazione pre16 = new Prenotazione(LocalDate.now().plusDays(10), p8, u9, 1);
        Prenotazione pre17 = new Prenotazione(LocalDate.now().plusDays(11), p15, u4, 10);
        Prenotazione pre18 = new Prenotazione(LocalDate.now().plusDays(12), p19, u6, 15);
        Prenotazione pre19 = new Prenotazione(LocalDate.now().minusDays(6), p13, u10, 12);
        Prenotazione pre20 = new Prenotazione(LocalDate.now().plusDays(13), p16, u8, 40);
        Prenotazione pre21 = new Prenotazione(LocalDate.now().plusDays(14), p1, u3, 30);
        Prenotazione pre22 = new Prenotazione(LocalDate.now().minusDays(7), p6, u1, 2);
        Prenotazione pre23 = new Prenotazione(LocalDate.now().plusDays(15), p11, u9, 1);
        Prenotazione pre24 = new Prenotazione(LocalDate.now().plusDays(16), p2, u5, 1);
        Prenotazione pre25 = new Prenotazione(LocalDate.now().minusDays(8), p9, u7, 9);
        Prenotazione pre26 = new Prenotazione(LocalDate.now().plusDays(17), p14, u2, 1);
        Prenotazione pre27 = new Prenotazione(LocalDate.now().plusDays(18), p4, u10, 15);
        Prenotazione pre28 = new Prenotazione(LocalDate.now().minusDays(9), p17, u4, 1);
        Prenotazione pre29 = new Prenotazione(LocalDate.now().plusDays(19), p12, u6, 5);
        Prenotazione pre30 = new Prenotazione(LocalDate.now().plusDays(20), p7, u8, 55);


        this.prenotazioniService.saveNewPrenotazione(pre1);
        this.prenotazioniService.saveNewPrenotazione(pre2);
        this.prenotazioniService.saveNewPrenotazione(pre3);
        this.prenotazioniService.saveNewPrenotazione(pre4);
        this.prenotazioniService.saveNewPrenotazione(pre5);
        this.prenotazioniService.saveNewPrenotazione(pre6);
        this.prenotazioniService.saveNewPrenotazione(pre7);
        this.prenotazioniService.saveNewPrenotazione(pre8);
        this.prenotazioniService.saveNewPrenotazione(pre9);
        this.prenotazioniService.saveNewPrenotazione(pre10);
        this.prenotazioniService.saveNewPrenotazione(pre11);
        this.prenotazioniService.saveNewPrenotazione(pre12);
        this.prenotazioniService.saveNewPrenotazione(pre13);
        this.prenotazioniService.saveNewPrenotazione(pre14);
        this.prenotazioniService.saveNewPrenotazione(pre15);
        this.prenotazioniService.saveNewPrenotazione(pre16);
        this.prenotazioniService.saveNewPrenotazione(pre17);
        this.prenotazioniService.saveNewPrenotazione(pre18);
        this.prenotazioniService.saveNewPrenotazione(pre19);
        this.prenotazioniService.saveNewPrenotazione(pre20);
        this.prenotazioniService.saveNewPrenotazione(pre21);
        this.prenotazioniService.saveNewPrenotazione(pre22);
        this.prenotazioniService.saveNewPrenotazione(pre23);
        this.prenotazioniService.saveNewPrenotazione(pre24);
        this.prenotazioniService.saveNewPrenotazione(pre25);
        this.prenotazioniService.saveNewPrenotazione(pre26);
        this.prenotazioniService.saveNewPrenotazione(pre27);
        this.prenotazioniService.saveNewPrenotazione(pre28);
        this.prenotazioniService.saveNewPrenotazione(pre29);
        this.prenotazioniService.saveNewPrenotazione(pre30);
*/


        System.out.println("\n===== TEST METODI SERVICE =====\n");

        // 1. Test ricerca per tipo e città
        System.out.println("--- Postazioni OPENSPACE a Milano ---");
        List<Postazione> risultatoRicerca = this.postazioneService.cercaPerTipoECitta(TipoPostazione.OPENSPACE, "Milano");
        risultatoRicerca.forEach(System.out::println);

        // 2. Test prenotazioni per utente
        System.out.println("\n--- Prenotazioni dell'utente u1 ---");
        List<Prenotazione> prenotazioniUtente = this.prenotazioniService.findByUtenteId(1);
        prenotazioniUtente.forEach(System.out::println);

        // 3. Test findAll generali
        System.out.println("\n--- Tutte le postazioni ---");
        this.postazioneService.findAll();

        System.out.println("\n--- Tutti gli edifici ---");
        this.edificioService.findAll();

        // 4. Test findById singolo
        System.out.println("\n--- Postazione con id 1 ---");
        Postazione p = this.postazioneService.findById(1);
        System.out.println(p);

        // 5. Test findById su id inesistente -> deve lanciare NotFoundException
        try {
            this.postazioneService.findById(9999);
        } catch (Exception e) {
            System.out.println("\nOK: NotFoundException catturata correttamente -> " + e.getMessage());
        }


        // 6. Test validazione: prenotazione con stesso utente/data già esistente -> deve fallire
        try {
            Utente utenteFromDB = this.utenteService.findById(1);
            Postazione postazioneFromDB = this.postazioneService.findById(5);
            Prenotazione doppia = new Prenotazione(LocalDate.now(), postazioneFromDB, utenteFromDB, 1);
            this.prenotazioniService.saveNewPrenotazione(doppia);
        } catch (Exception e) {
            System.out.println("OK: ValidationException catturata correttamente -> " + e.getMessage());
        }


        // 7. Test update prenotazione
        System.out.println("\n--- Update prenotazione id 2 ---");
        this.prenotazioniService.findByIdAndUpdateNOccupantiAndData(2, 2, LocalDate.now().plusDays(30));
        System.out.println(this.prenotazioniService.findById(2));

        System.out.println("\n===== FINE TEST =====\n");

    }
}
