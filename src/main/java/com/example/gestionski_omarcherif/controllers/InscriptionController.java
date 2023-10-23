package com.example.gestionski_omarcherif.controllers;

import com.example.gestionski_omarcherif.entities.Cours;
import com.example.gestionski_omarcherif.entities.Inscription;
import com.example.gestionski_omarcherif.services.IInscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("inscription")
@RequiredArgsConstructor
public class InscriptionController {

    private final IInscriptionService iInscriptionService;

    @PostMapping()
    public Inscription addiInscription(@RequestBody Inscription inscription){
        return iInscriptionService.addIns(inscription);
    }

    @GetMapping("{id}")
    public Inscription getInscrptionById(@PathVariable Long id){
        return iInscriptionService.getIns(id);
    }

    @DeleteMapping("{id}")
    public void deleteInscription(@PathVariable Long id) { iInscriptionService.deleteIns(id);}

    @GetMapping("/allInscriptions")
    public List<Inscription> getAll(){return iInscriptionService.getAllIns();}

    @PostMapping("addInscriptionSkieur/{skieurId}")
    public Inscription addInscriptionSkieur(@RequestBody Inscription inscription,@PathVariable Long skieurId){
        return iInscriptionService.addRegistrationAndAssignToSkier(inscription,inscription.getSkieur().getId());
    }

}
