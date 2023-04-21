package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BaseDeDonneesTests {

    @MockBean
    private VoitureRepository voitureRepository;

    @Test
    void uneVoiture(){
        // tester les méthodes de l'interface CrudRepository qui permette d'accéder à la base de données: https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
        // save, find, delete...
        Voiture v = new Voiture(1,  "Audi", 15000);
        voitureRepository.save(v);
        //Test s'il y a bien une ligne avec l'id 1 dans la bdd
        when(voitureRepository.existsById(1)).thenReturn(true);
        //Test si l'objet récupéré correspond bien à l'objet inséré
        when(voitureRepository.findById(1)).thenReturn(Optional.of(v));
        //Test ligne vide dans la base
        when(voitureRepository.findById(2)).thenReturn(Optional.empty());
        //suppression de l'objet inséré
        doNothing().when(voitureRepository).delete(v);
        //Test Si l'objet est bien supprimé
        when(voitureRepository.findById(1)).thenReturn(Optional.of(v));


    }


}
