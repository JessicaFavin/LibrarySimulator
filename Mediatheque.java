
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

public class Mediatheque implements Serializable {

    private String nomMediatheque;
    private ArrayList<Document> listeDocuments;
    private ArrayList<FicheEmprunt> listeFicheEmprunts;
    private ArrayList<Client> listeClients;
    private ArrayList<Employe> listeEmployes;

    public Mediatheque(String nom){
        this.nomMediatheque = nom;
        this.listeDocuments = new ArrayList<Document>();
        this.listeFicheEmprunts = new ArrayList<FicheEmprunt>();
        this.listeClients = new ArrayList<Client>();
        this.listeEmployes = new ArrayList<Employe>();
    }

    public Mediatheque(String nom, String pathname){
        this.nomMediatheque = nom;
        this.listeDocuments = new ArrayList<Document>();
        this.listeFicheEmprunts = new ArrayList<FicheEmprunt>();
        this.listeClients = new ArrayList<Client>();
        this.listeEmployes = new ArrayList<Employe>();
        try{
            this.initMediatheque(pathname);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        String str = "";
        str+="Mediathèque "+nomMediatheque+"\n";
        str+="Nombres de documents: "+listeDocuments.size()+"\n";
        str+="Nombres de clients: "+listeClients.size()+"\n";
        str+="Nombres d'employés: "+listeEmployes.size()+"\n";
        str+="Nombres d'emprunts: "+listeFicheEmprunts.size()+"\n";
        return str;
    }

    public boolean initMediatheque() throws DataBaseException {
        //open BDD file named "MEDIATHEQUE"+nomMediatheque
        //read documents and number of doc
        //read fichemeprunts and number of ficheemprunt
        //read clients and number of clients
        ObjectInputStream ois = null;
        try{
            File fichier =  new File("MEDIATHEQUE_"+nomMediatheque);
            ois =  new ObjectInputStream(new FileInputStream(fichier));
            String flag;
            Integer taille;

            flag = (String) ois.readObject();
            if(!flag.equals("Documents")) throw new DataBaseException();
            taille = (Integer) ois.readObject();
            Document document;
            for(int i=0; i<taille; i++){
                document = (Document) ois.readObject();
                listeDocuments.add(document);
            }

            flag = (String) ois.readObject();
            if(!flag.equals("FicheEmprunts")) throw new DataBaseException();
            taille = (Integer) ois.readObject();
            FicheEmprunt fiche;
            for(int i=0; i<taille; i++){
                fiche = (FicheEmprunt) ois.readObject();
                listeFicheEmprunts.add(fiche);
            }

            flag = (String) ois.readObject();
            if(!flag.equals("Clients")) throw new DataBaseException();
            taille = (Integer) ois.readObject();
            Client client;
            for(int i=0; i<taille; i++){
                client = (Client) ois.readObject();
                listeClients.add(client);
            }

            flag = (String) ois.readObject();
            if(!flag.equals("Employes")) throw new DataBaseException();
            taille = (Integer) ois.readObject();
            Employe employe;
            for(int i=0; i<taille; i++){
                employe = (Employe) ois.readObject();
                listeEmployes.add(employe);
            }
        } catch (NullPointerException e) {
            System.out.println("INIT.Fichier de BDD introuvable.");
            return false;
        } catch(IOException ex) {
            System.out.println("INIT.IOException problem.");
            ex.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if (ois != null) ois.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    public boolean initMediatheque(String pathname) throws DataBaseException {
        //open BDD file named "MEDIATHEQUE"+nomMediatheque
        //read documents and number of doc
        //read fichemeprunts and number of ficheemprunt
        //read clients and number of clients
        ObjectInputStream ois = null;
        try{
            File fichier =  new File(pathname);
            ois =  new ObjectInputStream(new FileInputStream(fichier));
            String flag;
            Integer taille;

            flag = (String) ois.readObject();
            if(!flag.equals("Documents")) throw new DataBaseException();
            taille = (Integer) ois.readObject();
            Document document;
            for(int i=0; i<taille; i++){
                document = (Document) ois.readObject();
                listeDocuments.add(document);
            }

            flag = (String) ois.readObject();
            if(!flag.equals("FicheEmprunts")) throw new DataBaseException();
            taille = (Integer) ois.readObject();
            FicheEmprunt fiche;
            for(int i=0; i<taille; i++){
                fiche = (FicheEmprunt) ois.readObject();
                listeFicheEmprunts.add(fiche);
            }

            flag = (String) ois.readObject();
            if(!flag.equals("Clients")) throw new DataBaseException();
            taille = (Integer) ois.readObject();
            Client client;
            for(int i=0; i<taille; i++){
                client = (Client) ois.readObject();
                listeClients.add(client);
            }

            flag = (String) ois.readObject();
            if(!flag.equals("Employes")) throw new DataBaseException();
            taille = (Integer) ois.readObject();
            Employe employe;
            for(int i=0; i<taille; i++){
                employe = (Employe) ois.readObject();
                listeEmployes.add(employe);
            }
        } catch (NullPointerException e) {
            System.out.println("INIT.Fichier de BDD introuvable.");
            return false;
        } catch(IOException ex) {
            System.out.println("INIT.IOException problem.");
            ex.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if (ois != null) ois.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    public boolean sauvegardeMediatheque(){
        //open BDD file named "MEDIATHEQUE"+nomMediatheque
        //read documents and number of doc
        //read fichemeprunts and number of ficheemprunt
        //read clients and number of clients
        ObjectOutputStream oos = null;
        try{
            File fichier =  new File("MEDIATHEQUE_"+nomMediatheque) ;
            oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
            String flag;
            Integer taille;

            flag = "Documents";
            taille = new Integer(listeDocuments.size());
            oos.writeObject(flag);
            oos.writeObject(taille);
            Document document;
            for(int i=0; i<taille; i++){
                document = listeDocuments.get(i);
                oos.writeObject(document);
            }

            flag = "FicheEmprunts";
            taille = new Integer(listeFicheEmprunts.size());
            oos.writeObject(flag);
            oos.writeObject(taille);
            FicheEmprunt fiche;
            for(int i=0; i<taille; i++){
                fiche = listeFicheEmprunts.get(i);
                oos.writeObject(fiche);
            }

            flag = "Clients";
            taille = new Integer(listeClients.size());
            oos.writeObject(flag);
            oos.writeObject(taille);
            Client client;
            for(int i=0; i<taille; i++){
                client = listeClients.get(i);
                oos.writeObject(client);
            }

            flag = "Employes";
            taille = new Integer(listeEmployes.size());
            oos.writeObject(flag);
            oos.writeObject(taille);
            Employe employe;
            for(int i=0; i<taille; i++){
                employe = listeEmployes.get(i);
                oos.writeObject(employe);
            }
        } catch (NullPointerException e) {
            System.out.println("SAUVEGARDE. Fichier de BDD introuvable.");
            return false;
        } catch(IOException ex) {
            System.out.println("SAUVEGARDE. IOException problem.");
            ex.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if (oos != null) oos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }
    public void addDocument(Document document){
        this.listeDocuments.add(document);
    }

    public boolean addFicheEmprunt(FicheEmprunt ficheEmprunt){
        int empruntMax = ficheEmprunt.getClient().getCategorie().getEmpruntsMax();
        int currentEmprunts = this.empruntClient(ficheEmprunt.getClient()).size();
        if(currentEmprunts<empruntMax){
            this.listeFicheEmprunts.add(ficheEmprunt);
            return true;
        }
        return false;
    }

    public void addClient(Client client){
        this.listeClients.add(client);
    }
    public void addEmploye(Employe employe){
        this.listeEmployes.add(employe);
    }


    public ArrayList<Document> getListeDocuments(){
        return this.listeDocuments;
    }

    public ArrayList<FicheEmprunt> getListeFicheEmprunts(){
        return this.listeFicheEmprunts;
    }

    public ArrayList<Client> getListeClients(){
        return this.listeClients;
    }

    public ArrayList<Employe> getListeEmployes(){
        return this.listeEmployes;
    }

    public Client logClient(String username, String password){
        Client client = null;
        for(Client c: listeClients){
            if(c.getUsername().equals(username) && c.getPassword().equals(password)){
                return c;
            }
        }
        return client;
    }

    public Employe logEmploye(String username, String password){
        Employe employe = null;
        for(Employe e: listeEmployes){
            if(e.getUsername().equals(username) && e.getPassword().equals(password)){
                return e;
            }
        }
        return employe;
    }

    public ArrayList<FicheEmprunt> empruntClient(Client client){
        ArrayList<FicheEmprunt> res = new ArrayList<FicheEmprunt>();
        for(FicheEmprunt f: listeFicheEmprunts){
            if(f.getClient().equals(client)){
                res.add(f);
            }
        }
        return res;
    }

    public FicheEmprunt getFiche(Document d){
        for(FicheEmprunt f: listeFicheEmprunts){
            if(d.equals(f.getDocument())){
                return f;
            }
        }
        return null;
    }

    public double getSoldeClient(Client client){
        double solde = 0;
        ArrayList<FicheEmprunt> list = empruntClient(client);
        for(FicheEmprunt f : list){
            solde += f.getDocument().getTarif()*f.getClient().getCategorie().getCoefTarif();
        }
        return solde;
    }

    public Client getClient(String nom, String prenom){
        for(Client c: listeClients){
            if(c.getNom().toLowerCase().equals(nom.trim().toLowerCase())&&c.getPrenom().toLowerCase().equals(prenom.trim().toLowerCase())){
                return c;
            }
        }
        return null;
    }

    public Document getDocument(String titre, String auteur){
        for(Document d: listeDocuments){
            if(d.getTitre().toLowerCase().equals(titre.trim().toLowerCase()) && d.getAuteur().toLowerCase().equals(auteur.trim().toLowerCase())){
                return d;
            }
        }
        return null;
    }

    public boolean removeFicheEmprunt(Client c, Document d){
        for(FicheEmprunt f: empruntClient(c)){
            if(c.getNom().toLowerCase().equals(f.getClient().getNom().trim().toLowerCase()) && c.getPrenom().toLowerCase().equals(f.getClient().getPrenom().trim().toLowerCase())
            && d.getTitre().toLowerCase().equals(f.getDocument().getTitre().trim().toLowerCase()) && d.getAuteur().toLowerCase().equals(f.getDocument().getAuteur().trim().toLowerCase())){
                f.getDocument().rendu();
                this.listeFicheEmprunts.remove(f);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Client> getClientStartsWith(String motif, boolean nom, boolean prenom){
        ArrayList<Client> res = new ArrayList<Client>();
        for(Client c: listeClients){
            if(nom && c.getNom().toLowerCase().startsWith(motif.toLowerCase())){
                res.add(c);
            }
            if(prenom && !res.contains(c) && c.getPrenom().toLowerCase().startsWith(motif.toLowerCase())){
                res.add(c);
            }
        }
        return res;
    }

    public ArrayList<Document> getDocumentStartsWith(String motif, boolean audio, boolean video, boolean livre){
        ArrayList<Document> res = new ArrayList<Document>();
        for(Document d: listeDocuments){
            if(audio && d instanceof Audio && (d.getTitre().toLowerCase().startsWith(motif.toLowerCase())||d.getAuteur().toLowerCase().startsWith(motif.toLowerCase()))){
                res.add(d);
            }
            if(video && d instanceof Video && (d.getTitre().toLowerCase().startsWith(motif.toLowerCase())||d.getAuteur().toLowerCase().startsWith(motif.toLowerCase()))){
                res.add(d);
            }
            if(livre && d instanceof Livre && (d.getTitre().toLowerCase().startsWith(motif.toLowerCase())||d.getAuteur().toLowerCase().startsWith(motif.toLowerCase()))){
                res.add(d);
            }
        }
        return res;
    }

}
