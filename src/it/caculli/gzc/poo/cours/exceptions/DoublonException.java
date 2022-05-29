package it.caculli.gzc.poo.cours.exceptions;

import it.caculli.gzc.poo.cours.model.Personne;

public class DoublonException extends Exception
{
    public static final long serialVersionUID = 2L;

    Personne pEnErreur;

    public DoublonException( Personne p )
    {
        super( String.format( "La personne %s est déjà présente dans le répertoire", p ) );
        pEnErreur = p;
    }

    public Personne getpEnErreur()
    {
        return pEnErreur;
    }
}
