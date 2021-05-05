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


    public Ingrediente() {
    }

    public Ingrediente(Long id, String descrizione, Double prezzo, String codice) {
        this.id=id;
        this.descrizione=descrizione;
        this.prezzo=prezzo;
        this.codice=codice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Set<Pizza> getPizze() {
        return pizze;
    }

    public void setPizze(Set<Pizza> pizze) {
        this.pizze = pizze;
    }
}
