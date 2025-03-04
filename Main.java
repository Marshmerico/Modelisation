import java.util.ArrayList;
import java.util.List;

class Etudiant {
    private String nom;
    private String prenom;
    private String matricule;
    private String dateAdmission;
    private int heuresAbsence;

    public Etudiant(String nom, String prenom, String matricule, String dateAdmission, int heuresAbsence) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateAdmission = dateAdmission;
        this.heuresAbsence = heuresAbsence;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getDateAdmission() {
        return dateAdmission;
    }

    public int getHeuresAbsence() {
        return heuresAbsence;
    }

    public void setHeuresAbsence(int heuresAbsence) {
        this.heuresAbsence = heuresAbsence;
    }
}

class RapportAbsences {
    public List<Etudiant> genererRapport(List<Etudiant> etudiants) {
        List<Etudiant> etudiantsARenvoyer = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getHeuresAbsence() > 30) {
                etudiantsARenvoyer.add(etudiant);
            }
        }
        return etudiantsARenvoyer;
    }
}

class Coordonnateur {
    private final RapportAbsences rapportAbsences;

    public Coordonnateur() {
        this.rapportAbsences = new RapportAbsences();
    }

    public void consulterEtudiantsARenvoyer(List<Etudiant> etudiants) {
        List<Etudiant> etudiantsARenvoyer = rapportAbsences.genererRapport(etudiants);
        System.out.println("Rapport des etudiants a renvoyer :");
        
        if (etudiantsARenvoyer.isEmpty()) {
            System.out.println("Aucun etudiant a renvoyer.");
        } else {
            for (Etudiant etudiant : etudiantsARenvoyer) {
                System.out.println("Nom: " + etudiant.getNom() + " " + etudiant.getPrenom() +
                        ", Matricule: " + etudiant.getMatricule() +
                        ", Date d'admission: " + etudiant.getDateAdmission() +
                        ", Heures d'absence: " + etudiant.getHeuresAbsence());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant("Ouellet", "Jeremy", "OUEJ11090000", "12 Avril 1987", 100));
        etudiants.add(new Etudiant("Renaud", "Emeric", "RENE05030000", "8 Aout 2016", 12));
        etudiants.add(new Etudiant("Bolduc", "Simon-Olivier", "BOLS01100300", "4 Mars 2025", 20));

        Coordonnateur coordonnateur = new Coordonnateur();
        coordonnateur.consulterEtudiantsARenvoyer(etudiants);
    }
}
