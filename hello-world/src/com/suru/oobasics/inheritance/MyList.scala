package com.suru.oobasics.inheritance

abstract class MyList {
    def head: Int

    def tail: MyList

    def isEmpty: Boolean

    def add(int: Int): MyList

    def print(): String

    override def toString: String = "[" + print + "]"
}

object MyEmptyList extends MyList {
    override def head: Int = ???

    override def tail: MyList = ???

    override def isEmpty: Boolean = true

    override def print(): String = ""

    override def add(int: Int): MyList = new MyListImpl(int, this)
}

class MyListImpl(val h: Int, val t: MyList) extends MyList {

    override def head: Int = h

    override def tail: MyList = t

    override def isEmpty: Boolean = false

    override def print(): String = if (tail.isEmpty) "" + h else h + " " + t.print()

    override def add(int: Int): MyList = new MyListImpl(int, this)

}

object TestMyList extends App {
    val l1 = new MyListImpl(10, MyEmptyList)
    val l2 = new MyListImpl(20, l1).add(30).add(40).add(50)

    println(l2)
}