package it.caculli.gzc.poo.recap;

public class TestHopital {
    public TestHopital() {
	/*public static void main(String[] args) {*/
		Hopital hopital = new Hopital();
		
		Patient p1 = new Patient("Granger","Hermione","12/10/1990",EtatSante.A_DIAGNOSTIQUER);
		Patient p2 = new Patient("Londubat","Neville","28/11/1991",EtatSante.A_OPERER);
		Medecin medecin = new Medecin("MacGonagall","Minerva","4/09/1930");
		int[] categories = {SpecialiteChirurgicale.PNEUMOLOGIE,SpecialiteChirurgicale.UROLOGIE};
		Chirurgien chirurgien = new Chirurgien("Dumbledore","Albus","5/04/1901",categories);
		
		System.out.println("Etat de Londubat : "+p2.getEtatSanteString());
		
		if (!medecin.ajouterPatient(p1))
			System.out.println("Le patient "+p1.getNom()+" "+p1.getPrenom()+" est déjà sur la liste du docteur "+
					medecin.getNom());
		if (!medecin.ajouterPatient(p2))
			System.out.println("Le patient "+p2.getNom()+" "+p2.getPrenom()+" est déjà sur la liste du docteur "+
					medecin.getNom());
		Patient p3 = new Patient("Londubat","Neville","28/10/2000",EtatSante.EN_TRAITEMENT);
		System.out.println("**************Patient déjà présent******************");
		if (!medecin.ajouterPatient(p3))
			System.out.println("Le patient "+p3.getNom()+" "+p3.getPrenom()+" est déjà sur la liste du docteur "+
					medecin.getNom());
		if (!chirurgien.ajouterPatient(p2))
			System.out.println("Le patient "+p2.getNom()+" "+p2.getPrenom()+" est déjà sur la liste du docteur "+
					chirurgien.getNom()+ " ou n'est pas opérable");
		
		if (!hopital.ajouter(p1))
			System.out.println(p1.getNom()+" "+p1.getPrenom()+" est déjà présent dans l'hôpital!!");
		if (!hopital.ajouter(p2))
			System.out.println(p2.getNom()+" "+p2.getPrenom()+" est déjà présent dans l'hôpital!!");
		if (!hopital.ajouter(medecin))
			System.out.println(medecin.getNom()+" "+medecin.getPrenom()+" est déjà présent dans l'hôpital!!");
		Medecin med2 = new Medecin("MacGonagall","Minerva","4/05/1945");
		System.out.println("**************Personne déjà présente dans l'hôpital****************");
		if (!hopital.ajouter(med2))
			System.out.println(med2.getNom()+" "+med2.getPrenom()+" est déjà présent dans l'hôpital!!");
		if (!hopital.ajouter(chirurgien))
			System.out.println(chirurgien.getNom()+" "+chirurgien.getPrenom()+" est déjà présent dans l'hôpital!!");
		
		System.out.println("**********Détails du patient p1***************");
		System.out.println(p1.getDetails());
		System.out.println("**********Détails du médecin***************");
		System.out.println(medecin.getDetails());
		System.out.println("**********Détails du chirurgien***************");
		System.out.println(chirurgien.getDetails());
		System.out.println("**********Méthodes utilitaires***************");
		System.out.println("Nombre de patients de MacGonagall : "+medecin.nombrePatients());
		System.out.println("Indice dans la liste du patient Londubat : "+medecin.rechercherPatient(p3));
		
		System.out.println("*************Patient pas à opérer***************");
		if (!chirurgien.ajouterPatient(p1))
			System.out.println("Le patient "+p1.getNom()+" "+p1.getPrenom()+" est déjà sur la liste du docteur "+
					chirurgien.getNom()+ " ou n'est pas opérable");
		
		System.out.println("\nListe des médecins de l'hôpital:");
		System.out.println("--------------------------------------------------");
		System.out.println(hopital.getListeMedecins());
		System.out.println("Liste des patients de l'hôpital:");
		System.out.println("--------------------------------------------------");
		System.out.println(hopital.getListePatients());
		
		Patient p4 = new Patient("Potter","Harry","10/03/1985",EtatSante.A_OPERER);
		if (!hopital.ajouter(p4))
			System.out.println(p4.getNom()+" "+p4.getPrenom()+" est déjà présent dans l'hôpital!!");
		System.out.println("**************Patient pas présent*****************");
		if (!medecin.supprimerPatient(p4))
			System.out.println("Le patient "+p4.getNom()+" "+p4.getPrenom()+" n'est pas dans la liste de "+
					medecin.getNom());
		if (!medecin.supprimerPatient(p3))
			System.out.println("Le patient "+p3.getNom()+" "+p3.getPrenom()+" n'est pas dans la liste de "+
					medecin.getNom());
		Patient p5 = new Patient("Weasley", "Ronald", "01/05/1992", EtatSante.EN_TRAITEMENT);
		System.out.println("********Patient pas présent donc pas de modification*********");
		if (!medecin.remplacerPatient(p5, p4))
			System.out.println("Le patient "+p5.getNom()+" "+p5.getPrenom()+" n'est pas dans la liste de "+
					medecin.getNom());
		if (!medecin.remplacerPatient(p1, p4))
			System.out.println("Le patient "+p2.getNom()+" "+p2.getPrenom()+" n'est pas dans la liste de "+
					medecin.getNom());
		System.out.println("**********Détails du médecin***************");
		System.out.println(medecin.getDetails());
		
		int[] categoriesBidon={1,2,100};
		System.out.println("*************Changement de spécialités erroné******************");
		if (!chirurgien.setSpecialite(categoriesBidon))
			System.out.println("Une des spécialités données n'existent pas !!");
		System.out.println("**********Détails du chirurgien***************");
		System.out.println(chirurgien.getDetails());
		
		System.out.println("*************Changement d'état de santé erroné*****************");
		if (!p3.setEtatSante(9))
			System.out.println("L'état de santé spécifié n'existe pas !!");
		
		System.out.println("***********Liste des personnes dans l'hôpital avant le tri***********");
		System.out.println(hopital.toString());
		hopital.trierPersonnes();
		System.out.println("***********Liste des personnes dans l'hôpital après le tri***********");
		System.out.println(hopital.toString());
	}
}
