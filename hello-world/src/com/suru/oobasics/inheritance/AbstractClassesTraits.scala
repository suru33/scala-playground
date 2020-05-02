package com.suru.oobasics.inheritance

object AbstractClassesTraits extends App {

    abstract class AbC {
        val intVal: Int = 0

        def inc: AbC

        def printIntVal(): Unit = println(intVal)
    }

    class AbC1(override val intVal: Int) extends AbC {
        override def inc: AbC = new AbC1(intVal + 1)
    }

    val abC1: AbC1 = new AbC1(100)
    val abC1_5 = abC1.inc.inc.inc.inc.inc

    abC1_5.printIntVal()


}
