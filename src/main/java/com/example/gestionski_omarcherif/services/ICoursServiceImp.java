package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Cours;
import com.example.gestionski_omarcherif.entities.Skieur;
import com.example.gestionski_omarcherif.repositories.CoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ICoursServiceImp implements ICoursService{

    //@Autowired
    private final CoursRepository coursRepository;
    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public void deleteCours(Long coursId) {
        coursRepository.deleteById(coursId);

    }

    @Override
    public Cours updateCours(Cours cours) {
        Assert.notNull(cours.getId(),"id not found");
            return coursRepository.save(cours);
    }

    @Override
    public Cours getCours(Long coursId) {
       return coursRepository
                .findById(coursId)
                .orElseThrow(() -> new IllegalArgumentException("cours not found"));
    }

    @Override
    public Set<Cours> getAllCours()  {
        return (Set<Cours>) coursRepository.findAll();
    }
}
