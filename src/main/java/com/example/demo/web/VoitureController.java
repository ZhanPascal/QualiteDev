package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.Statistique;

@RestController
public class VoitureController {

    @Autowired
    Statistique statistique;

    @GetMapping("/bonjour")
    public String disBonjour(){
        return "Bonjour";
    }

    
    @GetMapping("/voiture")
    public Voiture getVoiture(){
        Voiture v = new Voiture(1,  "Audi", 15000);
        return v;
    }

    @PostMapping("/voiture")
    public void creerVoiture(@RequestBody Voiture voiture) throws VoitureException {
        statistique.ajouter(voiture);
    }

    @GetMapping(value = "/statistique")
    public Echantillon getStatistiques() throws VoitureException {
        try{
            return statistique.prixMoyen();
        } catch (ArithmeticException e) {
            throw new VoitureException();
        }

    }

}