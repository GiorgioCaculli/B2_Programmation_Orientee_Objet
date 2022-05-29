package it.caculli.gzc.poo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import it.caculli.gzc.poo.core.GestionEtudiant;

public class Serialization
{
    private static GsonBuilder gb = new GsonBuilder();

    private static Gson gson;

    public static void sauvegarderEtudiants( GestionEtudiant gestion, String fileName )
    {
        gb.setPrettyPrinting();
        String path = fileName;
        File json = null;
        try
        {
            json = new File( path );
            json.createNewFile();
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        try ( /*Writer w = new FileWriter( json )*/
                OutputStreamWriter w = new OutputStreamWriter( new FileOutputStream( json ),
                        Charset.forName( "UTF-8" ).newEncoder() ) )
        {
            gb.setPrettyPrinting();
            gson = gb.create();
            gson.toJson( gestion, w );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    public static void saveGame( GestionEtudiant gestion )
    {
        sauvegarderEtudiants( gestion, "etudiants.json" );
    }

    public static GestionEtudiant chargerEtudiants( String path )
    {
        GestionEtudiant gestion = null;
        gson = gb.create();
        try
        {
            gestion = gson.fromJson( new FileReader( path, Charset.forName( "UTF-8" ) ), GestionEtudiant.class );
        }
        catch ( JsonSyntaxException | JsonIOException | IOException e2 )
        {
            e2.printStackTrace();
        }
        return gestion;
    }

}
