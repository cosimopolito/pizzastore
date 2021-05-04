package it.prova.pizzastore.repository.utente;

import it.prova.pizzastore.model.StatoUtente;
import it.prova.pizzastore.model.Utente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface UtenteRepository extends CrudRepository<Utente, Long>,CustomUtenteRepository {
	
	Utente findByUsernameAndPassword(String username, String password);
	
	//caricamento eager, ovviamente si può fare anche con jpql
	@EntityGraph(attributePaths = { "ruoli" })
	Utente findByUsernameAndPasswordAndStato(String username,String password, StatoUtente stato);

}
