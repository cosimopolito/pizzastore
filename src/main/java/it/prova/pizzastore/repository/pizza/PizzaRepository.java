package it.prova.pizzastore.repository.pizza;

import it.prova.pizzastore.model.Pizza;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends CrudRepository<Pizza, Long>, CustomPizzaRepository {

	@Query("Select p from Pizza p left join fetch p.ingredienti where p.id = ?1")
	Optional<Pizza> findOneEager(Long id);

	public List<Pizza> findByExample(Pizza example);
}
