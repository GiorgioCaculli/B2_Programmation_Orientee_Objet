package it.caculli.gzc.poo.ui.gui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import it.caculli.gzc.poo.core.Etudiant;
import it.caculli.gzc.poo.core.GestionEtudiant;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainPaneBP extends BorderPane
{
    private GestionEtudiant gestion;
    private TopMenuBar tmb;
    private VBox leftBox;
    private AfficherListeBP listeBP;
    private AjouterEtudiantBP ajouterBP;
    private StackPane mainPaneSP;
    private long elapsedTime;
    private AnimationTimer animation;
    private LocalTime lt = LocalTime.now();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "HH:mm:ss" );
    private String timeString = lt.format( dtf );
    private Label timeLabel = new Label( String.format( "Bienvenue, il est %s", timeString ) );

    private Button boutonAfficherListe = new Button( "Afficher Liste" );
    private Button boutonAjouterEtudiant = new Button( "Ajouter etudiant" );
    private Button boutonSupprimerEtudiant = new Button( "Supprimer etudiant" );

    public MainPaneBP( GestionEtudiant gestion )
    {
        this.gestion = gestion;
        mainPaneSP = new StackPane();

        listeBP = new AfficherListeBP( gestion );
        
        ajouterBP = new AjouterEtudiantBP( gestion, listeBP.getTvEtudiant() );

        mainPaneSP.getChildren().add( listeBP );
        mainPaneSP.getChildren().add( ajouterBP );
        mainPaneSP.getChildren().add( timeLabel );

        elapsedTime = System.nanoTime();
        animation = new AnimationTimer()
        {

            @Override
            public void handle( long now )
            {
                if ( now - elapsedTime > 1000000000 )
                {
                    lt = LocalTime.now();
                    timeString = lt.format( dtf );
                    ( ( Label ) mainPaneSP.getChildren().get( mainPaneSP.getChildren().indexOf( timeLabel ) ) )
                            .setText( String.format( "Bienvenue, il est %s", timeString ) );
                    elapsedTime = now;
                }

            }
        };
        
        animation.start();
        
        setVisibleNode( timeLabel.getClass().getSimpleName() );

        setCenter( mainPaneSP );

        tmb = new TopMenuBar( gestion, listeBP.getTvEtudiant() );

        setTop( tmb );
        
        boutonAjouterEtudiant.setOnAction( new EventHandler< ActionEvent >()
        {

            @Override
            public void handle( ActionEvent arg0 )
            {
                setVisibleNode( ajouterBP.getClass().getSimpleName() );
            }
        } );

        boutonSupprimerEtudiant.setOnAction( new EventHandler< ActionEvent >()
        {
            @Override
            public void handle( ActionEvent arg0 )
            {
                ObservableList< Etudiant > selected = listeBP.getTvEtudiant().getSelectionModel().getSelectedItems();
                for ( Etudiant e : selected )
                {
                    gestion.remove( e );
                }
                listeBP.getTvEtudiant().setItems( FXCollections.observableArrayList( gestion.getEtudiants() ) );
                listeBP.getTvEtudiant().getSelectionModel().clearSelection();
                if ( gestion.getEtudiants().size() == 0 )
                {
                    boutonSupprimerEtudiant.setVisible( false );
                }
                System.out.println( gestion );
            }
        } );

        leftBox = new VBox();

        leftBox.getChildren().add( boutonAfficherListe );
        leftBox.getChildren().add( boutonAjouterEtudiant );
        leftBox.getChildren().add( boutonSupprimerEtudiant );

        if ( gestion.getEtudiants().size() <= 0 )
        {
            boutonSupprimerEtudiant.setVisible( false );
        }

        setLeft( leftBox );
        
        boutonAfficherListe.setOnAction( new EventHandler< ActionEvent >()
        {
            @Override
            public void handle( ActionEvent arg0 )
            {
                setVisibleNode( listeBP.getClass().getSimpleName() );
            }
        } );
    }
    
    public void setVisibleNode( String id )
    {
        for( Node n : mainPaneSP.getChildren() )
        {
            if( n.getClass().getSimpleName().equalsIgnoreCase( id ) )
            {
                n.setVisible( true );
            }
            else
            {
                n.setVisible( false );
            }
            if( n instanceof AfficherListeBP )
            {
                if ( gestion.getEtudiants().size() > 0 )
                {
                    boutonSupprimerEtudiant.setVisible( true );
                }
            }
        }
    }
}
