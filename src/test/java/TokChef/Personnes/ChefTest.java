package TokChef.Personnes;

import TokChef.Alimentation.Plat;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChefTest {

    protected String telephone = "0610203040";
    protected Specialite specialite = Specialite.PATISIER;
    protected int etoile = 1;
    protected Plat p1 = new Plat(null,"plat Test 1");
    protected Plat p2 = new Plat(null,"plat Test 2");
    protected List<Plat> listeP = new ArrayList<>();


    @Test
    public void setEtoile() {

        final String FILENAME = "Fichier.txt";
        BufferedReader bufferedreader = null;
        FileReader filereader = null;

        try {
            filereader = new FileReader(FILENAME);
            bufferedreader = new BufferedReader(filereader);

            // Lecture fichier pour le nom
            String cNom = bufferedreader.readLine();

            // Lecture fichier pour le prénom
            String cPrenom = bufferedreader.readLine();

            // Lecture fichier pour le genre + conversion String en Genre
            String genre = bufferedreader.readLine();
            Genre cGenre = Genre.valueOf(genre);

            // Lecture fichier pour le telephone
            String cTelephone = bufferedreader.readLine();

            // Lecture fichier pour le specialité + conversion String en Specialite
            String specialite = bufferedreader.readLine();
            Specialite cSpecialite = Specialite.valueOf(specialite);

            // Lecture fichier pour les étoiles + conversion String en int
            String etoile = bufferedreader.readLine();
            int cEtoile = Integer.parseInt(etoile);

            // Création de la liste de plat NULL
            List<Plat> cListeP = new ArrayList<Plat>();


            Chef cTest = new Chef(cNom, cPrenom, cGenre, cTelephone, cEtoile, cSpecialite, cListeP);
            cTest.setEtoile(cEtoile);
            assertTrue("setEtoile ne fonctionne pas (Etoile du chef = "+cTest.getEtoile()+ ")", cTest.getEtoile()>=0 && cTest.getEtoile()<=3);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedreader != null)
                    bufferedreader.close();
                if (filereader != null)
                    filereader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}