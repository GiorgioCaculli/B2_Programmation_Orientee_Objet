package it.caculli.gzc.poo.cours.model;

import it.caculli.gzc.poo.cours.exceptions.NumRegNatException;

import java.io.Serializable;

public class Personne implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String numRegNat, nom, numTel;

    public Personne( String numRegNat, String nom, String numTel ) throws NumRegNatException
    {
        if( numRegNat.matches( "[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}-[0-9]{3}\\.[0-9]{2}" ) )
        {
            this.numRegNat = numRegNat;
        }
        else
        {
            throw new NumRegNatException( numRegNat );
        }
        this.nom = nom;
        if( numRegNat.matches( "0[0-9]{2}/[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}" ) )
        {
            this.numTel = numTel;
        }
        else
        {
            this.numTel = "065/00.00.00";
        }
    }

    public String toString()
    {
        return String.format( "%s %s %s", numRegNat, nom, numTel );
    }

    public boolean equals( Object o )
    {
        if( o instanceof Personne )
        {
            Personne tmp = (Personne) o;
            return numRegNat.equalsIgnoreCase( tmp.numRegNat );
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return this.numRegNat.hashCode();
    }
}
