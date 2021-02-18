package ex4;

import java.time.LocalTime;

public class Etudiant implements Comparable<Etudiant> {
	private final String nom;
	private int moyenne;
	private LocalTime application;
	public Etudiant(String nom, int moyenne) {
		super();
		this.nom = nom;
		this.moyenne = moyenne;
		this.application = LocalTime.now();
	}
	public String getNom() {
		return nom;
	}
	public int getMoyenne() {
		return moyenne;
	}
	public LocalTime getApplication() {
		return application;
	}

	@Override
	public int compareTo(Etudiant o) {
		// TODO Compare more than just points
		if (o.getMoyenne() == getMoyenne()) {
			System.out.println(o.getApplication());
			System.out.println(getApplication());
			System.out.println(o.getApplication().compareTo(getApplication()));
			return o.getApplication().compareTo(getApplication());
		} else {
			return o.getMoyenne() - getMoyenne();
		}
	}
}
