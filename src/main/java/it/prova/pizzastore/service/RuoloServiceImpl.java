package it.prova.pizzastore.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.repository.ruolo.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RuoloServiceImpl implements RuoloService {

	@Autowired
	private RuoloRepository ruoloRepository;

	@Transactional(readOnly = true)
	public List<Ruolo> listAll() {
		return (List<Ruolo>) ruoloRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Ruolo caricaSingoloElemento(Long id) {
		return ruoloRepository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Ruolo ruoloInstance) {
		ruoloRepository.save(ruoloInstance);
	}

	@Transactional
	public void inserisciNuovo(Ruolo ruoloInstance) {
		ruoloRepository.save(ruoloInstance);
	}

	@Transactional
	public void rimuovi(Ruolo ruoloInstance) {
		ruoloRepository.delete(ruoloInstance);
	}

	@Transactional(readOnly = true)
	public Ruolo cercaPerDescrizioneECodice(String descrizione, String codice) {
		return ruoloRepository.findByDescrizioneAndCodice(descrizione, codice);
	}

	@Transactional(readOnly = true)
	public Set<Ruolo> findByArrayIdParam(String[] ids) {
		Set<Ruolo> ruoli = new HashSet<>();
		if (ids != null && ids.length > 0) {
			for (String ruoloItem : ids) {
				ruoli.add(ruoloRepository.findById(Long.parseLong(ruoloItem)).get());
			}
		}
		return ruoli;
	}

}
