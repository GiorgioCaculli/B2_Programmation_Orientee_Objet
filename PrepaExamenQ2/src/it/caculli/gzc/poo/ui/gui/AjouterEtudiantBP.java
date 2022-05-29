package it.caculli.gzc.poo.ui.gui;

import it.caculli.gzc.poo.core.Etudiant;
import it.caculli.gzc.poo.core.GestionEtudiant;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class AjouterEtudiantBP extends BorderPane
{
    private GestionEtudiant gestion;
    private Label labelNom = new Label( "Nom" );
    private TextField textFieldNom = new TextField();
    private Label labelPrenom = new Label( "Prenom" );
    private TextField textFieldPrenom = new TextField();
    private Label labelAnnee = new Label( "Annee" );
    private ChoiceBox< Integer > choiceBoxAnnee = new ChoiceBox<>();
    private Button boutonAnnuler = new Button( "Annuler" );
    private Button boutonAjouter = new Button( "Ajouter etudiant" );

    public AjouterEtudiantBP( GestionEtudiant gestion, TableView< Etudiant > tvEtudiants )
    {
        this.gestion = gestion;

        choiceBoxAnnee.getItems().add( 1 );
        choiceBoxAnnee.getItems().add( 2 );
        choiceBoxAnnee.getItems().add( 3 );
        
        choiceBoxAnnee.setValue( 1 );

        GridPane gp = new GridPane();
        gp.add( labelNom, 0, 0 );
        gp.add( textFieldNom, 1, 0 );
        gp.add( labelPrenom, 0, 1 );
        gp.add( textFieldPrenom, 1, 1 );
        gp.add( labelAnnee, 0, 2 );
        gp.add( choiceBoxAnnee, 1, 2 );
        gp.add( boutonAnnuler, 1, 3 );
        gp.add( boutonAjouter, 2, 3 );
        gp.setMinSize( Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE );
        gp.setPrefSize( Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE );
        gp.setMaxSize( Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE );

        setCenter( gp );

        boutonAnnuler.setOnAction( new EventHandler< ActionEvent >()
        {

            @Override
            public void handle( ActionEvent arg0 )
            {
                ( ( TextField ) gp.getChildren().get( gp.getChildren().indexOf( textFieldNom ) ) ).clear();
                ( ( TextField ) gp.getChildren().get( gp.getChildren().indexOf( textFieldPrenom ) ) ).clear();
                ( ( ChoiceBox< Integer > ) gp.getChildren().get( gp.getChildren().indexOf( choiceBoxAnnee ) ) )
                        .setValue( 1 );
                ( ( MainPaneBP ) getParent().getParent() ).setVisibleNode( AfficherListeBP.class.getSimpleName() );
            }
        } );

        boutonAjouter.setOnAction( new EventHandler< ActionEvent >()
        {

            @Override
            public void handle( ActionEvent arg0 )
            {
                if ( textFieldNom.getText().trim().isEmpty() || textFieldPrenom.getText().trim().isEmpty()
                        || choiceBoxAnnee.getValue() == null )
                {
                }
                else
                {
                    Etudiant tmp = new Etudiant( textFieldNom.getText(), textFieldPrenom.getText(), choiceBoxAnnee.getValue() );
                    tvEtudiants.getItems().add( tmp );
                    gestion.add( tmp );
                    ( ( TextField ) gp.getChildren().get( gp.getChildren().indexOf( textFieldNom ) ) ).clear();
                    ( ( TextField ) gp.getChildren().get( gp.getChildren().indexOf( textFieldPrenom ) ) ).clear();
                    ( ( ChoiceBox< Integer > ) gp.getChildren().get( gp.getChildren().indexOf( choiceBoxAnnee ) ) )
                            .setValue( 1 );
                    ( ( MainPaneBP ) getParent().getParent() ).setVisibleNode( AfficherListeBP.class.getSimpleName() );
                }
            }
        } );
    }
}
