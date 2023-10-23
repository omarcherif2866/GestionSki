package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Cours;
import com.example.gestionski_omarcherif.entities.Moniteur;
import com.example.gestionski_omarcherif.repositories.MoniteurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class IMoniteurServiceImp implements IMoniteurService{
    private final MoniteurRepository moniteurRepository;
    @Lazy
    private final ICoursService iCoursService;

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long coursId) {
        Cours cours = iCoursService.getCours(coursId);
        Set<Cours> setCours = new HashSet<>();
        setCours.add(cours);
        moniteur.setCours(setCours);

        return moniteurRepository.save(moniteur);
    }
}
