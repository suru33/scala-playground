package com.suru.oobasics.inheritance

abstract class MyGenericList[A] {
    def head: A

    def tail: MyGenericList[A]

    def add[B >: A](element: B): MyGenericList[B]

    def print: String

    override def toString: String = "[" + print + "]"
}

object MyGenericEmptyList extends MyGenericList {
    override def head: Nothing = ???

    override def tail: MyGenericList[Nothing] = ???

    override def add[B >: Nothing](element: B): MyGenericList[B] = new

    override def print: String = ???
}
