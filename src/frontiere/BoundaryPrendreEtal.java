package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder etal = new StringBuilder();
		
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)){
			etal.append("Je suis désolé ");
			etal.append(nomVendeur);
			etal.append(" mais il faut etre un habitant de notre village pour commercer ici. \n");
		}else {
			
		etal.append("Bonjour ");
		etal.append(nomVendeur);
		etal.append(", je vais regarder si je peux trouver un etal. \n");
		
		if(!controlPrendreEtal.resteEtals()) {
			etal.append("Désolé ");
			etal.append(nomVendeur);
			etal.append(", je n'ai plus d'etal qui ne soit pas déja occupé. \n");
		}else {
			installerVendeur(nomVendeur);	
		}
			
		
		
		}
					
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder installer = new StringBuilder();
		installer.append("C'est parfait, il me reste un étal pour vous ! \n");
		installer.append("Il me faudrait quelques renseignements : \n");
		installer.append("Quel produit souhaitez-vous vendre ? \n");
		String produit = Clavier.entrerString(installer.toString());
		//TODO Creer une methode entrerString dans Clavier
		installer.append("Combien voulez-vous en vendre ?\n");
		int nbProduit = Clavier.entrerEntier(installer.toString());
	}
}
