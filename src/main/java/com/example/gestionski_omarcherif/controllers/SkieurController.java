package com.example.gestionski_omarcherif.controllers;

import com.example.gestionski_omarcherif.entities.Skieur;
import com.example.gestionski_omarcherif.entities.TypeAbonnement;
import com.example.gestionski_omarcherif.services.ISkieurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("skieur")

public class SkieurController {

    @Qualifier("ISkieurServiceImp")
    private final ISkieurService skieurService;

    //@Qualifier("iskieurServiceImp2")
    //private final ISkieurService iSkieurService;
    // ki besh nestaaml variable okhra f utilisation okhra b imp okhra

    @PostMapping()
    public Skieur addSkieur(@RequestBody Skieur skieur){
        return skieurService.addSkieur(skieur);
    }

    @GetMapping("{typeAbonnement}")
    public List<Skieur> getSkieurByAbn(@PathVariable TypeAbonnement typeAbonnement ){
        return skieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }

    @GetMapping("liste")
    public List<Skieur> GetSkieurJPQL(){
        return   skieurService.GetSkieurJPQL();
    }

    @PostMapping("SkieurCours/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur,@PathVariable Long numCourse){
        return skieurService.addSkierAndAssignToCourse(skieur,numCourse);
    }

}
