package View;

import Data.BDException;
import View.groupe.GroupeListerGenrePanel;
import View.groupe.GroupeInscriptionMainPanel;
import View.groupe.GroupeListingPanel;
import View.groupe.RechMembrePanel;
import View.scene.GestionGroupeAScenePanel;
import View.stand.StandInscriptionPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * MenuBar for the {@link MainFrame}
 * @author Cramike
 * @version 0.5
 *  
 */
public class BarreMenu extends JMenuBar {

    private JMenu fichier,  stand,  groupe,  personnel,  scene;
    private JMenuItem fichier_quitter;
    private JMenuItem fichier_seDeconnecter;
    private JMenuItem stand_inscription,  stand_listing,  stand_recherche;
    private JMenuItem groupe_inscription,  groupe_rechMembre,  groupe_listing;
    private JMenuItem personnel_ajout,  personnel_listing,  personnel_horaire;
    private JMenuItem scene_enregCarac,  scene_listing,  scene_horaireConcerts;
    private MainFrame frame;
    private ActionManager am;
    private JMenuItem groupe_listerGroupeAScene;
    private JMenuItem scene_gestionGroupeEtScene;

    public BarreMenu(MainFrame frame) {
        this.frame = frame;

        //Déclaration des JMenu
        fichier = new JMenu("Fichier");
        stand = new JMenu("Stand");
        groupe = new JMenu("Groupe");
        personnel = new JMenu("Personnel");
        scene = new JMenu("Scene");

        //Déclaration des JMenuItem
        fichier_quitter = new JMenuItem("Quitter");
        fichier_seDeconnecter = new JMenuItem("Se déconnecter");
        stand_inscription = new JMenuItem("Réserver stand");
        stand_listing = new JMenuItem("Lister stands");
        stand_recherche = new JMenuItem("Rechercher un stand");
        groupe_inscription = new JMenuItem("Inscrire groupe");
        groupe_rechMembre = new JMenuItem("Rechercher un membre");
        groupe_listing = new JMenuItem("Lister groupes");
        groupe_listerGroupeAScene = new JMenuItem("Lister les groupes par genre");
        personnel_ajout = new JMenuItem("Ajouter un ouvrier");
        personnel_listing = new JMenuItem("Lister ouvriers");
        personnel_horaire = new JMenuItem("Horaire de travail");
        scene_enregCarac = new JMenuItem("Enregistrer les Caractéristiques");
        scene_listing = new JMenuItem("Lister scènes");
        scene_gestionGroupeEtScene = new JMenuItem("Gestion des scènes");
        scene_horaireConcerts = new JMenuItem("Horaire des concerts");

        //Raccourcis clavier et mnémomic des JMenu
        fichier.setMnemonic(KeyEvent.VK_F);
        stand.setMnemonic(KeyEvent.VK_A);
        groupe.setMnemonic(KeyEvent.VK_G);
        personnel.setMnemonic(KeyEvent.VK_P);
        scene.setMnemonic(KeyEvent.VK_S);

        //Raccourcis et mnémomic des JMenuItem
        //Fichier
        fichier_quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
        fichier_quitter.setMnemonic(KeyEvent.VK_Q);
        fichier_seDeconnecter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
        fichier_seDeconnecter.setMnemonic(KeyEvent.VK_S);
        //Stand
        stand_inscription.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_MASK));
        stand_inscription.setMnemonic(KeyEvent.VK_I);
        stand_listing.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        stand_listing.setMnemonic(KeyEvent.VK_L);
        stand_recherche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
        stand_recherche.setMnemonic(KeyEvent.VK_R);
        //Groupe
        groupe_inscription.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_MASK));
        groupe_inscription.setMnemonic(KeyEvent.VK_I);
        groupe_rechMembre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
        groupe_inscription.setMnemonic(KeyEvent.VK_N);
        groupe_listing.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        groupe_listing.setMnemonic(KeyEvent.VK_L);
        groupe_listerGroupeAScene.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
        groupe_listerGroupeAScene.setMnemonic(KeyEvent.VK_O);
        //Personnel
        personnel_ajout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.ALT_MASK));
        personnel_ajout.setMnemonic(KeyEvent.VK_J);
        personnel_listing.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        personnel_listing.setMnemonic(KeyEvent.VK_L);
        personnel_horaire.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_MASK));
        personnel_horaire.setMnemonic(KeyEvent.VK_H);
        //Scene
        scene_enregCarac.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        scene_enregCarac.setMnemonic(KeyEvent.VK_E);
        scene_listing.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        scene_listing.setMnemonic(KeyEvent.VK_L);
        scene_horaireConcerts.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_MASK));
        scene_horaireConcerts.setMnemonic(KeyEvent.VK_H);
        scene_gestionGroupeEtScene.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.ALT_MASK));
        scene_gestionGroupeEtScene.setMnemonic(KeyEvent.VK_G);

        //Action Manager
        am = new ActionManager();

        //Add au fichier
        fichier_quitter.addActionListener(am);
        fichier.add(fichier_quitter);
        fichier_seDeconnecter.addActionListener(am);
        fichier.add(fichier_seDeconnecter);

        //Add au stand
        stand_inscription.addActionListener(am);
        stand.add(stand_inscription);
        stand_listing.addActionListener(am);
        stand.add(stand_listing);
        stand_recherche.addActionListener(am);
        stand.add(stand_recherche);

        //Add au groupe
        groupe_inscription.addActionListener(am);
        groupe.add(groupe_inscription);
        groupe_rechMembre.addActionListener(am);
        groupe.add(groupe_rechMembre);
        groupe_listing.addActionListener(am);
        groupe.add(groupe_listing);
        groupe_listerGroupeAScene.addActionListener(am);
        groupe.add(groupe_listerGroupeAScene);

        //Add au personnel
        personnel_ajout.addActionListener(am);
        personnel.add(personnel_ajout);
        personnel_horaire.addActionListener(am);
        personnel.add(personnel_horaire);
        personnel_listing.addActionListener(am);
        personnel.add(personnel_listing);

        //Add à la scene
        scene_enregCarac.addActionListener(am);
        scene.add(scene_enregCarac);
        scene_horaireConcerts.addActionListener(am);
        scene.add(scene_horaireConcerts);
        scene_listing.addActionListener(am);
        scene.add(scene_listing);
        scene_gestionGroupeEtScene.addActionListener(am);
        scene.add(scene_gestionGroupeEtScene);

        //Add au menu
        add(fichier);
        add(stand);
        add(groupe);
        add(personnel);
        add(scene);
    }

    /**
     * This is the ActionManager for the Class {@link BarreMenu}
     */
    private class ActionManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fichier_quitter) {
                System.exit(0);
            }
            if (e.getSource() == fichier_seDeconnecter) {
                try {
                    Controller.Controller.closeConnection();
                    frame.afficherPanel(new ConnexPanel(frame));
                } catch (BDException ex) {
                    frame.getBarreInfo().setText("Problème de déconnexion, si le problème persiste, redémarrer le programme");
                }
                
            }
            if (e.getSource() == stand_inscription) {
                frame.afficherPanel(new StandInscriptionPanel(frame.getBarreInfo()));
            }
            if (e.getSource() == stand_listing) {
                //frame.afficherPanel(new StandListingPanel());
            }
            if (e.getSource() == groupe_inscription) {
                frame.afficherPanel(new GroupeInscriptionMainPanel(frame));
            }
            if (e.getSource() == groupe_rechMembre) {
                frame.afficherPanel(new RechMembrePanel(frame));
            }
            if (e.getSource() == groupe_listing) {
                frame.afficherPanel(new GroupeListingPanel(frame.getBarreInfo()));
            }
            if (e.getSource() == groupe_listerGroupeAScene) {
                frame.afficherPanel(new GroupeListerGenrePanel(frame));
            }
            if (e.getSource() == personnel_ajout) //frame.afficherPanel(
            {
            }
            if (e.getSource() == personnel_horaire) //frame.afficherPanel(
            {
            }
            if (e.getSource() == personnel_listing) //frame.afficherPanel(
            {
            }
            if (e.getSource() == scene_enregCarac) //frame.afficherPanel(
            {
                frame.afficherPanel(new View.scene.SceneInscriptionJPanel(frame));
            }
            if (e.getSource() == scene_horaireConcerts) //frame.afficherPanel(
            {
            }
            if (e.getSource() == scene_listing) {
                //frame.afficherPanel(
            }
            if(e.getSource() == scene_gestionGroupeEtScene)
            {
                frame.afficherPanel(new GestionGroupeAScenePanel(frame));
            }
        }
    }
}
