package TokChef.Alimentation;

import javax.persistence.Entity;

@Entity
public class Autre extends Ingredient {
	private static final long serialVersionUID = 1L;
	protected double poids;
	protected boolean bio;
	protected double calories;
	protected double tauxDeCalories;



	public Autre(String nom, double poids, boolean bio, double tauxDeCalories) {
		super(nom);
		this.setPoids(poids);
		this.setBio(bio);
		this.setTauxDeCalories(tauxDeCalories);
		this.setCalories(getPoids()*getTauxDeCalories());
	}

	public Autre() {

	}


	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public boolean isBio() {
		return bio;
	}

	public void setBio(boolean bio) {
		this.bio = bio;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getTauxDeCalories() {
		return tauxDeCalories;
	}

	public void setTauxDeCalories(double tauxDeCalories) {
		this.tauxDeCalories = tauxDeCalories;
	}




	public String toString() {
		return "Autre{" +
				"poids=" + poids + // AJOUTER L'UNITE
				", bio=" + bio +
				", calories=" + calories +
				", tauxDeCalories=" + tauxDeCalories +
				", id=" + id +
				", nom='" + nom + '\'' +
				'}';
	}
}
