package it.prova.pizzastore.repository.ingrediente;

import it.prova.pizzastore.model.Ingrediente;

import java.util.List;

public interface CustomIngredienteRepository {

	public List<Ingrediente> findByExample(Ingrediente example);

}
