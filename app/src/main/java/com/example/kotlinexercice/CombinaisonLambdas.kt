//Lambdas :
// { it + 2.0 } => (Int) -> Double
// { (it * 2) - 4 } => (Int) -> Int
// { x: Int -> x + 3 } => (Int) -> Double ou (Int) -> Int ou var lambda5
// { println("coucou") } => (Double) -> Unit
// { x: Double -> x + 4 } => var lambda5
//
// Variables :
// var lambda1 : (Double) -> Int
// var lambda2 : (Int) -> Double
// var lambda3: (Int) -> Int
// var lambda4: (Double) -> Unit
// var lambda5
typealias ConversionLtoG = (Double) -> Double

val ltok: ConversionLtoG = { a -> a * 0.453592 }
val ktog: ConversionLtoG = { a -> a * 1000 }

fun combiner(ltok: ConversionLtoG, ktog: ConversionLtoG)
        : ConversionLtoG {

    val comb: ConversionLtoG = { a -> ktog(ltok(a)) }
    return comb
}

fun main(){
   val mix = combiner(ltok, ktog)
    println(mix(2.0))
}