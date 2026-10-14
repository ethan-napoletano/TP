
package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;


public class ZoneDeJeu {

    private List<Carte> limites;
    private List<Carte> batailles;
    private List<Carte> bornes;

    public ZoneDeJeu() {
        limites = new ArrayList<>();
        batailles = new ArrayList<>();
        bornes = new ArrayList<>();
    }
}
