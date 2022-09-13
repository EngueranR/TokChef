package TokChef.Personnes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Padawan extends Personne{
	protected Chef chefReferent;
	protected Date datePadawan;
	public static List<Padawan> listePadawan = new ArrayList<>();
	
	
	
	public Padawan(String nom, String prenom, Genre genre, String telephone, Chef chefReferent, Date dateChefReferent) {
		super(nom, prenom, genre,telephone);
		this.setChefReferent(chefReferent);
		this.setDatePadawan(dateChefReferent);
		listePadawan.add(this);
	}
	
	// Lorsque la date n'est pas precisé on met la date du jour.
	public Padawan(String nom, String prenom, Genre genre,String telephone, Chef chefReferent){
		super(nom, prenom, genre,telephone);
		this.setChefReferent(chefReferent);
		this.setDatePadawan(new Date());
		listePadawan.add(this);
	}


	public Chef getChefReferent() {
		return chefReferent;
	}
	

	public void setChefReferent(Chef chefReferent) {
		if(chefReferent == null) {
			// a remplir (avec erreur)
		}
		this.chefReferent = chefReferent;
	}

	public Date getDatePadawan() {
		return datePadawan;
	}

	public void setDatePadawan(Date datePadawan) {
		this.datePadawan = datePadawan;
	}

	public static List<Padawan> getListePadawan() {
		return listePadawan;
	}

	public static void setListePadawan(List<Padawan> listePadawan) {
		Padawan.listePadawan = listePadawan;
	}

	public String toString() {
		return "Padawan{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", genre=" + genre +
				", telephone='" + telephone + '\'' +
				", chefReferent= [ " + chefReferent +
				" ], dateChefReferent= " + datePadawan +
				'}';
	}
}


