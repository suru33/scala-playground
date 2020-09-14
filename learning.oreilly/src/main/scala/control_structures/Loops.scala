package control_structures

object Loops extends App {
    val myRange = 1 to 5 // or 1.to(5) also generator
    println(myRange) // Range 1 to 5
    println(myRange.getClass) // class scala.collection.immutable.Range$Inclusive
    println(myRange(1)) // 2 -> use () to access indexed value not []

    val result = for (i <- myRange) println(i)
    println(result) // ()

    val result_y = for (i <- myRange) yield i // like python yield
    println(result_y) // Vector(1, 2, 3, 4, 5)
    println(result_y.getClass) // class scala.collection.immutable.Vector


    // if called as guard statement
    val result_even = for (i <- myRange if i % 2 == 0) yield i
    println(result_even) // Vector(2, 4)

    // multiple generators
    for (i <- 1 to 3; j <- 3 to 5) print(s"($i, $j) ")
    // (1, 3) (1, 4) (1, 5) (2, 3) (2, 4) (2, 5) (3, 3) (3, 4) (3, 5)
    // loops through all i, j combinations
    println()
    for (i <- 1 to 3; j <- 3 to 5 if i + j > 5) print(s"($i, $j) ")
    // (1, 5) (2, 4) (2, 5) (3, 3) (3, 4) (3, 5)
}
