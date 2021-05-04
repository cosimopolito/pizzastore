package it.prova.pizzastore.repository.ordine;

import it.prova.pizzastore.model.Ordine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrdineRepository extends CrudRepository<Ordine, Long>, CustomOrdineRepository {
	@Query("Select o from Ordine o left join fetch o.pizze left join fetch o.cliente left join fetch o.utente where o.id = ?1")
	Optional<Ordine> findOneEager(Long id);

	public List<Ordine> findByExample(Ordine example);
}
