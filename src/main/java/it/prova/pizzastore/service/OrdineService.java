package it.prova.pizzastore.service;

import it.prova.pizzastore.model.Ordine;

import java.util.List;

public interface OrdineService {
	public List<Ordine> listAllElements();

	public Ordine caricaSingoloElemento(Long id);

	public Ordine caricaSingoloElementoEager(Long id);

	public void aggiorna(Ordine ordineInstance);

	public void inserisciNuovo(Ordine ordineInstance);

	public void rimuovi(Ordine ordineInstance);

	public List<Ordine> findByExample(Ordine example);
}
