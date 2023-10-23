package com.example.gestionski_omarcherif.repositories;

import com.example.gestionski_omarcherif.entities.*;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    Set<Abonnement> findByTypeAbon(TypeAbonnement typeAbon);
   // List<Abonnement> findByIsBetweenDateDebutAndDateFin(LocalDate dateDebut,LocalDate dateFin);

    List<Abonnement> findByDateFinBetween(LocalDate date1, LocalDate date2);

    @Query("select a from " +
            " Abonnement a join Skieur s on s.abn= a " +
            " join Piste p on p member of s.pistes " +
            " where p.couleur = :color ")
    public List<Abonnement> findAbonnementBySkieurPisteColor(@Param("color") Couleur couleur);



}
