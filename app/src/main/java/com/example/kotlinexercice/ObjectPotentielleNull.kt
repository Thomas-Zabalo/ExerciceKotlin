class Wolf(val type: String, val nombre: Int) {
    fun hurler() {
        println("Ouuuuuuuuuh")
    }
}

val loups = listOf(
    Wolf("loup des neiges", 3),
    null,
    Wolf("loup des forêt", 2)
)

// La variable loup est de type List<Wolf?>

fun main() {
    //   for(loup in loups){
    //       (loup?.hurler()?: println("Pas de cri"))
    //   }

    //  for (loup in loups) {
    //      loup!!.hurler()
    // }

    // loups.forEach { it?.let { println("type du loup: ${it.type} et le nombre est de ${it.nombre}") } }
    // loups.forEach { it?.run { println("type du loup: ${type} et le nombre est de ${nombre}") } }
    loups.filterNotNull()
        .forEach { it.run { println("type du loup: ${type} et le nombre est de ${nombre}") } }
}