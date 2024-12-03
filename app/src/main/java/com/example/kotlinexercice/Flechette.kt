import kotlin.random.Random

class Point(val x: Double, val y: Double) {
    private val point: Int = 0
}

class Dart {
    private var totalScore: Int = 0

    fun calcPoint(p: Point): Int {

        if (p.x >= -1 && p.x <= 1 && p.y >= -1 && p.y <= 1) {
            return 10
        }
        if (p.x >= -5 && p.x <= 5 && p.y >= -5 && p.y <= 5) {
            return 5
        }
        if (p.x >= -10 && p.x <= 10 && p.y >= -10 && p.y <= 10) {
            return 1
        }
        return 0
    }

    fun lancer(p: Point) {
        val points = calcPoint(p)
        println("Lancé à la position (${p.x}, ${p.y}) -> Points gagnés: $points")
        totalScore += points
    }

    fun affScore() {
        println("Score total: $totalScore points")
    }
}

fun main() {
    val dartGame = Dart()


    for (lance in 0..4) {
        val x = Random.nextDouble(-15.0, 15.0)
        val y = Random.nextDouble(-15.0, 15.0)
        val point = Point(x, y)
        dartGame.lancer(point)
    }

    dartGame.affScore()
}
