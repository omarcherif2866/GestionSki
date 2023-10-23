package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Skieur;
import com.example.gestionski_omarcherif.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISkieurService {

    public Skieur addSkieur(Skieur skieur);
    public void deleteSkieur(Long skieurId);
    public Skieur updateSkieur (Skieur skieur);
    public Skieur getSkieur (Long skieurId);
    public Set<Skieur> getAllSkieurs();

    public Skieur SkieurPist(Long skieurId, Long pisteId);

    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);

    public List<Skieur> retrieveSkiersByAge(LocalDate dateNaissance1,LocalDate dateNaissance2);

    List<Skieur>GetSkieurJPQL();

    public void SkieurPiste();

    Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse);
}
