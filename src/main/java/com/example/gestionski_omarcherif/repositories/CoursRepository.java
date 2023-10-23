package com.example.gestionski_omarcherif.repositories;

import com.example.gestionski_omarcherif.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository <Cours, Long> {
}
