package collections_examples

object MapsExamples extends App {
    val map1 = Map("John" -> 22, "Kyle" -> 34, "Jenna" -> 8)
    println(map1) // Map(John -> 22, Kyle -> 34, Jenna -> 8)
    println(map1("Jenna")) // 8

    // println(map1("king")) // java.util.NoSuchElementException

    // immutable need to capture in different variable
    val map2 = map1 + ("king" -> 30)
    println(map2) // Map(John -> 22, Kyle -> 34, Jenna -> 8, king -> 30)

    // map2("Jackson") = 90 not possible in immutable Map

    val mMap1 = scala.collection.mutable.Map("Casey" -> 8, "Walls" -> 9)
    println(mMap1) // HashMap(Casey -> 8, Walls -> 9)
    mMap1("Collin") = 9
    println(mMap1) // HashMap(Collin -> 9, Casey -> 8, Walls -> 9)
    mMap1 -= "Walls"
    println(mMap1) // HashMap(Collin -> 9, Casey -> 8)
    mMap1 += "John" -> 6
    println(mMap1) // HashMap(John -> 6, Collin -> 9, Casey -> 8)

    for ((k, v) <- mMap1) println(k, v)
    //    (John,6)
    //    (Collin,9)
    //    (Casey,8)
    for ((k, v) <- mMap1 if v > 7) println(k, v)
    //    (Collin,9)
    //    (Casey,8)


}
