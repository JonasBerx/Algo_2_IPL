package ex5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doodle {
	public PlageHoraire[] plages;
	// a compléter
	public Map<String, boolean[]> available;

	public Doodle(PlageHoraire... plages) {
		this.plages = plages;
		this.available = new HashMap<>();
		// a compléter
	}

	// ajoute les disponibilités d'un participant sous forme d'un tableau de booleen.
	// les indices du tableau correspondent aux indices du tableau plages
	// true à l'indice i veut dire que le participant est disponible pour la plage à l'indice i du tableau plages
	// false à l'indice i veut dire que le participant n'est pas disponible pour la plage à l'indice i du tableau plages
	public void ajouterDisponibilites(String participant,
			boolean[] disponibilites) {
		if (disponibilites.length != plages.length)
			throw new IllegalArgumentException();
		//a compléter
		available.put(participant, disponibilites);

		for (int i = 0; i < disponibilites.length; i++) {
			int ici = Arrays.asList(plages).get(i).getNbParticipantPresent();
			if (disponibilites[i]) {
				ici += 1;

			}
			Arrays.asList(plages).get(i).setNbParticipantPresent(ici);
			System.out.println(ici);
		}


		System.out.println("-----");

	}
	
	// Hypothèse: la PlageHoraire plage en paramètre fait bien partie du tableau plages
	// renvoie vrai si le participant est disponible pour cette plage horaire
	// renvoie faux si le participant n'est pas disponible ou s'il n'a pas rempli le
	// sondage doodle
	public boolean estDisponible(String participant, PlageHoraire plage) {
		int index = Arrays.asList(plages).indexOf(plage);
		return available.get(participant)[index];
	}

	// renvoie une des plages horaires qui a le maximum de participants prévus
	// cette méthode est appelée après que les participants aient rempli leurs disponibilités
	public PlageHoraire trouverPlageQuiConvientLeMieux() {
		int meilleur = 0;
		int index = 0;
		for (int i = 0; i < plages.length; i++) {
			if (plages[i].getNbParticipantPresent() > meilleur) {
				index = i;
				meilleur = plages[i].getNbParticipantPresent();
			}
		}
		return plages[index];
	}

}
