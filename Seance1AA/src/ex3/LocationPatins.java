package ex3;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.MILLIS;

public class LocationPatins {

	// TODO THis might be a little too complicated for a solution?

	// K = Size of skates, V = Number of safe that contains skates
	private Map<Integer, List> patinsLibre = new HashMap<>();
	private Map<Integer, List<List>> patinsPris = new HashMap<>();

	public LocationPatins(int[] casiers) {
		for (int i = 0; i < casiers.length ; i++) {
			patinsLibre.put(casiers[i], new LinkedList());
			patinsPris.put(i, new LinkedList());
		}
		for (int i = 0; i < casiers.length ; i++) {
			patinsLibre.get(casiers[i]).add(i);
		}
//		System.out.println(patinsLibre);
//		System.out.println(patinsPris);
//		System.out.println("Finit setup\n");
	}

	// date1 < date2
	private static double prix(LocalTime date1, LocalTime date2) {
		// 1 euro par milliseconde (c'est assez cher en effet)
		return MILLIS.between(date1, date2) ;
	}

	public int attribuerCasierAvecPatins(int pointure) {
		if (pointure < 33 || pointure > 48)
			throw new IllegalArgumentException();
		LocalTime l = LocalTime.now();
		if (patinsLibre.get(pointure).isEmpty()) {
			System.out.println("Pas de patins libre pour " + pointure);
			return -1;
		}
		List t = new ArrayList();
		t.add(pointure);
		t.add(LocalTime.now());
		patinsPris.get(patinsLibre.get(pointure).get(0)).add(t);
//		System.out.println(patinsLibre);
		return (int) patinsLibre.get(pointure).remove(0);

	}

	public double libererCasier(int numeroCasier) {
//		System.out.println("libre: " + patinsLibre);
//		System.out.println("pris: " + patinsPris);
//		System.out.println("");
		LocalTime b = (LocalTime) patinsPris.get(numeroCasier).get(0).get(1);
//		System.out.println(b);
		LocalTime e = LocalTime.now();
		patinsLibre.get(patinsPris.get(numeroCasier).remove(0).get(0)).add(numeroCasier);
//		System.out.println("libre: " + patinsLibre);
//		System.out.println("pris: " + patinsPris);
		return prix(b,e);
	}

}
