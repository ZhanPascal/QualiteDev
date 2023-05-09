package com.example.demo.service;

import com.example.demo.data.Voiture;

public interface Statistique {

    public void ajouter(Voiture voiture);

    /**
     *
     * @return
     * @throws ArithmeticException s'il n'y a pas de voiture
     */
    public Echantillon prixMoyen() throws ArithmeticException;

}