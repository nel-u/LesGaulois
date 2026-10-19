package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		
		assert isInvariantVerified();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte +"\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	@Override
	public String toString() {
		return nom;
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int forceAvant = force;
		
		force = force - forceCoup;
		if (force < 1) {
			parler("J'abandonne !");
		}
		else {
			parler("Aïe");
		}
		
		assert force < forceAvant;
		assert isInvariantVerified();
	}
	
	private boolean isInvariantVerified() {
		return force >= 0;
	}
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + "est déja bien protégé !");
			break;
			
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déja un " + equipement + " !");
			}
			else {
				ajouterEquipement(equipement);
			}
			break;

		default:
			ajouterEquipement(equipement);
			break;
		}
	}
	
	public static void main() {
		Romain minus = new Romain("Minus", 6);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
