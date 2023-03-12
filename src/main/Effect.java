package main;

public class Effect {
    protected TypeEffect typeEffect;
    protected TypeJauge nomJauge;
    protected int valeur;
    public Effect(TypeEffect typeEffect, TypeJauge nomJauge, int valeur) {
        this.typeEffect = typeEffect;
        this.nomJauge = nomJauge;
        this.valeur = valeur;
    }


    public void setNomJauge(TypeJauge nomJauge) {
        this.nomJauge = nomJauge;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public TypeEffect getTypeEffect() {
        return typeEffect;
    }

    public TypeJauge getNomJauge() {
        return nomJauge;
    }

    public int getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "; jauge " +
                 nomJauge +
                 (valeur>0 ? "+":"") +
                valeur;
    }
    public void appilquer(Personnage personnage){
        for(Jauge jauge : personnage.jauges){
            if(jauge.type==this.nomJauge){
                jauge.valeur += this.getValeur();
                break;
            }
        }

    }

}
