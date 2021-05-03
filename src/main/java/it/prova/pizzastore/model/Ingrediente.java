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
    private Integer prezzo;
    @Column(name = "codice")
    private String codice;
    @ManyToMany(mappedBy = "ingredienti")
    private Set<Pizza> pizze = new HashSet<>(0);


}
