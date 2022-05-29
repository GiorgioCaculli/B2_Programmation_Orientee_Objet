package it.caculli.gzc.poo.ui.gui;

import java.io.File;

import it.caculli.gzc.poo.core.Etudiant;
import it.caculli.gzc.poo.core.GestionEtudiant;
import it.caculli.gzc.poo.util.Serialization;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class TopMenuBar extends MenuBar
{
    private GestionEtudiant gestion;
    private Menu menuFichier = new Menu( "Fichier" );
    private MenuItem menuItemOuvrir = new MenuItem( "Ouvrir" );
    private MenuItem menuItemSauvegarder = new MenuItem( "Sauvegarder" );
    private MenuItem menuItemQuitter = new MenuItem( "Quitter" );
    
    public TopMenuBar( GestionEtudiant gestion, TableView< Etudiant > tvEtudiants )
    {
        this.gestion = gestion;
        

        menuItemQuitter.setOnAction( new EventHandler< ActionEvent >()
        {
            @Override
            public void handle( ActionEvent arg0 )
            {
                System.exit( 0 );
            }
            
        } );
        menuItemOuvrir.setOnAction( new EventHandler< ActionEvent >()
        {

            @Override
            public void handle( ActionEvent arg0 )
            {
                FileChooser fc = new FileChooser();
                fc.getExtensionFilters().add( new ExtensionFilter( "JSON File", "*.json" ) );
                Stage stage = ( Stage ) getScene().getWindow();
                File f = fc.showOpenDialog( stage );
                if ( f == null )
                {
                    return;
                }
                GestionEtudiant ge = Serialization.chargerEtudiants( f.getAbsolutePath() );
                for( Etudiant e : ge.getEtudiants() )
                {
                    gestion.add( e );
                }
                tvEtudiants.setItems( FXCollections.observableArrayList( gestion.getEtudiants() ) );
                tvEtudiants.getSelectionModel().clearSelection();
                System.out.println( gestion );
            }
        } );
        menuItemSauvegarder.setOnAction( new EventHandler< ActionEvent >()
        {
            @Override
            public void handle( ActionEvent arg0 )
            {
                FileChooser fc = new FileChooser();
                Stage stage = ( Stage ) getScene().getWindow();
                File f = fc.showSaveDialog( stage );
                if ( f == null )
                {
                    return;
                }
                if ( !f.getName().contains( "." ) )
                {
                    f = new File( f.getAbsoluteFile() + ".json" );
                }
                GestionEtudiant ge = gestion.clone();
                Serialization.sauvegarderEtudiants( ge, f.getAbsolutePath() );
            }
        } );
        
        menuFichier.getItems().add( menuItemOuvrir );
        menuFichier.getItems().add( menuItemSauvegarder );
        menuFichier.getItems().add( menuItemQuitter );
        
        getMenus().add( menuFichier );
    }
}
