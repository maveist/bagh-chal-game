/**
*Classe Chevre
*@autor DAHMANI Sélim LECARDUNER Noé
*@version 1.0
*/
package jeu;
import jeu.Pion;
import liste.Liste;

public class Chevre extends Pion{

	/**Constructeur de chevre
	*@param joueur joueur propriétaire du pion chèvre
	*/
	public Chevre(Joueur joueur){
		super(joueur);
		super.predateur = false;
		}
		
	/** toString()*/
	public String toString(){
		return ("C");	
		}

	/** méthode qui renvoie un chemin
		*@param coordDepartX la coordonnée du pion en X
		*@param coordDepartY la coordonnée du pion en Y
		*@param coordArriveeX la coordonnée de l'intersection d'arrivée en X
		*@param coordArriveeX la coordonnée de l'intersection d'arrivée en Y
		*@return une liste de coordonnées qui correspond au parcours du pion lors de son déplacement, la méthode renvoie null sice n'est pas posssible
		*/
	public Liste getDeplacement(int coordDepartX,int coordDepartY,int coordArriveeX,int coordArriveeY,boolean diagonalAutorise){
                  boolean diag = this.deplacementDiagonal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
                  if (super.longueurDeplacement(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY) == 1){
                  if (diagonalAutorise && diag){
		          return this.getCheminDiagonal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
		  
		          } else if (this.getCheminVertical(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY) != null){
		          		
		          		return this.getCheminDiagonal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
		          		
			} else if (this.getCheminHorizontal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY) != null){
				
				return this.getCheminVertical(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
				
			} else {return null;}
		}else {return null;}
	}

}


