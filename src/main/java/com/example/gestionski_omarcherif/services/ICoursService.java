package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Cours;

import java.util.Set;

public interface ICoursService {

    public Cours addCours(Cours cours);

    public void deleteCours(Long coursId);

    public Cours updateCours (Cours cours);

    public Cours getCours (Long coursId);

    public Set<Cours> getAllCours ();



}
