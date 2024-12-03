package com.example.kotlinexercice

import kotlin.random.Random

val monchiffre: Int = 3
val machaine: String = "coucou"
val chiffredeux: String = "2"
val mondouble: Double = 2.5
var somme = monchiffre + chiffredeux.toInt()
var somme2 = monchiffre + mondouble
val x = 7

val character = mapOf(
    "Force" to 5,
    "Dexterite" to 12,
    "Intelligence" to 12,
    "Sagesse" to 3,
    "Constitution" to 8,
    "Charisme" to 13
)
val cles = character.keys
val valeurs = character.values

fun genererCarac(): Int {
    var res: Int = 0
    val table = mutableListOf<Int>()

    for (x in 0..3) {
        val de = Random.nextInt(1, 7)
        table.add(de)
    }
    table.remove(table.min())
    res = table.sum()
    return res
}

fun genererCaracteristiques(): MutableMap<String, Int> {
    val mapCarac = mutableMapOf<String, Int>()

    for (carac in character.keys) {
        val valeur = genererCarac()
        mapCarac[carac] = valeur
    }
    return mapCarac
}

val phrase: String = "As soon as Possible"
val mots = phrase.split(" ")
var structure =""

fun word(){
    for (w in mots){
        if (w.isNotEmpty()) {
            val lettre = w[0].uppercaseChar()
            structure += lettre
        }
    }
    println(structure)
}

fun main() {
    println("Mon premier message en Kotlin")
    println(monchiffre)
    println(machaine)
    println(somme)
    println(somme2)
    fun estPair(x: Int) =
        x % 2 == 0
    println(estPair(x))
    fun estCompriseEntre(x: Int, inf: Int = 0, sup: Int = 10) =
        x in inf..sup
    println(estCompriseEntre(x))
    println(character)
    println(cles)
    println(valeurs)
    println("Ma force est égale à ${character["Force"]}")
    println(genererCarac())
    println(genererCaracteristiques())
    println(word())
}




