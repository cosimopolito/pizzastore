package it.prova.pizzastore.service;

import it.prova.pizzastore.model.Ingrediente;

import java.util.List;

public interface IngredienteService {
	public List<Ingrediente> listAllElements();

	public Ingrediente caricaSingoloElemento(Long id);

	public void aggiorna(Ingrediente ingredienteInstance);

	public void inserisciNuovo(Ingrediente ingredienteInstance);

	public void rimuovi(Ingrediente ingredienteInstance);

	public List<Ingrediente> findByExample(Ingrediente example);
}
