package it.caculli.gzc.poo.recap;

public class Chirurgien extends Medecin implements SpecialiteChirurgicale
{
    private int specialites[];
    
    public Chirurgien( String nom, String prenom, String dateNaissance, int[] specialites )
    {
        super( nom, prenom, dateNaissance );
        setSpecialite( specialites );
    }

    public boolean setSpecialite( int[] specialites )
    {
        this.specialites = new int[specialites.length];
        for( int i = 0; i < specialites.length; i++ )
            {
                switch( specialites[i] )
                    {
                    case CARDIOLOGIE:
                        this.specialites[i] = CARDIOLOGIE;
                        continue;
                    case NEUROLOGIE:
                        this.specialites[i] = NEUROLOGIE;
                        continue;
                    case PNEUMOLOGIE:
                        this.specialites[i] = PNEUMOLOGIE;
                        continue;
                    case STOMATOLOGIE:
                        this.specialites[i] = STOMATOLOGIE;
                        continue;
                    case UROLOGIE:
                        this.specialites[i] = UROLOGIE;
                        continue;
                    default:
                        this.specialites = new int[specialites.length];
                        return false;
                    }
            }
        return true;
    }

    public String getSpecialiteString()
    {
        StringBuilder sb = new StringBuilder();

        for( int i = 0; i < specialites.length; i++ )
            {
                sb.append( String.format( "Spécialité n°%d : ", i + 1 ) ); 
                switch( specialites[i] )
                    {
                    case CARDIOLOGIE:
                        sb.append( "Cardiologie\n" );
                        continue;
                    case NEUROLOGIE:
                        sb.append( "Neurologie\n" );
                        continue;
                    case PNEUMOLOGIE:
                        sb.append( "Pneumologie\n" );
                        continue;
                    case STOMATOLOGIE:
                        sb.append( "Stomatologie\n" );
                        continue;
                    case UROLOGIE:
                        sb.append( "Urologie\n" );
                        continue;
                    default:
                        continue;
                    }
            }
        return sb.toString();
    }

    public boolean ajouterPatient( Patient p )
    {
        if( p == null )
            {
                return false;
            }
        if( p.getEtatSante() != EtatSante.A_OPERER )
            {
                return false;
            }
        return super.ajouterPatient( p );
    }

    public String getDetails()
    {
        StringBuilder sb = new StringBuilder();

        sb.append( super.getDetails() );
        sb.append( "\n" );
        sb.append( getSpecialiteString() );

        return sb.toString();
    }

    public boolean equals( Object o )
    {
        if( o instanceof Chirurgien )
            {
                Chirurgien tmp = (Chirurgien) o;
                return tmp.getNom().equalsIgnoreCase( getNom() ) &&
                    tmp.getPrenom().equalsIgnoreCase( getPrenom() );
            }
        return false;
    }
}
