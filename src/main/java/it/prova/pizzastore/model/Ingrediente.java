package it.prova.pizzastore.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "prezzo")
    private Double prezzo;
    @Column(name = "codice")
    private String codice;
    @ManyToMany

    @JoinTable(name = "pizza_ingrediente", joinColumns = @JoinColumn(name = "ingrediente_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "ID"))
    private Set<Pizza> pizze = new HashSet<>(0);


}
