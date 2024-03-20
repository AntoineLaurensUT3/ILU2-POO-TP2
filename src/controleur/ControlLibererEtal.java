package controleur;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		boolean vendeurReconnu = false;
		
		if(controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null ) {
			vendeurReconnu = true;
		}
		
		return vendeurReconnu;
		
	}
	
	
	
	
	public String[] libererEtal(String nomVendeur) {
		
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal();
		
	}

}
