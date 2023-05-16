package com.example.demo.web;

import com.example.demo.data.Voiture;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoitureController {

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
        if(voiture.getId() == 0){
            throw new VoitureException();
        }
        System.out.println(voiture);
    }

}