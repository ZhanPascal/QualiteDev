package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.Voiture;
import com.example.demo.data.VoitureRepository;

import java.util.Iterator;

@Service
public class Statistique {

    @Autowired
    VoitureRepository voitureRepository;

    public void ajouter(Voiture voiture) {
        voitureRepository.save(voiture);
    }

    public Echantillon prixMoyen() throws ArithmeticException{
        int prixTotal = 0;
        int nombreDeVoitures = 0;
        Iterator<Voiture> voitures = voitureRepository.findAll().iterator();
        while(voitures.hasNext()){
            prixTotal = prixTotal + voitures.next().getPrix();
            nombreDeVoitures++;
        }
        return new Echantillon(nombreDeVoitures, prixTotal/nombreDeVoitures);
    }

}