class Artiste(val nom: String)
class Titre(val nom: String, val artiste: Artiste)

class LecteurAudio(_titre: List<Titre>) {

    private var currentIndex: Int = 0
    private var isPlaying: Boolean = false
    private var isPause: Boolean = false

    //correction
    val titres: MutableList<Titre> = _titre.toMutableList()


    fun play() {
        isPlaying = true
        isPause = false
    }

    fun pause() {
        if (isPlaying) {
            isPlaying = false
            isPause = true
        }
    }


    fun stop() {
        isPlaying = false
        isPause = false
    }

    fun next() {
        isPlaying = true
        isPause = false
        if (currentIndex < titres.size - 1) {
            currentIndex++
        } else {
            currentIndex = 0
        }
    }

    fun state() {
        if (isPlaying) {
            println("le lecteur joue le titre ${titres[currentIndex].nom}")
        } else if (isPause) {
            println("le lecteur est en pause sur le titre ${titres[currentIndex].nom}")
        } else {
            println("Le lecteur ne joue aucun titre")
        }
    }

    fun playlist() {
        println("Titre dans la playlist :")
        for (titre in titres) {
            println("- ${titre.nom} par ${titre.artiste.nom}")
        }
    }

    fun add(titre: Titre) {
        titres.add(titre)
    }
}

fun main() {
    val bashung = Artiste("Alain Bashung")
    println("Le nom de l'artiste est ${bashung.nom}")

    val titre1 = Titre("La nuit comme je mens", Artiste("Bashung"))
    val titre2 = Titre("Vertige de l'amour", Artiste("Bashung"))
    val titre3 = Titre("Dogs out", Artiste("Baha Men"))

    val lecteur = LecteurAudio(listOf(titre1, titre2))

    lecteur.state()
    lecteur.play()
    lecteur.state()
    lecteur.pause()
    lecteur.state()
    lecteur.next()
    lecteur.state()
    lecteur.pause()
    lecteur.state()
    lecteur.next()
    lecteur.state()
    lecteur.stop()
    lecteur.state()
    lecteur.add(titre3)
    println(lecteur.playlist())
}