
public class Main{

    public static void main(String[] args) {

        //---------------------------TEST DOCUMENT--------------------------------------
        Audio cd = new Audio("Citizen of Glass", "Agnes Obel", 2016, "FZ6J63CJ8", "Classique", "Musique", "Classique", 40);
        Audio cd2 = new Audio("Aventine", "Agnes Obel", 2013, "ZGEJ634", "Classique", "Musique", "Classique", 37);
        Video dvd = new Video("Mommy", "Xavier Dolan", 2015, "JGR345J0", "Drame", "DVD", "Drame", 125);
        Livre livre = new Livre("Are you my mother?", "Alison Bechdel", 2006, "FZD9YE4", "Roman graphique", "Adulte", "BD", 157);

        Adresse adresse = new Adresse(12, "rue", "des pommiers", 75012, "Paris", "France");
        Client client = new Client("Smith","John", adresse, CategorieClient.ETUDIANT);
        Employe emp = new Employe("admin","admin",adresse,"admin","admin");
        FicheEmprunt fiche = new FicheEmprunt(client, dvd);

        Mediatheque med = new Mediatheque("Helene_Berr");
        med.addDocument(cd);
        med.addDocument(cd2);
        med.addDocument(dvd);
        med.addDocument(livre);
        med.addFicheEmprunt(fiche);
        med.addClient(client);
        med.addEmploye(emp);
        try{
            boolean res;
            res = med.sauvegardeMediatheque();
            System.out.println("Sauvegarde : "+res+"\n");
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
