package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Voiture;

@RestController
public class VoitureController{

    @GetMapping("/bonjour")
    public String disBonjour(){
        return "Bonjour";
    }

    @GetMapping("voiture")
    public Voiture getVoiture(){
        Voiture v = new Voiture(1,  "Audi", 15000);
        return v;
    }

    @PostMapping("/voiture")
    public void creerVoiture(@RequestBody Voiture voiture){
        System.out.println(voiture);
    }

}