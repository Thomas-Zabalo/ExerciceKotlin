import com.example.kotlinexercice.genererCarac
import kotlin.random.Random

val caracteristiques = mapOf(
    "Force" to 5,
    "Dexterite" to 12,
    "Intelligence" to 12,
    "Sagesse" to 3,
    "Constitution" to 8,
    "Charisme" to 13
)


fun lancer() {
    return List(4) { Random.nextInt(1, 7) }.let {
        (it - it.min()).sum()
    }
}

fun genererCaracteristiques() =
    caracteristiques.mapValues { k -> lancer() }

fun main() {
    println(lancer())
    println(genererCaracteristiques())
}