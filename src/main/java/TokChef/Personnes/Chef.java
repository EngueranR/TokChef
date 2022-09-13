package TokChef.Personnes;

import TokChef.Alimentation.*;

import java.util.*;

public class Chef extends Personne {
    protected String telephone;
    protected  Specialite specialite;
    protected int etoile;
    protected  List<Plat> platsDuChef;
    public static List<Chef> listeChef = new ArrayList<>();



    // Sans plat
    public Chef(String nom, String prenom, Genre genre, String telephone, int etoile, Specialite specialite) {
        super(nom, prenom, genre, telephone);
        this.setEtoile(etoile);
        this.setSpecialite(specialite);
        this.setPlatsDuChef(new ArrayList<>());
        listeChef.add(this);
    }


    //Un plat
    public Chef(String nom, String prenom, Genre genre, String telephone, int etoile, Specialite specialite, Plat platDuChef) {
        super(nom, prenom, genre, telephone);
        this.setEtoile(etoile);
        this.setSpecialite(specialite);
        this.setPlatsDuChef(new ArrayList<>());
        this.getPlatsDuChef().add(platDuChef);
        listeChef.add(this);
    }

    //Plusieurs plats
    public Chef(String nom, String prenom, Genre genre, String telephone, int etoile, Specialite specialite, List<Plat> platsDuChef) {
        super(nom, prenom, genre, telephone);
        this.setEtoile(etoile);
        this.setSpecialite(specialite);
        this.setPlatsDuChef(platsDuChef);
        listeChef.add(this);
    }


    public Map<String,Integer> platsInfCalories(int seuil) {

        Map<String,Integer> listeDeSortie = new HashMap<>();

        double calPlat = 0;

        for (Plat p : this.getPlatsDuChef()) {

            calPlat = 0;

            // Caluler les calories d'un plat
            for (Object o : p.getIngredientPlat().keySet()) {

                // Verifier le type d'ingredient
                if (o.getClass() == Legume.class) {
                    calPlat += ((Legume) o).getCalorie() * p.getIngredientPlat().get(o).getQuantite();
                } else if (o.getClass() == Autre.class) {
                    calPlat += ((Autre) o).getCalories() * p.getIngredientPlat().get(o).getQuantite();
                } else if (o.getClass() == ViandePoisson.class) {
                    calPlat += ((ViandePoisson) o).getCalorie() * p.getIngredientPlat().get(o).getQuantite();
                }
            }

            if (calPlat <= seuil) {
                listeDeSortie.put(p.getNom(),(int) calPlat);
            }
        }

        return listeDeSortie;
    }

    public Map<String,Integer> platsSupCalories(int seuil) {

        Map<String,Integer> listeDeSortie = new HashMap<>();
        double calPlat = 0;

        for (Plat p : this.getPlatsDuChef()) {

            calPlat = 0;

            // Caluler les calories d'un plat
            for (Object o : p.getIngredientPlat().keySet()) {

                // Verifier le type d'ingredient
                if (o.getClass() == Legume.class) {
                    calPlat += ((Legume) o).getCalorie() * p.getIngredientPlat().get(o).getQuantite();
                } else if (o.getClass() == Autre.class) {
                    calPlat += ((Autre) o).getCalories() * p.getIngredientPlat().get(o).getQuantite();
                } else if (o.getClass() == ViandePoisson.class) {
                    calPlat += ((ViandePoisson) o).getCalorie() * p.getIngredientPlat().get(o).getQuantite();
                }
            }
            if (calPlat >= seuil) {
                listeDeSortie.put(p.getNom(),(int) calPlat);
            }
        }

        return listeDeSortie;
    }





    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public Specialite getSpecialite() {
        return specialite;
    }


    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }


    public int getEtoile() {
        return etoile;
    }


    public void setEtoile(int etoile) {
        if (etoile > 3) {
            etoile = 3;
        } else if (etoile < 0) {
            etoile = 0;
        }
        this.etoile = etoile;
    }

    public List<Plat> getPlatsDuChef() {
        return platsDuChef;
    }

    public void setPlatsDuChef(List<Plat> platsDuChef) {
        this.platsDuChef = platsDuChef;
    }

    public static List<Chef> getListeChef() {
        return listeChef;
    }

    public static void setListeChef(List<Chef> listeChef) {
        Chef.listeChef = listeChef;
    }

    public String toString() {
        return this.getNom() + " " +this.getPrenom();
    }

    public String listeChef() {
        return "listeChef{" + listeChef + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chef chef = (Chef) o;
        return etoile == chef.etoile && specialite == chef.specialite && Objects.equals(platsDuChef, chef.platsDuChef);
    }

    public int hashCode() {
        return Objects.hash(specialite, etoile, platsDuChef);
    }
}
