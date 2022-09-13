package TokChef.Alimentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

import fr.sofianelecubeur.dataserializer.CompilationType;
import fr.sofianelecubeur.dataserializer.FileSerializerBuilder;
import fr.sofianelecubeur.dataserializer.JsonFileSerializer;

@Entity

public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;
    protected static final AtomicInteger count = new AtomicInteger(0);
    @Id
    protected final int id;
    protected String nom;
    public static List<Ingredient> listeIngredient = new ArrayList<>();


    public Ingredient(String nom) {
        this.id = count.incrementAndGet();
        this.setNom(nom);
        listeIngredient.add(this);
    }

    public Ingredient() {
        this.id = count.incrementAndGet();
    }


    public static void serializeIngredient() throws IOException {
        JsonFileSerializer serializer = (JsonFileSerializer) new FileSerializerBuilder().type(CompilationType.JSON).get();
        serializer.writeObject("listeIngredient", getListeIngredient());
        serializer.compile(new File("ListeIng/listeIngredient.json"));
        serializer.close();
    }


    public static void sauvegardeIngredient() throws IOException {
        File fichier = new File("sauvegarde/ingredientSerialize.ser");

        // ouverture d'un flux sur un fichier
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));

        // sérialization de l'objet
        oos.writeObject(listeIngredient);

        // fermeture du flux dans le bloc finally
        oos.close();
    }


    public static List<Ingredient> chargeIngredient() throws IOException, ClassNotFoundException {
        // on simplifie le code en retirant la gestion des exceptions
        File fichier = new File("sauvegarde/ingredientSerialize.ser");

        // ouverture d'un flux sur un fichier
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier));

        // désérialization de l'objet
        List<Ingredient> listeIngredient = (List<Ingredient>) ois.readObject();

        // fermeture du flux dans le bloc finally
        ois.close();
        return listeIngredient;
    }

    public boolean persist() {
        boolean b;
        EntityManagerFactory baseDeDonnees = Persistence.createEntityManagerFactory("IngredientService");
        EntityManager em = baseDeDonnees.createEntityManager();
        em.getTransaction().begin();
        em.persist(this);
        try {
            em.getTransaction().commit();
            b = true;
        } catch (Exception e) {
            b = false;
        }
        em.close();
        baseDeDonnees.close();
        return b;
    }

    public static Ingredient persistLoad(long id) {
        EntityManagerFactory baseDeDonnees = Persistence.createEntityManagerFactory("IngredientService");
        EntityManager em = baseDeDonnees.createEntityManager();
        em.getTransaction().begin();
        Ingredient ing = em.find(Ingredient.class, id);
        em.close();
        baseDeDonnees.close();
        return ing;
    }


    public static AtomicInteger getCount() {
        return count;
    }

    public static List<Ingredient> getListeIngredient() {
        return listeIngredient;
    }

    public static void setListeIngredient(List<Ingredient> listeIngredient) {
        Ingredient.listeIngredient = listeIngredient;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getId() {
        return id;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id && Objects.equals(nom, that.nom);
    }

    public int hashCode() {
        return Objects.hash(id, nom);
    }


    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}	