package it.prova.pizzastore.repository.ingrediente;

import it.prova.pizzastore.model.Ingrediente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long>, CustomIngredienteRepository {

	public List<Ingrediente> findByExample(Ingrediente example);

}
