package com.suru.oobasics.inheritance

object InheritanceBasics extends App {

    class Animal(name: String) {
        // multiple constructors
        def this() = this(null)

        val animalType = "Wild"

        def eat = println("EAT EAT EAT")

        def print = println(s"$animalType Animal name is $name")
    }

    // extends Animal(name)
    // constructor initialization
    class Dog(name: String, tag: String) extends Animal(name) {
        // override super val or var
        override val animalType: String = "Domestic"


        // override super methods
        override def print: Unit = println(s"Dog name $name with tag $tag")
    }

    // inline override val which is equal to following def
    //    class Cat(name: String, catType: String) extends Animal(name) {
    //        override val animalType: String = catType
    //    }
    class Cat(name: String, override val animalType: String) extends Animal(name)

    val d1 = new Dog("K9", "IX89P37KI")
    d1.eat
    d1.print
    println(d1.animalType)

    val cat1 = new Cat("Lucy", "Domestic Wild")
    cat1.print
    println(cat1.animalType)

    class Crocodile(name: String) extends Animal(name) {
        override val animalType: String = "Reptile"

        override def eat: Unit = println("GRRR! GRRR! GRRRR!")

    }

    val cr1 = new Crocodile("Killer Wind")
    cr1.print
    cr1.eat


}
