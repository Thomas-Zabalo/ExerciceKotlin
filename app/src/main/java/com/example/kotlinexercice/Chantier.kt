import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period

//Exercice Le chantier

abstract class Salarie() {
    abstract val nom: String
    abstract val prenom: String

    abstract fun getSalaire(): Int
    abstract fun afficher()
}

open class Ouvrier(
    override val nom: String,
    override val prenom: String,
    val dateEntree: LocalDate
) : Salarie() {

    val SMIG = 2500

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getSalaire(): Int {

        val maintenant = LocalDate.now()
        val anciennete = Period.between(dateEntree, maintenant)

        var salaire = SMIG + (anciennete.years * 100)

        if (salaire > SMIG * 2) {
            salaire = SMIG * 2
            return salaire
        }
        return salaire
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun afficher() {
        println("Ouvrier: $prenom $nom, Salaire: ${getSalaire()} euros")
    }
}

open class Contremaitre(
    override val nom: String,
    override val prenom: String,
    val indice: Int
) : Salarie() {

    override fun getSalaire(): Int {

        if (indice == 1) {
            return 13000
        } else if (indice == 2) {
            return 15000
        } else if (indice == 3) {
            return 17000
        } else if (indice == 4) {
            return 20000
        }
        return 0
    }

    override fun afficher() {
        println("Contremaitre: $prenom $nom, Salaire: ${getSalaire()} euros")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val ouvrier1 = Ouvrier("Jean", "Clement", LocalDate.of(2015, 6, 16)).afficher()
    val ouvrier2 = Ouvrier("Bernard", "Dupond", LocalDate.of(1980, 1, 25)).afficher()
    val contremaitre1 = Contremaitre("Titan", "Dupond", 1).afficher()
    val contremaitre2 = Contremaitre("Pecatte", "Jean-Marie", 2).afficher()
}