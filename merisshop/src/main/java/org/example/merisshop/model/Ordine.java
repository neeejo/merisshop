package org.example.merisshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ordine")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "ordini-prodotti",
            joinColumns = @JoinColumn(name = "ID Ordine", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ID Prodotto", referencedColumnName = "id"))
    private List<Prodotto> prodotti;

    @Column
    private Long quantita;

    @Column
    private double totale;

}
