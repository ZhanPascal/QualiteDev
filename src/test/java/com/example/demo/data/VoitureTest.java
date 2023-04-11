package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture v = new Voiture(1,  "Audi", 15000);
        Assert.isInstanceOf(Voiture.class, v, "Ce n'est pas une voiture");

        Assert.isTrue(v.getMarque().equals("Audi"), "La voiture n'est pas une Audi");
        
        Assert.isTrue(v.getId() == 1,"La voiture n'a pas le bon ID");
    
        Assert.isTrue(v.getPrix() == 15000, "La voiture ne coute pas 15000€");
    }

}
