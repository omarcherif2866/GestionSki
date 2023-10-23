package com.example.gestionski_omarcherif.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerer par la base
    @Setter(AccessLevel.NONE)
    long id;

    String nomS ;
    String prenomS ;
    LocalDate dateNaissance ;
    String ville ;


    @JsonIgnore
    @ManyToMany //(fetch = FetchType.EAGER)
    Set<Piste> pistes;

    @JsonBackReference
    @OneToMany (mappedBy = "skieur")
    Set<Inscription> insc ;

    @OneToOne (cascade = CascadeType.ALL)
    Abonnement abn;

}

