package com.example.gestionski_omarcherif.controllers;

import com.example.gestionski_omarcherif.entities.Inscription;
import com.example.gestionski_omarcherif.entities.Moniteur;
import com.example.gestionski_omarcherif.services.IMoniteurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("moniteur")
@RequiredArgsConstructor
public class MoniteurController {
    private final IMoniteurService iMoniteurService ;

    @PostMapping("/{coursId}")
    public Moniteur addCoursToMoniteur(@RequestBody Moniteur moniteur, @PathVariable Long coursId){
        return iMoniteurService.addInstructorAndAssignToCourse(moniteur,coursId);
    }
}
