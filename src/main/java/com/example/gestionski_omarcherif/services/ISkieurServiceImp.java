package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.*;
import com.example.gestionski_omarcherif.repositories.CoursRepository;
import com.example.gestionski_omarcherif.repositories.InscriptionRepository;
import com.example.gestionski_omarcherif.repositories.PisteRepository;
import com.example.gestionski_omarcherif.repositories.SkieurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.theme.CookieThemeResolver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Primary // par defaut yekhdem b hedhy
@RequiredArgsConstructor
@Service
public class ISkieurServiceImp implements ISkieurService{
    @Autowired //injection dependance
    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;
    private final InscriptionRepository inscriptionRepository;

    private final PisteRepository pisteRepository;

    private final ISkieurService skieurService;
    private final IPisteService iPisteService;

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public void deleteSkieur(Long skieurId) {
    skieurRepository.deleteById(skieurId);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
            }

    @Override
    public Skieur getSkieur(Long skieurId) {
    return skieurRepository.findById(skieurId).orElse(null);
    }

    @Override
    public Set<Skieur> getAllSkieurs() {
        return (Set<Skieur>) skieurRepository.findAll();
    }

    @Override
    public Skieur SkieurPist(Long skieurId, Long pisteId) {
        Piste piste= pisteRepository.findById(pisteId).orElse(null);
        Skieur skieur = skieurRepository.findById(skieurId).orElse(null);
        Set<Skieur> skieurSet= piste.getSkieurs();
        skieurSet.add(skieur);
        piste.setSkieurs(skieurSet);
        piste.getSkieurs().add(skieur);
        pisteRepository.save(piste);
        return skieur;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {

   //     List<Skieur> skieurList = (List<Skieur>) this.skieurRepository.findAll();
    //    List<Skieur> skieurListIni = new ArrayList<>();
      //  skieurList.forEach(skieur -> {
        //    if(skieur.getAbn().getTypeAbon().equals(typeAbonnement)){
          //      skieurListIni.add(skieur);
    //        }
      //  });
      //  return skieurListIni;
        return this.skieurRepository.findByAbn_TypeAbon(typeAbonnement);
    }

    @Override
    public List<Skieur> retrieveSkiersByAge(LocalDate dateNaissance1,LocalDate dateNaissance2) {
            return this.skieurRepository.findByDateNaissanceIsBetween(dateNaissance1,dateNaissance2);

    }

    @Override
    public List<Skieur> GetSkieurJPQL() {
        return skieurRepository.findBySkieurJPQL();
    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void SkieurPiste() {

        skieurRepository.findAll().forEach(skieur ->
                log.info("Skieur " + skieur.getNomS() + " has " + pisteRepository.countBySkieursId(skieur.getId()))
                );

    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {

       Cours cours = coursRepository.findById(numCourse).orElse(null);


       skieurRepository.save(skieur);


       Inscription inscription = skieur.getInsc().stream().findFirst().get();
       inscription.setSkieur(skieur);
       inscription.setCours(cours);
       inscriptionRepository.save(inscription);
        return skieur;
    }

}



