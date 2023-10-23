package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Skieur;
import com.example.gestionski_omarcherif.entities.TypeAbonnement;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class IskieurServiceImp2 implements ISkieurService{
    @Override
    public Skieur addSkieur(Skieur skieur) {
        return null;
    }

    @Override
    public void deleteSkieur(Long skieurId) {

    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return null;
    }

    @Override
    public Skieur getSkieur(Long skieurId) {
return null ;
    }

    @Override
    public Set<Skieur> getAllSkieurs() {
        return null;
    }

    @Override
    public Skieur SkieurPist(Long skieurId, Long pisteId) {
        return null;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return null;
    }

    @Override
    public List<Skieur> retrieveSkiersByAge(LocalDate dateNaissance1, LocalDate dateNaissance2) {
        return null;
    }

    @Override
    public List<Skieur> GetSkieurJPQL() {
        return null;
    }

    @Override
    public void SkieurPiste() {

    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        return null;
    }

}
