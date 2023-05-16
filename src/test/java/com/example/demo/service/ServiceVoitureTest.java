package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceVoitureTest {

    @MockBean
    Statistique statistique;

    @Test
    void statistiqueZeroVoiture(){
        when(statistique.prixMoyen()).thenReturn(new Echantillon(0, 0));
    }

    @Test
    void statistique1Voiture(){
        doNothing().when(statistique).ajouter(new Voiture("KFC", 5000));
        when(statistique.prixMoyen()).thenReturn(new Echantillon(1, 5000));
    }

    @Test
    void statistique2Voiture(){
        doNothing().when(statistique).ajouter(new Voiture("Toyota", 1000));
        doNothing().when(statistique).ajouter(new Voiture("BYD", 3000));
        when(statistique.prixMoyen()).thenReturn(new Echantillon(2, 2000));
    }

}