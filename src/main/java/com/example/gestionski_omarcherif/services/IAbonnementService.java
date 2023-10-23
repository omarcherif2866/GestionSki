package com.example.gestionski_omarcherif.services;

import com.example.gestionski_omarcherif.entities.Abonnement;
import com.example.gestionski_omarcherif.entities.TypeAbonnement;

import java.util.List;
import java.util.Set;

public interface IAbonnementService {
   public Set<Abonnement> getSubscriptionByType(TypeAbonnement type);

   public void retrieveSubscriptions();

   public List<Abonnement> findAbonnementBySkieurPisteColor();
}
