package ex2;

public class Employe {
	private String nom;
	private String prenom;
	private boolean present;
	public Employe(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.present = false;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public boolean getPresence() {
		return present;
	}

	public void scanBadge() {
		present = !present;
	}
}
