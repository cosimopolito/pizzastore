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


    public Cliente(String nome, String cognome, String via, String citta, String numeroCivico, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.via = via;
        this.citta = citta;
        this.numeroCivico = numeroCivico;
        this.telefono = telefono;
    }

    public Cliente(Long id, String nome, String cognome, String via, String citta, String numeroCivico, String telefono) {
        this.id=id;
        this.nome=nome;
        this.cognome=cognome;
        this.via=via;
        this.citta=citta;
        this.numeroCivico=numeroCivico;
        this.telefono=telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(Boolean attivo) {
        this.attivo = attivo;
    }

    public Set<Ordine> getOrdine() {
        return ordine;
    }

    public void setOrdine(Set<Ordine> ordine) {
        this.ordine = ordine;
    }
}
