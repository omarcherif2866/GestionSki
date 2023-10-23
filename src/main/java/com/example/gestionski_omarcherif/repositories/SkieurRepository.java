package com.example.gestionski_omarcherif.repositories;

import com.example.gestionski_omarcherif.entities.Couleur;
import com.example.gestionski_omarcherif.entities.Skieur;
import com.example.gestionski_omarcherif.entities.TypeAbonnement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SkieurRepository extends CrudRepository<Skieur,Long> {
List<Skieur> findByAbn_TypeAbon(TypeAbonnement abn_typeAbon);
List<Skieur> findByDateNaissanceIsBetween(LocalDate dateNaissance1, LocalDate dateNaissance2);
//SQL
    @Query(value = "SELECT * FROM skieur s JOIN abonnement a on s.abn_id = a.id WHERE a.type_abn = :typeAbonnement",nativeQuery = true)
    List<Skieur> findByAbn_TypeAbonSql(@Param("typeAbonnement") TypeAbonnement typeAbonnement);
    //JPQL
    //@Query("select s from Skieur where s.abn.typeAbn = ?1")
    // List<Skieur> findByAbn_TypeAbon(TypeAbonnement typeAbonnement);




    //Get skieur order by nbr pistes
    @Query("select s from Skieur s order by size(s.pistes) DESC ")
    List<Skieur> findBySkieurJPQL() ;



    //SQL
    @Query( value ="SELECT * FROM `skieur` s" +
            "    JOIN inscription i ON s.id=i.skieur_id" +
            "    JOIN moniteur_cours mc ON mc.cours_id =i.cours_id" +
            "    JOIN moniteur m ON m.id=mc.moniteur_id" +
            "    WHERE m.nomm= :name",nativeQuery = true)
    List<Skieur>GetSkieurByMoniteur(@Param("name") String name);
    //JPQL
    //Get skieur by moniteur name
    // @Query("select s from Skieur s " +
    //        "join Inscription i ON i.skieur=s " +
    //        "join Moniteur m on i.cours member of m.cours" +
    //        " WHERE m.nomM = :name")
    //List<Skieur>GetSkieurByMoniteurJPQL(String name);


    List<Skieur> findByPistesCouleur(Couleur pistes_couleur);

    List<Skieur> findByAbn_DateFinBetween(LocalDate abn_dateFin, LocalDate abn_dateFin2);

}
