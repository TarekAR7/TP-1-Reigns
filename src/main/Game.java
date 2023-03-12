package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Personnage personnage;

    /**
     * la banque de questions
     */
    private ArrayList<Question> questions;
    public Game(){

     }
     public void run(){
         // début du jeu
         System.out.println("Bienvenue sur Reigns");

         initBanqueQuestions();

         System.out.println("Création du personnage...");

         initPersonnage();

         System.out.println(personnage.longRegne()
                 +" "+personnage.getNom());

         personnage.AfficheJauges();

         // tirage des questions
         int nbTours = 0;
         while(!this.finDuJeu()){
             nbTours++;
             Question question = getQuestionAleatoire();
             reponseQuestion(question);
             personnage.AfficheJauges();
         }

         // fin du jeu
         System.out.println(
                 personnage.getNom()
                         + " a perdu ! Son règne a duré "
                         +nbTours
                         + " tours");
     }

    private void reponseQuestion(Question question){
        question.afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        question.appliquerEffet(TypeEffect.valueOf(reponse), this.personnage);
    }


    /**
     * Cette fonction permet d'initialiser le personnage joué. Elle demande à l'utilisateur de saisir le nom du personnage
     * et le genre (Roi ou Reine). Elle crée ensuite le personnage.
     */

    private void initPersonnage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println(
                "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        int genre = scanner.nextInt();
        if(genre==1){
            this.personnage = new Roi(nom);
        }else{
            this.personnage = new Reine(nom);
        }

    }

    public static Question initq1(){
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniersS",
                "Oui",
                "Non");
        question1.ajoutEffets(TypeEffect.G, TypeJauge.ARMEE, -5);
        question1.ajoutEffets(TypeEffect.G, TypeJauge.PEUPLE, 5);
        question1.ajoutEffets(TypeEffect.D, TypeJauge.PEUPLE, -7);
        return question1;
    }
    public static Question initq2(){
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.ajoutEffets(TypeEffect.G,TypeJauge.FINANCE,-5);
        question2.ajoutEffets(TypeEffect.G,TypeJauge.PEUPLE, +5);
        question2.ajoutEffets(TypeEffect.D,TypeJauge.PEUPLE, -5);
        return question2;
    }

    public static Question initq3(){
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.ajoutEffets(TypeEffect.G,TypeJauge.CLERGE, +5);
        question3.ajoutEffets(TypeEffect.G,TypeJauge.PEUPLE, -3);
        question3.ajoutEffets(TypeEffect.D,TypeJauge.CLERGE, -5);
        return question3;
    }

    public static Question initq4(){
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.ajoutEffets(TypeEffect.G,TypeJauge.ARMEE, +3);
        question4.ajoutEffets(TypeEffect.G,TypeJauge.FINANCE, -3);
        question4.ajoutEffets(TypeEffect.G,TypeJauge.CLERGE, -3);
        question4.ajoutEffets(TypeEffect.D,TypeJauge.PEUPLE, +3);
        return question4;
    }
    public static Question initq5(){
        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                "Taxer énormément",
                "Taxer un tout petit peu");
        question5.ajoutEffets(TypeEffect.G,TypeJauge.FINANCE, +10);
        question5.ajoutEffets(TypeEffect.G,TypeJauge.PEUPLE, -5);
        question5.ajoutEffets(TypeEffect.D,TypeJauge.FINANCE, +1);
        question5.ajoutEffets(TypeEffect.D,TypeJauge.PEUPLE, -3);
        return question5;
    }
    /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */
    private void initBanqueQuestions(){
        this.questions = new ArrayList<>();
        Question q1 = initq1();
        this.questions.add(q1);
        Question q2 = initq2();
        this.questions.add(q2);
        Question q3 = initq3();
        this.questions.add(q3);
        Question q4 = initq4();
        this.questions.add(q4);
        Question q5 = initq5();
        this.questions.add(q5);
    }

    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    private Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*this.questions.size());
        return this.questions.get(numQuestion);
    }
    public boolean finDuJeu(){
        for(Jauge jauge: this.personnage.jauges){
            if(jauge.verfierJauge())
                return true;
        }
        return false;

    }
}
