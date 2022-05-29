package it.caculli.gzc.poo.recap;

/* UTIL */
import java.util.List;
import java.util.ArrayList;

public class Medecin extends Personne
{
    protected List< Patient > listePatients;

    public Medecin( String nom, String prenom, String dateNaissance )
    {
        super( nom, prenom, dateNaissance );
        listePatients = new ArrayList< Patient >();
    }

    public boolean ajouterPatient( Patient p )
    {
        if( p == null )
            {
                return false;
            }
        if( listePatients.contains( p ) )
            {
                return false;
            }
        return listePatients.add( p );
    }

    public boolean supprimerPatient( Patient p )
    {
        if( p == null )
            {
                return false;
            }
        return listePatients.remove( p );
    }

    public int rechercherPatient( Patient p )
    {
        if( p == null )
            {
                return -1;
            }
        return listePatients.indexOf( p );
    }

    public boolean remplacerPatient( Patient p1, Patient p2 )
    {
        if( p1 == null || p2 == null )
            {
                return false;
            }
        int patientIndex = rechercherPatient( p1 );
        if( patientIndex < 0 )
            {
                return false;
            }
        listePatients.set( patientIndex, p2 );
        return true;
    }

    public int nombrePatients()
    {
        return listePatients.size();
    }

    public String getDetails()
    {
        StringBuilder sb = new StringBuilder();

        sb.append( super.getDetails() );

        for( int i = 0; i < listePatients.size(); i++ )
            {
                sb.append( String.format( "\nPatient n°%d\n", i + 1 ) );
                sb.append( listePatients.get(i) );
            }
        return sb.toString();
    }

    public boolean equals( Object o )
    {
        if( o instanceof Medecin )
            {
                Medecin tmp = (Medecin) o;
                return tmp.getNom().equalsIgnoreCase( getNom() ) &&
                    tmp.getPrenom().equalsIgnoreCase( getPrenom() );
            }
        return false;
    }
}
