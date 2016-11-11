import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main{

    public static void main(String[] args) {

        //---------------------------TEST DOCUMENT--------------------------------------
        Audio cd = new Audio("Citizen of Glass", "Agnes Obel", 2016, "FZ6J63CJ8", "Classique", "Musique", "Classique", 40);
        Video dvd = new Video("Mommy", "Xavier Dolan", 2015, "JGR345J0", "Drame", "DVD", "Drame", 125);
        Livre livre = new Livre("Are you my mother?", "Alison Bechdel", 2006, "FZD9YE4", "Roman graphique", "Adulte", "BD", 157);
        /*
        System.out.println(cd);
        System.out.println(dvd);
        System.out.println(livre);
        */
        Adresse adresse = new Adresse(12, "rue", "des pommiers", 75012, "Paris", "France");
        Client client = new Client("Smith","John", adresse, CategorieClient.ETUDIANT);
        FicheEmprunt fiche = new FicheEmprunt(client, dvd);
        //System.out.println(client);
        //System.out.println(fiche);

        Mediatheque med = new Mediatheque("Lennon");
        med.addDocument(cd);
        med.addDocument(dvd);
        med.addDocument(livre);
        med.addFicheEmprunt(fiche);
        med.addClient(client);
        try{
            boolean res;
            System.out.println(med);
            Audio cd2 = new Audio("Aventine", "Agnes Obel", 2013, "ZGEJ634", "Classique", "Musique", "Classique", 37);
            med.addDocument(cd2);
            res = med.sauvegardeMediatheque();
            System.out.println("Sauvegarde : "+res+"\n");
            Mediatheque med2 = new Mediatheque("Lennon bis");
            res = med2.initMediatheque("MEDIATHEQUE_Lennon");
            System.out.println("Init : "+res+"\n");
            System.out.println(med2);
        } catch(Exception e) {
            e.printStackTrace();
        }

        /*
        //---------------------------TEST CALENDAR--------------------------------------
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("d/M/Y");
        Date dateDebut = calendar.getTime();
        calendar.add(calendar.DAY_OF_MONTH,-7);
        Date dateFin = calendar.getTime();
        System.out.println("Today is : "+dateFormatter.format(dateDebut));
        System.out.println("Last week was : "+dateFormatter.format(dateFin));
        */
    }
}
