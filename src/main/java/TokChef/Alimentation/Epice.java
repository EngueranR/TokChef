package TokChef.Alimentation;

import javax.persistence.Entity;

@Entity
public class Epice extends Ingredient {
	private static final long serialVersionUID = 1L;
	protected boolean bio;

	public Epice(String nom, boolean bio) {
		super(nom);
		this.setBio(bio);
	}

	public Epice() {

	}

	public boolean isBio() {
		return bio;
	}

	public void setBio(boolean bio) {
		this.bio = bio;
	}


	public String toString() {
		return "Epice{" +
				"bio=" + bio +
				", id=" + id +
				", nom='" + nom + '\'' +
				'}';
	}
}
