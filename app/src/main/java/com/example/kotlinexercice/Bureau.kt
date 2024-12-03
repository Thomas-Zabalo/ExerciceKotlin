//Exercice Le bureau

open class Visiteur(val nom: String = "", val prenom: String = "") {
    open fun afficher() {
        println("Visiteur: $nom $prenom")
    }
}

open class Employe(nom: String, prenom: String, val salaire: Int) : Visiteur(nom, prenom) {
    override fun afficher() {
        println("Employé:$nom, $prenom. Salaire: $salaire")
    }
}

class Chef(nom: String, prenom: String, salaire: Int, val service: String = "") :
    Employe(nom, prenom, salaire) {
    override fun afficher() {
        println("Chef: $nom, $prenom. Salaire: $salaire, Service: $service")
    }
}

fun main() {
    val visiteur = Visiteur("Jean", "Clement").afficher()
    val employe1 = Employe("Bernard", "Dupond", 1300).afficher()
    val employe2 = Employe("Titan", "Dupond", 1500).afficher()
    val chef = Chef("Pecatte", "Jean-Marie", 3500, "DRH").afficher()
}
