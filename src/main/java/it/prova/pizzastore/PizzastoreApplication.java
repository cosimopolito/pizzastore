package it.prova.pizzastore;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.StatoUtente;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.RuoloService;
import it.prova.pizzastore.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PizzastoreApplication implements CommandLineRunner {

	@Autowired
	private RuoloService ruoloServiceInstance;
	@Autowired
	private UtenteService utenteServiceInstance;


	public static void main(String[] args) {
		SpringApplication.run(PizzastoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Administrator", "ROLE_ADMIN"));
		}

		if (utenteServiceInstance.findByUsernameAndPassword("admin", "admin") == null) {
			Utente admin = new Utente("admin", "admin", "Mario", "Rossi", new Date());
			admin.setStato(StatoUtente.ATTIVO);
			admin.getRuoli().add(ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN"));
			utenteServiceInstance.inserisciNuovo(admin);
//			utenteServiceInstance.aggiungiRuolo(admin,
//					ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN"));
		}

		if (utenteServiceInstance.findByUsernameAndPassword("user", "user") == null) {
			Utente admin = new Utente("user", "user", "Antonio", "Verdi", new Date());
			admin.setStato(StatoUtente.ATTIVO);
			admin.getRuoli().add(ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER"));
			utenteServiceInstance.inserisciNuovo(admin);
//			utenteServiceInstance.aggiungiRuolo(admin,
//					ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER"));
		}

	}
}
