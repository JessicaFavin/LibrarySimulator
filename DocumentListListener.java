
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DocumentListListener implements ActionListener{
    Mediatheque m;
    Frame frame;
    Employe employe;
    Client client;
    Document document;
    FicheEmprunt fiche;

    //emprunt prolongation
    public DocumentListListener(Frame frame, Mediatheque m, Client client, Document document){
        this.frame = frame;
        this.m = m;
        this.employe = null;
        this.client = client;
        this.document = document;
    }
    //emprunt, modif, suppr
    public DocumentListListener(Frame frame, Mediatheque m, Employe employe, Document document){
        this.frame = frame;
        this.m = m;
        this.employe = employe;
        this.client = null;
        this.document = document;
    }

    public DocumentListListener(Frame frame, Mediatheque m, FicheEmprunt fiche){
        this.frame = frame;
        this.m = m;
        this.employe = null;
        this.client = fiche.getClient();
        this.document = fiche.getDocument();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "emprunt":
                if(client!=null){
                    FicheEmprunt f = new FicheEmprunt(client, document);
                    m.addFicheEmprunt(f);
                    JOptionPane.showMessageDialog(frame, "Emprunt enregisté.", "Emprunt document", JOptionPane.INFORMATION_MESSAGE);

                }
                break;
            case "prolong":
                ArrayList<FicheEmprunt> listeFiche = m.getListeFicheEmprunts();
                int i = listeFiche.indexOf(document);
                listeFiche.get(i).prolongeEmprunt();
                JOptionPane.showMessageDialog(frame, "Emprunt prolongé.", "Prolongation document", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "edit":
                break;
            case "suppression":
                break;
            default:
                break;
        }
    }

}
