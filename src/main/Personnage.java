package main;

import java.util.Vector;

/**
 * Représente un personnage ayant un nom, un genre, et des jauges de Clergé, Peuple, Armée et Finances.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Personnage {
    /**
     * Le nom du personnage
     */
    protected String nom;
    /**
     * Le genre du personnage
     */
    /**
     * La jauge de Clergé
     */
    protected Vector<Jauge>  jauges;
    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom Le nom du personnage
     */

    public Personnage(String nom) {
        this.nom = nom;
        // Initialisation des jauges entre 15 et 35 points
        this.jauges= new Vector<Jauge>();
        this.jauges.add(new Jauge(TypeJauge.CLERGE,"Clergé", 15 + (int)(Math.random() * (35 - 15))));
        this.jauges.add( new Jauge(TypeJauge.PEUPLE,"Peuple", 15 + (int)(Math.random() * (35 - 15))));
        this.jauges.add(new Jauge(TypeJauge.ARMEE,"Armée", 15 + (int)(Math.random() * (35 - 15))));
        this.jauges.add(new Jauge(TypeJauge.FINANCE,"Finances", 15 + (int)(Math.random() * (35 - 15))));
    }
    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public void AfficheJauges() {

        for (Jauge jauge : jauges){
            jauge.afficheJauge();
        }
        System.out.println();
    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    /**
     * Retourne le nom du personnage
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifie le nom du personnage
     * @param nom Le nouveau nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retourne le genre du personnage
     * @return le genre du personnage
     */
    /**
     * Modifie le genre du personnage
     * @param genre Le nouveau genre du personnage
     */
    /**
     * Retourne la jauge du clergé
     * @return la jauge du clergé
     */
    public String longRegne(){
        return "Long règne";
    }

}