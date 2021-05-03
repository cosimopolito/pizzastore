package it.prova.pizzastore.model;


import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ordine")
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
    @Column(name = "numeroCivico")
    private String numero_civico;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "attivo")
    private Boolean attivo;
    @OneToMany( mappedBy = "cliente")
    Set<Ordine>  ordine = new HashSet<>(0);

}
