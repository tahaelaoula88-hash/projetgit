public class Main {

    public static void main(String[] args) {
        System.out.println("=== Application de gestion d'etudiants ===");
        System.out.println("Hello SCRUM project");

        Etudiant e1 = new Etudiant("Taha", 21, 15.5);
        Etudiant e2 = new Etudiant("Sara", 22, 12.0);
        Etudiant e3 = new Etudiant("Yassine", 20, 17.8);

        Etudiant[] etudiants = { e1, e2, e3 };

        System.out.println();
        System.out.println("Liste des etudiants :");
        for (Etudiant e : etudiants) {
            e.afficher();
        }

        double moyenneGenerale = calculerMoyenneGenerale(etudiants);
        System.out.println();
        System.out.println("Moyenne generale de la promotion : " + moyenneGenerale);

        Etudiant meilleur = trouverMeilleurEtudiant(etudiants);
        System.out.println("Meilleur etudiant : " + meilleur.getNom() + " avec une moyenne de " + meilleur.getMoyenne());
    }

    public static double calculerMoyenneGenerale(Etudiant[] etudiants) {
        double somme = 0;
        for (Etudiant e : etudiants) {
            somme += e.getMoyenne();
        }
        return somme / etudiants.length;
    }

    public static Etudiant trouverMeilleurEtudiant(Etudiant[] etudiants) {
        Etudiant meilleur = etudiants[0];
        for (Etudiant e : etudiants) {
            if (e.getMoyenne() > meilleur.getMoyenne()) {
                meilleur = e;
            }
        }
        return meilleur;
    }
}

class Etudiant {
    private String nom;
    private int age;
    private double moyenne;

    public Etudiant(String nom, int age, double moyenne) {
        this.nom = nom;
        this.age = age;
        this.moyenne = moyenne;
    }

    public String getNom() {
        return nom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void afficher() {
        String mention;
        if (moyenne >= 16) {
            mention = "Tres bien";
        } else if (moyenne >= 14) {
            mention = "Bien";
        } else if (moyenne >= 12) {
            mention = "Assez bien";
        } else {
            mention = "Passable";
        }
        System.out.println("- " + nom + " (" + age + " ans) : " + moyenne + "/20 -> " + mention);
    }
}
