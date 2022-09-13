package TokChef.Concours;

import TokChef.Alimentation.Plat;
import TokChef.Exception.ConcoursException;
import TokChef.Personnes.Chef;
import TokChef.Personnes.Jury;
import TokChef.Personnes.Padawan;

import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Concours {
    protected static final AtomicInteger count = new AtomicInteger(0);
    protected final int id;
    protected List<Jury> jurys;
    public List<Chef> chefs;
    protected List<Padawan> padawans;
    protected Date dateConcoursDebut;
    protected boolean statut;
    protected HashMap<Chef, Plat> platPresente;
    protected HashMap<Chef, Integer> resultat;
    public Chef vainqueurConcours;
    public static List<Concours> listeDeConcoursPasse = new ArrayList<>();
    public static List<Concours> listeDeConcoursPrevu = new ArrayList<>();

    public Concours(List<Jury> jury, List<Chef> chefs, Date dateConcoursDebut) {
        this.id = count.incrementAndGet();
        this.setJurys(jury);
        this.setChefs(chefs);
        this.setDateConcoursDebut(dateConcoursDebut);
        this.setStatut(false);
        this.setPlatPresente(new HashMap<Chef, Plat>());
        this.setResultat(new HashMap<Chef, Integer>());
        this.setPadawans(new ArrayList<Padawan>());
        this.setVainqueurConcours(null);
        for (Chef c : getChefs()) {
            this.getResultat().put(c, -1);

            int i = ((int) (Math.random() * c.getPlatsDuChef().size()));
            if (i <= 0) {
                i = 1;
            }
            this.getPlatPresente().put(c, c.getPlatsDuChef().get(i));

            for (Padawan p : Padawan.getListePadawan()) {
                if (p.getChefReferent().equals(c)) {
                    this.getPadawans().add(p);
                }
            }
        }
        listeDeConcoursPrevu.add(this);
    }

    // Valide les 3 membres du jury

    public boolean validationJury() {
        if (getJurys() == null) {
            return false;
        } else if (getJurys().size() != 3) {
            return false;
        } else {
            return true;
        }
    }

    // Valide les chefs si il sont supperieur à 5

    public boolean validationChef() {
        if (getChefs() == null) {
            return false;
        } else if (getChefs().size() < 5) {
            return false;
        } else {
            return true;
        }
    }

    // Valide la date si il n'y en a pas d'autres de prévu ou en cours

    public boolean validationDate() {
        for (Concours concours : listeDeConcoursPrevu) {
            if (this != concours && concours.isStatut()) {
                return false;
            }
            if (this != concours && concours.getDateConcoursDebut().before(this.getDateConcoursDebut())) {
                return false;
            }
        }
        return true;
    }


    // Valide si le plat du chef est correct

    public boolean validationPlatsChefs() {
        for (Chef c : chefs) {
            if (c.getPlatsDuChef() == null) {
                return false;
            } else if (c.getPlatsDuChef().size() < 1) {
                return false;
            }

            //CONSEIL DE DISCIPLINE
            /*
             else if (c.getPlatsDuChef() != getPlatPresente().get(c)) {
                return false;
            }
            */
        }
        return true;
    }

    // Valide le bon fonctionnement global du concours

    public boolean validationGlobale() {
        return validationJury() && validationChef() && validationDate() && validationPlatsChefs();
    }

    // affecte une note du Jury pour un chef

    public void noteDuJuryParChef(Chef c){
                getResultat().put(c, ((int) (Math.random() * 9 + 1)));
    }

    public void notesDuJuryGenerales() throws ConcoursException {
            for (Chef c : getResultat().keySet()) {
                getResultat().put(c, ((int) (Math.random() * 9 + 1)));
            }
    }

    // Defini quel chef à gagner le concours

    public void vainqueurConcours() {
            Chef v = null;
            int max = -1;
            for (Chef c : getResultat().keySet()) {
                if (max < getResultat().get(c)) {
                    max = getResultat().get(c);
                    v = c;
                }
            }
            this.setVainqueurConcours(v);
    }

    // Augmente de 1 etoile le chef gagant (si etoile >3 le setter fixe le nombre à 3)

    public void vainqueurEtoile() throws ConcoursException {
        getVainqueurConcours().setEtoile((getVainqueurConcours().getEtoile()) + 1);
    }


    // Fait defenir le padawan le plus vieux du vainqueur en Chef

    public Chef padawanVersChef() {
            List<Padawan> listePadawanVainqueur = new ArrayList<>();


            for (Padawan p : padawans) {
                if (getVainqueurConcours() == p.getChefReferent()) {
                    listePadawanVainqueur.add(p);
                }
            }
            if (listePadawanVainqueur.size() > 0) {
                Padawan pVainqueurAge = listePadawanVainqueur.get(0);
                for (Padawan padw : listePadawanVainqueur) {
                    if (pVainqueurAge.getDatePadawan().after(padw.getDatePadawan())) {
                        pVainqueurAge = padw;
                    }
                }
                Chef c = new Chef(pVainqueurAge.getNom(), pVainqueurAge.getPrenom(), pVainqueurAge.getGenre(), pVainqueurAge.getTelephone(), 0, getVainqueurConcours().getSpecialite(), platPresente.get(getVainqueurConcours()));
                Chef.listeChef.add(c);
                Padawan.listePadawan.remove(pVainqueurAge);
                return c;
            } else {
                return null;
            }
    }

    // Défini la fin du concours

    public Concours finConcours() throws ConcoursException {
            this.setStatut(false);
            return this;
    }

    // Fait passer le concours de la liste en cours vers la liste des concours passé

    public Concours passeConcours() throws ConcoursException {
            listeDeConcoursPasse.add(this);
            listeDeConcoursPrevu.remove(this);
            return this;
    }



    //  Permet d'obtenir la liste des concours passé pour un chef

    public static List<Concours> ConcoursPasseChef(Chef chef) {
        List<Concours> listeCouncoursChef = new ArrayList<Concours>();
        for (Concours concours : listeDeConcoursPasse) {
            for (Chef c : concours.getChefs()) {
                if (chef == c) {
                    listeCouncoursChef.add(concours);
                }
            }
        }
        return listeCouncoursChef;
    }


    //  Permet d'obtenir la liste des concours inscrit par un chef

    public static List<Concours> ConcoursPrevuChef(Chef chef) {
        List<Concours> listeCouncoursChef = new ArrayList<Concours>();
        for (Concours concours : listeDeConcoursPrevu) {
            for (Chef c : concours.getChefs()) {
                if (chef == c) {
                    listeCouncoursChef.add(concours);
                }
            }
        }
        return listeCouncoursChef;
    }


    // Permet d'obtenir la liste des concours auquel un chef a participé et est inscrit

    public List<Concours> ConcoursChef(Chef chef) {
        List<Concours> listeToutConcours = new ArrayList<Concours>();
        List<Concours> listeCouncoursChef = new ArrayList<Concours>();
        for (Concours concoursPrevu : listeDeConcoursPrevu) {
            listeToutConcours.add(concoursPrevu);
        }
        for (Concours concoursPasse : listeDeConcoursPasse) {
            listeToutConcours.add(concoursPasse);
        }
        for (Concours concours : listeToutConcours) {
            for (Chef c : concours.getChefs()) {
                if (chef == c) {
                    listeCouncoursChef.add(concours);
                }
            }
        }
        return listeCouncoursChef;
    }



    // automatisme le concours  (Affichage pas obligatoire)

    public Concours automatiqueConcours() throws ConcoursException {
        if (validationGlobale()) {
            setStatut(true);
    //      System.out.println("Statut : " + this.isStatut());
            notesDuJuryGenerales();
    /*      for (Chef c : chefs) {
                System.out.println(c.getNom() + " : " + getResultat().get(c) + " " + getPlatPresente().get(c));
            }
     */
            vainqueurConcours();
    //       System.out.println("Vainqueur : " + getVainqueurConcours().getNom());
            vainqueurEtoile();
    //      System.out.println("Etoile : " + getVainqueurConcours().getEtoile());
    //      System.out.println("Padawan->Chef :" + padawanVersChef());
            finConcours();
    //        System.out.println("Statut : " + this.isStatut());
            passeConcours();
            return this;
        } else throw new ConcoursException();
    }


    public static AtomicInteger getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public List<Jury> getJurys() {
        return jurys;
    }

    public void setJurys(List<Jury> jurys) {
        this.jurys = jurys;
    }

    public List<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }

    public List<Padawan> getPadawans() {
        return padawans;
    }

    public void setPadawans(List<Padawan> padawans) {
        this.padawans = padawans;
    }

    public Date getDateConcoursDebut() {
        return dateConcoursDebut;
    }

    public void setDateConcoursDebut(Date dateConcoursDebut) {
        this.dateConcoursDebut = dateConcoursDebut;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public HashMap<Chef, Integer> getResultat() {
        return resultat;
    }

    public void setResultat(HashMap<Chef, Integer> resultat) {
        this.resultat = resultat;
    }

    public static List<Concours> getListeDeConcoursPasse() {
        return listeDeConcoursPasse;
    }

    public static void setListeDeConcoursPasse(List<Concours> listeDeConcoursPasse) {
        Concours.listeDeConcoursPasse = listeDeConcoursPasse;
    }

    public static List<Concours> getListeDeConcoursPrevu() {
        return listeDeConcoursPrevu;
    }

    public static void setListeDeConcoursPrevu(List<Concours> listeDeConcoursPrevu) {
        Concours.listeDeConcoursPrevu = listeDeConcoursPrevu;
    }

    public HashMap<Chef, Plat> getPlatPresente() {
        return platPresente;
    }

    public void setPlatPresente(HashMap<Chef, Plat> platPresente) {
        this.platPresente = platPresente;
    }

    public Chef getVainqueurConcours() {
        return vainqueurConcours;
    }

    public void setVainqueurConcours(Chef vainqueurConcours) {
        this.vainqueurConcours = vainqueurConcours;
    }

    public String toString() {
        return "Concours{" +
                "id=" + id +
                ", jurys=" + jurys +
                ", chefs=" + chefs +
                ", padawans=" + padawans +
                ", dateConcoursDebut=" + dateConcoursDebut +
                ", statut=" + statut +
                ", platPresente=" + platPresente +
                ", resultat=" + resultat +
                ", vainqueurConcours=" + vainqueurConcours +
                '}';
    }
}




