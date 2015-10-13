/**
*Classe Intersection
*@autor DAHMANI Sélim LECARDUNER Noé
*@version 1.0
*/
package jeu;
import liste.Liste;
import jeu.Pion;

			
public class Intersection {

private boolean accesDiagonal;
private Pion pion;
	
			/**Constructeur de la classe Intersection*/
			public Intersection()
				{
					this.pion = null;
				}	
	
			/**Méthode permettant de savoir si l'intersection de ne contient pas de pion
			*@return true si l'intersection est libre, false sinon.
			*/
			public boolean estLibre()
				{
					return(this.pion == null);
				}
			
			/**Méthode permettant de définir si l'intersection est pourvu d'acces diagonal
			*@return true si l'intersection a des acces diagonaux,false sinon
			*/
			public void setAccesDiagonal(boolean etat)
				{
					this.accesDiagonal = etat;
				}
			
			/**Méthode permettant de savoir si l'intersection est pourvu d'acces diagonal
			*@return true si l'intersection a des acces diagonaux,false sinon
			*/
			public boolean getAccesDiagonal()
				{
				return this.accesDiagonal;	
				}
			
			/**Méthode de définir l'objet pion qui se trouve dans l'intersection
			*@param pion le pion qui se trouve sur l'intersection
			*/
			public void setPion(Pion pion)
				{
					this.pion = pion;
				}
			
			/**Méthode permettant de récupérer l'objet pion qui se trouve sur l'intersection
			*@return l'objet pion
			*/
			public Pion getPion()
				{
				return (this.pion);	
				}
	
			/**toString()*/
	
				public String toString(){
					if (this.getPion() == null){
						return ("o");
						} else {return ((this.getPion()).toString());}
				}		
			}		
		
