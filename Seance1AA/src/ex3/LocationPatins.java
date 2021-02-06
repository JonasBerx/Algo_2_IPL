package ex3;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MILLIS;

public class LocationPatins {

	// K = Size of skates, V = Number of safe that contains skates
//	private Map<Integer, Map<Integer, Boolean>> safes;
//	private Map<Integer, ArrayList> safes = new HashMap<Integer,ArrayList>();
	private List<ArrayList> safes = new ArrayList<>();


	public LocationPatins(int[] casiers) {
		for (int i = 0; i < casiers.length; i++) {
			ArrayList patins = new ArrayList();
			patins.add(casiers[i]);
			patins.add(true);
			patins.add(LocalTime.now());

			safes.add(patins);
		}
		System.out.println(safes);
	}

	// date1 < date2
	private static double prix(LocalTime date1, LocalTime date2) {
		// 1 euro par milliseconde (c'est assez cher en effet)
		return MILLIS.between(date1, date2) ;
	}

	public int attribuerCasierAvecPatins(int pointure) {
		System.out.println("---start attribue---");
		if (pointure < 33 || pointure > 48)
			throw new IllegalArgumentException();
		LocalTime l = LocalTime.now();

//		System.out.println(safes.get(pointure));


		//a compléter
		// TODO Make less complex, not optimised yet.
		for (int i = 0; i < safes.size(); i++) {
			if ((int) safes.get(i).get(0) == pointure && (boolean) safes.get(i).get(1)) {
				safes.get(i).set(1, false);
				return (int) safes.get(i).get(0);
			}
		}
		System.out.println("No free casiers");
		return -1;

	}

	public double libererCasier(int numeroCasier) {
		//a completer
		System.out.println("---start liberer");
		safes.get(numeroCasier).set(1, true);
		return prix((LocalTime) safes.get(numeroCasier).get(2),LocalTime.now());
	}

}
