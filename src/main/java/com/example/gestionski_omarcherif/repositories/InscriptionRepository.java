package com.example.gestionski_omarcherif.repositories;

import com.example.gestionski_omarcherif.entities.Inscription;
import com.example.gestionski_omarcherif.entities.Skieur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InscriptionRepository extends CrudRepository<Inscription, Long> {
//    int countNumSemaineByInscriptionCousSupportAnd();
}
