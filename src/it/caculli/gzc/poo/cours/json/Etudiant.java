package com.masticass.mangad;

import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Etudiant
{
    private String nom;
    private int annee;
    private List< String > intitules;
    private List< Cours > cours;
    
    public Etudiant( String nom, int annee, List< String > intitules, List< Cours > cours )
    {
        this.nom = nom;
        this.annee = annee;
        this.intitules = intitules;
        this.cours = cours;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom( String nom )
    {
        this.nom = nom;
    }

    public String toString()
    {
        return "Etudiant [nom = " + nom + ", annee = " + annee + ", intitules = " + intitules + ", cours = " + cours + "]";
    }

    public String toJson()
    {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson( this );
    }

    public static Etudiant fromJson( String json )
    {
        /*Gson gson = new Gson();
        Etudiant result = gson.fromJson( json, Etudiant.class );
        return result;*/
        return new Gson().fromJson( json, Etudiant.class );
    }
}
