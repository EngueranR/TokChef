package TokChef.Concours;

import TokChef.Alimentation.Plat;
import TokChef.Personnes.Chef;
import TokChef.Personnes.Genre;
import TokChef.Personnes.Jury;
import TokChef.Personnes.Specialite;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ConcoursTest {

    @Test
    public void validationJury() {

        Jury j1 = new Jury("jNom1","jPrenom1", Genre.HOMME,"0000000001");
        Jury j2 = new Jury("jNom2","jPrenom2", Genre.FEMME,"0000000002");
        Jury j3 = new Jury("jNom3","jPrenom3", Genre.NON_BINAIRE,"0000000003");
        Jury j4 = new Jury("jNom4","jPrenom4", Genre.ORDINATEUR,"0000000004");

        List<Jury> listeJury1= new ArrayList<Jury>();
        listeJury1.add(j1);

        List<Jury> listeJury2 = new ArrayList<Jury>();
        listeJury2.add(j1);
        listeJury2.add(j2);

        List<Jury> listeJury3 = new ArrayList<Jury>();
        listeJury3.add(j1);
        listeJury3.add(j2);
        listeJury3.add(j3);

        List<Jury> listeJury4 = new ArrayList<Jury>();
        listeJury4.add(j1);
        listeJury4.add(j2);
        listeJury4.add(j3);
        listeJury4.add(j4);

        List<Chef> listeChef= new ArrayList<Chef>();


        // Mettre commentaire explication
        Concours concours1 = new Concours(listeJury1,listeChef,null);
        assertFalse("validationJury ne fonctionne pas (1)",concours1.validationJury());

        Concours concours2 = new Concours(listeJury2,listeChef,null);
        assertFalse("validationJury ne fonctionne pas (2)",concours2.validationJury());

        Concours concours3 = new Concours(listeJury3,listeChef,null);
        assertTrue("validationJury ne fonctionne pas (3)",concours3.validationJury());

        Concours concours4 = new Concours(listeJury4,listeChef,null);
        assertFalse("validationJury ne fonctionne pas (4)",concours4.validationJury());
    }

    @Test
    public void validationChef() {


        List<Plat> listePlat = new ArrayList<Plat>();
        Plat p1 = new Plat(null,"plat Test 1");
        Plat p2 = new Plat(null,"plat Test 2");
        listePlat.add(p1);
        listePlat.add(p2);

        Chef c1 = new Chef("cNom1","cPrenom1", Genre.HOMME,"0000000001",1, Specialite.PATISIER,listePlat);
        Chef c2 = new Chef("cNom2","cPrenom2", Genre.FEMME,"0000000002",1,Specialite.AUTRES,listePlat);
        Chef c3 = new Chef("cNom3","cPrenom3", Genre.NON_BINAIRE,"0000000003",1,Specialite.CUISINER,listePlat);
        Chef c4 = new Chef("cNom4","cPrenom4", Genre.ORDINATEUR,"0000000004",1,Specialite.TRAVAIL_A_DISTANCE,listePlat);
        Chef c5 = new Chef("cNom5","cPrenom5", Genre.FEMME,"0000000005",1,Specialite.TRAVAIL_A_DISTANCE,listePlat);
        Chef c6 = new Chef("cNom6","cPrenom6", Genre.HOMME,"0000000006",1,Specialite.TRAVAIL_A_DISTANCE,listePlat);

        List<Chef> listeChef1= new ArrayList<Chef>();
        listeChef1.add(c1);

        List<Chef> listeChef2 = new ArrayList<Chef>();
        listeChef2.add(c1);
        listeChef2.add(c2);

        List<Chef> listeChef3 = new ArrayList<Chef>();
        listeChef3.add(c1);
        listeChef3.add(c2);
        listeChef3.add(c3);

        List<Chef> listeChef4 = new ArrayList<Chef>();
        listeChef4.add(c1);
        listeChef4.add(c2);
        listeChef4.add(c3);
        listeChef4.add(c4);

        List<Chef> listeChef5 = new ArrayList<Chef>();
        listeChef5.add(c1);
        listeChef5.add(c2);
        listeChef5.add(c3);
        listeChef5.add(c4);
        listeChef5.add(c5);

        List<Chef> listeChef6 = new ArrayList<Chef>();
        listeChef6.add(c1);
        listeChef6.add(c2);
        listeChef6.add(c3);
        listeChef6.add(c4);
        listeChef6.add(c5);
        listeChef6.add(c6);


        List<Jury> listeJury= new ArrayList<Jury>();
        Date d = null;
        Concours concours1 = new Concours(listeJury,listeChef1,d);
        assertFalse("validationChef ne fonctionne pas (1)",concours1.validationChef());

        Concours concours2 = new Concours(listeJury,listeChef2,d);
        assertFalse("validationChef ne fonctionne pas (2)",concours2.validationChef());

        Concours concours3 = new Concours(listeJury,listeChef3,d);
        assertFalse("validationChef ne fonctionne pas (3)",concours3.validationChef());

        Concours concours4 = new Concours(listeJury,listeChef4,d);
        assertFalse("validationChef ne fonctionne pas (4)",concours4.validationChef());

        Concours concours5 = new Concours(listeJury,listeChef5,d);
        assertTrue("validationChef ne fonctionne pas (4)",concours5.validationChef());

        Concours concours6 = new Concours(listeJury,listeChef6,d);
        assertTrue("validationChef ne fonctionne pas (6)",concours6.validationChef());
    }



    @Test
    public void validationDate() throws ParseException {
        List<Chef> listeChef= new ArrayList<Chef>();
        List<Jury> listeJury= new ArrayList<Jury>();

        String dateString1 = "02/01/2021";
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateString1);
        Concours concours1 = new Concours(listeJury, listeChef, date1);

        String dateString2 = "03/01/2021";
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateString2);
        Concours concours2 = new Concours(listeJury, listeChef, date2);

        String dateString3 = "04/01/2021";
        Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse(dateString3);
        Concours concours3 = new Concours(listeJury, listeChef, date3);

        String dateString0 = "05/01/2021";
        Date date0 = new SimpleDateFormat("dd/MM/yyyy").parse(dateString0);
        Concours concours0 = new Concours(listeJury, listeChef, date0);

        // True ne fonctionne pas surement à cause de listeConcoursPrevu
        assertTrue("validationDate ne fonctionne pas (1)", concours1.validationDate());
        concours1.setStatut(true);
        assertFalse("validationDate ne fonctionne pas (2)", concours2.validationDate());
        concours2.setStatut(true);
        assertFalse("validationDate ne fonctionne pas (4)", concours3.validationDate());
        concours3.setStatut(true);
        assertFalse("validationDate ne fonctionne pas (0)", concours0.validationDate());
        concours0.setStatut(true);
        // FOnction passe concours
    }

    @Test
    public void validationPlatsChefs() {
        List<Plat> listePlat = new ArrayList<Plat>();
        Plat p1 = new Plat(null,"plat Test 1");
        Plat p2 = new Plat(null,"plat Test 2");
        listePlat.add(p1);
        listePlat.add(p2);

        Chef c1 = new Chef("cNom1","cPrenom1", Genre.HOMME,"0000000001",1, Specialite.PATISIER,listePlat);
        Chef c2 = new Chef("cNom2","cPrenom2", Genre.FEMME,"0000000002",1,Specialite.AUTRES,listePlat);
        Chef c3 = new Chef("cNom3","cPrenom3", Genre.NON_BINAIRE,"0000000003",1,Specialite.CUISINER,listePlat);
        Chef c4 = new Chef("cNom4","cPrenom4", Genre.ORDINATEUR,"0000000004",1,Specialite.TRAVAIL_A_DISTANCE,listePlat);
        Chef c5 = new Chef("cNom5","cPrenom5", Genre.FEMME,"0000000005",1,Specialite.TRAVAIL_A_DISTANCE,listePlat);

        List<Chef> listeChef = new ArrayList<Chef>();
        listeChef.add(c1);
        listeChef.add(c2);
        listeChef.add(c3);
        listeChef.add(c4);
        listeChef.add(c5);

        List<Jury> listeJury= new ArrayList<Jury>();
        Date d = null;

        Concours concours1 = new Concours(listeJury,listeChef,d);

        assertTrue("validationPlatsChefs ne fonctionne pas (1)",concours1.validationPlatsChefs());
    }

    @Test
    public void validationGlobale() {
    }

    @Test
    public void noteDuJuryParChef() {
    }

    @Test
    public void notesDuJuryGenerales() {
    }

    @Test
    public void vainqueurConcours() {
    }

    @Test
    public void vainqueurEtoile() {
    }

    @Test
    public void padawanVersChef() {
    }

    @Test
    public void finConcours() {
    }

    @Test
    public void passeConcours() {
    }

    @Test
    public void concoursPasseChef() {
    }

    @Test
    public void concoursPrevuChef() {
    }

    @Test
    public void concoursChef() {
    }

    @Test
    public void automatiqueConcours() {
    }


}