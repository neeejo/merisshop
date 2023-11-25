package org.example.merisshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "negozio")
public class Negozio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long negozioID;

    @OneToOne
    @JoinColumn(name = "proprietario",referencedColumnName = "anagraficaID")
    private Anagrafica proprietario;

    @Column
    private String nome;

    @Column
    private String descrizione;


}
