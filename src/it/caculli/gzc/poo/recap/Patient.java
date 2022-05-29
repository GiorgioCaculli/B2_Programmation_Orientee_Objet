package it.caculli.gzc.poo.recap;

public class Patient extends Personne implements EtatSante
{
    private int etatSante;

    private static final int ERREUR_ETAT_SANTE = -1;
    
    public Patient( String nom, String prenom, String dateNaissance, int etatSante )
    {
        super( nom, prenom, dateNaissance );
        setEtatSante( etatSante );
    }

    public boolean setEtatSante( int etatSante )
    {
        switch( etatSante )
            {
            case A_DIAGNOSTIQUER:
                this.etatSante = A_DIAGNOSTIQUER;
                return true;
            case A_OPERER:
                this.etatSante = A_OPERER;
                return true;
            case EN_TRAITEMENT:
                this.etatSante = EN_TRAITEMENT;
                return true;
            case DECEDE:
                this.etatSante = DECEDE;
                return true;
            case RETABLI:
                this.etatSante = RETABLI;
                return true;
            default:
                this.etatSante = ERREUR_ETAT_SANTE;
                return false;
            }
    }

    public int getEtatSante()
    {
        return etatSante;
    }

    public String getEtatSanteString()
    {
        String etatSanteString;
        switch( etatSante )
            {
            case A_DIAGNOSTIQUER:
                etatSanteString = "à diagnostiquer";
                break;
            case A_OPERER:
                etatSanteString = "à opérer";
                break;
            case EN_TRAITEMENT:
                etatSanteString = "en traitement";
                break;
            case DECEDE:
                etatSanteString = "décédé";
                break;
            case RETABLI:
                etatSanteString = "rétabli";
                break;
            default:
                etatSanteString = "erreur";
                break;
            }
        return etatSanteString;
    }

    public boolean equals( Object o )
    {
        if( o instanceof Patient )
            {
                Patient tmp = (Patient) o;
                return tmp.getNom().equalsIgnoreCase( getNom() ) &&
                    tmp.getPrenom().equalsIgnoreCase( getPrenom() );
            }
        return false;
    }

    public String getDetails()
    {
        return String.format( "%sEtat de santé : %s\n", super.getDetails(), getEtatSanteString() );
    }

    public Patient clone()
    {
        return new Patient( getNom(), getPrenom(), getDateNaissance(), etatSante );
    }
}
