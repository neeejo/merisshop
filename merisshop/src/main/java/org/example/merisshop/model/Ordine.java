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
    @JoinTable(name = "ordini-prodotti",
            joinColumns = @JoinColumn(name = "ID Ordine", referencedColumnName = "ordineID"),
            inverseJoinColumns = @JoinColumn(name = "ID Prodotto", referencedColumnName = "prodottoID"))
    private List<Prodotto> prodotti;

    @Column
    private Long quantita;

    @Column
    private double totale;

}
