package it.prova.pizzastore.service;

import java.util.List;
import java.util.Set;

import it.prova.pizzastore.model.Ruolo;

public interface RuoloService {
	public List<Ruolo> listAll() ;

	public Ruolo caricaSingoloElemento(Long id) ;

	public void aggiorna(Ruolo ruoloInstance) ;

	public void inserisciNuovo(Ruolo ruoloInstance) ;

	public void rimuovi(Ruolo ruoloInstance) ;

	public Ruolo cercaPerDescrizioneECodice(String descrizione, String codice) ;
	
	public Set<Ruolo> findByArrayIdParam(String[] ids);

}
