package com.example.gestionski_omarcherif.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerer par la base
    @Setter(AccessLevel.NONE)
    long id;

    String nomPiste;
    int longeur;
    int pente;
    @Enumerated(EnumType.STRING)
    Couleur couleur ;

    @ManyToMany (mappedBy = "pistes")
    Set<Skieur> skieurs;
}
