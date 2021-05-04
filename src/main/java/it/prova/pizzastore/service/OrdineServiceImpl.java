package it.prova.pizzastore.service;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.repository.ordine.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineRepository repository;

	@Transactional(readOnly = true)
	public List<Ordine> listAllElements() {
		return (List<Ordine>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Ordine caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Ordine caricaSingoloElementoEager(Long id) {
		return repository.findOneEager(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Ordine ordineInstance) {
		repository.save(ordineInstance);
	}

	@Transactional
	public void inserisciNuovo(Ordine ordineInstance) {
		repository.save(ordineInstance);
	}

	@Transactional
	public void rimuovi(Ordine ordineInstance) {
		repository.delete(ordineInstance);

	}

	@Transactional(readOnly = true)
	public List<Ordine> findByExample(Ordine example) {
		return repository.findByExample(example);
	}

}
