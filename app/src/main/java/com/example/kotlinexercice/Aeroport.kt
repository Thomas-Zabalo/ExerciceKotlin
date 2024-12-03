import kotlin.random.Random

// Exercice Aeroport

interface PeutVoler {
    //Valeur en Km/h
    abstract val vitesse: Int

    abstract fun decolle()
    abstract fun atterir()
    abstract fun vole(distance: Int)

    open fun tempsVol(distance: Int): Double {
        val temps = distance / vitesse
        return temps.toDouble()
    }
}

open class Avion(
    val consommation: Int,
    override val vitesse: Int
) : PeutVoler {

    override fun decolle() {
        println("l'avion décolle")
    }

    override fun atterir() {
        println("l'avion atterit")
    }

    override fun vole(distance: Int) {
        val carburantConsomme = tempsVol(distance) * consommation
        println("L'avion vole sur une distance de $distance km pendant ${tempsVol(distance)} heures.")
        println("Carburant consommé pendant le vol : $carburantConsomme litres.")
    }
}

open class Oiseau(
    override val vitesse: Int
) : PeutVoler {

    override fun decolle() {
        println("Cuicui décolle")
    }

    override fun atterir() {
        println("Cui cui atterit")
    }

    override fun vole(distance: Int) {
        println("L'oiseau vole sur une distance de $distance km pendant ${tempsVol(distance)} heures.")
    }
}

open class Superman(
    override val vitesse: Int
) : PeutVoler {

    override fun decolle() {
        println("Superman le roi des bananes")
    }

    override fun atterir() {
        println("Clark Kent")
    }

    override fun vole(distance: Int) {
        println("Superman vole sur une distance de $distance km pendant ${tempsVol(distance)} heures.")
    }
}

open class Aeroport(val items: List<PeutVoler>) {
    open fun opere() {
        while (true) {
            val item = items.random()
            val distance = Random.nextInt(700, 1001)
            item.decolle()
            Thread.sleep(1000)
            item.vole(distance)
            Thread.sleep(1000)
            item.atterir()
        }
    }
}

fun main() {
    val item = listOf(
        Avion(20, 300),
        Oiseau(50),
        Superman(130)
    )
    val aeroport = Aeroport(item)
    aeroport.opere()
}
