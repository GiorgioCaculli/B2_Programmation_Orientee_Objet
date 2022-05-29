package it.caculli.gzc.poo.cours.model;

import it.caculli.gzc.poo.cours.exceptions.DoublonException;
import it.caculli.gzc.poo.cours.exceptions.NumRegNatException;
import it.caculli.gzc.poo.cours.exceptions.PersonnePasPresenteException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Repertoire implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<Personne> personnes;
    public Repertoire()
    {
        personnes = new ArrayList<Personne>();
    }

    public void ajouter( String numRegNat, String nom, String numTel ) throws NumRegNatException, DoublonException
    {
        Personne p = new Personne( numRegNat, nom, numTel );
        if( personnes.contains( p ) )
        {
            throw new DoublonException( p );
        }
        personnes.add( p );
    }

    public int nbPersonnes()
    {
        return personnes.size();
    }

    public void supprimer( Personne p ) throws PersonnePasPresenteException
    {
        if( !personnes.remove( p ) )
        {
            throw new PersonnePasPresenteException();
        }
    }

    public String toString()
    {
        return personnes.toString();
    }
}
