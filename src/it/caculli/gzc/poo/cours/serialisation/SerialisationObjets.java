package it.caculli.gzc.poo.cours.serialisation;

import it.caculli.gzc.poo.cours.model.Repertoire;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialisationObjets
{
    public static void ecrire( String nomFichier, Repertoire rep )
    {
        ObjectOutputStream out = null;
        try
        {
            FileOutputStream fichier = new FileOutputStream( nomFichier );
            out = new ObjectOutputStream( fichier );
            out.writeObject( rep );
        } catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        } catch ( IOException e )
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if( out != null )
                    out.close();
            } catch ( IOException e )
            {
                e.printStackTrace();
            }
        }
    }

    public static Repertoire lire( String nomFichier )
    {
        try ( ObjectInputStream in = new ObjectInputStream( new FileInputStream( nomFichier ) ) )
        {
            Repertoire rep = ( Repertoire ) in.readObject();
            return rep;
        } catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        } catch ( IOException e )
        {
            e.printStackTrace();
        } catch ( ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        return new Repertoire();
    }

    public static Repertoire lireSansFileNotFound( String nomFichier ) throws FileNotFoundException
    {
        try ( ObjectInputStream in = new ObjectInputStream( new FileInputStream( nomFichier ) ) )
        {
            Repertoire rep = ( Repertoire ) in.readObject();
            return rep;
        } catch ( FileNotFoundException e )
        {
            throw e;
        }catch ( IOException e )
        {
            e.printStackTrace();
        } catch ( ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        return new Repertoire();
    }
}
