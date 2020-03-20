package com.suru.oobasics

object ScalaObjects extends App {

    object Person {
        // equivalent to `public static final` variable
        // scala doesn't support static
        // all static things should be done in object definition
        val DOC = "Yes"

        // factory methods
        def youngPerson(name: String): Person = new Person(name, 10)

        def oldPerson(name: String): Person = new Person(name, 40)
    }

    class Person(name: String, age: Int) {
        def + : Person = new Person(name, age + 1)

        def +(nickname: String) = new Person(s"$name ($nickname)", age)

        def print = println(s"$name, $age")
    }

    // Both Person class and object are defined in same scope
    // This is called companion
    // all static and factory code goes to object def
    // Scala 'object' are singleton objects

    println(Person.DOC)

    val phil = Person.youngPerson("Phil")
    phil.print

}
