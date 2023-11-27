package org.example.merisshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Long id;

    @ManyToOne
    @JoinColumn(name="negozio", referencedColumnName = "id")
    private Negozio negozio;

    @Column
    private String nome;

    @Column
    private String tipologia;

    @Column
    private double prezzo;

    @JsonBackReference
    @ManyToMany(mappedBy = "prodotti")
    private List<Ordine> ordini;

}
