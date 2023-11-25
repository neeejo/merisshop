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
@Table(name = "ordine")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long ordineID;

    @ManyToMany
    @JoinTable(name = "ordini_prodotti",
            joinColumns = @JoinColumn(name = "ordini", referencedColumnName = "ordineID"),
            inverseJoinColumns = @JoinColumn(name = "prodotti", referencedColumnName = "prodottoID"))
    private List<Prodotto> prodotti;

    @Column
    private Long quantita;

    @Column
    private double totale;
}
