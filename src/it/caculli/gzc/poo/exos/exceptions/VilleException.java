package it.caculli.gzc.poo.exos.exceptions;

public class VilleException extends Exception
{
    public VilleException( String nom, int nbHabitants )
    {
        super( String.format( "Le nombre d'habitats dans la ville %s: %d n'est pas une valeur accéptable", nom, nbHabitants ) );
    }
}
