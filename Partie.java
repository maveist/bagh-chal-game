/**
*Classe Partie
*@autor DAHMANI Sélim LECARDUNER Noé
*@version 1.0
*/

package jeu;
import jeu.Joueur;
import liste.Liste;
import jeu.*;


public class Partie{
private int tailleHorizontale;
private int tailleVerticale;
private Joueur joueur1;
private Joueur joueur2;
private Liste chevreCapt;
private Liste coordTigres;
private Intersection[][] plateau;

	/**constructeur de l'objet partie
	*@param joueur1 le joueur 1
	*@param joueur2 le joueur2
	*/
	public Partie(Joueur joueur1, Joueur joueur2){
		this.tailleHorizontale = 5;
		this.tailleVerticale = 5;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.chevreCapt = new Liste();
		this.coordTigres = new Liste();
		plateau = new Intersection[this.tailleHorizontale][this.tailleVerticale];
		for (int x = 0; x <= 4; x++){
			for (int y = 0; y<= 4; y++){
				this.plateau[x][y]= new Intersection();
				}
			} 
		}
		

	/**Méthode pour savoir si un deplacement est possible
	*@param coordDepartX la coordonnée du pion en X
	*@param coordDepartY la coordonnée du pion en Y
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en X
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en Y
	*@return un booléen pour savoir si le déplacement est possible ou non
	*/
	public boolean deplacementPossible(int coordDepartX, int coordDepartY,int coordArriveeX,int coordArriveeY, Joueur joueur){
		boolean estPossible = true;
		/*boolean estVertical = true;
		boolean estHorizontal= true;
		*/boolean estDiagonal = true;
		Pion pion = this.plateau[coordDepartX][coordDepartY].getPion();
		if (pion.getCheminDiagonal(coordDepartX,coordDepartY,coordArriveeX,coordArriveeY) == null){
			estDiagonal = false;
		}
		if ((pion.getDeplacement(coordDepartX,coordDepartY,coordArriveeX,coordArriveeY, estDiagonal) == null) && (this.plateau[coordArriveeX][coordArriveeY].estLibre() == false)){
			estPossible = false;
			} 
			
			if((joueur.equals(this.joueur1)) && (pion.longueurDeplacement(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY) > 1)){
				estPossible = false;
			}
			if ((joueur.equals(this.joueur2)) && (pion.longueurDeplacement(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY) > 2)){
				estPossible = false;
				}
			
		return estPossible;
}
	
		
	/** Définir intersection Diagonal */
	public void definirIntersectionDiagonal()
	{
		this.plateau[0][1].setAccesDiagonal(true);
		this.plateau[0][3].setAccesDiagonal(true);
		this.plateau[1][0].setAccesDiagonal(true);
		this.plateau[1][2].setAccesDiagonal(true);
		this.plateau[1][4].setAccesDiagonal(true);
		this.plateau[2][1].setAccesDiagonal(true);
		this.plateau[2][3].setAccesDiagonal(true);
		this.plateau[3][0].setAccesDiagonal(true);
		this.plateau[3][2].setAccesDiagonal(true);
		this.plateau[3][4].setAccesDiagonal(true);
		this.plateau[4][1].setAccesDiagonal(true);
		this.plateau[4][3].setAccesDiagonal(true);
	
		
	}
	
	/**Méthode qui permet de déplacer un pion
	*@param coordDepartX la coordonnée du pion en X
	*@param coordDepartY la coordonnée du pion en Y
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en X
	*@param coordArriveeX la coordonnée de l'intersection d'arrivée en Y
	*@return un booléen pour confirmer le déplacement du pion
	*/
	public boolean deplacer(int coordDepartX, int coordDepartY,int coordArriveeX,int coordArriveeY, Joueur joueur){
		Pion pion = this.plateau[coordDepartX][coordDepartY].getPion();
		Liste chemin = pion.getDeplacement(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY, this.plateau[coordDepartX][coordDepartY].getAccesDiagonal());
		if (joueur.equals(pion.getJoueur()) && (this.deplacementPossible(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY, joueur))){
			// gestion de la capture de la chevre
			if((joueur.equals(this.joueur2)) && (pion.longueurDeplacement(coordDepartX, coordDepartY, coordArriveeX, coordArriveeY) == 2 ) && (chemin.get(1) instanceof Chevre)){
				int coordonnee_chevreX = ((Coordonnee)(chemin.get(1))).getX();
				int coordonnee_chevreY = ((Coordonnee)(chemin.get(1))).getY();
				chevreCapt.add(this.plateau[coordonnee_chevreX][coordonnee_chevreY].getPion());
				this.plateau[coordonnee_chevreX][coordonnee_chevreY].setPion(null);
			}
			//deplacement du pion
			this.plateau[coordArriveeX][coordArriveeY].setPion(pion);
			this.plateau[coordDepartX][coordDepartY].setPion(null);	
			return true;
			}
		else {return false;}
	
	}
	
	/**Méthode qui permet de placer un pion
	*@param pion le pion à placer
	*@param coordX la coordonnée en X
	*@param coordY la coordonnée en Y
	*@return un booléen pour confirmer le placement du pion
	*/
	public boolean placer(Pion pion, int coordX, int coordY){
		Intersection inter = this.plateau[coordX][coordY];
		if(inter.estLibre()){
			inter.setPion(pion);
			if (pion instanceof Tigre){
				this.coordTigres.add(new Coordonnee(coordX, coordY));
				}
			return true;
		} else {return false;}  		
	}
	
	/**Méthode qui permet d'avoir le nombre de chevres capturés
	*@return un entier qui le nombre de chevre capturées
	*/
	public int getNombreChevresCapturees(){
		return this.chevreCapt.size();
		}
	
	public Joueur getJoueurGagnant(){
		if (this.chevreCapt.size()>= 7){
			return this.joueur2;	//Joueur1 est le joueur qui a des chèvres 
		}/* else if (this.getNombreTigresEncercles() = 4){
			return this.joueur1;
			}*/
		else {return null;}
		
		}
		
	/*public int getNombreTigresEncercles(){
	
	**** Nous n'avons pas réussi à implémenter cette méthode, le code qui se trouve en dessous ne sont que des ébauches qui n'ont pas aboutit
	
	
		int nbr = 0;
		for (int i = 0; i<= 3; i++){
			// on caste l'object en coordonnee
			
			int coordX = ((Coordonnee)this.coordTigres.get(i)).getX();
			int coordY = ((Coordonnee)this.coordTigres.get(i)).getY();
			boolean deplacement = false;
			Intersection inter = this.plateau[coordX][coordY];
				//cherche les différents possibilités de mouvement pour le tigre
			/*boolean deplacement = ((inter.estLibre(coordX + 1, coordY + 1)) || (inter.estLibre(coordX + 2, coordY + 2)) || (inter.estLibre(coordX + 1, coordY)) || (inter.estLibre(coordX + 2, coordY)) || (inter.estLibre(coordX , coordY + 1))|| (inter.estLibre(coordX, coordY + 2)) || (inter.estLibre(coordX - 1, coordY)) || (inter.estLibre(coordX-2, coordY)) || (inter.estLibre(coordX, coordY - 1)) || (inter.estLibre(coordX, coordY - 2)) || (inter.estLibre(coordX-1, coordY-1))|| (inter.estLibre(coordX - 2, coordY - 2)));*/
			/*int x1 = 0 - coord
			for (int x = (0 - coordX); x <= (4 - coordX); x++){
				for (int y = (0 - coordY); y <=(4 - coordY); y++){
					deplacement = (deplacement
				}
			
			
			switch(coordX){
				case 0: 
					switch(coordY):
						case 0: for (int x = 0; x <= 2; x++){ 
								for (int y = 0; y<= 2; y++){
								deplacement = (deplacement) || (inter.estlibre(coordX+x, coordY+y);
								}
							}	
						case 1: for (int x = 0; x <= 2; x++){ 
								for (int y = -1 ; y<= 2; y++){
								deplacement = (deplacement) || (inter.estlibre(coordX+x, coordY+y);
								}
							}											
						case 2: for (int x = 0; x <= 2; x++){ 
								for (int y = -2; x<= 2; y++){
								deplacement = (deplacement) || (inter.estlibre(coordX+x, coordY+y);
								}
							}	
			}
				if (!deplacement){
					nbr ++;
					}
			
				
			}
			 
		
		}
		*/
	
	
	
	
	
		/**Méthode toString
		@return une chaine de caractères représentant plateau ainsi que les pions présents
		*/
		public String toString(){
			return (this.plateau[0][4].toString() + "---" + this.plateau[1][4].toString() + "---" + this.plateau[2][4].toString() +  "---" + this.plateau[3][4].toString() + "---" + this.plateau[4][4].toString() + "\n"+
		"| \\ | / | \\ | / |\n"+
		this.plateau[0][3].toString() + "---"+ this.plateau[1][3].toString() +"---" + this.plateau[2][3].toString() +"---" + this.plateau[3][3].toString() +"---" + this.plateau[4][3].toString() + "\n"+
		"| / | \\ | / | \\ |\n"+
		this.plateau[0][2].toString() +"---"+ this.plateau[1][2].toString()+ "---" + this.plateau[2][2].toString() + "---" + this.plateau[3][2].toString()+"---" + this.plateau[4][2].toString() +"\n"+
		"| \\ | / | \\ | / |\n"+
		this.plateau[0][1].toString() + "---" + this.plateau[1][1].toString() + "---" + this.plateau[2][1].toString()+"---" +this.plateau[3][1].toString()+ "---" + this.plateau[4][1].toString() +"\n"+
		"| / | \\ | / | \\ |\n"+
		this.plateau[0][0].toString()+"---" + this.plateau[0][1].toString() + "---" + this.plateau[0][2].toString() + "---" + this.plateau[0][3].toString() +"---" + this.plateau[0][4].toString() +"\n \n"+ "Nombre de chèvre capturées:" + this.getNombreChevresCapturees() + "\n");	
		
		}
}
