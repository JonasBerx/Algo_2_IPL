package ex1;


import java.util.*;


public class Ordonnancement {
	public static final int NIVEAU_PRIORITE_MAX=5;
	// LinkedList or Arraylist for this exercise

	private ArrayList<List<Tache>> taches;

	public Ordonnancement(){
		taches = new ArrayList<>();
		for (int i = 0; i < NIVEAU_PRIORITE_MAX; i++) {
			taches.add(new LinkedList<>());
		}
	}
	public void ajouterTache (String descriptif, int priorite){
		//Check if linkedlist for prio already exists. if not add create new linkedlist for priority.
		// Add task to list of prio and then add linkedlist to arraylist of tasks
		Tache t = new Tache(descriptif, priorite);
		taches.get(priorite - 1).add(t);
	}
	//renvoie la tache prioritaire
	//renvoie null si plus de tache presente
	public Tache attribuerTache(){
		// Read first array (prio 5). Once empty go down to second array (prio 4.) etc...
		for (int i = NIVEAU_PRIORITE_MAX; i > 0; i--) {
			for (int j = 0; j < taches.get(i-1).size(); j++) {
				return taches.get(i-1).remove(j);
			}
		}
		return null;
	}
}
