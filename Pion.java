/**
*Classe Pion
*@autor DAHMANI Sélim LECARDUNER Noé
*@version 1.0
*/
package jeu;
import jeu.Joueur;
import jeu.Coordonnee;
import liste.Liste;
import java.lang.Math;

public class Pion{
protected boolean predateur;
private Joueur joueur;

	/**constructeur Pion
	*@param joueur le joueur propriétaire du pion
	*/
	public Pion(Joueur joueur)
	{
		this.joueur = joueur;
	}
	
	
	
	/** Méthode qui permet de savoir si le pion est un tigre ou pas
	*@return true si le pion est un tigre sinon false
	*/
	public boolean isPredateur(){
		return this.predateur;
	};
	
	/** Méthode qui permet de savoir si le déplacement indiqué est diagonal
	*@param coordDepartX la coordonnée du pion en X
	*@param coordDepartY la coordonnée du pion en Y
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en X
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en Y
	*@return true si le déplacement est diagonal sinon false
	*/
	public boolean deplacementDiagonal(int coordDepartX, int coordDepartY, int coordArriveeX, int coordArriveeY){
		
		boolean diag = true;		
		if (!(coordDepartX - coordArriveeX == 1)||!(coordDepartX - coordArriveeX == -1) ||
			(!(coordDepartY - coordArriveeY == 1)||!(coordDepartY - coordArriveeY == -1))){
				diag=false;
				} 	
				return diag;	
			}
		

	/** méthode qui permet de calculer la longueur du déplacement déplacement indiqué
	*@param coordDepartX la coordonnée du pion en X
	*@param coordDepartY la coordonnée du pion en Y
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en X
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en Y
	*@return un entier qui définit la longueur en intersection
	*/
	public int longueurDeplacement(int coordDepartX, int coordDepartY,int coordArriveeX,int coordArriveeY){
		if (coordDepartX == coordArriveeX){
			return Math.abs(coordDepartY-coordArriveeY);
			} else {
			return Math.abs(coordDepartX - coordArriveeX);
			} 
	}
	
	
	/** méthode qui renvoie un chemin si le déplacement est vertical
	*@param coordDepartX la coordonnée du pion en X
	*@param coordDepartY la coordonnée du pion en Y
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en X
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en Y
	*@return une liste de coordonnées qui correspond au parcours du pion lors de son déplacement si le chemin est vertical, la méthode renvoie null sinon
	*/
	public Liste getCheminVertical( int coordDepartX, int coordDepartY,int coordArriveeX, int coordArriveeY){
	if (coordDepartX == coordArriveeX)){
		Liste list = new Liste();
		if (coordDepartY > coordArriveeY){
			if (coordDepartY > coordArriveeY){
				for(int y = coordDepartY; y >= coordArriveeY; y--){
						// comme la trajectoire est vertical, la valeur X reste inchangée
						list.add(new Coordonnee(coordDepartX, y));
				}
			} else if (coordDepartY < coordArriveeY){
				for (int y = coordDepartY; y<= coordArriveeY;y++){
					list.add(new Coordonnee(coordDepartX, y));
					}
				}
		}	
		return list;
		} else { return null;}
	
	}
	
	
	/** méthode qui renvoie un chemin si le déplacement est horizontal
	*@param coordDepartX la coordonnée du pion en X
	*@param coordDepartY la coordonnée du pion en Y
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en X
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en Y
	*@return une liste de coordonnées qui correspond au parcours du pion lors de son déplacement si le chemin est horizontal, la méthode renvoie null sinon
	*/
	public Liste getCheminHorizontal( int coordDepartX, int coordDepartY,int coordArriveeX, int coordArriveeY){
	if (coordDepartY == coordArriveeY){
		Liste list = new Liste();
		if (coordDepartX > coordArriveeX){
			if (coordDepartY > coordArriveeY){
				for(int x = coordDepartX; x >= coordArriveeX; x--){
						// comme la trajectoire est horizontal, la valeur Y reste inchangée
						list.add(new Coordonnee(x, coordDepartY));
				}
			} else if (coordDepartX < coordArriveeX){
				for (int x = coordDepartX; x<= coordArriveeX; x++){
					list.add(new Coordonnee(x, coordDepartY));
					}
				}
		}	
		return list;
		} else { return null;}
}

	/** méthode qui renvoie un chemin si le déplacement est diagonal
	*@param coordDepartX la coordonnée du pion en X
	*@param coordDepartY la coordonnée du pion en Y
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en X
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en Y
	*@return une liste de coordonnées qui correspond au parcours du pion lors de son déplacement si le chemin est diagonal, la méthode renvoie null sinon
	*/
	
	public Liste getCheminDiagonal( int coordDepartX, int coordDepartY,int coordArriveeX, int coordArriveeY){
	if (this.deplacementDiagonal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY)){
		Liste list= new Liste();
		int y = coordDepartY;
		if (coordDepartX > coordArriveeX && coordDepartY > coordArriveeY){
			for (int x = coordDepartX; x >= coordArriveeX; x--){
				list.add(new Coordonnee(x, y));
				y--;
			} 
		} else if (coordDepartX > coordArriveeX && coordDepartY < coordArriveeY){
				for (int x = coordDepartX; x >= coordArriveeX; x--){
					list.add(new Coordonnee(x, y));
					y++;
				}
		} else if (coordDepartX < coordArriveeX && coordDepartY > coordArriveeY){
				for (int x = coordDepartX; x <= coordArriveeX; x++){
					list.add(new Coordonnee(x, y));
					y--;
				}
		} else if (coordDepartX < coordArriveeX && coordDepartY < coordArriveeY){
			for (int x = coordDepartX; x <= coordArriveeX; x++){
					list.add(new Coordonnee(x, y)) ;
					y++;
				}
		}
		return list;
   	} else {return null;}
   		
   		
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
                  if (diagonalAutorise && diag){
		          return this.getCheminDiagonal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
		  
		          } else if (this.getCheminVertical(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY) != null){
		          		
		          		return this.getCheminDiagonal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
		          		
			} else if (this.getCheminHorizontal(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY) != null){
				
				return this.getCheminVertical(coordDepartX,coordDepartY, coordArriveeX, coordArriveeY);
				
			} else {return null;}
		          			
 }
                
                /** Méthode qui renvoie le joueur qui est propriétaire du pion
                *@return l'objet joueur
                */
                public Joueur getJoueur(){
                	return this.joueur;
                	}
                	
                /**Méthode qui permet de définir le propriétaire du pion
                *@param joueur le joueur propriétaire du pion
                */
                public void setJoueur(Joueur joueur){
                	  this.joueur = joueur;
                	  }
                  
}
