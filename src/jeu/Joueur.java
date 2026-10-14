package jeu;

import cartes.Carte;
import cartes.Probleme;

public class Joueur {

    private String nom;
    private ZoneDeJeu zoneDeJeu;
    private MainJoueur main;
    

    public Joueur(String nom) {
        this.nom = nom;
        this.zoneDeJeu = new ZoneDeJeu();
        this.main = new MainJoueur();
    }
    
    public String getNom() {
		return nom;
	}
	
	public MainJoueur getMain() {
		return main;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
    @Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur joueur) {
			return nom.equals(joueur.toString());
		}
		return false;
		
	}
    @Override
	public String toString() {
		return nom;
	}
    
    public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		this.donner(carte);
		
		return carte;		
	}

}