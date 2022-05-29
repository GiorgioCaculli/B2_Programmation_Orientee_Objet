package it.caculli.gzc.poo.cours.tests;

import it.caculli.gzc.poo.cours.exceptions.DoublonException;
import it.caculli.gzc.poo.cours.exceptions.NumRegNatException;
import it.caculli.gzc.poo.cours.model.Personne;
import it.caculli.gzc.poo.cours.model.Repertoire;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.Explorateur;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepertoireTest
{
    private Repertoire rep;
    private List<Personne> liste;

    @BeforeEach
    void setUp() throws Exception
    {
        rep = new Repertoire();
        liste = (List< Personne >) Explorateur.getField( rep, "personnes" );
    }

    @AfterEach
    void tearDown() throws Exception
    {
        rep = null;
    }

    @Test
    void testAjouter() throws DoublonException, NumRegNatException
    {
        rep.ajouter( "97.01.02-123.02", "Caculli", "081/84.54.21" );
        assertEquals( 1, liste.size(), "Test taille liste = 1" );
    }

    @Test
    void testAjouterDoublon()
    {
        assertDoesNotThrow( ()->rep.ajouter( "97.01.02-123.02", "Caculli", "081/84.54.21" ), "pas d'exception à l'ajout" );
        assertThrows( DoublonException.class, ()->rep.ajouter( "97.01.02-123.02", "Caculli", "081/84.54.21" ), "doublon ajouté" );
    }

    @Test
    void testAjouterFormatNumReg()
    {
        assertThrows( NumRegNatException.class, ()->rep.ajouter( "97.01.0-123.02", "Caculli", "081/84.54.21" ), "Numero RegNat erroné" );
    }
}
