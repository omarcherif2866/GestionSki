package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Moniteur;

public interface IMoniteurService {

    public Moniteur addInstructorAndAssignToCourse (Moniteur moniteur, Long coursId);

}
