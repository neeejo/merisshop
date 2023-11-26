package org.example.merisshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prodotto")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long prodottoID;

    @ManyToOne
    @JoinColumn(name="negozio", referencedColumnName = "negozioID")
    private Negozio negozio;

    @Column
    private String nome;

    @Column
    private String tipologia;

    @Column
    private double prezzo;

    @ManyToMany(mappedBy = "prodotti")
    private List<Ordine> ordine;

}
