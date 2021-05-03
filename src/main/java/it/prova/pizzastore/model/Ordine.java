package it.prova.pizzastore.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ordine")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_ordine")
    private Date dataOrdine;
    @Column(name = "codice")
    private String codice;
    @Column(name = "closed")
    private Boolean closed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToMany
    @JoinTable(name = "ordine_pizza", joinColumns = @JoinColumn(name = "ordine_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "ID"))
    private Set<Pizza> pizze = new HashSet<>(0);
}
