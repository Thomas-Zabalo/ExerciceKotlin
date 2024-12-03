package com.example.kotlinexercice.recap

import kotlin.random.Random


val monchiffre: Int = 3
val machaine: String = "coucou"
val chiffredeux: String = "2"
val somme = monchiffre + chiffredeux.toInt()
val mondouble: Double = 2.5
val somme2 = monchiffre + mondouble

val caracteristiques: Map<String, Int> = mapOf(
    "force" to 5,
    "dextérité" to 2,
    "intelligence" to 7,
    "sagesse" to 9,
    "constitution" to 12,
    "charisme" to 8
)


fun main() {
    println(machaine)
    println(monchiffre)
    println(somme)
    println(somme2)

    println(estPair(4))
    println(estComprisEntre(4))
    println("Ma force est égale à ${caracteristiques["force"]}")

    val valeurCarac = genererCarac() // Appel de la fonction
    println("Valeur générée pour la caractéristique : $valeurCarac")
}

fun estPair(x: Int): Boolean {
    return x % 2 == 0
}

fun estComprisEntre(x: Int, inf: Int = 0, sup: Int = 10): Boolean {
    return x in inf..sup
}

fun genererCarac(): Int {
    var res: Int = 0
    for (x in 1..3) {
        val de = Random.nextInt(1, 7)
        res += de
    }
    return res
}

fun genererCaracteristiques(): MutableMap<String, Int> {
    for (x in 1..6){

    }
}