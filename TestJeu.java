

import jeu.Partie;
import jeu.Coordonnee;
import jeu.Pion;
import jeu.Intersection;
import jeu.Tigre;
import jeu.Chevre;
import jeu.Joueur;


public class TestJeu{
	public static void main(String[] args){
		System.out.println("Bienvenue!\n" + "Veulliez entrer le nom du joueur 1: \n");
		String str = Clavier.readString();
		Joueur j1 = new Joueur(str);
		System.out.println("Veuillez entrer le nom du joueur 2: \n");
		str = Clavier.readString();
		Joueur j2 = new Joueur(str);
		Partie partie = new Partie(j1, j2);
		partie.definirIntersectionDiagonal();
		TestJeu.jouer(j1, j2, partie);
		}
		public static void jouer(Joueur j1, Joueur j2, Partie partie){
		int tour = 0;
		int nombre_chevre_placer = 20;
		//declaration de variable que l'on va utiliser plus tard
		int x = 0;
		int y = 0;
		int pion_x = 0;
		int pion_y = 0;
		partie.placer((new Tigre(j2)), 0, 0);
		partie.placer((new Tigre(j2)), 0, 4);
		partie.placer((new Tigre(j2)), 4, 0);
		partie.placer((new Tigre(j2)), 4, 4);
		System.out.println(partie.toString() + "Nombre de tour: " + tour);
		//Phase de placement
		while (nombre_chevre_placer != 0){
			// Tour du joueur1 pour placer une chèvre
			System.out.println(j1.getPseudo() + ", veuillez placer une chèvre.\n");
			System.out.println("Placer en coordonnée (X):"); 
			x = Clavier.readInt();
			System.out.println("Placer en coordonnée (Y):");
			y = Clavier.readInt();
			partie.placer((new Chevre(j1)), x, y);
			tour ++;
			nombre_chevre_placer --;
			//affichage du placement de la chèvre
			System.out.println(partie.toString() + "Nombre de tour: " + tour+ "\n");
			//vérification si un joueur gagne
			if (partie.getJoueurGagnant() != null){
				System.out.println("Le gagnant de la partie est: "+ partie.getJoueurGagnant().getPseudo());
				System.exit(0);
			}
			//Tour du joueur2 pour déplacer un tigre
			System.out.println(j2.getPseudo() + ", veuillez déplacer un tigre\n");
			System.out.println("Selectionner le pion (coordonnée X):");
			pion_x = Clavier.readInt();
			System.out.println("Selectionner le pion (coordonnée Y):");
			pion_y = Clavier.readInt();
			System.out.println("Vers? (coordonnée X):");
			x = Clavier.readInt();
			System.out.println("Vers? (coordonnée Y):");
			y = Clavier.readInt();
			while(partie.deplacer(pion_x, pion_y, x, y, j2) == false){
				System.out.println("La demande de déplacement est erronée veuillez refaire un déplacement valide. \n");
				System.out.println("Selectionner le pion (coordonnée X):");
				pion_x = Clavier.readInt();
				System.out.println("Selectionner le pion (coordonnée Y):");
				pion_y = Clavier.readInt();
				System.out.println("Vers? (coordonnée X):");
				x = Clavier.readInt();
				System.out.println("Vers? (coordonnée Y):");
				y = Clavier.readInt();
			 }
			 tour ++;
			 //affichage du déplacement du pion
			 System.out.println(partie.toString() + "Nombre de tour:" + tour + "\n");
			 //vérification si un joueur gagne
			 if (partie.getJoueurGagnant() != null){
				System.out.println("Le gagnant de la partie est: "+ partie.getJoueurGagnant().getPseudo());
				System.exit(0);
			 }
		}
		//Dernière phase
		while(partie.getJoueurGagnant() != null){
			System.out.println(j1.getPseudo() + ", veuillez déplacer une chèvre\n");
			System.out.println("Selectionner le pion (coordonnée X):");
			pion_x = Clavier.readInt();
			System.out.println("Selectionner le pion (coordonnée Y):");
			pion_y = Clavier.readInt();
			System.out.println("Vers? (coordonnée X):");
			x = Clavier.readInt();
			System.out.println("Vers? (coordonnée Y):");
			y = Clavier.readInt();
			//déplacer un pion si la méthode renvoie false on redemande au joueur de déplacer le pion sur une autre intersection
			while(partie.deplacer(pion_x, pion_y, x, y, j2) == false){
				System.out.println("La demande de déplacement est erronée veuillez refaire un déplacement valide. \n");
				System.out.println("Selectionner le pion (coordonnée X):");
				pion_x = Clavier.readInt();
				System.out.println("Selectionner le pion (coordonnée Y):");
				pion_y = Clavier.readInt();
				System.out.println("Vers? (coordonnée X):");
				x = Clavier.readInt();
				System.out.println("Vers? (coordonnée Y):");
				y = Clavier.readInt();
			}
			System.out.println(j2.getPseudo() + ", veuillez déplacer un tigre\n");
			System.out.println("Selectionner le pion (coordonnée X):");
			pion_x = Clavier.readInt();
			System.out.println("Selectionner le pion (coordonnée Y):");
			pion_y = Clavier.readInt();
			System.out.println("Vers? (coordonnée X):");
			x = Clavier.readInt();
			System.out.println("Vers? (coordonnée Y):");
			y = Clavier.readInt();
			//déplacer un pion si la méthode renvoie false on redemande au joueur de déplacer le pion sur une autre intersection
			while(partie.deplacer(pion_x, pion_y, x, y, j2) == false){
				System.out.println("La demande de déplacement est erronée veuillez refaire un déplacement valide. \n");
				System.out.println("Selectionner le pion (coordonnée X):");
				pion_x = Clavier.readInt();
				System.out.println("Selectionner le pion (coordonnée Y):");
				pion_y = Clavier.readInt();
				System.out.println("Vers? (coordonnée X):");
				x = Clavier.readInt();
				System.out.println("Vers? (coordonnée Y):");
				y = Clavier.readInt();
				}		 
			 
		}
	}
}		
