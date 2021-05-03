package it.prova.pizzastore.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "codice")
	private String codice;
	@Column(name = "prezzo_base")
	private Integer prezzoBase;
	@Column(name = "attivo")
	private Integer attivo;
	@ManyToMany
	@JoinTable(name = "pizza_ingrediente", joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id", referencedColumnName = "ID"))
	private Set<Ingrediente> ingredienti = new HashSet<>(0);

	@ManyToMany(mappedBy = "pizze")
	private Set<Ordine> ordini = new HashSet<>(0);



	


	

}
