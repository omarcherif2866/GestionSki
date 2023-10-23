package com.example.gestionski_omarcherif.repositories;

import com.example.gestionski_omarcherif.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PisteRepository extends JpaRepository<Piste,Long> {

   // @Query("select count(p) from Piste p inner join p.skieurs skieurs where skieurs.id = ?1")
    int countBySkieursId(long skieurs_id);



}
