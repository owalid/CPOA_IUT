import java.util.*;

public class Jeu {
	List<Joueur> Joueurs = new LinkedList<>();
	Talon t = new Talon(1);
	int nbJoueur;
	public Jeu(int nbJoueur) {
		this.nbJoueur = nbJoueur;
		for(int i=0;i<nbJoueur-1;i++){
			Joueurs.add(new JoueurHumain(i));
		}
		Joueurs.add(new JoueurOrdinateur(Joueurs.size()+1));
	}

	public void start() {
		int i=0;
		int y=0;
		while(t.estcomplet()){
			//continuer le jeux
			
				//parcours de l'array list de joueur pour la premiere condition
				for(y=0;y<Joueurs.size();y++){

					//verifions maintenant que personne n'est gagner 
					//et qu'il reste des cartes dans le talon
					if(!Joueurs.get(y).Gagne() && t.getNbCartes()>0){
						//tours
						
						//on parcours tout les joueurs
						for (i=0; i<nbJoueur;i++){
							//si le joueur veux piocher
							if(Joueurs.get(i).prendCartes()){
								Joueurs.get(i).mainJ.addCard(1);
							}
							//si un joueur gagne
							else if(Joueurs.get(i).Gagne()){
								System.out.println("le joueur"+Joueurs.get(i)+"a gagner");
							}
							//sinon on recommence
							else
							start();
						}					
					}
				}
			//reinitialisation des variables compteurs
			y=0;
			i=0;
		}

	}

	public static void main(String args[]){
		Jeu j = new Jeu(2);
		j.start();
	}
}
