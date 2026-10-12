package personnages;

import objets.Chaudron;

public class Druides {
	private String nom;
	private int force;
	private Chaudron chaudron;
	
	public Druides(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.chaudron = new Chaudron();
	}

	public String getNom() {
		return nom;
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
	}
	
	public void booster(Gaulois gaulois) {
		String nomGaulois = gaulois.getNom();
		if(chaudron.resterPotion() == true) {
			if(nomGaulois == "Obélix") {
				parler("Non, " + nomGaulois + " Non !... Et tu le sais très bien !");
			}
			else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens " + nomGaulois + " un peu de potion magique.");
			}
		}
		else {
			parler("Désolé " + nomGaulois + " il n'y a plus une seule goutte de potion.");
		}
	}
}
