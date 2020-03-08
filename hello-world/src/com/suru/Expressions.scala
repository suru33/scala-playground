package com.suru

object Expressions extends App {
    val aStr = "Hello"
    println(aStr)
    // Code Block
    val exp = {
        val a = 10
        (a + 100) / 9.76
        // Last expression result is return value
    }

    println("exp result: " + exp)

    // IF Expression
    val a = 23
    val b = 97
    // IF returns a value if there is no value the return value is Unit
    val big = if (a > b) a else b

    println("a: " + a)
    println("b: " + b)
    println("big of a, b: " + big)

    val f1 = "Pineapple"
    val f2 = "Orange"

    val res = if (f1.contains("apple")) {
        f1.substring(0, "apple".length - 1)
    } else {
        f2 + "Apples"
    }
    println("result from IF: " + res)

}
