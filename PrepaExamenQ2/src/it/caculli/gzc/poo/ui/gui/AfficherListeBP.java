package it.caculli.gzc.poo.ui.gui;

import java.util.Optional;

import it.caculli.gzc.poo.core.Etudiant;
import it.caculli.gzc.poo.core.GestionEtudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.converter.IntegerStringConverter;

public class AfficherListeBP extends BorderPane
{
    private TableView< Etudiant > tvEtudiant;
    private GestionEtudiant gestion;

    public AfficherListeBP( GestionEtudiant gestion )
    {
        this.gestion = gestion;
        setCenter( getTvEtudiant() );
    }

    public TableView< Etudiant > getTvEtudiant()
    {
        if ( tvEtudiant == null )
        {
            tvEtudiant = new TableView<>();
            tvEtudiant.setEditable( true );

            tvEtudiant.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

            TableColumn< Etudiant, String > nomCol = new TableColumn<>( "Nom" );
            nomCol.setCellValueFactory( new PropertyValueFactory<>( "nom" ) );
            nomCol.setCellFactory( TextFieldTableCell.< Etudiant > forTableColumn() );
            nomCol.setOnEditCommit( new EventHandler< TableColumn.CellEditEvent< Etudiant, String > >()
            {
                @Override
                public void handle( CellEditEvent< Etudiant, String > arg0 )
                {
                    Etudiant tmp = arg0.getRowValue().clone();
                    tmp.setNom( arg0.getNewValue() );
                    gestion.update( arg0.getRowValue(), tmp );
                    arg0.getRowValue().setNom( arg0.getNewValue() );
                    System.out.println( gestion );
                }

            } );
            TableColumn< Etudiant, String > prenomCol = new TableColumn<>( "Prenom" );
            prenomCol.setCellValueFactory( new PropertyValueFactory<>( "prenom" ) );
            prenomCol.setCellFactory( TextFieldTableCell.< Etudiant > forTableColumn() );
            prenomCol.setOnEditCommit( new EventHandler< TableColumn.CellEditEvent< Etudiant, String > >()
            {
                @Override
                public void handle( CellEditEvent< Etudiant, String > arg0 )
                {
                    Etudiant tmp = arg0.getRowValue().clone();
                    tmp.setPrenom( arg0.getNewValue() );
                    gestion.update( arg0.getRowValue(), tmp );
                    arg0.getRowValue().setPrenom( arg0.getNewValue() );
                    System.out.println( gestion );
                }

            } );
            TableColumn< Etudiant, Integer > anneeCol = new TableColumn<>( "Annee" );
            anneeCol.setCellValueFactory( new PropertyValueFactory<>( "annee" ) );
            anneeCol.setCellFactory(
                    TextFieldTableCell.< Etudiant, Integer > forTableColumn( new IntegerStringConverter() ) );
            anneeCol.setOnEditCommit( new EventHandler< TableColumn.CellEditEvent< Etudiant, Integer > >()
            {
                @Override
                public void handle( CellEditEvent< Etudiant, Integer > arg0 )
                {
                    Etudiant tmp = arg0.getRowValue().clone();
                    tmp.setAnnee( arg0.getNewValue() );
                    gestion.update( arg0.getRowValue(), tmp );
                    arg0.getRowValue().setAnnee( arg0.getNewValue() );
                    System.out.println( gestion );
                }

            } );

            tvEtudiant.getColumns().addAll( nomCol, prenomCol, anneeCol );

            tvEtudiant.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );
            
            tvEtudiant.getItems().addAll( gestion.getEtudiants() );
        }
        return tvEtudiant;
    }
}
