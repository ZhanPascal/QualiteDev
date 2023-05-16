package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.data.Voiture;
import com.example.demo.data.VoitureRepository;

public class Echantillon implements Statistique{

    @Autowired
    private VoitureRepository voitureRepository;

    public int prixMoyen() throws ArithmeticException{
        int nombreVoitures = 0;
        int sommePrix = 0;
        int moyenne = 0;

        try {
            nombreVoitures = (int)voitureRepository.count();
            for (Voiture voiture : voitureRepository.findAll()){
                sommePrix += voiture.getPrix();
            }
            moyenne = sommePrix/nombreVoitures;
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        

        return moyenne;
    }

    public void ajouter(Voiture voiture){
        try{
            voitureRepository.save(voiture);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
