package TokChef.Alimentation;

import java.io.Serializable;

public class Consigne implements Serializable{
	private static final long serialVersionUID = 1L;
	protected Etat etat;
	protected double quantite;


	public Consigne(Etat etat, double quantite) {
		this.setEtat(etat);
		this.setQuantite(quantite);
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		if(quantite <0) {
			this.quantite = 0;
		}
		else
			this.quantite = quantite;
	}

	public String toStringEpice() {
		return "Consigne{" +
				"etat=" + etat +
				", pincee=" + quantite +
				'}';
	}


}



