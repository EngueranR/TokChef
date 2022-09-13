package TokChef.Alimentation;

import javax.persistence.Entity;

@Entity
public class ViandePoisson extends Ingredient {
	private static final long serialVersionUID = 1L;
	protected double calorie; 
	protected boolean bio;
	protected double tauxGraisse;
	protected double gras;
	protected double poids;


	public ViandePoisson(String nom, double calorie, boolean bio, double tauxGraisse, double poids) {
		super(nom);
		this.setCalorie(calorie);
		this.setBio(bio);
		this.setTauxGraisse(tauxGraisse);
		this.setPoids(poids);
		this.setGras(this.getPoids() * this.getTauxGraisse());
	}

	public ViandePoisson() {

	}


	public double getCalorie() {
		return calorie;
	}


	public void setCalorie(double calorie) {
		if(calorie < 0) {
			this.calorie = 0;
		}
		this.calorie = calorie;
	}


	public boolean isBio() {
		return bio;
	}


	public void setBio(boolean bio) {
		this.bio = bio;
	}


	public double getTauxGraisse() {
		return tauxGraisse;
	}


	public void setTauxGraisse(double tauxGraisse) {
		if(tauxGraisse < 0 ) {
			this.tauxGraisse = 0;
		}
		else if(tauxGraisse > 1) {
			this.tauxGraisse = 1;
		}
		else 
			this.tauxGraisse = tauxGraisse;
	}


	public double getGras() {
		return gras;
	}


	public void setGras(double gras) {
		if(gras < 0) {
			this.gras = 0;
		}
		this.gras = gras;
	}


	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		if(poids < 0) {
			this.poids = 0;
		}
		this.poids = poids;
	}


	@Override
	public String toString() {
		return "ViandePoisson{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", calorie=" + calorie +
				", bio=" + bio +
				", tauxGraisse=" + tauxGraisse +
				", gras=" + gras +
				", poids=" + poids +
				"g}";
	}
}

