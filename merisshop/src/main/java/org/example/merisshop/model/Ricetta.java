package org.example.merisshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ricetta")
public class Ricetta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nome;

    @ManyToMany
    @JoinTable(name = "ricette-ingredienti",
    joinColumns = @JoinColumn(name = "idricetta", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="ingrediente", referencedColumnName = "nome"))
    private List<Ingrediente> ingredienti;

}
