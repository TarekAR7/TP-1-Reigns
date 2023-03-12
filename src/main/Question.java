package main;


import java.util.Vector;

/**
 * La classe Question représente une question avec ses effets sur les jauges d'un personnage
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Question {
    /**
     * nom du personnage associé à la question
     */
    protected String nomPersonnage;
    /**
     * la question
     */
    protected String question;
    /**
     * l'effet de la réponse de gauche
     */
    protected String effetGauche;
    /**
     * l'effet de la réponse de droite
     */
    protected String effetDroite;
    /**
     * les effets sur les jauges pour la réponse de gauche
     */

    /**
     * Construit une nouvelle question avec les informations données
     *
     * @param nomPersonnage Le nom du personnage associé à la question
     * @param question La question à poser
     * @param effetGauche L'effet de la réponse de gauche
     * @param effetDroite L'effet de la réponse de droite
     */
    protected Vector<Effect> effects;
    public Question(String nomPersonnage,
                    String question,
                    String effetGauche,
                    String effetDroite) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effetGauche = effetGauche;
        this.effetDroite = effetDroite;
        this.effects = new Vector<Effect>();
    }

    /**
     * Affiche la question avec les effets associés aux choix gauche et droit.
     */
    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question
                + "[G: "+effetGauche
                + ",D: "+effetDroite
                + "]";
        System.out.println(result);
        this.afficheEffets();
        System.out.flush();
    }

    public void afficheEffets(){
        for(TypeEffect typeEffect : TypeEffect.values()){
            StringBuilder result = new StringBuilder();
            result.append("Effet ").append(typeEffect).append(":");
            for(Effect effet : this.effects){
                if(effet.typeEffect == typeEffect){
                    result.append(effet.toString());
                }
            }
            System.out.println(result);
        }

    }
    public void appliquerEffet(TypeEffect typeEffect, Personnage personnage){
        for(Effect effet : this.effects){
            if(effet.typeEffect == typeEffect){
                effet.appilquer(personnage);
            }
        }
    }
    public void ajoutEffets(TypeEffect typeEffect, TypeJauge nomJauge, int valeur){
        effects.add(new Effect(typeEffect, nomJauge, valeur));
    }
    /**
     * Applique les effets associés au choix gauche sur un personnage donné.
     *
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */

    /**
     * Applique les effets associés au choix droit sur un personnage donné.
     *
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */

    /**
     * Applique les effets d'une jauge sur un personnage donné.
     *
     * @param effets les effets de jauge à appliquer
     * @param personnage le personnage sur lequel les effets doivent être appliqués
     */
//    private void appliqueEffets(Map<TypeJauge,Integer> effets,
//                                Personnage personnage){
//        for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){
//            switch(effet.getKey()){
//                case ARMEE:
//                    personnage.getJaugeArmee().setValeur(
//                            personnage.getJaugeArmee().getValeur()
//                                    +effet.getValue());
//                    break;
//                case CLERGE:
//                    personnage.getJaugeClerge().setValeur(
//                            personnage.getJaugeClerge().getValeur()
//                                    +effet.getValue());
//                    break;
//                case FINANCE:
//                    personnage.getJaugeFinance().setValeur(
//                            personnage.getJaugeFinance().getValeur()
//                                    +effet.getValue());
//                    break;
//                case PEUPLE:
//                    personnage.getJaugePeuple().setValeur(
//                            personnage.getJaugePeuple().getValeur()
//                                    +effet.getValue());
//                    break;
//            }
//        }
//    }

    /**
     * Retourne le nom du personnage associé à la question.
     *
     * @return le nom du personnage associé à la question
     */
    public String getNomPersonnage() {
        return nomPersonnage;
    }

    /**
     * Modifie le nom du personnage associé à la question.
     *
     * @param nomPersonnage le nouveau nom du personnage associé à la question
     */
    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    /**
     * Retourne la question.
     *
     * @return la question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Modifie la question.
     *
     * @param question la nouvelle question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Retourne l'effet gauche de la question.
     *
     * @return l'effet gauche de la question.
     */
    public String getEffetGauche() {
        return effetGauche;
    }

    /**
     * Modifie l'effet gauche de la question.
     *
     * @param effetGauche le nouvel effet gauche de la question
     */
    public void setEffetGauche(String effetGauche) {
        this.effetGauche = effetGauche;
    }

    /**
     * Retourne l'effet droit de la question.
     *
     * @return l'effet droit de la question.
     */
    public String getEffetDroite() {
        return effetDroite;
    }

    /**
     * Modifie l'effet droit de la question.
     *
     * @param effetDroite le nouvel effet droit de la question
     */
    public void setEffetDroite(String effetDroite) {
        this.effetDroite = effetDroite;
    }
}