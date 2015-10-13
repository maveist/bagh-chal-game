package jeu;

public class Joueur{
private String pseudo;

	/*Constructeur de Joueur*/
	public Joueur(String pseudo){
		this.pseudo = pseudo;
		}
		
	/*equals*/
	public boolean equals(Object o){
		if (o instanceof Joueur){
			if (((Joueur)o).pseudo == this.pseudo){
				return true;
				}
		}
		return false;
		}
		
	/* getPseudo() */
	public String getPseudo(){
		return this.pseudo;
		}
	
}
