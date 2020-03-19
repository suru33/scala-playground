package com.suru.oobasics

object SyntacticSugar extends App {

    class Person(val name: String, place: String, movie: String = null) {
        // Infix
        def likesTheMovie(movie: String): Boolean = movie == this.movie

        def livesIn(place: String) = place == this.place

        // Prefix
        val x = -1
        val y = !true

        def unary_- = s"Negative $name"
    }

    val john = new Person("John", "Tallinn", "Terminator")
    // Infix
    // method name acts like "OPERATOR"
    // possible with one param methods
    println(john.likesTheMovie("Terminator"))
    println(john likesTheMovie "Sky Walker")
    println(john.livesIn("Florida"))
    println(john livesIn "Florida")

    // ALL OPERATORS ARE METHODS
    println(4 + 8)
    println(4.+(8))
    println(4.*(2))
    println(4 + 8)
    var a = 10
    a += 9
    a.+=(9)
    println(a)

    // Prefix

    println(john.name)
    println(-john)

}
