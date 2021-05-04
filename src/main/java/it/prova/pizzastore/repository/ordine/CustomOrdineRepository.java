package it.prova.pizzastore.repository.ordine;

import it.prova.pizzastore.model.Ordine;

import java.util.List;

public interface CustomOrdineRepository {

	public List<Ordine> findByExample(Ordine example);

}
