package com.suru.oobasics.some_others

/*

case class and case object
1. Companion class already implemented we can use apply() out of the box **
2. toString, equals, hashCode methods already implemented
3. Constructor params are promoted to class fields
4. Cloning already implemented via copy() methods with params
5. Already serialized
6. Already have extractor patterns can be used in PATTERN MATCHING

** For case object don't have companion class. It self it is a companion class
   everything else is same as case class

 */

object CaseClassTest extends App {

    case class Person(name: String, age: Int)

    // val john = new Person("John", 21)
    // Companion class already has apply() method so, we can use ClassName(params)
    val john = Person("John", 21)
    println(john) // Person(John,21)

    val bob = john.copy("Bob")
    println(bob) // Person(Bob,21) "age copied from john"

    val bob2 = bob.copy()
    println(bob == bob2) //true "equals() method already implemented"
}
