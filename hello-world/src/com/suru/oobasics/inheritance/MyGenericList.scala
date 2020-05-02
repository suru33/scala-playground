package com.suru.oobasics.inheritance

/*

Variance Problem:
----------------------------------
If B extends A, should List[B] extends List[A]
1. Yes (covariant)          trait List[+A]  All sub classes can be used
2. No (Invariant)           trait List[A]   Strict types usage
3. No No (Contravariant)    trait List[-A]  All super classes can be used

Bounded Types:
----------------------------------
class Shape
class Circle extends Shape
class Triangle extends Shape

class Test[T <: Shape]  -   `T` must be Shape or sub type of Shape (Shape, Circle, Triangle)
class Test[T >: Circle] -   `T` must be Circle or super type of Circle (Circle, Shape) No for Triangle

 */

abstract class MyGenericList[+A] {
    def head: A

    def tail: MyGenericList[A]

    def add[B >: A](element: B): MyGenericList[B]

    def print: String

    def isEmpty: Boolean

    override def toString: String = "[" + print + "]"
}

object MyGenericEmptyList extends MyGenericList[Nothing] {
    override def head: Nothing = ???

    override def tail: MyGenericList[Nothing] = ???

    override def add[A >: Nothing](element: A) = new MyGenericListImpl[A](element, this)

    override def isEmpty: Boolean = true

    override def print: String = ""
}

class MyGenericListImpl[A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {
    override def head: A = h

    override def tail: MyGenericList[A] = t

    override def add[B >: A](element: B): MyGenericList[B] = new MyGenericListImpl[B](element, this)

    override def isEmpty: Boolean = false

    override def print: String = if (t.isEmpty) h + "" else h + " " + t.print
}

object TestMyGenericList extends App {
    val intList = new MyGenericListImpl[Int](10, MyGenericEmptyList)
    val anotherIntList = intList.add(100).add(38).add(92).add(25)
    println(intList)
    println(anotherIntList)
}