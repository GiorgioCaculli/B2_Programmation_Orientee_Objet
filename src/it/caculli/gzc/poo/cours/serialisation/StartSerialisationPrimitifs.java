package it.caculli.gzc.poo.cours.serialisation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StartSerialisationPrimitifs
{
    public static void main( String[] args )
    {
        DataOutputStream out = null;
        try
        {
            FileOutputStream fichier;
            fichier = new FileOutputStream( "primitifs.dat" );
            out = new DataOutputStream( fichier );
            out.writeInt( 5 );
            out.writeInt( 10 );
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

        /* lecture */
        DataInputStream in = null;
        try
        {
            FileInputStream fichier = new FileInputStream( "primitifs.dat" );
            in = new DataInputStream( fichier );
            while( true )
            {
                System.out.println(in.readInt());
            }
        } catch ( EOFException e )
        {
            System.out.println( "End of file" );
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
                if( in != null )
                    in.close();
            } catch ( IOException e )
            {
                e.printStackTrace();
            }
        }

        try( DataInputStream input = new DataInputStream( new FileInputStream( "primitifs.dat" ) ) )
        {
            while( true )
            {
                System.out.println( input.readInt() );
            }
        } catch ( EOFException e )
        {
            System.out.println( "End of file" );
        } catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        } catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
