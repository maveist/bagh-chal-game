/**
*Classe Tigre
*@autor DAHMANI Sélim LECARDUNER Noé
*@version 1.0
*/
package jeu;
import liste.Liste;

public class Tigre extends Pion{
		
		/**constructeur de tigre 
		*@param le joueur qui est propriétaire du pion tigre
		*/
		public Tigre(Joueur joueur){
			super(joueur);
			super.predateur = true;
			}
		

		/**Méthode toString()*/
		public String toString(){
		return ("T");	
		}
		
		/** méthode qui renvoie un chemin
		*@param coordDepartX la coordonnée du pion en X
		*@param coordDepartY la coordonnée du pion en Y
		*@param coordArriveeX la coordonnée de l'intersection d'arrivée en X
		*@param coordArriveeX la coordonnée de l'intersection d'arrivée en Y
		*@return une liste de coordonnées qui correspond au parcours du pion lors de son déplacement, la méthode renvoie null sice n'est pas posssible
		*/
		public Liste getDeplacement(int coordDepartX,int coordDepartY,int coordArriveeX,int coordArriveeY,boolean diagonalAutorise){
		if (super.longueurDeplacement(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY) <= 2){
                  boolean diag = super.deplacementDiagonal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
                  if (diagonalAutorise && diag){
		          return super.getCheminDiagonal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
		  
		          } else if (super.getCheminVertical(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY) != null){
		          		
		          		return super.getCheminDiagonal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
		          		
			} else if (super.getCheminHorizontal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY) != null){
				
				return super.getCheminVertical(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
				
			} else {return null;}
		} else {return null;}
		          			
 }
		
	
}
