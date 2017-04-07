package utils;

import entities.FicheDePaie;

public class SalaryCalculations {
	
	
	public static Double salaireBruteMensuel(FicheDePaie fiche){
		return fiche.getSalaireDeBase() + fiche.getPrimeDePanier() + fiche.getPrimeDePresence()
		+ fiche.getPrimeDeProduction() + fiche.getPrimeDeTransport() + fiche.getPrimeSpeciale();
	}
	
	public static Double salaireImposableMensuel(FicheDePaie fiche){
		Double salBrute = salaireBruteMensuel(fiche);
		return salBrute - (salBrute * (fiche.getRetenueCnss() / 100));
	}
	
	public static Double salaireBruteAnnuel(FicheDePaie fiche){
		
		return salaireBruteMensuel(fiche)*12;
	}
	
	public static Double retenue(FicheDePaie fiche){
		Double salBruteAnn = salaireBruteAnnuel(fiche);
		return salBruteAnn * (fiche.getRetenueCnss() / 100);
	}
	
	public static Double reliquat(FicheDePaie fiche){
		salaireBruteAnnuel(fiche);
		return salaireBruteAnnuel(fiche)-retenue(fiche);
	}
	
	public static Double salaireImposableAnnuel(FicheDePaie fiche){
		
		Double reliquat = reliquat(fiche);
		return reliquat - (reliquat * 0.1);
	}
	
	public static Double value(FicheDePaie fiche){
		
		Double value =null;
		Double salImposableAnn= salaireImposableAnnuel(fiche);
		if (salImposableAnn >= 1500) {
			value = 525.0;
			if (salImposableAnn > 5000 ) {
				value = value + (salImposableAnn - 5000) * 0.2;
				if (salImposableAnn > 10000 ) {
					value = value + (salImposableAnn - 10000) * (25 / 100);
					if (salImposableAnn > 20000) {
						value = value + (salImposableAnn - 20000) * (30 / 100);
					}
				}
			}

		}
		return value;
		
	}
	
	public static Double impoSurRevenue(FicheDePaie fiche){
		return value(fiche)/12;
	}
	
	public static Double salaireNet(FicheDePaie fiche)
	{
		return salaireImposableMensuel(fiche) - impoSurRevenue(fiche);
	}
	
	

}
