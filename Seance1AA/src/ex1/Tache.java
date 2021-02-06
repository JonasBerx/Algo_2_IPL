package ex1;

import java.time.LocalDate;

public class Tache implements Comparable<Tache> {
	private LocalDate date;
	private String descriptif;
	private int priorite;

	public Tache(String descriptif, int priorite) {
		super();
		this.date = LocalDate.now();
		this.descriptif = descriptif;
		this.priorite = priorite;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public int getPriorite() {
		return priorite;
	}

	@Override
	public int compareTo(Tache t) {
		//Compare priority of tasks. If tasks have same priority then check date of creation.
		if (t.getPriorite() > getPriorite()) {
			return 1;
		} else if (t.getPriorite() == getPriorite()) {
			if (t.getDate().isBefore(getDate())) {
				return 1;
			} else {
				return -1;
			}
		}
		return -1;
	}
}
