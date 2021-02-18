package ex6;

import java.util.*;

public class GestionImpression {

	// TODO This one do be kinda hard tho..
	// Queue to start and keep second structure for the last one
	private Queue<Impression> printQueue;
	private HashMap<String,Impression> lastImpr;

	public GestionImpression() {
		printQueue = new ArrayDeque();
		lastImpr = new LinkedHashMap<>();
	}


	public void ajouterImpression(Impression impr){
		printQueue.add(impr);
		lastImpr.put(impr.getIdUtilisateur(),impr);
	}

	public Impression selectionnerImpression(){
		System.out.println(lastImpr);
		System.out.println(printQueue);
		String nom = printQueue.poll().getIdUtilisateur();

		// TODO How to get correct name only once? - Jean gets printed twice but he went already...

		return lastImpr.get(nom);
//		return null;
	}


}
