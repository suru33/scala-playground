package com.suru.oobasics

object OOBasics extends App {
    println("Hello, OO!")

    val author = new Writer("Jon", "Red", 1992)
    println(author)
    val novel = new Novel("Expected People", 2012, author)
    println(novel)

    println(novel.isWrittenBy(author))
    println(novel isWrittenBy author)

    // ICounter Usage
    // we have default value = 0 in constructor
    val counter = new ICounter
    counter.inc.print
    counter.inc.inc.inc.inc.print
    counter.inc(10).inc(2).dec.dec(23).print

}

// class definition with constructor
// constructor params are not variables in side class they are default to vals and you can't use with object
// firstName: val and private
// lastName: val and private
// age: val and public like `this.age = age` Java Style
class Writer(firstName: String, lastName: String, val dobYear: Int) {
    // constructor overloading
    // should call another constructor
    // makes no practical use we can implement default args for constructor like Python
    def this(firstName: String, lastName: String) = this(firstName, lastName, 0)

    // method definition
    def fullName: String = firstName + " " + lastName


    override def toString = s"Writer($fullName, $dobYear)"
}


class Novel(name: String, yearOfRelease: Int, author: Writer) {
    def authorAge: Int = yearOfRelease - author.dobYear

    def isWrittenBy(author: Writer): Boolean = author == this.author

    def copy(yearOfRelease: Int) = new Novel(name, yearOfRelease, author)


    override def toString = s"Novel($name, $yearOfRelease, $author)"
}

// the general implementation
// private var -> private access and can be modified
class Counter(private var counterValue: Int) {
    def current: Int = counterValue

    def increment: Int = {
        counterValue += 1
        counterValue
    }

    def decrement: Int = {
        counterValue -= 1
        counterValue
    }

    def increment(increment: Int): Int = {
        counterValue += increment
        counterValue
    }

    def decrement(decrement: Int): Int = {
        counterValue -= decrement
        counterValue
    }
}

// Immutability implementation
// never change the object value and always return new object
// implementation like primitive types Int
class ICounter(val count: Int = 0) {
    def inc = new ICounter(count + 1)

    def dec = new ICounter(count - 1)

    // recursively calling inc for n times
    def inc(n: Int): ICounter = {
        if (n <= 0) this
        else inc.inc(n - 1)
    }

    // recursively calling dec for n times
    def dec(n: Int): ICounter = {
        if (n <= 0) this
        else dec.dec(n - 1)
    }

    // side effect method
    def print: Unit = println(count)
}