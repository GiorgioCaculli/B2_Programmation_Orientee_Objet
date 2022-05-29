package it.caculli.gzc.poo.core;

import java.util.ArrayList;
import java.util.List;

public class GestionEtudiant
{
    private List< Etudiant > etudiants;
    
    public GestionEtudiant()
    {
        etudiants = new ArrayList<>();
    }
    
    public boolean add( Etudiant e )
    {
        if( e == null )
        {
            return false;
        }
        if( etudiants.contains( e ) )
        {
            return false;
        }
        return etudiants.add( e.clone() );
    }
    
    public boolean remove( Etudiant e )
    {
        if( e == null )
        {
            return false;
        }
        return etudiants.remove( e );
    }
    
    public List< Etudiant > getEtudiants()
    {
        List< Etudiant > tmp = new ArrayList<>();
        for( Etudiant e : etudiants )
        {
            tmp.add( e.clone() );
        }
        return tmp;
    }

    public boolean update( Etudiant e1, Etudiant e2 )
    {
        if( etudiants.indexOf( e1 ) != -1 && !etudiants.contains( e2 ) )
        {
            etudiants.set( etudiants.indexOf( e1 ), e2.clone() );
            return true;
        }
        return false;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for( Etudiant e : etudiants )
        {
            sb.append( String.format( "%s\n", e ) );
        }
        return sb.toString();
    }
    
    public GestionEtudiant clone()
    {
        GestionEtudiant ge = new GestionEtudiant();
        for( Etudiant e : etudiants )
        {
            ge.add( e.clone() );
        }
        return ge;
    }
}
