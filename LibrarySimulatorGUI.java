
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LibrarySimulatorGUI implements ActionListener {

    Mediatheque m;
    JFrame frame;
    Client clientLogged;
    JLabel userLogged;
    String userStatus;
    //----------------Conneciton---------------
    JPanel connectionPanel;
    JLabel warning;
    JTextField userField;
    JPasswordField passwordField;
    JCheckBox employeBox;
    //-----------------Employe-----------------
    JPanel employePanel;
    JTabbedPane employePane;
    //-------------------Client----------------
    JTabbedPane clientPane;
    JPanel clientPanel;
    //-------------------Invite----------------
    JTabbedPane invitePane;
    JPanel invitePanel;
    //----------------Add Client---------------
    JPanel msgAddClient;
    JLabel warningAddClient;
    JLabel confirmAddClient;
    JPanel addClientPanel;
    JTextField nomClient;
    JTextField prenomClient;
    JRadioButton categEtudiant;
    JRadioButton categEntreprise;
    JRadioButton categParticulier;
    JTextField numeroClient;
    JTextField voieClient;
    JTextField rueClient;
    JTextField postalClient;
    JTextField villeClient;
    JTextField paysClient;
    //----------------Add Employe---------------
    JPanel msgAddEmploye;
    JLabel warningAddEmploye;
    JLabel confirmAddEmploye;
    JPanel addEmployePanel;
    JTextField usernameEmploye;
    JPasswordField passwordEmploye;
    JPasswordField confirmPasswordEmploye;
    JTextField nomEmploye;
    JTextField prenomEmploye;
    JTextField numeroEmploye;
    JTextField voieEmploye;
    JTextField rueEmploye;
    JTextField postalEmploye;
    JTextField villeEmploye;
    JTextField paysEmploye;
    //----------------Add Document---------------
    JPanel msgAddDocument;
    JLabel warningAddDocument;
    JLabel confirmAddDocument;
    JPanel addDocumentPanel;
    JRadioButton typeAudio;
    JRadioButton typeVideo;
    JRadioButton typeLivre;
    JTextField titreDocument;
    JTextField auteurDocument;
    JTextField anneeDocument;
    JTextField isbnDocument;
    JTextField genreDocument;
    JTextField salleDocument;
    JTextField rayonDocument;
    JTextField tailleDocument;
    JPanel taillePanel;
    JLabel dureeDocumentLabel;
    JLabel pagesDocumentLabel;
    //--------------AddEmprunt-------------------
    JPanel addEmpruntPanel;
    JPanel msgAddEmprunt;
    JLabel warningAddEmprunt;
    JLabel confirmAddEmprunt;
    JLabel restantEmprunt;
    JTextField titreDocEmprunt;
    JTextField auteurDocEmprunt;
    JTextField nomClientEmprunt;
    JTextField prenomClientEmprunt;
    //--------------Retour-------------------
    JPanel retourPanel;
    JPanel msgRetour;
    JLabel warningRetour;
    JLabel confirmRetour;
    JLabel restantRetour;
    JTextField titreDocRetour;
    JTextField auteurDocRetour;
    JTextField nomClientRetour;
    JTextField prenomClientRetour;
    //--------------Recherche-------------------
    JPanel recherchePanel;
    JTextField rechercheField;
    JRadioButton clientButton;
    JRadioButton documentButton;
    JPanel optionPanel;
    JCheckBox nomBox;
    JCheckBox prenomBox;
    JCheckBox audioBox;
    JCheckBox videoBox;
    JCheckBox livreBox;
    JTextArea resultatArea;
    //--------------Emprunt user-------------------
    JPanel empruntPanel;
    //----------------Profil user-------------------
    JPanel profilPanel;

    //----------------Update password-------------------
    JFrame editPasswordFrame;
    JPanel updatePasswordPanel;
    JPanel msgPassPanel;
    JLabel warningPassLabel;
    JPasswordField oldPassField;
    JPasswordField newPassField;
    JPasswordField confPassField;

    private void updateFrame(){
        frame.dispose();
        frame = new JFrame("Library Simulator GUI");
        frame.setMinimumSize(new Dimension(640, 480));
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void initUserLogged(String prenom){
        userLogged = new JLabel("Bonjour "+prenom);
    }

    private void initAddClientPanel(){
        addClientPanel = new JPanel(new GridLayout(12,1));

        warningAddClient = new JLabel("Infos incorrectes, recommencez.");
        warningAddClient.setBounds(warningAddClient.getX(),warningAddClient.getY(),10,warningAddClient.getHeight());
        warningAddClient.setForeground(Color.red);
        warningAddClient.setVisible(false);

        confirmAddClient = new JLabel("Utilisateur bien ajouté!");
        confirmAddClient.setForeground(Color.green);
        confirmAddClient.setBounds(confirmAddClient.getX(),confirmAddClient.getY(),10,confirmAddClient.getHeight());
        confirmAddClient.setVisible(false);

        msgAddClient = new JPanel(new FlowLayout());;
        addClientPanel.add(msgAddClient);

        JPanel nomPanel = new JPanel(new FlowLayout());
        JLabel nomClientLabel = new JLabel("Nom :                  ");
        nomClient = new JTextField(10);
        nomPanel.add(nomClientLabel);
        nomPanel.add(nomClient);
        addClientPanel.add(nomPanel);

        JPanel prenomPanel = new JPanel(new FlowLayout());
        JLabel prenomClientLabel = new JLabel("Prenom :            ");
        prenomClient = new JTextField(10);
        prenomPanel.add(prenomClientLabel);
        prenomPanel.add(prenomClient);
        addClientPanel.add(prenomPanel);

        JPanel categoriePanel = new JPanel(new FlowLayout());
        JLabel categorieClientLabel = new JLabel("Catégorie : ");
        ButtonGroup categorieClient = new ButtonGroup( );
        categEtudiant = new JRadioButton("Etudiant");
        categEntreprise = new JRadioButton("Entreprise");
        categParticulier = new JRadioButton("Particulier");
        categParticulier.setSelected(true);
        categorieClient.add(categEtudiant);
        categorieClient.add(categEntreprise);
        categorieClient.add(categParticulier);

        categoriePanel.add(categorieClientLabel);
        categoriePanel.add(categEtudiant);
        categoriePanel.add(categEntreprise);
        categoriePanel.add(categParticulier);

        addClientPanel.add(categoriePanel);

        JPanel adresseClientPanel = new JPanel(new FlowLayout());
        JLabel adresseClient = new JLabel("Adresse");
        adresseClientPanel.add(adresseClient);
        addClientPanel.add(adresseClientPanel);

        JPanel numeroPanel = new JPanel(new FlowLayout());
        JLabel numeroClientLabel = new JLabel("Numéro :           ");
        numeroClient = new JTextField(10);
        numeroPanel.add(numeroClientLabel);
        numeroPanel.add(numeroClient);
        addClientPanel.add(numeroPanel);

        JPanel voiePanel = new JPanel(new FlowLayout());
        JLabel voieClientLabel = new JLabel("Type de voie :   ");
        voieClient = new JTextField(10);
        voiePanel.add(voieClientLabel);
        voiePanel.add(voieClient);
        addClientPanel.add(voiePanel);

        JPanel ruePanel = new JPanel(new FlowLayout());
        JLabel rueClientLabel = new JLabel("Nom de la voie :");
        rueClient = new JTextField(10);
        ruePanel.add(rueClientLabel);
        ruePanel.add(rueClient);
        addClientPanel.add(ruePanel);

        JPanel postalPanel = new JPanel(new FlowLayout());
        JLabel postalClientLabel = new JLabel("Code postal :    ");
        postalClient = new JTextField(10);
        postalPanel.add(postalClientLabel);
        postalPanel.add(postalClient);
        addClientPanel.add(postalPanel);

        JPanel villePanel = new JPanel(new FlowLayout());
        JLabel villeClientLabel = new JLabel("Ville :                  ");
        villeClient = new JTextField(10);
        villePanel.add(villeClientLabel);
        villePanel.add(villeClient);
        addClientPanel.add(villePanel);

        JPanel paysPanel = new JPanel(new FlowLayout());
        JLabel paysClientLabel = new JLabel("Pays :                 ");
        paysClient = new JTextField(10);
        paysPanel.add(paysClientLabel);
        paysPanel.add(paysClient);
        addClientPanel.add(paysPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton validateButton = new JButton("Valider");
        validateButton.addActionListener(this);
        validateButton.setActionCommand("AddClient");
        JButton clearButton = new JButton("Effacer");
        clearButton.addActionListener(this);
        clearButton.setActionCommand("ClearClient");

        buttonPanel.add(validateButton);
        buttonPanel.add(clearButton);
        addClientPanel.add(buttonPanel);
    }

    private void initAddEmployePanel(){
        addEmployePanel = new JPanel(new GridLayout(14,1));

        warningAddEmploye = new JLabel("Infos incorrectes, recommencez.");
        warningAddEmploye.setBounds(warningAddEmploye.getX(),warningAddEmploye.getY(),10,warningAddEmploye.getHeight());
        warningAddEmploye.setForeground(Color.red);
        warningAddEmploye.setVisible(false);

        confirmAddEmploye = new JLabel("Employe bien ajouté!");
        confirmAddEmploye.setForeground(Color.green);
        confirmAddEmploye.setBounds(confirmAddEmploye.getX(),confirmAddEmploye.getY(),10,confirmAddEmploye.getHeight());
        confirmAddEmploye.setVisible(false);

        msgAddEmploye = new JPanel(new FlowLayout());;
        addEmployePanel.add(msgAddEmploye);

        JPanel usernamePanel = new JPanel(new FlowLayout());
        JLabel usernameEmployeLabel = new JLabel("Login :                                ");
        usernameEmploye = new JTextField(10);
        usernamePanel.add(usernameEmployeLabel);
        usernamePanel.add(usernameEmploye);
        addEmployePanel.add(usernamePanel);

        JPanel passwordPanel = new JPanel(new FlowLayout());
        JLabel passwordEmployeLabel = new JLabel("Mot de passe :                 ");
        passwordEmploye = new JPasswordField(10);
        passwordPanel.add(passwordEmployeLabel);
        passwordPanel.add(passwordEmploye);
        addEmployePanel.add(passwordPanel);

        JPanel confirmPasswordPanel = new JPanel(new FlowLayout());
        JLabel confirmPasswordEmployeLabel = new JLabel("Confirm. mot de passe : ");
        confirmPasswordEmploye = new JPasswordField(10);
        confirmPasswordPanel.add(confirmPasswordEmployeLabel);
        confirmPasswordPanel.add(confirmPasswordEmploye);
        addEmployePanel.add(confirmPasswordPanel);


        JPanel nomPanel = new JPanel(new FlowLayout());
        JLabel nomEmployeLabel = new JLabel("Nom :                                ");
        nomEmploye = new JTextField(10);
        nomPanel.add(nomEmployeLabel);
        nomPanel.add(nomEmploye);
        addEmployePanel.add(nomPanel);

        JPanel prenomPanel = new JPanel(new FlowLayout());
        JLabel prenomEmployeLabel = new JLabel("Prenom :                          ");
        prenomEmploye = new JTextField(10);
        prenomPanel.add(prenomEmployeLabel);
        prenomPanel.add(prenomEmploye);
        addEmployePanel.add(prenomPanel);

        JPanel adresseEmployePanel = new JPanel(new FlowLayout());
        JLabel adresseEmploye = new JLabel("Adresse");
        adresseEmployePanel.add(adresseEmploye);
        addEmployePanel.add(adresseEmployePanel);

        JPanel numeroPanel = new JPanel(new FlowLayout());
        JLabel numeroEmployeLabel = new JLabel("Numéro :                         ");
        numeroEmploye = new JTextField(10);
        numeroPanel.add(numeroEmployeLabel);
        numeroPanel.add(numeroEmploye);
        addEmployePanel.add(numeroPanel);

        JPanel voiePanel = new JPanel(new FlowLayout());
        JLabel voieEmployeLabel = new JLabel("Type de voie :                 ");
        voieEmploye = new JTextField(10);
        voiePanel.add(voieEmployeLabel);
        voiePanel.add(voieEmploye);
        addEmployePanel.add(voiePanel);

        JPanel ruePanel = new JPanel(new FlowLayout());
        JLabel rueEmployeLabel = new JLabel("Nom de la voie :              ");
        rueEmploye = new JTextField(10);
        ruePanel.add(rueEmployeLabel);
        ruePanel.add(rueEmploye);
        addEmployePanel.add(ruePanel);

        JPanel postalPanel = new JPanel(new FlowLayout());
        JLabel postalEmployeLabel = new JLabel("Code postal :                  ");
        postalEmploye = new JTextField(10);
        postalPanel.add(postalEmployeLabel);
        postalPanel.add(postalEmploye);
        addEmployePanel.add(postalPanel);

        JPanel villePanel = new JPanel(new FlowLayout());
        JLabel villeEmployeLabel = new JLabel("Ville :                                ");
        villeEmploye = new JTextField(10);
        villePanel.add(villeEmployeLabel);
        villePanel.add(villeEmploye);
        addEmployePanel.add(villePanel);

        JPanel paysPanel = new JPanel(new FlowLayout());
        JLabel paysEmployeLabel = new JLabel("Pays :                               ");
        paysEmploye = new JTextField(10);
        paysPanel.add(paysEmployeLabel);
        paysPanel.add(paysEmploye);
        addEmployePanel.add(paysPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton validateButton = new JButton("Valider");
        validateButton.addActionListener(this);
        validateButton.setActionCommand("AddEmploye");
        JButton clearButton = new JButton("Effacer");
        clearButton.addActionListener(this);
        clearButton.setActionCommand("ClearEmploye");
        buttonPanel.add(validateButton);
        buttonPanel.add(clearButton);
        addEmployePanel.add(buttonPanel);
    }

    public void initAddDocumentPanel(){
        addDocumentPanel = new JPanel(new GridLayout(11,1));

        warningAddDocument = new JLabel("Infos incorrectes, recommencez.");
        warningAddDocument.setBounds(warningAddDocument.getX(),warningAddDocument.getY(),10,warningAddDocument.getHeight());
        warningAddDocument.setForeground(Color.red);
        warningAddDocument.setVisible(false);

        confirmAddDocument = new JLabel("Document bien ajouté!");
        confirmAddDocument.setForeground(Color.green);
        confirmAddDocument.setBounds(confirmAddDocument.getX(),confirmAddDocument.getY(),10,confirmAddDocument.getHeight());
        confirmAddDocument.setVisible(false);

        msgAddDocument = new JPanel(new FlowLayout());;
        addDocumentPanel.add(msgAddDocument);

        JPanel typePanel = new JPanel(new FlowLayout());
        JLabel typeDocumentLabel = new JLabel("Catégorie : ");
        ButtonGroup typeDocument = new ButtonGroup( );
        typeAudio = new JRadioButton("Audio");
        typeAudio.addActionListener(this);
        typeAudio.setActionCommand("MultimediaLabel");
        typeVideo = new JRadioButton("Video");
        typeVideo.addActionListener(this);
        typeVideo.setActionCommand("MultimediaLabel");
        typeLivre = new JRadioButton("Livre");
        typeLivre.addActionListener(this);
        typeLivre.setActionCommand("LivreLabel");
        typeLivre.setSelected(true);
        typeDocument.add(typeAudio);
        typeDocument.add(typeVideo);
        typeDocument.add(typeLivre);

        typePanel.add(typeDocumentLabel);
        typePanel.add(typeAudio);
        typePanel.add(typeVideo);
        typePanel.add(typeLivre);

        addDocumentPanel.add(typePanel);

        JPanel titrePanel = new JPanel(new FlowLayout());
        JLabel titreDocumentLabel = new JLabel("Titre :                   ");
        titreDocument = new JTextField(10);
        titrePanel.add(titreDocumentLabel);
        titrePanel.add(titreDocument);
        addDocumentPanel.add(titrePanel);

        JPanel auteurPanel = new JPanel(new FlowLayout());
        JLabel auteurDocumentLabel = new JLabel("Auteur :               ");
        auteurDocument = new JTextField(10);
        auteurPanel.add(auteurDocumentLabel);
        auteurPanel.add(auteurDocument);
        addDocumentPanel.add(auteurPanel);

        JPanel anneePanel = new JPanel(new FlowLayout());
        JLabel anneeDocumentLabel = new JLabel("Année :               ");
        anneeDocument = new JTextField(10);
        anneePanel.add(anneeDocumentLabel);
        anneePanel.add(anneeDocument);
        addDocumentPanel.add(anneePanel);

        JPanel isbnPanel = new JPanel(new FlowLayout());
        JLabel isbnDocumentLabel = new JLabel("Isbn :                   ");
        isbnDocument = new JTextField(10);
        isbnPanel.add(isbnDocumentLabel);
        isbnPanel.add(isbnDocument);
        addDocumentPanel.add(isbnPanel);

        JPanel genrePanel = new JPanel(new FlowLayout());
        JLabel genreDocumentLabel = new JLabel("Genre :               ");
        genreDocument = new JTextField(10);
        genrePanel.add(genreDocumentLabel);
        genrePanel.add(genreDocument);
        addDocumentPanel.add(genrePanel);

        JPanel sallePanel = new JPanel(new FlowLayout());
        JLabel salleDocumentLabel = new JLabel("Salle :                 ");
        salleDocument = new JTextField(10);
        sallePanel.add(salleDocumentLabel);
        sallePanel.add(salleDocument);
        addDocumentPanel.add(sallePanel);

        JPanel rayonPanel = new JPanel(new FlowLayout());
        JLabel rayonDocumentLabel = new JLabel("Rayon :               ");
        rayonDocument = new JTextField(10);
        rayonPanel.add(rayonDocumentLabel);
        rayonPanel.add(rayonDocument);
        addDocumentPanel.add(rayonPanel);

        taillePanel = new JPanel(new FlowLayout());
        dureeDocumentLabel = new JLabel("Duree (mm.ss) : ");
        pagesDocumentLabel = new JLabel("Nb de pages :   ");
        tailleDocument = new JTextField(10);
        taillePanel.add(pagesDocumentLabel);
        taillePanel.add(tailleDocument);
        addDocumentPanel.add(taillePanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton validateButton = new JButton("Valider");
        validateButton.addActionListener(this);
        validateButton.setActionCommand("AddDocument");
        JButton clearButton = new JButton("Effacer");
        clearButton.addActionListener(this);
        clearButton.setActionCommand("ClearDocument");

        buttonPanel.add(validateButton);
        buttonPanel.add(clearButton);
        addDocumentPanel.add(buttonPanel);
    }

    private void initEmployePane(){
        employePane = new JTabbedPane();

        initRecherchePanel();
        employePane.addTab("Recherche",recherchePanel);

        initAddDocumentPanel();
        employePane.addTab("Ajout Document", addDocumentPanel);

        initAddClientPanel();
        employePane.addTab("Ajout Client", addClientPanel);

        initAddEmployePanel();
        employePane.addTab("Ajout Employé", addEmployePanel);

        initAddEmpruntPanel();
        employePane.addTab("Emprunt", addEmpruntPanel);

        initRetourPanel();
        employePane.addTab("Retour", retourPanel);
    }


    private void initEmployePanel(String nom, String prenom){
        employePanel = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel(new BorderLayout());
        initUserLogged(prenom);
        userStatus = "employe";
        infoPanel.add(userLogged, BorderLayout.CENTER);
        JButton logoutButton = new JButton("Déconnexion");
        logoutButton.addActionListener(this);
        logoutButton.setActionCommand("deconnect");
        infoPanel.add(logoutButton, BorderLayout.LINE_END);
        employePanel.add(infoPanel, BorderLayout.NORTH);
        //----------------------------------------------------------------------
        initEmployePane();
        //----------------------------------------------------------------------
        employePanel.add(employePane ,BorderLayout.CENTER);
    }

    private void initEmpruntPanel(){
        empruntPanel = new JPanel(new FlowLayout());
        ArrayList<FicheEmprunt> listeEmprunts = m.empruntClient(clientLogged);
        JPanel empruntList = new JPanel(new GridLayout(21,1));

        JPanel infoDoc = new JPanel(new GridLayout(1,5));
        infoDoc.add(new JLabel("Titre"));
        infoDoc.add(new JLabel("Auteur"));
        infoDoc.add(new JLabel("Année"));
        infoDoc.add(new JLabel("Date Retour"));
        infoDoc.add(new JLabel("En retard"));
        empruntList.add(infoDoc);
        JPanel docLigne;
        SimpleDateFormat dateform = new SimpleDateFormat("d/M/Y");
        for(FicheEmprunt f: listeEmprunts){
            Document doc = f.getDocument();
            docLigne = new JPanel(new GridLayout(1,5));
            docLigne.add(new JLabel(doc.getTitre()));
            docLigne.add(new JLabel(doc.getAuteur()));
            docLigne.add(new JLabel(Integer.toString(doc.getAnnee())));
            docLigne.add(new JLabel(dateform.format(f.getDateFin())));
            if(f.getEnRetard()){
                docLigne.add(new JLabel("Oui"));
            }else{
                docLigne.add(new JLabel("Non"));
            }
            empruntList.add(docLigne);
        }
        int ghost = (20-listeEmprunts.size());
        for(int i=0; i<ghost; i++){
            docLigne = new JPanel(new GridLayout(1,5));
            docLigne.add(new JLabel(""));
            docLigne.add(new JLabel(""));
            docLigne.add(new JLabel(""));
            docLigne.add(new JLabel(""));
            docLigne.add(new JLabel(""));
            empruntList.add(docLigne);
        }

        JScrollPane scroll = new JScrollPane(empruntList);
        scroll.setPreferredSize(new Dimension(600,400));
        //scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        empruntPanel.add(scroll);
    }

    private void initRetourPanel(){
        retourPanel = new JPanel(new GridLayout(8,1));

        msgRetour = new JPanel(new FlowLayout());
        warningRetour = new JLabel("Document non emprunté.");
        warningRetour.setForeground(Color.red);
        warningRetour.setVisible(false);

        confirmRetour = new JLabel("Retour enregistré.");
        confirmRetour.setForeground(Color.green);
        confirmRetour.setVisible(false);

        if(clientLogged!=null){
            int currentRetours = m.empruntClient(clientLogged).size();
            restantRetour = new JLabel("Il vous reste "+currentRetours+" emprunts à retourner.");
        } else {
            restantRetour = new JLabel("");
        }
        msgRetour.add(restantRetour);
        retourPanel.add(msgRetour);

        JPanel docPanel = new JPanel(new FlowLayout());
        JLabel docLabel = new JLabel("Document");
        docPanel.add(docLabel);
        retourPanel.add(docPanel);

        JPanel titrePanel = new JPanel(new FlowLayout());
        JLabel titreLabel = new JLabel("Titre :      ");
        titreDocRetour = new JTextField(10);
        titrePanel.add(titreLabel);
        titrePanel.add(titreDocRetour);
        retourPanel.add(titrePanel);

        JPanel auteurPanel = new JPanel(new FlowLayout());
        JLabel auteurLabel = new JLabel("Auteur :   ");
        auteurDocRetour = new JTextField(10);
        auteurPanel.add(auteurLabel);
        auteurPanel.add(auteurDocRetour);
        retourPanel.add(auteurPanel);

        JPanel clientPanel = new JPanel(new FlowLayout());
        JLabel clientLabel = new JLabel("Utilisateur");
        if(clientLogged!=null){
            clientPanel.setVisible(false);
        }
        clientPanel.add(clientLabel);
        retourPanel.add(clientPanel);

        JPanel nomPanel = new JPanel(new FlowLayout());
        JLabel nomLabel = new JLabel("Nom :      ");
        nomClientRetour = new JTextField(10);
        if(clientLogged!=null){
            nomClientRetour.setText(clientLogged.getNom());
            nomPanel.setVisible(false);
        }
        nomPanel.add(nomLabel);
        nomPanel.add(nomClientRetour);
        retourPanel.add(nomPanel);

        JPanel prenomPanel = new JPanel(new FlowLayout());
        JLabel prenomLabel = new JLabel("Prenom : ");
        prenomClientRetour = new JTextField(10);
        if(clientLogged!=null){
            prenomClientRetour.setText(clientLogged.getPrenom());
            prenomPanel.setVisible(false);
        }
        prenomPanel.add(prenomLabel);
        prenomPanel.add(prenomClientRetour);
        retourPanel.add(prenomPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton empruntButton = new JButton("Valider");
        empruntButton.addActionListener(this);
        empruntButton.setActionCommand("Retour");
        buttonPanel.add(empruntButton);
        JButton clearButton = new JButton("Effacer");
        clearButton.addActionListener(this);
        clearButton.setActionCommand("ClearRetour");
        buttonPanel.add(clearButton);
        retourPanel.add(buttonPanel);
    }

    private void initAddEmpruntPanel(){
        addEmpruntPanel = new JPanel(new GridLayout(8,1));

        msgAddEmprunt = new JPanel(new FlowLayout());
        warningAddEmprunt = new JLabel("Document déjà emprunté.");
        warningAddEmprunt.setForeground(Color.red);
        warningAddEmprunt.setVisible(false);

        confirmAddEmprunt = new JLabel("Emprunt enregistré.");
        confirmAddEmprunt.setForeground(Color.green);
        confirmAddEmprunt.setVisible(false);

        if(clientLogged!=null){
            int empruntMax = clientLogged.getCategorie().getEmpruntsMax();
            int currentEmprunts = m.empruntClient(clientLogged).size();
            int empruntRestant = empruntMax-currentEmprunts;
            restantEmprunt = new JLabel("Vous pouvez encore effecuer "+empruntRestant+" emprunts");
        } else {
            restantEmprunt = new JLabel("");
        }
        msgAddEmprunt.add(restantEmprunt);
        addEmpruntPanel.add(msgAddEmprunt);

        JPanel docPanel = new JPanel(new FlowLayout());
        JLabel docLabel = new JLabel("Document");
        docPanel.add(docLabel);
        addEmpruntPanel.add(docPanel);

        JPanel titrePanel = new JPanel(new FlowLayout());
        JLabel titreLabel = new JLabel("Titre :      ");
        titreDocEmprunt = new JTextField(10);
        titrePanel.add(titreLabel);
        titrePanel.add(titreDocEmprunt);
        addEmpruntPanel.add(titrePanel);

        JPanel auteurPanel = new JPanel(new FlowLayout());
        JLabel auteurLabel = new JLabel("Auteur :   ");
        auteurDocEmprunt = new JTextField(10);
        auteurPanel.add(auteurLabel);
        auteurPanel.add(auteurDocEmprunt);
        addEmpruntPanel.add(auteurPanel);

        JPanel clientPanel = new JPanel(new FlowLayout());
        JLabel clientLabel = new JLabel("Utilisateur");
        if(clientLogged!=null){
            clientPanel.setVisible(false);
        }
        clientPanel.add(clientLabel);
        addEmpruntPanel.add(clientPanel);

        JPanel nomPanel = new JPanel(new FlowLayout());
        JLabel nomLabel = new JLabel("Nom :      ");
        nomClientEmprunt = new JTextField(10);
        if(clientLogged!=null){
            nomClientEmprunt.setText(clientLogged.getNom());
            nomPanel.setVisible(false);
        }
        nomPanel.add(nomLabel);
        nomPanel.add(nomClientEmprunt);
        addEmpruntPanel.add(nomPanel);

        JPanel prenomPanel = new JPanel(new FlowLayout());
        JLabel prenomLabel = new JLabel("Prenom : ");
        prenomClientEmprunt = new JTextField(10);
        if(clientLogged!=null){
            prenomClientEmprunt.setText(clientLogged.getPrenom());
            prenomPanel.setVisible(false);
        }
        prenomPanel.add(prenomLabel);
        prenomPanel.add(prenomClientEmprunt);
        addEmpruntPanel.add(prenomPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton empruntButton = new JButton("Valider");
        empruntButton.addActionListener(this);
        empruntButton.setActionCommand("AddEmprunt");
        buttonPanel.add(empruntButton);
        JButton clearButton = new JButton("Effacer");
        clearButton.addActionListener(this);
        clearButton.setActionCommand("ClearEmprunt");
        buttonPanel.add(clearButton);
        addEmpruntPanel.add(buttonPanel);
    }

    private void initProfilPanel(){
        profilPanel = new JPanel(new GridLayout(7,1));
        JPanel headerPanel = new JPanel(new FlowLayout());
        JLabel header = new JLabel("Votre Profil");
        headerPanel.add(header);
        profilPanel.add(headerPanel);

        JPanel nomPanel = new JPanel(new FlowLayout());
        JLabel nomClientLabel = new JLabel("Nom : ");
        JLabel nom = new JLabel(clientLogged.getNom());
        nomPanel.add(nomClientLabel);
        nomPanel.add(nom);
        profilPanel.add(nomPanel);

        JPanel prenomPanel = new JPanel(new FlowLayout());
        JLabel prenomClientLabel = new JLabel("Prenom : ");
        JLabel prenom = new JLabel(clientLogged.getPrenom());
        prenomPanel.add(prenomClientLabel);
        prenomPanel.add(prenom);
        profilPanel.add(prenomPanel);

        JPanel categoriePanel = new JPanel(new FlowLayout());
        JLabel categorieClientLabel = new JLabel("Catégorie : ");
        JLabel categorie = new JLabel(clientLogged.getCategorie().name());
        categoriePanel.add(categorieClientLabel);
        categoriePanel.add(categorie);
        profilPanel.add(categoriePanel);

        JPanel adresseClientPanel = new JPanel(new FlowLayout());
        JLabel adresseClient = new JLabel("Adresse : ");
        JLabel adresse = new JLabel(clientLogged.getAdresse().toString());
        adresseClientPanel.add(adresseClient);
        adresseClientPanel.add(adresse);
        profilPanel.add(adresseClientPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton editButton = new JButton("Modifier le mot de passe");
        editButton.addActionListener(this);
        editButton.setActionCommand("editPassword");
        //editButton.setVisible(false);
        buttonPanel.add(editButton);
        profilPanel.add(buttonPanel);

        String msg = "Votre solde est de "+m.getSoldeClient(clientLogged)+"€. Votre cotisation est de "+clientLogged.getCategorie().getCotisation()+"€.";
        JLabel soldeClient = new JLabel(msg);
        soldeClient.setHorizontalAlignment(SwingConstants.CENTER);
        profilPanel.add(soldeClient);

        profilPanel.setPreferredSize(new Dimension(600, 200));
    }

    private void initRecherchePanel(){
        recherchePanel = new JPanel(new FlowLayout());
        recherchePanel.setPreferredSize(new Dimension(600,400));
        JPanel upperPanel = new JPanel(new GridLayout(3,1));
        JPanel recherche = new JPanel(new FlowLayout());
        JLabel rechercheLabel = new JLabel("Recherche");
        rechercheField = new JTextField(20);
        rechercheField.addActionListener(this);
        rechercheField.setActionCommand("UpdateSearch");
        JButton rechercheButton = new JButton("Valider");
        rechercheButton.addActionListener(this);
        rechercheButton.setActionCommand("UpdateSearch");
        recherche.add(rechercheLabel);
        recherche.add(rechercheField);
        recherche.add(rechercheButton);
        upperPanel.add(recherche);

        JPanel categoriePanel = new JPanel(new FlowLayout());
        ButtonGroup categorieRecherche = new ButtonGroup( );
        clientButton = new JRadioButton("Utilisateur");
        clientButton.addActionListener(this);
        clientButton.setActionCommand("SearchClient");
        documentButton = new JRadioButton("Document");
        documentButton.addActionListener(this);
        documentButton.setActionCommand("SearchDocument");
        documentButton.setSelected(true);
        categorieRecherche.add(clientButton);
        categorieRecherche.add(documentButton);
        categoriePanel.add(clientButton);
        categoriePanel.add(documentButton);
        upperPanel.add(categoriePanel);

        optionPanel = new JPanel(new FlowLayout());

        nomBox = new JCheckBox("Nom");
        nomBox.setSelected(true);
        prenomBox = new JCheckBox("Prénom");
        prenomBox.setSelected(true);
        audioBox = new JCheckBox("Audio");
        audioBox.setSelected(true);
        videoBox = new JCheckBox("Video");
        videoBox.setSelected(true);
        livreBox = new JCheckBox("Livre");
        livreBox.setSelected(true);
        optionPanel.add(audioBox);
        optionPanel.add(videoBox);
        optionPanel.add(livreBox);

        upperPanel.add(optionPanel);
        recherchePanel.add(upperPanel);

        resultatArea = new JTextArea();
        resultatArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultatArea);
        scroll.setPreferredSize(new Dimension(600,300));
        recherchePanel.add(scroll);
    }

    private void initClientPane(){
        clientPane = new JTabbedPane();
        initEmpruntPanel();
        clientPane.addTab("Emprunts", empruntPanel);
        initRecherchePanel();
        clientPane.addTab("Recherche",recherchePanel);
        initProfilPanel();
        clientPane.addTab("Profil", profilPanel);
        initAddEmpruntPanel();
        clientPane.addTab("Emprunter", addEmpruntPanel);
        initRetourPanel();
        clientPane.addTab("Retour", retourPanel);
    }

    private void initClientPanel(String nom,String prenom){
        clientPanel = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel(new BorderLayout());
        initUserLogged(prenom);
        userStatus = "client";
        infoPanel.add(userLogged, BorderLayout.CENTER);
        JButton logoutButton = new JButton("Déconnexion");
        logoutButton.addActionListener(this);
        logoutButton.setActionCommand("deconnect");
        infoPanel.add(logoutButton, BorderLayout.LINE_END);
        clientPanel.add(infoPanel, BorderLayout.NORTH);
        initClientPane();
        clientPanel.add(clientPane ,BorderLayout.CENTER);
    }

    private void initInvitePane(){
        invitePane = new JTabbedPane();

        initRecherchePanel();
        invitePane.addTab("Recherche",recherchePanel);

        initAddClientPanel();
        invitePane.addTab("S'inscrire", addClientPanel);

    }


    private void initInvitePanel(){

        invitePanel = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel(new BorderLayout());
        initUserLogged("invité");
        userStatus = "invite";
        infoPanel.add(userLogged, BorderLayout.CENTER);
        JButton logoutButton = new JButton("Quitter");
        logoutButton.addActionListener(this);
        logoutButton.setActionCommand("deconnect");
        infoPanel.add(logoutButton, BorderLayout.LINE_END);
        invitePanel.add(infoPanel, BorderLayout.NORTH);
        initInvitePane();
        invitePanel.add(invitePane ,BorderLayout.CENTER);
    }

    private void initLogPanel(){
        connectionPanel = new JPanel(new BorderLayout());
        connectionPanel.setBorder(BorderFactory.createTitledBorder("Connexion"));
        connectionPanel.setLayout(null);
        userLogged = null;
        userStatus = null;

        warning = new JLabel("Nom d'utilisateur ou mot de passe incorrect.");
        warning.setBounds(150, 120, 500, 25);
        warning.setForeground(Color.red);
        warning.setVisible(false);
        connectionPanel.add(warning);
        JLabel userLabel = new JLabel("Nom d'utilisateur");
        userLabel.setBounds(150, 150, 140, 25);
        connectionPanel.add(userLabel);

        userField = new JTextField();
        userField.setBounds(300, 150, 160, 25);
        connectionPanel.add(userField);

        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(150, 180, 120, 25);
        connectionPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(300, 180, 160, 25);
        connectionPanel.add(passwordField);

        employeBox = new JCheckBox("Employé");
        employeBox.setBounds(150, 210, 100, 25);
        connectionPanel.add(employeBox);

        JButton loginButton = new JButton("Connexion");
        loginButton.addActionListener(this);
        loginButton.setActionCommand("connect");
        loginButton.setBounds(150, 250, 120, 25);
        connectionPanel.add(loginButton);

        JButton inviteButton = new JButton("Invité");
        inviteButton.addActionListener(this);
        inviteButton.setActionCommand("invite");
        inviteButton.setBounds(300, 250, 120, 25);
        connectionPanel.add(inviteButton);
    }

    private void initUpdatePasswordPanel(){
        updatePasswordPanel = new JPanel(new GridLayout(6,1));
        msgPassPanel = new JPanel(new FlowLayout());
        warningPassLabel = new JLabel("Ancien mdp incorrecte");
        warningPassLabel.setVisible(false);
        warningPassLabel.setForeground(Color.red);
        msgPassPanel.add(warningPassLabel);
        updatePasswordPanel.add(msgPassPanel);

        JPanel lengendPassPanel = new JPanel(new FlowLayout());
        JLabel lengendPass = new JLabel("Modifier votre mot de passe");
        lengendPassPanel.add(lengendPass);
        updatePasswordPanel.add(lengendPassPanel);

        JPanel oldPassPanel = new JPanel(new FlowLayout());
        JLabel oldPass = new JLabel("Ancien mdp : ");
        oldPassField = new JPasswordField(10);
        oldPassPanel.add(oldPass);
        oldPassPanel.add(oldPassField);
        updatePasswordPanel.add(oldPassPanel);

        JPanel newPassPanel = new JPanel(new FlowLayout());
        JLabel newPass = new JLabel("Nouveau mdp : ");
        newPassField = new JPasswordField(10);
        newPassPanel.add(newPass);
        newPassPanel.add(newPassField);
        updatePasswordPanel.add(newPassPanel);

        JPanel confPassPanel = new JPanel(new FlowLayout());
        JLabel confPass = new JLabel("Confirmez mdp : ");
        confPassField = new JPasswordField(10);
        confPassPanel.add(confPass);
        confPassPanel.add(confPassField);
        updatePasswordPanel.add(confPassPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton changePassButton = new JButton("Valider");
        changePassButton.addActionListener(this);
        changePassButton.setActionCommand("valideNewPassword");
        updatePasswordPanel.add(changePassButton);

    }

    public LibrarySimulatorGUI(String name) {
        //maybe check if save file exists load it!
        //or else a tab for loading data and saving it
        name = name.replaceAll(" ", "_");
        this.m = new Mediatheque(name);
        this.clientLogged = null;
        try {
            File fichier =  new File("MEDIATHEQUE_"+name);
            if(fichier.exists()){
                m.initMediatheque();
            } else {
                Adresse adresse = new Adresse(12, "rue", "des pommiers", 75012, "Paris", "France");
                Employe emp = new Employe("admin","admin",adresse,"admin","admin");
                Client client = new Client("Dupont","Jean", adresse, CategorieClient.ETUDIANT);
                Audio cd = new Audio("Citizen of Glass", "Agnes Obel", 2016, "FZ6J63CJ8", "Classique", "Musique", "Classique", 40);
                Audio cd2 = new Audio("Aventine", "Agnes Obel", 2013, "ZGEJ634", "Classique", "Musique", "Classique", 37);
                Video dvd = new Video("Mommy", "Xavier Dolan", 2015, "JGR345J0", "Drame", "DVD", "Drame", 125);
                Livre livre = new Livre("Are you my mother?", "Alison Bechdel", 2006, "FZD9YE4", "Roman graphique", "Adulte", "BD", 157);
                FicheEmprunt fiche = new FicheEmprunt(client, cd);

                m.addEmploye(emp);
                m.addClient(client);
                m.addDocument(cd);
                m.addDocument(cd2);
                m.addDocument(dvd);
                m.addDocument(livre);
                m.addFicheEmprunt(fiche);
            }
        } catch (DataBaseException ex) {
            ex.printStackTrace();
        }

        frame = new JFrame("Library Simulator GUI");
        frame.setMinimumSize(new Dimension(640, 480));
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        initLogPanel();

        frame.add(connectionPanel);
        frame.pack();

    }

    private boolean checkChangePassword(){
        if( !(new String(oldPassField.getPassword())).trim().equals("")
        &&!(new String(newPassField.getPassword())).trim().equals("")
        &&!(new String(confPassField.getPassword())).trim().equals("")
        &&(new String(oldPassField.getPassword())).equals(clientLogged.getPassword())
        &&(new String(newPassField.getPassword())).equals(new String(confPassField.getPassword())) ){
            return true;
        }
        return false;
    }

    private boolean checkAddClient(){
        if (nomClient.getText().trim()=="" || prenomClient.getText().trim()=="" ||
         numeroClient.getText().trim()=="" || voieClient.getText().trim()=="" ||
         rueClient.getText().trim()=="" || postalClient.getText().trim()=="" ||
         villeClient.getText().trim()=="" || paysClient.getText().trim()==""){
                return false;
        }
        try {
            Integer.parseInt(numeroClient.getText());
            Integer.parseInt(postalClient.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean checkAddEmploye(){
        if (nomEmploye.getText().trim()=="" || prenomEmploye.getText().trim()=="" ||
         usernameEmploye.getText().trim()=="" || (new String(passwordEmploye.getPassword())).trim()=="" ||
         (new String(confirmPasswordEmploye.getPassword())).trim()=="" || numeroEmploye.getText().trim()=="" ||
         voieEmploye.getText().trim()=="" || rueEmploye.getText().trim()=="" ||
         postalEmploye.getText().trim()=="" || villeEmploye.getText().trim()=="" ||
         paysEmploye.getText().trim()==""){
                return false;
        }
        try {
            Integer.parseInt(numeroEmploye.getText());
            Integer.parseInt(postalEmploye.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean checkAddDocument(){
        if (titreDocument.getText().trim()=="" || auteurDocument.getText().trim()=="" ||
         genreDocument.getText().trim()=="" || isbnDocument.getText().trim()=="" ||
         salleDocument.getText().trim()=="" || rayonDocument.getText().trim()==""){
                return false;
        }
        try {
            Integer.parseInt(anneeDocument.getText());
            if(typeLivre.isSelected()){
                Integer.parseInt(tailleDocument.getText());
            } else {
                Double.parseDouble(tailleDocument.getText());
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean checkLoginEmploye(){
        for(Employe e : m.getListeEmployes()){
            if(e.getUsername().equals(usernameEmploye.getText().trim())){
            return false;
            }
        }
        return true;
    }

    public boolean checkPasswordEmploye(){
        return (new String(passwordEmploye.getPassword())).trim().equals((new String(confirmPasswordEmploye.getPassword())).trim());
    }

    private boolean checkAddEmprunt(){
        if (titreDocEmprunt.getText().trim()=="" || auteurDocEmprunt.getText().trim()=="" ||
         nomClientEmprunt.getText().trim()=="" || prenomClientEmprunt.getText().trim()==""){
                return false;
        }
        return true;
    }

    private boolean checkRetour(){
        if (titreDocRetour.getText().trim()=="" || auteurDocRetour.getText().trim()=="" ||
         nomClientRetour.getText().trim()=="" || prenomClientRetour.getText().trim()==""){
                return false;
        }
        return true;
    }

    private String stringSize(String str, int length) {
        for (int i = str.length(); i<length; i++)
            str += " ";
        return str;
    }

    private String booleanToString(boolean b){
        if(b){
            return "Oui";
        }
        return "Non";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "connect":
                String username = this.userField.getText();
                String password = (new String(this.passwordField.getPassword()));
                boolean found = false;
                if (employeBox.isSelected()) {
                    Employe employe = m.logEmploye(username, password);
                    if (employe != null) {
                        found = true;
                        updateFrame();
                        initEmployePanel(employe.getNom(), employe.getPrenom());
                        frame.add(employePanel);
                        frame.pack();
                    }
                } else {
                    Client client = m.logClient(username, password);
                    if (client != null) {
                        found = true;
                        updateFrame();
                        clientLogged = client;
                        initClientPanel(client.getNom(), client.getPrenom());
                        frame.add(clientPanel);
                        frame.pack();
                    }
                }
                if(!found){
                    warning.setVisible(true);
                    frame.pack();
                }
                break;
            case "invite":
                updateFrame();
                initInvitePanel();
                frame.add(invitePanel);
                frame.pack();
                break;
            case "deconnect":
                clientLogged = null;
                updateFrame();
                SwingUtilities.updateComponentTreeUI(frame);
                frame.invalidate();
                frame.validate();
                frame.repaint();
                initLogPanel();
                frame.add(connectionPanel);
                frame.pack();
                break;
            case "AddClient":
                //Client(String nom, String prenom, Adresse adresse, CategorieClient categorie)
                if(checkAddClient()){
                    Adresse adresse = new Adresse(Integer.parseInt(numeroClient.getText()),
                    voieClient.getText(), rueClient.getText(), Integer.parseInt(postalClient.getText()),
                    villeClient.getText(), paysClient.getText());
                    CategorieClient categorie;
                    categorie = CategorieClient.PARTICULIER;
                    if(categEtudiant.isSelected()){
                        categorie = CategorieClient.ETUDIANT;
                    }
                    if(categEntreprise.isSelected()){
                        categorie = CategorieClient.ENTREPRISE;
                    }
                    Client client = new Client(nomClient.getText(), prenomClient.getText(),
                    adresse, categorie);
                    if(!m.getListeClients().contains(client)){
                        m.addClient(client);
                        m.sauvegardeMediatheque();
                        warningAddClient.setVisible(false);
                        confirmAddClient.setVisible(true);
                        msgAddClient.removeAll();
                        msgAddClient.add(confirmAddClient);
                        JOptionPane.showMessageDialog(frame, "Le login et le mot de passe sont : "+(client.getPrenom()+client.getNom()).toLowerCase()+". Pensez à les modifier!", "Login utilisateur", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        warningAddClient.setText("Cet utilisateur existe déjà!");
                        warningAddClient.setBounds(warningAddClient.getX(),warningAddClient.getY(),10,warningAddClient.getHeight());
                        confirmAddClient.setVisible(false);
                        warningAddClient.setVisible(true);
                        msgAddClient.removeAll();
                        msgAddClient.add(warningAddClient);
                    }
                } else {
                    warningAddClient.setText("Infos incorrectes, recommencez.");
                    warningAddClient.setBounds(warningAddClient.getX(),warningAddClient.getY(),10,warningAddClient.getHeight());
                    confirmAddClient.setVisible(false);
                    warningAddClient.setVisible(true);
                    msgAddClient.removeAll();
                    msgAddClient.add(warningAddClient);
                }
                frame.pack();
                break;
            case "AddEmploye":
                if(checkAddEmploye()){
                    Adresse adresse = new Adresse(Integer.parseInt(numeroEmploye.getText()),
                    voieEmploye.getText(), rueEmploye.getText(), Integer.parseInt(postalEmploye.getText()),
                    villeEmploye.getText(), paysEmploye.getText());
                    if(checkLoginEmploye() && checkPasswordEmploye()){
                        Employe employe = new Employe(nomEmploye.getText(), prenomEmploye.getText(),
                        adresse, usernameEmploye.getText(), (new String(passwordEmploye.getPassword())));
                        if(!m.getListeEmployes().contains(employe)){
                            m.addEmploye(employe);
                            m.sauvegardeMediatheque();
                            warningAddEmploye.setVisible(false);
                            confirmAddEmploye.setVisible(true);
                            msgAddEmploye.removeAll();
                            msgAddEmploye.add(confirmAddEmploye);
                        } else {
                            warningAddEmploye.setText("Cet employe existe déjà!");
                            warningAddEmploye.setBounds(warningAddEmploye.getX(),warningAddEmploye.getY(),10,warningAddEmploye.getHeight());
                            confirmAddEmploye.setVisible(false);
                            warningAddEmploye.setVisible(true);
                            msgAddEmploye.removeAll();
                            msgAddEmploye.add(warningAddEmploye);
                        }
                    } else {
                        if(!checkLoginEmploye()){
                            warningAddEmploye.setText("Login dejà utilisé.");
                        } else if(!checkPasswordEmploye()){
                            warningAddEmploye.setText("Les mots de passe ne sont pas les mêmes!");
                        }
                        warningAddEmploye.setBounds(warningAddEmploye.getX(),warningAddEmploye.getY(),10,warningAddEmploye.getHeight());
                        confirmAddEmploye.setVisible(false);
                        warningAddEmploye.setVisible(true);
                        msgAddEmploye.removeAll();
                        msgAddEmploye.add(warningAddEmploye);
                    }
                } else {
                    warningAddEmploye.setText("Infos incorrectes, recommencez.");
                    warningAddEmploye.setBounds(warningAddEmploye.getX(),warningAddEmploye.getY(),10,warningAddEmploye.getHeight());
                    confirmAddEmploye.setVisible(false);
                    warningAddEmploye.setVisible(true);
                    msgAddEmploye.removeAll();
                    msgAddEmploye.add(warningAddEmploye);
                }
                frame.pack();
                break;
            case "AddDocument":
                if(checkAddDocument()){
                    Document document = null;
                    if(typeAudio.isSelected()){
                        document = new Audio(titreDocument.getText(), auteurDocument.getText(),
                        Integer.parseInt(anneeDocument.getText()), isbnDocument.getText(),
                        genreDocument.getText(), salleDocument.getText(), rayonDocument.getText(),
                        Double.parseDouble(tailleDocument.getText()));
                    } else if(typeVideo.isSelected()){
                        document = new Video(titreDocument.getText(), auteurDocument.getText(),
                        Integer.parseInt(anneeDocument.getText()), isbnDocument.getText(),
                        genreDocument.getText(), salleDocument.getText(), rayonDocument.getText(),
                        Double.parseDouble(tailleDocument.getText()));
                    } else {
                        document = new Livre(titreDocument.getText(), auteurDocument.getText(),
                        Integer.parseInt(anneeDocument.getText()), isbnDocument.getText(),
                        genreDocument.getText(), salleDocument.getText(), rayonDocument.getText(),
                        Integer.parseInt(tailleDocument.getText()));
                    }
                    if(document!=null && !m.getListeDocuments().contains(document)){
                        m.addDocument(document);
                        m.sauvegardeMediatheque();
                        warningAddDocument.setVisible(false);
                        confirmAddDocument.setVisible(true);
                        msgAddDocument.removeAll();
                        msgAddDocument.add(confirmAddDocument);
                    } else {
                        warningAddDocument.setText("Ce document existe déjà!");
                        warningAddDocument.setBounds(warningAddDocument.getX(),warningAddDocument.getY(),10,warningAddDocument.getHeight());
                        confirmAddDocument.setVisible(false);
                        warningAddDocument.setVisible(true);
                        msgAddDocument.removeAll();
                        msgAddDocument.add(warningAddDocument);
                    }
                } else {
                    warningAddDocument.setText("Infos incorrectes, recommencez.");
                    warningAddDocument.setBounds(warningAddDocument.getX(),warningAddDocument.getY(),10,warningAddDocument.getHeight());
                    confirmAddDocument.setVisible(false);
                    warningAddDocument.setVisible(true);
                    msgAddDocument.removeAll();
                    msgAddDocument.add(warningAddDocument);
                }
                frame.pack();
                break;
            case "MultimediaLabel":
                taillePanel.removeAll();
                taillePanel.add(dureeDocumentLabel);
                taillePanel.add(tailleDocument);
                frame.revalidate();
                frame.repaint();
                frame.pack();
                break;
            case "LivreLabel":
                taillePanel.removeAll();
                taillePanel.add(pagesDocumentLabel);
                taillePanel.add(tailleDocument);
                frame.revalidate();
                frame.repaint();
                frame.pack();
                break;
            case "ClearEmploye":
                warningAddEmploye.setVisible(false);
                confirmAddEmploye.setVisible(false);
                usernameEmploye.setText("");
                passwordEmploye.setText("");
                confirmPasswordEmploye.setText("");
                nomEmploye.setText("");
                prenomEmploye.setText("");
                numeroEmploye.setText("");
                voieEmploye.setText("");
                rueEmploye.setText("");
                postalEmploye.setText("");
                villeEmploye.setText("");
                paysEmploye.setText("");
                break;
            case "ClearClient":
                warningAddClient.setVisible(false);
                confirmAddClient.setVisible(false);
                categParticulier.setSelected(true);
                nomClient.setText("");
                prenomClient.setText("");
                numeroClient.setText("");
                voieClient.setText("");
                rueClient.setText("");
                postalClient.setText("");
                villeClient.setText("");
                paysClient.setText("");
                break;
            case "ClearDocument":
                warningAddDocument.setVisible(false);
                confirmAddDocument.setVisible(false);
                typeLivre.setSelected(true);
                titreDocument.setText("");
                auteurDocument.setText("");
                anneeDocument.setText("");
                isbnDocument.setText("");
                genreDocument.setText("");
                salleDocument.setText("");
                rayonDocument.setText("");
                tailleDocument.setText("");
                taillePanel.removeAll();
                taillePanel.add(pagesDocumentLabel);
                taillePanel.add(tailleDocument);
                frame.revalidate();
                frame.repaint();
                frame.pack();
                break;
            case "AddEmprunt":
                if(checkAddEmprunt()){
                    Document document = m.getDocument(titreDocEmprunt.getText(), auteurDocEmprunt.getText());
                    Client client = m.getClient(nomClientEmprunt.getText(), prenomClientEmprunt.getText());

                    if(document!=null && client!=null &&(!document.getEmprunte()) && m.getListeDocuments().contains(document) && m.getListeClients().contains(client)){
                        FicheEmprunt fiche = new FicheEmprunt(client, document);
                        m.addFicheEmprunt(fiche);
                        m.sauvegardeMediatheque();
                        warningAddEmprunt.setVisible(false);
                        restantEmprunt.setVisible(false);
                        confirmAddEmprunt.setVisible(true);
                        msgAddEmprunt.removeAll();
                        msgAddEmprunt.add(confirmAddEmprunt);
                        msgRetour.removeAll();
                        int currentRetours = m.empruntClient(clientLogged).size();
                        restantRetour = new JLabel("Il vous reste "+currentRetours+" emprunts à retourner.");
                        restantRetour.setBounds(restantRetour.getX(),restantRetour.getY(),10,restantRetour.getHeight());
                        restantRetour.setVisible(true);
                        msgRetour.add(restantRetour);
                        if(clientLogged!=null){
                            initEmpruntPanel();
                            clientPane.setComponentAt(0, empruntPanel);
                        }

                    } else {
                        if(document==null || !m.getListeDocuments().contains(document)){
                            warningAddEmprunt.setText("Ce document n'existe pas!");
                        } else if(document.getEmprunte()){
                            warningAddEmprunt.setText("Ce document n'est pas disponible!");
                        }

                        if(client==null || !m.getListeClients().contains(client)){
                            warningAddEmprunt.setText("Cet utilisateur n'existe pas!");
                        }

                        warningAddEmprunt.setBounds(warningAddEmprunt.getX(),warningAddEmprunt.getY(),10,warningAddEmprunt.getHeight());
                        confirmAddEmprunt.setVisible(false);
                        restantEmprunt.setVisible(false);
                        warningAddEmprunt.setVisible(true);
                        msgAddEmprunt.removeAll();
                        msgAddEmprunt.add(warningAddEmprunt);
                    }
                } else {
                    warningAddEmprunt.setText("Infos incorrectes, recommencez.");
                    warningAddEmprunt.setBounds(warningAddEmprunt.getX(),warningAddEmprunt.getY(),10,warningAddEmprunt.getHeight());
                    confirmAddEmprunt.setVisible(false);
                    restantEmprunt.setVisible(false);
                    warningAddEmprunt.setVisible(true);
                    msgAddEmprunt.removeAll();
                    msgAddEmprunt.add(warningAddEmprunt);
                }
                if(clientLogged!=null){
                    initEmpruntPanel();
                }
                frame.pack();
                break;
            case "ClearEmprunt":
                titreDocEmprunt.setText("");
                auteurDocEmprunt.setText("");
                confirmAddEmprunt.setVisible(false);
                warningAddEmprunt.setVisible(false);
                msgAddEmprunt.removeAll();
                if(clientLogged==null){
                    nomClientEmprunt.setText("");
                    prenomClientEmprunt.setText("");
                } else {
                    int empruntMax = clientLogged.getCategorie().getEmpruntsMax();
                    int currentEmprunts = m.empruntClient(clientLogged).size();
                    int empruntRestant = empruntMax-currentEmprunts;
                    restantEmprunt = new JLabel("Vous pouvez encore effecuer "+empruntRestant+" emprunts");
                    restantEmprunt.setBounds(restantEmprunt.getX(),restantEmprunt.getY(),10,restantEmprunt.getHeight());
                    restantEmprunt.setVisible(true);
                    msgAddEmprunt.add(restantEmprunt);
                    msgRetour.removeAll();
                    int currentRetours = m.empruntClient(clientLogged).size();
                    restantRetour = new JLabel("Il vous reste "+currentRetours+" emprunts à retourner.");
                    restantRetour.setBounds(restantRetour.getX(),restantRetour.getY(),10,restantRetour.getHeight());
                    restantRetour.setVisible(true);
                    msgRetour.add(restantRetour);
                }
                frame.pack();
                break;
            case "Retour":
                if(checkRetour()){
                    Document document = m.getDocument(titreDocRetour.getText(), auteurDocRetour.getText());
                    Client client = m.getClient(nomClientRetour.getText(), prenomClientRetour.getText());

                    if(document!=null && client!=null && document.getEmprunte() && m.getListeDocuments().contains(document) && m.getListeClients().contains(client)){
                        boolean removed = m.removeFicheEmprunt(client, document);
                        if(removed){
                            m.sauvegardeMediatheque();
                            warningRetour.setVisible(false);
                            restantRetour.setVisible(false);
                            confirmRetour.setVisible(true);
                            msgRetour.removeAll();
                            msgRetour.add(confirmRetour);
                            msgAddEmprunt.removeAll();
                            if(clientLogged!=null){
                                int empruntMax = clientLogged.getCategorie().getEmpruntsMax();
                                int currentEmprunts = m.empruntClient(clientLogged).size();
                                int empruntRestant = empruntMax-currentEmprunts;
                                restantEmprunt = new JLabel("Vous pouvez encore effecuer "+empruntRestant+" emprunts");
                                restantEmprunt.setBounds(restantEmprunt.getX(),restantEmprunt.getY(),10,restantEmprunt.getHeight());
                                restantEmprunt.setVisible(true);
                                msgAddEmprunt.add(restantEmprunt);
                                if(clientLogged!=null){
                                    initEmpruntPanel();
                                    clientPane.setComponentAt(0, empruntPanel);
                                }

                            }
                        } else {
                            if(clientLogged==null){
                                warningRetour.setText("Ce document n'est pas emprunté par "+client.getPrenom()+" "+client.getNom());
                            } else {
                                warningRetour.setText("Ce document n'est pas dans vos emprunts. ");
                            }
                        }


                    } else {
                        if(document==null || !m.getListeDocuments().contains(document)){
                            warningRetour.setText("Ce document n'existe pas!");
                        } else if(!document.getEmprunte()){
                            warningRetour.setText("Ce document n'est pas emprunté!");
                        }

                        if(client==null || !m.getListeClients().contains(client)){
                            warningRetour.setText("Cet utilisateur n'existe pas!");
                        }

                        warningRetour.setBounds(warningRetour.getX(),warningRetour.getY(),10,warningRetour.getHeight());
                        confirmRetour.setVisible(false);
                        restantRetour.setVisible(false);
                        warningRetour.setVisible(true);
                        msgRetour.removeAll();
                        msgRetour.add(warningRetour);
                    }
                } else {
                    warningRetour.setText("Infos incorrectes, recommencez.");
                    warningRetour.setBounds(warningRetour.getX(),warningRetour.getY(),10,warningRetour.getHeight());
                    confirmRetour.setVisible(false);
                    restantRetour.setVisible(false);
                    warningRetour.setVisible(true);
                    msgRetour.removeAll();
                    msgRetour.add(warningRetour);
                }
                if(clientLogged!=null){
                    initRetourPanel();
                }
                frame.pack();
                break;
            case "ClearRetour":
                titreDocRetour.setText("");
                auteurDocRetour.setText("");
                confirmRetour.setVisible(false);
                warningRetour.setVisible(false);
                msgRetour.removeAll();
                frame.pack();

                if(clientLogged==null){
                    nomClientRetour.setText("");
                    prenomClientRetour.setText("");
                } else {
                    msgAddEmprunt.removeAll();
                    int empruntMax = clientLogged.getCategorie().getEmpruntsMax();
                    int currentEmprunts = m.empruntClient(clientLogged).size();
                    int empruntRestant = empruntMax-currentEmprunts;
                    restantEmprunt = new JLabel("Vous pouvez encore effecuer "+empruntRestant+" emprunts");
                    restantEmprunt.setBounds(restantEmprunt.getX(),restantEmprunt.getY(),10,restantEmprunt.getHeight());
                    restantEmprunt.setVisible(true);
                    msgAddEmprunt.add(restantEmprunt);
                    int currentRetours = m.empruntClient(clientLogged).size();
                    restantRetour = new JLabel("Il vous reste "+currentRetours+" emprunts à retourner.");
                    restantRetour.setBounds(restantRetour.getX(),restantRetour.getY(),10,restantRetour.getHeight());
                    restantRetour.setVisible(true);
                    msgRetour.add(restantRetour);
                }
                frame.revalidate();
                frame.repaint();
                frame.pack();
                break;
            case "UpdateSearch":
                String motif = rechercheField.getText();
                ArrayList<Client> resClient = null;
                ArrayList<Document> resDocument = null;
                String res = "";
                if(clientButton.isSelected()){
                    resClient = m.getClientStartsWith(motif, nomBox.isSelected(), prenomBox.isSelected());
                    res += " Nom                 | Prenom             | Nb d'emprunts \n";
                    for(Client c: resClient){
                        res += " "+stringSize(c.getNom(), 17)+" | "+stringSize(c.getPrenom(), 19)+" | "+stringSize(Integer.toString(m.empruntClient(c).size()), 13)+"\n";
                    }
                } else {
                    resDocument = m.getDocumentStartsWith(motif, audioBox.isSelected(), videoBox.isSelected(), livreBox.isSelected());
                    res += " Titre                               | Auteur                 | Emprunté | Retour   | Salle           | Rayon      \n";
                    for(Document d: resDocument){
                        String retourDate = "--/--/--";
                        if(d.getEmprunte()){
                            FicheEmprunt f = m.getFiche(d);
                            Date date = null;
                            if(f!=null){
                                SimpleDateFormat dateFromatter = new SimpleDateFormat("d/M/Y");
                                retourDate = dateFromatter.format(f.getDateFin());
                            }
                        }
                        res += " "+stringSize(d.getTitre(), 31)+" | "+stringSize(d.getAuteur(), 19)+" | "+stringSize(booleanToString(d.getEmprunte()), 9)+" | "+retourDate+" | "+stringSize(d.getSalle(), 16)+" | "+stringSize(d.getRayon(), 11)+"\n";
                    }
                }
                resultatArea.setText(res);
                frame.revalidate();
                frame.repaint();
                frame.pack();
                break;
            case "SearchClient":
                optionPanel.removeAll();
                optionPanel.add(nomBox);
                optionPanel.add(prenomBox);
                frame.revalidate();
                frame.repaint();
                frame.pack();
                break;
            case "SearchDocument":
                optionPanel.removeAll();
                optionPanel.add(audioBox);
                optionPanel.add(videoBox);
                optionPanel.add(livreBox);
                frame.revalidate();
                frame.repaint();
                frame.pack();
                break;
            case "editPassword":
                editPasswordFrame = new JFrame("Modifier le mot de passe");
                editPasswordFrame.setMinimumSize(new Dimension(300, 200));
                editPasswordFrame.setLayout(new BorderLayout());
                //editPasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                editPasswordFrame.setVisible(true);
                initUpdatePasswordPanel();
                editPasswordFrame.add(updatePasswordPanel);
                editPasswordFrame.pack();
                break;
            case "valideNewPassword":
                if(checkChangePassword()){
                    clientLogged.setPassword(new String(newPassField.getPassword()));
                    editPasswordFrame.dispose();
                    JOptionPane.showMessageDialog(frame, "Mot de passe modifié avec succès.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    m.sauvegardeMediatheque();
                } else {
                    if(!(new String(oldPassField.getPassword())).equals(clientLogged.getPassword())){
                        warningPassLabel = new JLabel("Ancien mdp incorrecte");
                        warningPassLabel.setForeground(Color.red);
                        warningPassLabel.setVisible(true);
                        msgPassPanel.removeAll();
                        msgPassPanel.add(warningPassLabel);
                    }else if((new String(newPassField.getPassword()))!=(new String(confPassField.getPassword()))){
                        warningPassLabel = new JLabel("Tapez le même nouveau mdp");
                        warningPassLabel.setForeground(Color.red);
                        warningPassLabel.setVisible(true);
                        msgPassPanel.removeAll();
                        msgPassPanel.add(warningPassLabel);
                    }
                    editPasswordFrame.revalidate();
                    editPasswordFrame.repaint();
                    editPasswordFrame.pack();
                }
                break;
            default:
                break;
        }

    }

    public static void main(String[] args) {
        if(args.length>0){
            new LibrarySimulatorGUI(args[0]);
        } else {
            new LibrarySimulatorGUI("Helene_Berr");
        }
    }
}
