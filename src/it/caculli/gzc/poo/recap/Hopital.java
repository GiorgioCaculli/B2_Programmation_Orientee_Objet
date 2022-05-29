package it.caculli.gzc.poo.recap;

/* UTIL */
import java.util.List;
import java.util.ArrayList;

public class Hopital
{
    private List< Personne > listePersonnes;
    
    public Hopital()
    {
        listePersonnes = new ArrayList< Personne >();
    }

    public boolean ajouter( Personne p )
    {
        if( p == null )
            {
                return false;
            }
        if( listePersonnes.contains( p ) )
            {
                return false;
            }
        return listePersonnes.add( p );
    }

    public ArrayList< Medecin > getListeMedecins()
    {
        ArrayList< Medecin > listeMedecins = new ArrayList< Medecin >();
        for( Personne p : listePersonnes )
            {
                if( p instanceof Medecin )
                    {
                        listeMedecins.add( (Medecin) p );
                    }
            }
        return listeMedecins;
    }

    public ArrayList< Patient > getListePatients()
    {
        ArrayList< Patient > listePatients = new ArrayList< Patient >();
        for( Personne p : listePersonnes )
            {
                if( p instanceof Patient )
                    {
                        listePatients.add( (Patient) p );
                    }
            }
        return listePatients;
    }

    public void trierPersonnes()
    {
        for( int i = 0; i < listePersonnes.size() - 1; i++ )
            {
                for( int j = i + 1; j < listePersonnes.size(); j++ )
                    {
                        if( listePersonnes.get(i).getNom().compareTo( listePersonnes.get(j).getNom() ) > 0 )
                            {
                                Personne tmp = listePersonnes.get(i);
                                listePersonnes.set( i, listePersonnes.get(j) );
                                listePersonnes.set( j, tmp );
                            }
                        else if( listePersonnes.get(i).getNom().equalsIgnoreCase( listePersonnes.get(j).getNom() ) )
                            {
                                if( listePersonnes.get(j).getPrenom().compareTo( listePersonnes.get(j).getPrenom() ) > 0 )
                                    {
                                        Personne tmp = listePersonnes.get(i);
                                        listePersonnes.set( i, listePersonnes.get(j) );
                                        listePersonnes.set( j, tmp );
                                    }
                            }
                    }
            }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append( "[ " );
        
        for( Personne p : listePersonnes )
            {
                sb.append( p );
                sb.append( ", " );
            }

        sb.append( " ]" );
        return sb.toString();
    }
}
