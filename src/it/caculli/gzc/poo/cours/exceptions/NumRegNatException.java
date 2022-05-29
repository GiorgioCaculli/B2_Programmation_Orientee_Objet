package it.caculli.gzc.poo.cours.exceptions;

public class NumRegNatException extends Exception
{
    private static final long serialVersionUID = 1L;

    public NumRegNatException( String numRegNat )
    {
        super( String.format( "Le numéro de registre national %s ne respecte pas le format demandé.", numRegNat ) );
    }
}
