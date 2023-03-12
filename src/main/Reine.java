package main;

public class Reine extends Personnage {
    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom   Le nom du personnage
     */
    public Reine(String nom) {
        super(nom);
    }
    @Override
    public String longRegne(){
        return "Long règne à la reine";
    }
}
