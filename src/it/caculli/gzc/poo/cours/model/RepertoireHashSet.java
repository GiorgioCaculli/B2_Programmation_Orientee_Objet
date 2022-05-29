package it.caculli.gzc.poo.cours.model;

import it.caculli.gzc.poo.cours.exceptions.DoublonException;
import it.caculli.gzc.poo.cours.exceptions.NumRegNatException;

import java.util.HashSet;
import java.util.Iterator;

public class RepertoireHashSet
{
    private HashSet< Personne > personnes;

    public RepertoireHashSet()
    {
        personnes = new HashSet<>();
    }

    public void ajouter( String numRegNat, String nom, String numT ) throws DoublonException, NumRegNatException
    {
        Personne p = new Personne( numRegNat, nom, numT );
        if( !personnes.add( p ) )
        {
            throw new DoublonException( p );
        }
    }

    public void supprimer( Personne p )
    {
        personnes.remove( p );
    }

    public String toString()
    {
        String tmp = "Liste des personnes : ";

        Iterator< Personne > it = personnes.iterator();

        while( it.hasNext() )
        {
            tmp += "\n";
        }
        return tmp;
    }
}
