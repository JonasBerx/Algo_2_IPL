package ex4;

public class Test {
	public static void main(String[] args) {
		try {

			ChoixOptions co= new ChoixOptions(2, "IA","SAP","Unity");
			Etudiant jean= new Etudiant("jean", 80);
			Thread.sleep(4000);
			Etudiant paul= new Etudiant("paul", 81);
			Thread.sleep(4000);
			Etudiant luc= new Etudiant("luc",81);
			Thread.sleep(4000);
			co.ajouterPreferences(jean, "IA", "SAP", "Unity");
			co.ajouterPreferences(paul, "IA", "SAP", "Unity");
			co.ajouterPreferences(luc, "IA", "SAP", "Unity");
			co.attribuerOptions();
			System.out.println(co);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
