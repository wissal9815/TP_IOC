 package pres;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.DaoImp;
import dao.IDao;
import metier.IMetier;
import metier.MetierImp;

public class Pres1 {

	public static void main(String[] args) throws Exception {
		
		/*Couplage fort
		Injection des dependances par instanciation statique
		
		DaoImp dao = new DaoImp();
		MetierImp metier = new MetierImp();
		metier.setDao(dao);
		System.out.println(metier.calcul());
		
		*/
		
		/*
		 * en JEE l'injection travail realisee est fait par les framework
		 */
		
		//Couplage faible
		
		Scanner scanner = new Scanner(new File("config.txt")); //lire nom de la classe
		
		String daoClassName = scanner.nextLine(); 
		Class cDao = Class.forName(daoClassName);//charger le byteCode de la classe en memoire 
		IDao dao = (IDao) cDao.newInstance(); // instanciation de la classe
		
		String metierClassName = scanner.nextLine();
		Class cMetier = Class.forName(metierClassName);
		IMetier metier = (IMetier) cMetier.newInstance();
		
		Method m = cMetier.getMethod("setDao", IDao.class);
		m.invoke(metier, dao);
		System.out.println(metier.calcul());

		

	}

}
