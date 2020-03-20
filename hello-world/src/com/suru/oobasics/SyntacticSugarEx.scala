package com.suru.oobasics

import scala.language.postfixOps

object SyntacticSugarEx extends App {

    class Person(name: String, age: Int, movie: String = "") {
        def +(nickName: String): Person = new Person(name + " (" + nickName + ")", age, movie)

        def unary_+(): Person = new Person(name, age + 1, movie)

        def learns(course: String) = s"$name learns $course"

        def learnsScala = learns("Scala")

        def apply(count: Int): String = s"$name watched $movie $count times"

        override def toString: String = s"Person($name, $age, $movie)"
    }

    val john = new Person("John", 22, "King Kong")
    println(john)
    println(john + "The Ripper")
    println(+john)
    println(john learns "Java")
    println(john learnsScala)


}

/*
    Error:(24, 18) postfix operator learnsScala needs to be enabled
    by making the implicit value scala.language.postfixOps visible.
    ----
    This can be achieved by adding the import clause 'import scala.language.postfixOps'
    or by setting the compiler option -language:postfixOps.
    See the Scaladoc for value scala.language.postfixOps for a discussion
    why the feature needs to be explicitly enabled.
        println(john learnsScala)
*/
