
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class LibrarySimulatorGUI implements ActionListener {

    Mediatheque m;
    JFrame frame;
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

        confirmAddClient = new JLabel("Client bien ajouté!");
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

        JPanel validatePanel = new JPanel(new FlowLayout());
        JButton validateButton = new JButton("Valider");
        validateButton.addActionListener(this);
        validateButton.setActionCommand("AddClient");
        validatePanel.add(validateButton);
        addClientPanel.add(validatePanel);
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

        JPanel validatePanel = new JPanel(new FlowLayout());
        JButton validateButton = new JButton("Valider");
        validateButton.addActionListener(this);
        validateButton.setActionCommand("AddEmploye");
        validatePanel.add(validateButton);
        addEmployePanel.add(validatePanel);
    }

    private void initEmployePane(){
        employePane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        employePane.addTab("Recherche",panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        employePane.addTab("Ajout Document", panel2);

        initAddClientPanel();
        employePane.addTab("Ajout Client", addClientPanel);

        initAddEmployePanel();
        employePane.addTab("Ajout Employé", addEmployePanel);
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

    private void initClientPane(){
        clientPane = new JTabbedPane();
        JLabel welcome = new JLabel("WELCOME BITCHES");
        JButton button = new JButton("prout");
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(welcome, BorderLayout.CENTER);
        panel1.add(button, BorderLayout.SOUTH);
        clientPane.addTab("Tab 1",panel1);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        clientPane.addTab("Tab 2", panel2);
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        clientPane.addTab("Tab 3", panel3);
        JPanel panel4 = new JPanel(null);
        panel4.setLayout(new BorderLayout());
        clientPane.addTab("Tab 4", panel4);
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
        //----------------------------------------------------------------------
        initClientPane();
        //----------------------------------------------------------------------
        clientPanel.add(clientPane ,BorderLayout.CENTER);
    }

    private void initInvitePane(){
        invitePane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        invitePane.addTab("Recherche",panel1);

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
        //----------------------------------------------------------------------
        initInvitePane();
        //----------------------------------------------------------------------
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

    LibrarySimulatorGUI(String name) {
        //maybe check if save file exists load it!
        //or else a tab for loading data and saving it
        name = name.replaceAll(" ", "_");
        this.m = new Mediatheque(name);
        try {
            File fichier =  new File("MEDIATHEQUE_"+name);
            if(fichier.exists()){
                m.initMediatheque();
            } else {
                Adresse adresse = new Adresse(12, "rue", "des pommiers", 75012, "Paris", "France");
                Employe emp = new Employe("admin","admin",adresse,"admin","admin");
                m.addEmploye(emp);
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
         usernameEmploye.getText().trim()=="" || passwordEmploye.getText().trim()=="" ||
         confirmPasswordEmploye.getText().trim()=="" || numeroEmploye.getText().trim()=="" ||
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

    public boolean checkLoginEmploye(){
        for(Employe e : m.getListeEmployes()){
            if(e.getUsername().equals(usernameEmploye.getText().trim())){
            return false;
            }
        }
        return true;
    }

    public boolean checkPasswordEmploye(){
        return passwordEmploye.getText().trim().equals(confirmPasswordEmploye.getText().trim());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "connect":
                String username = this.userField.getText();
                String password = this.passwordField.getText();
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
                        //-------------------------------------------------------
                        System.out.println(m);
                        //-------------------------------------------------------
                        warningAddClient.setVisible(false);
                        confirmAddClient.setVisible(true);
                        msgAddClient.removeAll();
                        msgAddClient.add(confirmAddClient);
                    } else {
                        warningAddClient.setText("Ce client existe déjà!");
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
                //TO DO
                if(checkAddEmploye()){
                    Adresse adresse = new Adresse(Integer.parseInt(numeroEmploye.getText()),
                    voieEmploye.getText(), rueEmploye.getText(), Integer.parseInt(postalEmploye.getText()),
                    villeEmploye.getText(), paysEmploye.getText());
                    if(checkLoginEmploye() && checkPasswordEmploye()){
                        Employe employe = new Employe(nomEmploye.getText(), prenomEmploye.getText(),
                        adresse, usernameEmploye.getText(), passwordEmploye.getText());
                        if(!m.getListeEmployes().contains(employe)){
                            m.addEmploye(employe);
                            m.sauvegardeMediatheque();
                            System.out.println(m);
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
            default:
                break;
        }

    }

    public static void main(String[] args) {
        new LibrarySimulatorGUI("Pouic");
    }
}
