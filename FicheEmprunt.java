import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FicheEmprunt{

    private Client      client;
    private Document    document;
    private Date        dateDebut;
    private Date        dateFin;
    private Date        dateRappel;
    private int         prolongation;
    private boolean     enRetard;

    FicheEmprunt(Client client, Document document){
        this.client = client;
        this.document = document;
        Calendar calendar = Calendar.getInstance();
        this.dateDebut = calendar.getTime();
        calendar.add(calendar.DAY_OF_MONTH,document.getDureeEmprunt());
        this.dateFin = calendar.getTime();
        calendar.add(calendar.DAY_OF_MONTH, -7);
        this.dateRappel = calendar.getTime();
        this.prolongation = 0;
        this.enRetard = false;
    }

    public String toString(){
        String str = "";
        str += "\""+document.getTitre()+"\" de "+document.getAuteur()+"\n";
        str += "Emprunté par: "+client.getPrenom()+" "+client.getNom().toUpperCase()+"\n";
        SimpleDateFormat dateFormatter = new SimpleDateFormat("d/M/Y");
        str += "Le: "+dateFormatter.format(dateDebut)+"\n";
        str += "A rendre avant le "+dateFormatter.format(dateFin)+"\n";
        str += "Prolongé "+prolongation+" fois\n";
        str += "En retard? ";
        if(enRetard){
            str += "Oui\n";
        } else {
            str += "Non\n";
        }
        return str;
    }
    public Client getClient(){
        return this.client;
    }
    public Document getDocument(){
        return this.document;
    }
    public Date getDateDebut(){
        return this.dateDebut;
    }
    public Date getDateFin(){
        return this.dateFin;
    }
    public Date getDateRappel(){
        return this.dateRappel;
    }
    public int getProlongation(){
        return this.prolongation;
    }
    public boolean getEnRetard(){
        return this.enRetard;
    }

    public void prolongeEmprunt(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.dateFin);
        calendar.add(calendar.DAY_OF_MONTH,document.getDureeEmprunt());
        this.dateFin = calendar.getTime();
        calendar.add(calendar.DAY_OF_MONTH, -7);
        this.dateRappel = calendar.getTime();
        this.prolongation++;
    }

}