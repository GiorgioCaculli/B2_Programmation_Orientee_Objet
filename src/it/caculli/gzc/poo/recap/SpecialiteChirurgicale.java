package it.caculli.gzc.poo.recap;

public interface SpecialiteChirurgicale
{
    int CARDIOLOGIE = 1,
        NEUROLOGIE = 2,
        PNEUMOLOGIE = 3,
        STOMATOLOGIE = 4,
        UROLOGIE = 5;

    boolean setSpecialite( int[] specialites );
}
