package main;

public class Roi extends Personnage {
    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom   Le nom du personnage
     */
    public Roi(String nom) {
        super(nom);
    }
    @Override
    public String longRegne(){
        return "Long règne au roi";
    }

}