package it.caculli.gzc.poo.recap;

public abstract class Personne
{
    private int id;
    private static int idCounter = 0;
    private String nom, prenom, dateNaissance;

    public Personne( String nom, String prenom, String dateNaissance )
    {
        id = idCounter++;
        setNom( nom );
        setPrenom( prenom );
        setDateNaissance( dateNaissance );
    }

    public void setNom( String nom )
    {
        if( nom == null )
            {
                this.nom = "";
                return;
            }
        this.nom = nom;
    }

    public void setPrenom( String prenom )
    {
        if( prenom == null )
            {
                this.prenom = "";
                return;
            }
        this.prenom = prenom;
    }

    public void setDateNaissance( String dateNaissance )
    {
        if( dateNaissance == null )
            {
                this.dateNaissance = dateNaissance;
                return;
            }
        this.dateNaissance = dateNaissance;
    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getDateNaissance()
    {
        return dateNaissance;
    }

    public String toString()
    {
        return String.format( "%s %s", getNom(), getPrenom() ); 
    }

    public String getDetails()
    {
        return String.format( "Identifiant : %d\nNom : %s\nPrénom : %s\nDate de naissance : %s\n", id, getNom(), getPrenom(), getDateNaissance() );
    }

    public boolean equals( Object o )
    {
        if( o instanceof Personne )
            {
                Personne tmp = (Personne) o;
                return tmp.nom.equalsIgnoreCase( nom ) &&
                    tmp.prenom.equalsIgnoreCase( prenom ) &&
                    tmp.dateNaissance.equalsIgnoreCase( dateNaissance );
            }
        return false;
    }
}
