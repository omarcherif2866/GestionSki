package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Abonnement;
import com.example.gestionski_omarcherif.entities.Couleur;
import com.example.gestionski_omarcherif.entities.Skieur;
import com.example.gestionski_omarcherif.entities.TypeAbonnement;
import com.example.gestionski_omarcherif.repositories.AbonnementRepository;
import com.example.gestionski_omarcherif.repositories.SkieurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class IAbonnementServiceImp implements IAbonnementService {
    private final AbonnementRepository abonnementRepository;
    private final SkieurRepository skieurRepository;

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return this.abonnementRepository.findByTypeAbon(type);

    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void retrieveSubscriptions() {
        LocalDate dateToday = LocalDate.now();
        LocalDate dateNextWeek = dateToday.plusDays(7);
        //List<Abonnement> listAbn = abonnementRepository.findByDateFinBetween(dateToday,dateNextWeek);
        List<Skieur> listSkieur = skieurRepository.findByAbn_DateFinBetween(dateToday,dateNextWeek);
       /* listAbn.forEach(abonnement ->
                log.info("num abonnement" + abonnement.getId() )
                );  */
        listSkieur.forEach(skieur ->
                log.info("num abonnement : " + skieur.getAbn().getId() +
                        "nom skieur : " + skieur.getNomS() +
                        "prenom skieur : " + skieur.getPrenomS()
                )
                );
    }

    @Override
    public List<Abonnement> findAbonnementBySkieurPisteColor() {
        List<Abonnement> listAbn;

        listAbn= skieurRepository.findByPistesCouleur(Couleur.NOIR)
                .stream()
                .map(Skieur::getAbn)
                .collect(Collectors.toList());

//        listAbn = abonnementRepository.findAbonnementBySkieurPisteColor(Couleur.NOIR);
        return listAbn;
    }


}
