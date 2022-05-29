package it.caculli.gzc.poo.exos;

import it.caculli.gzc.poo.exos.exceptions.VilleException;
import it.caculli.gzc.poo.exos.main.Ville;

public class StartExos
{
    public static void main( String[] args )
    {
        Ville mons = null, bari = null, roma = null;
        try
        {
            mons = new Ville( "Mons" );
            bari = new Ville( "Bari", 500 );
            roma = new Ville( "Roma", 0 );
            mons.setNbHabitants( -10 );
        } catch ( VilleException e )
        {
            e.printStackTrace();
        }

        System.out.println( mons );
        System.out.println( bari );
        System.out.println( roma );
    }
}
