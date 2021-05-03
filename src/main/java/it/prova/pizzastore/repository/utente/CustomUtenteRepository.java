package it.prova.pizzastore.repository.utente;

import java.util.List;
import java.util.Optional;

import it.prova.pizzastore.model.Utente;

public interface CustomUtenteRepository {
	List<Utente> findByExample(Utente example);
	public Long countByAdmin();
	public Optional<Utente> findOneEager(Long id);
}
