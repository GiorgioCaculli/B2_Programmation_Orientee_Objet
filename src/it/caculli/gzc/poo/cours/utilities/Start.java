package it.caculli.gzc.poo.cours.utilities;

import it.caculli.gzc.poo.cours.exceptions.DoublonException;
import it.caculli.gzc.poo.cours.exceptions.NumRegNatException;
import it.caculli.gzc.poo.cours.model.Personne;
import it.caculli.gzc.poo.cours.model.Repertoire;
import it.caculli.gzc.poo.cours.serialisation.SerialisationObjets;
import it.caculli.gzc.poo.cours.serialisation.StartSerialisationPrimitifs;

import java.io.FileNotFoundException;

public class Start
{
    public static void main( String[] args )
    {
        Repertoire rep = new Repertoire();
        try
        {
            rep.ajouter( "12.23.34-456.67", "Giorgio", "0123" );
            rep.ajouter( "21.32.43-654.76", "Giorgio", "3210" );
        } catch ( NumRegNatException | DoublonException e )
        {
            e.printStackTrace();
        } /*catch ( DoublonException e )
        {
            Personne p = e.getpEnErreur();
            System.err.println( e.getMessage() );
        }*/ /*catch ( Exception e )
        {
            e.printStackTrace();
        }*/ finally
        {
            System.out.println( "Exécuté tout le temps");
        }
        System.out.println( rep.toString() );

        SerialisationObjets.ecrire( "repertoire.obj", rep );

        Repertoire rep2 = SerialisationObjets.lire( "repertoire.obj" );

        System.out.println( rep2 );

        Repertoire rep3 = null;
        try
        {
            rep3 = SerialisationObjets.lireSansFileNotFound( "repertoi.obj" );
        } catch ( FileNotFoundException e )
        {
            System.out.println( "On est ici" );
            e.printStackTrace();
        }

        System.out.println( rep3 );
    }
}
