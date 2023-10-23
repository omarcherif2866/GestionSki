package com.example.gestionski_omarcherif.controllers;

import com.example.gestionski_omarcherif.entities.Abonnement;
import com.example.gestionski_omarcherif.entities.Skieur;
import com.example.gestionski_omarcherif.entities.TypeAbonnement;
import com.example.gestionski_omarcherif.services.IAbonnementService;
import com.example.gestionski_omarcherif.services.ISkieurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("abonnement")
@RequiredArgsConstructor
public class AbonnementController {
    private final IAbonnementService iAbonnementService;

    @GetMapping("{typeAbonnement}")
    public Set<Abonnement> getAbnByType (@PathVariable TypeAbonnement typeAbonnement ){
        return iAbonnementService.getSubscriptionByType(typeAbonnement);
    }
}
