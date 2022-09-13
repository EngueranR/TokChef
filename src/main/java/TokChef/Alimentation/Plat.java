package TokChef.Alimentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class Plat implements Serializable {
	private static final long serialVersionUID = 1L;
	public HashMap<Ingredient, Consigne> ingredientPlat;
    protected String nom;
    public static List<Plat> listePlat = new ArrayList<>();


    public Plat(HashMap<Ingredient, Consigne> ingredientsPlat, String nom) {
        ingredientPlat = new HashMap<Ingredient, Consigne>();
        listePlat.add(this);
        this.nom = nom;

    }


    public void ajouterIngredient(Ingredient ig, Etat e, double quantite) {
        if (ig != null && !ingredientPlat.containsKey(ig) && e != null) {
            Consigne c = new Consigne(e, quantite);
            ingredientPlat.put(ig, c);
        }
    }


    public static List<Plat> platsBio() {

        List<Plat> listeDeSortie = new ArrayList<>();
        boolean bio = true;

        for (Plat p : listePlat) {
            for (Object o : p.getIngredientPlat().keySet()) {
                // Verifier Bio des ingédients
                if (o.getClass() == Legume.class) {
                    if (!((Legume) o).isBio()) {
                        bio = false;
                    }
                } else if (o.getClass() == Autre.class) {
                    if (!((Autre) o).isBio()) {
                        bio = false;
                    }
                } else if (o.getClass() == Epice.class) {
                    if (!((Epice) o).isBio()) {
                        bio = false;
                    }
                } else if (o.getClass() == ViandePoisson.class) {
                    if (!((ViandePoisson) o).isBio()) {
                        bio = false;
                    }
                }
            }
            if (bio) {
                listeDeSortie.add(p);
            }
        }
        return listeDeSortie;
    }


    public static void sauvegardePlat() throws IOException {
        File fichier = new File("PlatSerialize.ser");

        // ouverture d'un flux sur un fichier
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));

        // sérialization de l'objet
        oos.writeObject(listePlat);

        // fermeture du flux dans le bloc finally
        oos.close();
    }


    public static List<Plat> chargePlat() throws IOException, ClassNotFoundException {
        // on simplifie le code en retirant la gestion des exceptions
        File fichier =  new File("PlatSerialize.ser") ;

        // ouverture d'un flux sur un fichier
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;

        // désérialization de l'objet
        List<Plat> listePlat = (List<Plat>)ois.readObject() ;

        // fermeture du flux dans le bloc finally
        ois.close();

        return listePlat;
    }



    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return Objects.equals(ingredientPlat, plat.ingredientPlat);
    }

    public int hashCode() {
        return Objects.hash(ingredientPlat);
    }

    public HashMap<Ingredient, Consigne> getIngredientPlat() {
        return ingredientPlat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return this.getNom();
    }
}