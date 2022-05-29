package it.caculli.gzc.poo.core;

public class Etudiant
{
    private String nom, prenom;
    private int annee;

    public Etudiant( String nom, String prenom, int annee )
    {
        setNom( nom );
        setPrenom( prenom );
        setAnnee( annee );
    }

    public void setNom( String nom )
    {
        this.nom = nom;
    }

    public String getNom()
    {
        return nom;
    }

    public void setPrenom( String prenom )
    {
        this.prenom = prenom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setAnnee( int annee )
    {
        this.annee = annee;
    }

    public int getAnnee()
    {
        return annee;
    }
    
    public String toString()
    {
        return String.format( "Nom: %s Prenom: %s annee: %d", nom, prenom, annee );
    }

    public boolean equals( Object o )
    {
        if ( o instanceof Etudiant )
        {
            Etudiant tmp = ( Etudiant ) o;
            return tmp.getNom().equalsIgnoreCase( nom ) && tmp.getPrenom().equalsIgnoreCase( prenom );
        }
        return false;
    }

    public Etudiant clone()
    {
        return new Etudiant( nom, prenom, annee );
    }
}
