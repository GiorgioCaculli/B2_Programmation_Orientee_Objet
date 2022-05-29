package it.caculli.gzc.poo.cours.serialisation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StartTexte
{
    public static void main( String[] args )
    {
        PrintWriter print = null;
        try
        {
            FileWriter fichier = new FileWriter( "notretexte.txt" );
            print = new PrintWriter( fichier );
            print.println( "Mon texte" );
            print.println( "Suite du texte ");
        } catch ( IOException e )
        {
            e.printStackTrace();
        } finally
        {
            if( print != null )
                print.close();
        }

        /* lecture */
        try ( Scanner scan = new Scanner( new FileReader( "notretexte.txt" ) ) )
        {
            while ( scan.hasNextLine() )
            {
                System.out.println( scan.nextLine() );
            }
        } catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        } catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
