package TokChef.Personnes;

public class Jury extends Personne {
	
	protected int participation;

	
	public Jury(String nom, String prenom, Genre genre, String telephone) {
			super(nom, prenom, genre,telephone);
			this.setParticipation(0);
			
	}


	public int getParticipation() {
		return participation;
	}


	public void setParticipation(int participation) {
		this.participation = participation;
	}



	public String toString() {
		return "Jury{" +
				"participation=" + participation +
				", id=" + id +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", genre=" + genre +
				", telephone='" + telephone + '\'' +
				'}';
	}
}



