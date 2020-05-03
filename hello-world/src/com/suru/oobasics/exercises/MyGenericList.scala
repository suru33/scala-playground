package com.suru.oobasics.exercises

/*

Variance Problem:
----------------------------------
If B extends A, should List[B] extends List[A]
1. Yes (Covariant)          trait List[+A]  All sub classes can be used
2. No (Invariant)           trait List[A]   Strict types usage
3. No No (Contravariant)    trait List[-A]  All super classes can be used

Bounded Types:
----------------------------------
class Shape
class Circle extends Shape
class Triangle extends Shape

Shape -> Circle
Shape -> Triangle

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

    def filter(predicate: MyPredicate[A]): MyGenericList[A]

    def map[B](transformer: MyTransformer[A, B]): MyGenericList[B]

    def ++[B >: A](list: MyGenericList[B]): MyGenericList[B]

    def flatMap[B >: A](transformer: MyTransformer[A, MyGenericList[B]]): MyGenericList[B]
}

object MyGenericEmptyList extends MyGenericList[Nothing] {
    override def head: Nothing = ???

    override def tail: MyGenericList[Nothing] = ???

    override def add[A >: Nothing](element: A) = new MyGenericListImpl[A](element, this)

    override def isEmpty: Boolean = true

    override def print: String = ""

    override def filter(predicate: MyPredicate[Nothing]): MyGenericList[Nothing] = this

    override def map[B](transformer: MyTransformer[Nothing, B]): MyGenericList[B] = this

    override def ++[B >: Nothing](list: MyGenericList[B]): MyGenericList[B] = list

    override def flatMap[B >: Nothing](transformer: MyTransformer[Nothing, MyGenericList[B]]): MyGenericList[B] = this
}

class MyGenericListImpl[A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {
    override def head: A = h

    override def tail: MyGenericList[A] = t

    override def add[B >: A](element: B): MyGenericList[B] = new MyGenericListImpl[B](element, this)

    override def isEmpty: Boolean = false

    override def print: String = if (t.isEmpty) h + "" else h + " " + t.print

    override def filter(predicate: MyPredicate[A]): MyGenericList[A] = {
        if (predicate.test(head)) new MyGenericListImpl(head, tail.filter(predicate))
        else tail.filter(predicate)
    }

    override def map[B](transformer: MyTransformer[A, B]): MyGenericList[B] = {
        new MyGenericListImpl(transformer.transform(head), tail.map(transformer))
    }

    override def ++[B >: A](list: MyGenericList[B]): MyGenericList[B] = new MyGenericListImpl(head, tail ++ list)

    override def flatMap[B >: A](transformer: MyTransformer[A, MyGenericList[B]]): MyGenericList[B] =
        transformer.transform(head) ++ tail.flatMap(transformer)
}

object TestMyGenericList extends App {
    val intList = new MyGenericListImpl[Int](10, MyGenericEmptyList)
    val anotherIntList = intList.add(3).add(32).add(92).add(25)
    val superList = new MyGenericListImpl[Int](10, MyGenericEmptyList).add(20)

    println(intList)
    println(anotherIntList)
    println(superList)

    val evenPredicate: MyPredicate[Int] = (t: Int) => t % 2 == 0
    val filteredList = anotherIntList.filter(evenPredicate)
    println(filteredList)

    val squareTransformer: MyTransformer[Int, Int] = (a: Int) => a * a
    val square = anotherIntList.map(squareTransformer)
    println(square)

    val cList = intList ++ anotherIntList ++ filteredList
    println(cList)

    val superTransformer: MyTransformer[Int, MyGenericList[Int]] =
        (a: Int) => new MyGenericListImpl[Int](a, new MyGenericListImpl(a + 1, MyGenericEmptyList))
    val flatMapList = superList.flatMap(superTransformer)
    println(flatMapList)

}