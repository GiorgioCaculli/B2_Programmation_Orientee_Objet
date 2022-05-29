package it.caculli.gzc.poo.recap;

public interface EtatSante
{
    int A_DIAGNOSTIQUER = 0,
        A_OPERER = 1,
        EN_TRAITEMENT = 2,
        DECEDE = 3,
        RETABLI = 4;

    boolean setEtatSante( int etat );
}
