package TokChef;

import TokChef.Alimentation.*;
import TokChef.Concours.Concours;
import TokChef.Exception.ConcoursException;
import TokChef.Personnes.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException, ConcoursException, IOException, ClassNotFoundException {

        // Creation des legumes
        Legume carotte = new Legume("carotte", 10.50, 30, 0.15, true);
        Legume champignon = new Legume("champignon", 12.50, 40, 0.2, true);

        // Creation des viandes et poissons
        ViandePoisson saumon = new ViandePoisson("saumon",10.2,false,0.3,12.5);
        ViandePoisson poulet = new ViandePoisson("poulet", 30.5, true, 0.7, 10);

        // Creation des epices
        Epice sel = new Epice("sel", true);
        Epice poivre = new Epice("poivre", true);
        Epice basilique = new Epice("basilique",true);

        // Creation des autres
        Autre cremeFraiche = new Autre("cremeFraiche",30,true,0.2);
        Autre pate = new Autre("Pate", 150, true, 0.30);
        Autre gruyere = new Autre("gruyere", 70, true, 0.25);

        // Creation des plats
        Plat pateGruyere = new Plat(null, "pate Gruyere");
        pateGruyere.ajouterIngredient(pate, Etat.ENTIER, 100);
        pateGruyere.ajouterIngredient(gruyere, Etat.ENTIER, 10);

        Plat pateSaumon = new Plat(null,"pate Saumon");
        pateSaumon.ajouterIngredient(pate, Etat.CRU,100);
        pateSaumon.ajouterIngredient(saumon,Etat.DECOUPER,30);
        pateSaumon.ajouterIngredient(sel, Etat.ENTIER, 2);
        pateSaumon.ajouterIngredient(poivre, Etat.ENTIER, 2);

        Plat patePesto = new Plat(null,"pate Pesto");
        pateSaumon.ajouterIngredient(pate, Etat.ENTIER,100);
        pateSaumon.ajouterIngredient(basilique,Etat.DECOUPER,30);
        pateSaumon.ajouterIngredient(sel, Etat.ENTIER, 2);
        pateSaumon.ajouterIngredient(poivre, Etat.ENTIER, 2);

        Plat patePoulet = new Plat(null, "pate Poulet");
        patePoulet.ajouterIngredient(champignon, Etat.DECOUPER, 50);
        patePoulet.ajouterIngredient(poulet, Etat.ENTIER, 100);
        patePoulet.ajouterIngredient(sel, Etat.ENTIER, 2);
        patePoulet.ajouterIngredient(poivre, Etat.ENTIER, 2);
        patePoulet.ajouterIngredient(pate, Etat.ENTIER, 100);

        Plat pateChampignon = new Plat(null, "pate Champignon");
        pateChampignon.ajouterIngredient(champignon, Etat.DECOUPER, 75);
        pateChampignon.ajouterIngredient(sel, Etat.ENTIER, 2);
        pateChampignon.ajouterIngredient(poivre, Etat.ENTIER, 2);
        pateChampignon.ajouterIngredient(pate, Etat.ENTIER, 100);

        Plat pateCarbonara = new Plat(null, "pate Champignon");
        pateChampignon.ajouterIngredient(champignon, Etat.DECOUPER, 75);
        pateChampignon.ajouterIngredient(sel, Etat.ENTIER, 2);
        pateChampignon.ajouterIngredient(poivre, Etat.ENTIER, 2);
        pateChampignon.ajouterIngredient(pate, Etat.ENTIER, 100);


        // Liste Plat des chefs

        List<Plat> platChef1 = new ArrayList<Plat>();
        platChef1.add(pateChampignon);
        platChef1.add(patePoulet);
        platChef1.add(pateGruyere);

        List<Plat> platChef2 = new ArrayList<Plat>();
        platChef2.add(pateChampignon);
        platChef2.add(pateSaumon);
        platChef2.add(pateGruyere);
        platChef2.add(patePoulet);

        List<Plat> platChef3 = new ArrayList<Plat>();
        platChef3.add(pateChampignon);
        platChef3.add(pateSaumon);
        platChef3.add(patePesto);


        // Creation des chefs

        Chef c1 = new Chef("Etchbest", "Philipe", Genre.HOMME, "0601345204", 3, Specialite.PATISIER, platChef1);
        Chef c2 = new Chef("Bocuse", "Paul", Genre.HOMME, "0799549284", 0, Specialite.TRAVAIL_A_DISTANCE, platChef2);
        Chef c3 = new Chef("Ligniac", "Cyril", Genre.HOMME, "0304829475", 3, Specialite.CUISINER, platChef3);
        Chef c4 = new Chef("Gagnaire", "Pierre", Genre.HOMME, "0304342475", 2, Specialite.ROTISIER, platChef1);
        Chef c5 = new Chef("Pic", "Anne-Sophie", Genre.FEMME, "0334234712", 1, Specialite.PATISIER, platChef2);


        // Creation des padawans

        new Padawan("Skywalker", "Anakin", Genre.HOMME, "0638462943", c1);
        new Padawan("Skywalker", "Rey", Genre.FEMME, "0738452837", c2);
        new Padawan("Binks", "JarJar", Genre.HOMME, "0629354952", c2);
        new Padawan("Skywalker", "Rey", Genre.FEMME, "0738452837", c4);
        new Padawan("Binks", "JarJar", Genre.HOMME, "0629354952", c3);
        new Padawan("Binks", "JarJar", Genre.HOMME, "0629354952", c5);


        // Creation des jurys

        Jury j1 = new Jury("Yoda", "Maitre", Genre.NON_BINAIRE, "0645849345");
        Jury j2 = new Jury("Solo", "Han", Genre.HOMME, "064549334");
        Jury j3 = new Jury("Chewbacca", "Jury3", Genre.HOMME, "0645855334");


        // Creaiton des listes de jurys

        List<Jury> cJury = new ArrayList<Jury>();
        cJury.add(j1);
        cJury.add(j2);
        cJury.add(j3);

        // Creaiton des listes de chefs

        List<Chef> cChef = new ArrayList<Chef>();
        cChef.add(c1);
        cChef.add(c2);
        cChef.add(c3);
        cChef.add(c4);
        cChef.add(c5);


        // Simulation concours manuel
        String dateString = "29/05/2021";
        Date dateC1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        Concours concours1 = new Concours(cJury, cChef, dateC1);

        String dateString2 = "30/06/2021";
        Date dateC2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateString2);
        new Concours(cJury, cChef, dateC2);


        // Définir le statut du concours à true (en cours)
        concours1.setStatut(true);
        System.out.println("Le concours est t'il en cours ?" + " " + concours1.isStatut());

        // mettre une note à tout les chefs
        concours1.notesDuJuryGenerales();
        concours1.vainqueurConcours();
        for (Chef c : concours1.chefs) {
            System.out.println(c.getNom() + " : " + concours1.getResultat().get(c) + "/10  " + concours1.getPlatPresente().get(c));
        }
        System.out.println("Le vainqueur est : " + concours1.vainqueurConcours.getNom());

        // ajouter une etoile au chef gagnant
        concours1.vainqueurEtoile();
        System.out.println("Une étoile est ajouter au chef il à donc : " + concours1.vainqueurConcours.getEtoile() + "étoiles");

        // passé du statue en cours (true) à (false)
        concours1.finConcours();
        System.out.println("Le concours est t'il en cours ?" + " " + concours1.isStatut());

        // Passé de la liste prévu à la liste passé
        concours1.passeConcours();
        System.out.print("Liste des concours passe : ");
        Concours.getListeDeConcoursPasse().forEach(c -> System.out.println(c.getId() + " "));


        // Simulation du concours automatique
        // concours1.automatiqueConcours();


        // On peut afficher la liste des plats connu d’un chef.fe par nombre de calorie.
        // Calorie inférieur à n
        int n = 5000;

        System.out.println("Plat Inférieur à " + n + " calories pour le chef " + c1.getNom() + " " + c1.platsInfCalories(n));
        System.out.println("Plat Inférieur à " + n + " calories pour le chef " + c2.getNom() + " " + c2.platsInfCalories(n));

        // On peut afficher la liste des plats connu d’un chef.fe par nombre de calorie.
        // Calorie supérieur à n

        System.out.println("Plat Supérieur à " + n + " calories pour le chef " + c1.getNom() + " " + c1.platsSupCalories(n));
        System.out.println("Plat Supérieur à " + n + " calories pour le chef " + c2.getNom() + " " + c2.platsSupCalories(n));

        // il est possible d’avoir l’affichage de tous les concours auquel un chef a participé.
        System.out.print("Liste des concours effectué par le chef : " + c1.getNom() + " : ");
        Concours.ConcoursPasseChef(c1).forEach(c -> System.out.print(c.getId() + " "));

        System.out.println();

        // il est possible d’afficher tous les concours auquel un chef.fe est inscrit.e.
        System.out.print("Liste des concours inscrit par le chef : " + c2.getNom() + " : ");
        Concours.ConcoursPrevuChef(c2).forEach(c -> System.out.print(c.getId() + " "));

        System.out.println();

        // On peut aussi afficher les plat 1OO% bio.
        System.out.println("Liste des plats bio : " + Plat.platsBio());

        // Obtenir la liste des ingrédients en .Json ( /listeIng/listeIngredient.json )
        Ingredient.serializeIngredient();

        // Obtenir une sauvegarde des ingrédients
        Ingredient.sauvegardeIngredient();

        // Charger la sauvegarde des ingrédients
        System.out.print("Liste des ingrédients chargés : ");
        String output = "";
        for (Ingredient i : (Ingredient.chargeIngredient())) {
            output += i.getNom() + ", ";
        }
        System.out.println(output.substring(0, output.length() - 2));


        // Obtenir une sauvegarde des plats
        Plat.sauvegardePlat();

        // Charger la sauvegarde des plats
        System.out.print("Liste des plats chargés : ");
        output = "";
        for (Plat i : (Plat.chargePlat())) {
            output += i.getNom() + ", ";
        }
        System.out.println(output.substring(0, output.length() - 2));



        // Sauvegarder un ingredient dans la base de données

        if (carotte.persist()) {
            System.out.println("L'objet " + carotte.getNom() + " est enregistré dans la base de données");
        } else {
            System.out.println("L'objet " + carotte.getNom() + " existe déjà");
        }

        if (poulet.persist()) {
            System.out.println("L'objet " + poulet.getNom() + " est enregistré dans la base de données");
        } else {
            System.out.println("L'objet " + poulet.getNom() + " existe déjà");
        }

        if (poivre.persist()) {
            System.out.println("L'objet " + poivre.getNom() + " est enregistré dans la base de données");
        } else {
            System.out.println("L'objet " + poivre.getNom() + " existe déjà");
        }

        if (pate.persist()) {
            System.out.println("L'objet " + pate.getNom() + " est enregistré dans la base de données");
        } else {
            System.out.println("L'objet " + pate.getNom() + " existe déjà");
        }


        System.out.println(Ingredient.persistLoad(1));
    }
}

