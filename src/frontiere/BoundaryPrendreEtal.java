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
		
		
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)){
			System.out.println("Je suis désolé " + nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici. \n" );
		}else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux trouver un etal. \n" );

		
		if(!controlPrendreEtal.resteEtals()) {
			System.out.println("Désolé " + nomVendeur + ", je n'ai plus d'etals qui ne soit pas déja occupé. \n");
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
		System.out.println(installer);
		
		String produit = scan.next();
		
		int nbProduit = Clavier.entrerEntier("Combien voulez-vous en vendre ?\n");
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit) + 1;
		
		System.out.println("Le vendeur " + nomVendeur + " s'est intallé à l'étal n° " + numeroEtal + ". \n" );
	}
}
