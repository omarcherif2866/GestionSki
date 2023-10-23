package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Cours;
import com.example.gestionski_omarcherif.entities.Inscription;

import java.util.List;
import java.util.Set;

public interface IInscriptionService {

    public Inscription addIns(Inscription inscription);

    public void deleteIns(Long inscriptionId);

    public Inscription updateIns (Inscription inscription);

    public Inscription getIns (Long inscriptionId);

    public List<Inscription> getAllIns ();

    public Inscription addRegistrationAndAssignToSkier (Inscription registration, Long skieurId);

    public Inscription assignRegistrationToCours(Long numInscription, Long numCours);

    public void testSchu();

   // public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);

}
