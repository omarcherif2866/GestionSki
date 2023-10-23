package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Cours;
import com.example.gestionski_omarcherif.entities.Inscription;
import com.example.gestionski_omarcherif.entities.Skieur;
import com.example.gestionski_omarcherif.entities.TypeCours;
import com.example.gestionski_omarcherif.repositories.CoursRepository;
import com.example.gestionski_omarcherif.repositories.InscriptionRepository;
import com.example.gestionski_omarcherif.repositories.SkieurRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class IInscriptionSerivceImp implements IInscriptionService{

    private final InscriptionRepository inscriptionRepository;
    private final CoursRepository coursRepository;
    private final  SkieurRepository skieurRepository;
    private final ISkieurService skieurService;


    @Override
    public Inscription addIns(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public void deleteIns(Long inscriptionId) {
    inscriptionRepository.deleteById(inscriptionId);
    }

    @Override
    public Inscription updateIns(Inscription inscription) {
        Assert.notNull(inscription.getId(),"id not found");
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription getIns(Long inscriptionId) {
        return inscriptionRepository
                .findById(inscriptionId)
                .orElseThrow(() -> new IllegalArgumentException("Inscription not found"));
    }

    @Override
    public List<Inscription> getAllIns() {
        return (List<Inscription>) inscriptionRepository.findAll();
    }

        public Inscription addRegistrationAndAssignToSkier(Inscription registration, Long skieurId) {

            //Skieur skieur = skieurRepository.findById(skieurId)
            //       .orElseThrow(() -> new IllegalArgumentException("Le Skieur avec l'ID " + skieurId + " n'a pas été trouvé."));

            Skieur skieur = skieurService.getSkieur(skieurId);
            registration.setSkieur(skieur);

            return inscriptionRepository.save(registration);
        }

    @Override
    public Inscription assignRegistrationToCours(Long idInsc, Long numCours)  {
        Cours cours= coursRepository.findById(numCours).orElse(null);
        Inscription inscription= inscriptionRepository.findById(idInsc).orElse(null);
        Set<Inscription> inscriptionSet=cours.getInsc();
        inscriptionSet.add(inscription);
        return inscriptionRepository.save(inscription);
    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void testSchu() {
        log.info("hello");
    }

   /* @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long idSkieur, Long idCours) {
        Cours cours = coursRepository.findById(idCours).orElse(null);
        Skieur skieur = skieurRepository.findById(idSkieur).orElse(null);
            if (cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT || cours.getTypeCours() == TypeCours.COLLECTIF_ADULTE) {
                if (cours.getInsc().size() < 6) {
                    if (skieurService.retrieveSkiersByAge("2023-12-01","2005-12-01") && cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT) {
                        this.assignRegistrationToCours(idInsc,idCours);
                        inscription.setSkieur(skieur);
                    } else if (skieurService.retrieveSkiersByAge("2023-12-01","1993-12-01") && cours.getTypeCours() == TypeCours.COLLECTIF_ADULTE) {
                        this.assignRegistrationToCours(idInsc,idCours);
                        inscription.setSkieur(skieur);
                    }
                } else {
                    throw new IllegalArgumentException("Ce cours est complet. Le nombre maximum de skieurs est atteint.");
                }
            } else {
                throw new IllegalArgumentException("Ce cours n'est pas de type collectif.");
            }
        return inscriptionRepository.save(inscription);


    } */





}
