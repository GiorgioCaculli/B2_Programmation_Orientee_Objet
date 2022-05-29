package it.caculli.gzc.poo.ui.gui;

import it.caculli.gzc.poo.core.Etudiant;
import it.caculli.gzc.poo.core.GestionEtudiant;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MainFrame extends Application
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = WIDTH / 4 * 3;

    @Override
    public void start( Stage primaryStage )
    {
        try
        {
            GestionEtudiant ge = new GestionEtudiant();
            
            BorderPane root = new MainPaneBP( ge );
            Scene scene = new Scene( root, WIDTH, HEIGHT );
            scene.getStylesheets().add( getClass().getResource( "application.css" ).toExternalForm() );
            primaryStage.setScene( scene );
            primaryStage.setTitle( "Prepa Examen POO Q2" );
            primaryStage.show();
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    public MainFrame()
    {
    }
}
