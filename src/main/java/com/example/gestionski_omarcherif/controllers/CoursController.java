package com.example.gestionski_omarcherif.controllers;

import com.example.gestionski_omarcherif.entities.Cours;
import com.example.gestionski_omarcherif.entities.Skieur;
import com.example.gestionski_omarcherif.services.ICoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cours")
@RequiredArgsConstructor
public class CoursController {
    private final ICoursService iCoursService;

    @PostMapping()
    public Cours addCours(@RequestBody Cours cours){
        return iCoursService.addCours(cours);
    }

    @GetMapping("name/{name}")
    public String helloWorld(@PathVariable String name){
        return "bonjour "+name;
    }

    @GetMapping("{id}")
    public Cours getCours(@PathVariable Long id){
        return iCoursService.getCours(id);
    }
}

