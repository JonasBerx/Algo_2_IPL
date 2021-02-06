package ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControleDAcces {
	Map<Badge, Employe> employes;
	public ControleDAcces(){
		employes = new HashMap<>();
	}

	// associe le badge à un employé
	public void donnerBadge (Badge b, Employe e){
		employes.put(b, e);

	}

	// met à jour les employés présents dans le batiment
	public void entrerBatiment (Badge b){
		employes.get(b).scanBadge();
	}

	// met à jour les employés présents dans le batiment
	public void sortirBatiment (Badge b){
		employes.get(b).scanBadge();
	}

	// renvoie vrai si l'employé est dans le batiment, faux sinon
	public boolean estDansBatiment (Employe e){
		return e.getPresence();

	}

}
