package com.masticass.mangad;

import java.util.Arrays;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = WIDTH / 4 * 3;
    
	@Override
	public void start( Stage primaryStage )
    {
		try
            {
                BorderPane root = new BorderPane();
                Scene scene = new Scene( root, WIDTH, HEIGHT );
                scene.getStylesheets().add( getClass().getResource( "application.css" ).toExternalForm() );
                primaryStage.setScene( scene );
                primaryStage.setResizable( false );
                primaryStage.show();
            } catch(Exception e)
            {
                e.printStackTrace();
            }
	}
    
    public static void main( String args[] )
    {
        System.out.println( "Mangad by Masticass" );
        
        Etudiant e = new Etudiant( "Roger", 3,
                                   Arrays.asList( "POO", "Anglais" ),
                                   Arrays.asList( new Cours( "Java", 1 ), new Cours( "Analyse", 2 ) ) );

        System.out.println( e );

        String json = e.toJson();
        System.out.println( json );

        Etudiant lecture = Etudiant.fromJson( json );
        System.out.println( lecture );
        
		launch(args);
    }
}
