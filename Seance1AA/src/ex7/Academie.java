package ex7;

import java.util.*;

public class Academie {
	public Map<String,LinkedList<String>> waitingList;
	/**
	 * For every type of instrument we need a new queue
	 * Every queue should have an identifier => name of instrument and contains the names of the students that are waiting for that instrument
	 * Use priorityqueue for each instrument.
	 * */

	public Academie(ArrayList<String> v){
		waitingList = new HashMap<>();
		System.out.println(v.size());
		for (String s : v) {

			waitingList.put(s, new LinkedList<>());
		}
		System.out.println(waitingList);
	}

	public void mettreEnAttente(String instrument, String nomEleve){
		waitingList.get(instrument).add(nomEleve);
	}

	// supprime uniquement l'�l�ve de la file d'attente et le renvoie
	// renvoie null s�il n�y a pas d��l�ve en attente pour cet instrument	
	public String attribuerPlace(String instrument){
		return waitingList.get(instrument).poll();
	}

}
