package it.prova.pizzastore.service;

import it.prova.pizzastore.model.Cliente;

import java.util.List;

public interface ClienteService {
	public List<Cliente> listAllElements();

	public Cliente caricaSingoloElemento(Long id);

	public void aggiorna(Cliente clienteInstance);

	public void inserisciNuovo(Cliente clienteInstance);

	public void rimuovi(Cliente clienteInstance);

}
