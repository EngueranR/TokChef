package TokChef.Personnes;

import java.util.concurrent.atomic.AtomicInteger;

public class Personne {
	protected static final AtomicInteger count = new AtomicInteger(0);
	protected final int id;
	protected String nom;
	protected String prenom;
	protected Genre genre;
	protected String telephone;

	public Personne(String nom, String prenom, Genre genre, String telephone) {
		this.id = count.incrementAndGet();
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.telephone = telephone;
	}

    public int getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Genre getGenre() {
		return genre;
	}


	public static AtomicInteger getCount() {
		return count;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setGenre(Genre genre) {this.genre = genre;

	}
}

