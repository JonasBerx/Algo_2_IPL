package ex7;

import java.util.*;

public class AcademieAvecDesistement {
	public Map<String, LinkedList<String>> waitingList;
	// Another structure
	public AcademieAvecDesistement(ArrayList<String> v){
		waitingList = new HashMap<>();
		System.out.println(v.size());
		for (String s : v) {
			waitingList.put(s, new LinkedList<>());
		}
	}
	
	public void mettreEnAttente(String instrument, String nomEleve){
		System.out.println(waitingList);
		waitingList.get(instrument).add(nomEleve);
		System.out.println(waitingList);
	} 
	// TODO Too expensive in linkedlist
	public void desistement(String instrument, String eleve){
		waitingList.get(instrument).remove(eleve);
	}
	
	//supprime uniquement l'élève de la file d'attente
	public String attribuerPlace(String instrument){
		return waitingList.get(instrument).poll();
	} 
	
	

}
