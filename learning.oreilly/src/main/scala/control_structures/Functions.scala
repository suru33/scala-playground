package control_structures

object Functions extends App {
    def abs(v: Double) = if (v >= 0) v else -v

    // return type is "Double" and it is inferred
    //    def abs(v: Double): Double = {
    //        if (v >= 0) v else -v
    //    }
    // no need of = {} for single liners

    def fact(n: Int) = { // return type Int is inferred
        // var is for mutable variable
        var rv = 1
        for (i <- 2 to n) rv *= i // changing rv in every iteration
        rv // last statement is return value
    }

    println(fact(10)) // 3628800

    def fact_rec(n: Int): Int = { // recursion should always have return type in signature
        if (n == 1) n else n * fact_rec(n - 1)
    }

    println(fact_rec(10)) // 3628800

    // named params and default param values

    def decorate(s: String, left: String = "<", right: String = ">") = left + s + right

    println(decorate("Hello Scala")) // <Hello Scala>
    println(decorate("Hello Scala", "[")) // [Hello Scala>
    println(decorate("Hello Scala", "[", "]")) // [Hello Scala]
    println(decorate("Hello Scala", right = "]")) // <Hello Scala]
    println(decorate("Hello Scala", left = "---[[", right = "]]--")) // --[[Hello Scala]]--

    // variable arguments (var args)
    def sum(values: Int*) = {
        println(values.getClass) // class scala.collection.immutable.ArraySeq$ofInt
        var rv = 0
        for (i <- values) rv += i
        rv
    }

    println(sum(1, 2, 3, 4, 5)) // 15

    // sum(1 to 10) --- compile error
    // you can't just pass a Seq to sum function it compile errors for type safety
    println(sum(1 to 5: _*)) // 15 "1 to 5: _*" -> _* is type casting or unpacking the variables

    def sum_rec(values: Int*): Int = {
        if (values.isEmpty) 0 else values.head + sum_rec(values.tail: _*) // unpacking Seq
    }

    println(sum_rec(1, 2, 3, 4, 5)) // 15


    def isVowel(ch: Char) = if ("aeiou".contains(ch)) true else false

    def vowels(s: String) = for (ch <- s if isVowel(ch)) yield ch

    println(vowels("collection")) // oeio

    // final vowels implementation

    def isVowelFinal(ch: Char, vowels: String, ignoreCase: Boolean): Boolean = {
        if (ignoreCase) isVowelFinal(ch.toLower, vowels, false)
        else if (vowels.contains(ch)) true else false
    }

    def vowelsFinal(s: String, vowels: String = "aeiou", ignoreCase: Boolean = true) =
        for (ch <- s if isVowelFinal(ch, vowels, ignoreCase)) yield ch

    println(vowelsFinal("ArraySeq$ofInt")) // AaeoI
    println(vowelsFinal("Scälā Cóllectiön ÖÄ", vowels = "aeiouöäó")) // äóeiöÖÄ
    println(vowelsFinal("Scälā Cóllectiön ÖÄ", vowels = "aeiouöäó", ignoreCase = false)) // äóeiö
}
