package org.example.merisshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "anagrafica")
public class Anagrafica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long anagraficaID;

    @OneToOne
    @JoinColumn(name = "user" , referencedColumnName = "userID")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User user;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private String indirizzo;
}
