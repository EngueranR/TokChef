package TokChef.Alimentation;

import javax.persistence.Entity;

@Entity

public class Legume extends Ingredient {
	private static final long serialVersionUID = 1L;
	protected double calorie;
    protected double fibre;
    protected double poids;
    protected double tauxFibre;
    protected boolean bio;

    public Legume() {
        super();
    }

    public Legume(String nom, double calorie, double poids, double tauxFibre, boolean bio) {
        super(nom);
        this.setCalorie(calorie);
        this.setPoids(poids);
        this.setTauxFibre(tauxFibre);
        this.setBio(bio);
        this.setFibre(getPoids() * getTauxFibre());


    }



    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        if (calorie < 0) {
            this.calorie = 1;
        }
        this.calorie = calorie;
    }

    public double getFibre() {
        return fibre;
    }

    public void setFibre(double fibre) {
        if (fibre < 0) {
            this.fibre = 0;
        }
        this.fibre = fibre;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        if (poids < 0) {
            this.poids = 0;
        }
        this.poids = poids;
    }

    public double getTauxFibre() {
        return tauxFibre;
    }

    public void setTauxFibre(double tauxFibre) {
        if (tauxFibre < 0) {
            this.tauxFibre = 0;
        }
        if (tauxFibre > 1) {
            this.tauxFibre = 1;
        }
        this.tauxFibre = tauxFibre;
    }

    public boolean isBio() {
        return bio;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }

    public String toString() {
        return "Legume{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", calorie=" + calorie +
                ", fibre=" + fibre +
                ", poids=" + poids +
                "g, tauxFibre=" + tauxFibre +
                ", bio=" + bio +
                '}';
    }
}

