package it.prova.pizzastore.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "via")
    private String via;
    @Column(name = "citta")
    private String citta;
    @Column(name = "numero_civico")
    private String numeroCivico;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "attivo")
    private Boolean attivo;
    @OneToMany( mappedBy = "cliente")
    Set<Ordine>  ordine = new HashSet<>(0);

}
