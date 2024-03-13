package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous etes deja  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("etes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;	

				case 2:
					StringBuilder EstGaulois = new StringBuilder();
					EstGaulois.append("Bienvenue villageois ");
					EstGaulois.append(nomVisiteur);
					EstGaulois.append(". \n");
					EstGaulois.append("Quelle est votre force ? \n");
					int force = Clavier.entrerEntier(EstGaulois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder EstDruide = new StringBuilder();
		EstDruide.append("Bienvenue Druide ");
		EstDruide.append(nomVisiteur);
		EstDruide.append(". \n");
		EstDruide.append("Quelle est votre force ? \n");
		int ForceDruide = Clavier.entrerEntier(EstDruide.toString());
		int effetPotionMax;
		int effetPotionMin;
		do {
			EstDruide.append("Quelle est la force de la potion la plus faible que vous produisez ?  \n");
			effetPotionMin = Clavier.entrerEntier(EstDruide.toString());
			EstDruide.append("Quelle est la force de la potion la plus forte que vous produisez ?  \n");
			effetPotionMax = Clavier.entrerEntier(EstDruide.toString());
			if(effetPotionMax < effetPotionMin) {
				EstDruide.append("Attention Druide, vous vous etes trompé entre le minimum et le maximum !  \n");
			}
			
		} while(effetPotionMax < effetPotionMin); 
		
		controlEmmenager.ajouterDruide(nomVisiteur, ForceDruide, effetPotionMin, effetPotionMax);
		
		
	}
}
