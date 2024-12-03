class Ingredient(
    val nom: String,
    val categorie: String,
    val unite: String,
    val prix: Double,
    val quantite: Double
) {
    override fun toString(): String {
        val vendu = if (unite == "kilo") "au kilo" else "à la pièce"
        return "$quantite $nom, $categorie vendu $vendu pour un prix de $prix euros"
    }
}

val liste = listOf(
    Ingredient(
        nom = "sel", categorie = "épice", unite = "kilo", prix = 2.5, quantite = 1.0
    ), Ingredient(
        nom = "tomates", categorie = "légume", unite = "kilo", prix = 4.9, quantite = 1.5
    ), Ingredient(
        nom = "bananes", categorie = "fruit", unite = "kilo", prix = 1.5, quantite = 3.0
    ), Ingredient(
        nom = "melons", categorie = "fruit", unite = "pièce", prix = 2.0, quantite = 4.0
    ), Ingredient(
        nom = "champignons", categorie = "légume", unite = "kilo", prix = 4.2, quantite = 2.0
    ), Ingredient(
        nom = "cumin", categorie = "épice", unite = "kilo", prix = 20.0, quantite = 0.2
    )
)

fun main() {
    // Afficher tous ce qui n'est pas un fruit ou une épice.
    val epices = liste.filter { it.categorie == "épice" }
        .forEach { (println("Affichage des épices " + it.nom)) }

    // Afficher tous ce qui n'est pas un fruit ou une épice.
    val legume = liste.filter { it.categorie != "épice" && it.categorie != "fruit" }
        .forEach { (println("Affiche des légumes " + it.nom)) }

    // Même question mais dans l'ordre inverse alphabétique.
    val nomAsc = liste.sortedBy { it.nom }.forEach { (println("Orderby Asc nom " + it.nom)) }

    // Même question mais dans l'ordre inverse alphabétique.
    val nomDes =
        liste.sortedByDescending { it.nom }.forEach { (println("Orderby Desc nom " + it.nom)) }

    // Vérifiez si un des ingrédient vaut moins de 1 euros
    val moinsUn = liste.any { it.prix < 1 }
    println("Quantité inf à 1 " + moinsUn)

    // Vérifiez si tous les ingrédients ont une quantité plus grande que 1.
    val supUn = liste.all { it.quantite > 1 }
    println("Quantité sup à 1 " + supUn)

    // Afficher le produit le plus cher au kilo (il faut donc sélectionner uniquement les produits qui se vendent au kilo).
    val cherKilo = liste.filter { it.unite == "kilo" }.maxByOrNull { it.prix }
    println(cherKilo)

    // En utilisant la méthode groupBy{ } , regroupez les produits par catégories et affichez les clés de ces catégories. Cette méthode retourne en effet une Map<String, List<Ingredient>> .
    val categorie = liste.groupBy { it.categorie }
    println(categorie.keys)


    // Obtenez une liste de paires de valeur représentant le nom du produit et son coût total obtenu  en multipliant son prix par sa quantité, puis affichez cette liste.  En Kotlin, on peut créer une paire en créant un objet de type  Pair(x,y) avec les deux éléments de la paire en paramètre.
    val panier = liste.map { Pair(it.nom, it.prix * it.quantite) }
        .forEach { (println("Produit: ${it.first}, Coût total: ${it.second} euros")) }

    // Affichez le coût total du panier.
    val prixTot = liste.fold(0.0){acc, p -> acc + p.prix * p.quantite}
    println(prixTot)
}