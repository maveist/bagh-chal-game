/**
*Classe Chevre
*@autor DAHMANI Sélim LECARDUNER Noé
*@version 1.0
*/
package jeu;
public class Coordonnee{
private int x;
private int y;
			/**Constructeur de la classe Coordonnée
			*@param x coordonnée en x
			*@param y coordonnée en y
			*/	
			public Coordonnee(int x, int y){
				this.x = x;
				this.y = y;
				}
			
			/**Méthode qui permet de récuperer seulement la coordonnée en x
			*@return un entier correspondant à la coordonnée en x
			*/
			public int getX(){
				return this.x;
				}
			/**Méthode qui permet de récuperer seulement la coordonnée en y
			*@return un entier correspondant à la coordonnée en y
			*/
			public int getY(){
				return this.y;
				}
	
}
				
				
