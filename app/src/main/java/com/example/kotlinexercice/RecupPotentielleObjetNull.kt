class Personne(val prenom: String, val age: Int) {

}

val personnes1 = listOf(
    Personne("Nicolas", 13),
    Personne("Noémie", 16)
)

val personnes2 = listOf(
    Personne("Jean", 34),
    Personne("Marie", 19)
)

fun main() {
    println(personnes1.find { it.age >= 18 }?.prenom ?: "Personne n'est majeur")
    println(personnes2.find { it.age >= 18 }?.prenom ?: "Personne n'est majeur")

    println(
        personnes2.filter { it.age >= 18 }.ifEmpty { null }?.maxBy { it.age }?.prenom
            ?: "Personne n'est majeur"
    )
}