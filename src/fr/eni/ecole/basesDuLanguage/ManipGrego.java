package fr.eni.ecole.basesDuLanguage;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class ManipGrego {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//En se basant sur la diapositive 10:
		//1- Créer une instance de GregorianCalendar() qui 
		//resprésente la Saint-Valentin De La Loose le 14 février 1515 (penser au fait que les mois vont de 0 à 11)
		GregorianCalendar SaintValentinDeLaLoose = new GregorianCalendar(1515, 1, 14);
		//Afficher la date
		System.out.format("%02d %s %d%n",SaintValentinDeLaLoose.get(GregorianCalendar.DAY_OF_MONTH),SaintValentinDeLaLoose.getDisplayName(GregorianCalendar.MONTH,GregorianCalendar.LONG_FORMAT, Locale.FRANCE),SaintValentinDeLaLoose.get(GregorianCalendar.YEAR));
		//3-Ajouter 151 ans
		SaintValentinDeLaLoose.add(GregorianCalendar.YEAR, 151);
		//4-Afficher la date
		System.out.format("%02d %s %d%n",SaintValentinDeLaLoose.get(GregorianCalendar.DAY_OF_MONTH),SaintValentinDeLaLoose.getDisplayName(GregorianCalendar.MONTH,GregorianCalendar.LONG_FORMAT, Locale.FRANCE),SaintValentinDeLaLoose.get(GregorianCalendar.YEAR));
		int annee ,  mois;

		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Saisissez un mois(en chiffres): ");
			mois= scan.nextInt();			
		}while(!(mois >=1 && mois <=12 ));

		System.out.println("Saisissez une année: ");
		annee= scan.nextInt();
		scan.close();
		
		//Les mois vont de 0 à 11 plutôt que de 1 à 12 dans le modele de GregorianCalendar 
		afficherMois(mois-1,annee);
		afficherMois(mois,annee);
		afficherMois(mois-2,annee);
		afficherMois(10,2018);
	}
	
	/*Création d'une procédure afficherMois prenant en paramètre 2 entiers:le mois et l'année à afficher.
	 * Le numéro du mois va de 0 à 11
	 * L'affichage attendu est constitué des valeurs 2018 et 10*/
	static void afficherMois(int mois,int annee) {
		GregorianCalendar CalendrierAAfficher= new GregorianCalendar(annee, mois,1);
		System.out.format(" * %s %d *\n",CalendrierAAfficher.getDisplayName(GregorianCalendar.MONTH,GregorianCalendar.LONG_FORMAT, Locale.FRANCE), annee);
		
		

		int nombreJoursDansMois=CalendrierAAfficher.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		
		//System.out.format("\nLe nombre de jours dans le mois est de %d\n",nombreJoursDansMois);
		//Extraction du jour de la semaine du premier jour du mois et ajout de "   " pour chaque jour de la semaine passé avant lui si lundi 1er alors 0*"   " si mardi 1*"   "etc
		//Premier Lundi du mois:

		int NumeroPremierLundi=0;

		//Voire un switch case en recupérant le nom du jour
		//Numero européen du jour de la semaine semaine allant du lundi au dimanche plutôt que la version américaine allant du dimanche au samedi
		//Ici NumeroPremierLundi Correspond au  numero du jour dans le mois du premierLundi  du mois
		int NumeroJourSemaine=0;
		switch(CalendrierAAfficher.getDisplayName(GregorianCalendar.DAY_OF_WEEK,GregorianCalendar.LONG_FORMAT, Locale.FRANCE)) {
		case "lundi":  NumeroJourSemaine=1;NumeroPremierLundi=1;
		break;
		case "mardi": NumeroJourSemaine=2;NumeroPremierLundi=7;
		break;
		case "mercredi": NumeroJourSemaine=3;NumeroPremierLundi=6;
		break;
		case "jeudi":NumeroJourSemaine=4;NumeroPremierLundi=5;
		break;
		case "vendredi": NumeroJourSemaine=5;NumeroPremierLundi=4;
		break;
		case "samedi":NumeroJourSemaine=6;NumeroPremierLundi=3;
		break;
		case "dimanche": NumeroJourSemaine=7;NumeroPremierLundi=2;
		}	

		for(int i = NumeroPremierLundi; i < NumeroPremierLundi+7;i++) {//On défile tous les jours de la semaine du lundi au dimanche dans le format français
			GregorianCalendar NomJourSemaine= new GregorianCalendar(annee,mois,i);

			System.out.format("%s  ",NomJourSemaine.getDisplayName(GregorianCalendar.DAY_OF_WEEK,GregorianCalendar.NARROW_FORMAT, Locale.FRANCE));
		}
		//La formule suivante donne la chaine de caractère du jour de la semaine
		System.out.format("\n");


		for(int i=0;i <NumeroJourSemaine -1;i++) {
				
			System.out.format("   ");//3 espaces nécessaires à la place du numéro de jour si le mois commence un jeudi
		}
		
		for(int i=1;i <= nombreJoursDansMois ;i++) {
			GregorianCalendar JourDeLaSemaine= new GregorianCalendar(annee,mois,i);

			System.out.format("%02d ",i);//Numero du jour avec 0 devant si nécessaire

			//System.out.format("Le jour de la semaine  est ici %s" + " \n",JourDeLaSemaine.getDisplayName(GregorianCalendar.DAY_OF_WEEK,GregorianCalendar.NARROW_FORMAT, Locale.FRANCE));

			if(JourDeLaSemaine.getDisplayName(GregorianCalendar.DAY_OF_WEEK,GregorianCalendar.NARROW_FORMAT, Locale.FRANCE)=="D") {//Retour à la ligne si l'on arrive à dimanche
				System.out.println("\n");
			};

		}

		
		System.out.format("\n\n");
	}
}
