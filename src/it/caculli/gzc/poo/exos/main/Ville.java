package it.caculli.gzc.poo.exos.main;

import it.caculli.gzc.poo.exos.exceptions.VilleException;

public class Ville
{
    private String nom;
    private int nbHabitants;

    public Ville( String nom, int nbHabitants ) throws VilleException
    {
        this.nom = nom;
        try
        {
            setNbHabitants( nbHabitants );
        } catch ( VilleException e )
        {
            e.printStackTrace();
            this.nbHabitants = 1000;
        }
    }

    public Ville( String nom ) throws VilleException
    {
        this( nom, 1000 );
    }

    public void setNbHabitants( int nbHabitants ) throws VilleException
    {
        if( nbHabitants > 0 )
        {
            this.nbHabitants = nbHabitants;
        } else
        {
            throw new VilleException( nom, nbHabitants );
        }
    }

    public String toString()
    {
        return String.format( "Nom: %s Habitants: %d", nom, nbHabitants );
    }
}
