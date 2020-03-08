package com.suru

object Functions extends App {
    def aFunction(a: Int, b: Int): Int = {
        // Last expression result is return value of the function
        a + b
    }

    // Single statement functions
    def sum(a: Int, b: Int): Int = a + b

    def PI(): Float = 3.14f

    // No argument functions can be called without ()
    println("PI: " + PI)

    // Try to avoid using Loops
    // Build recursion function

    def repeatStr(s: String, n: Int): String = {
        var i = 0
        var rv = ""
        while (i < n) {
            i += 1
            rv += s
        }
        rv
    }

    println("Repeat 'Hello', 3 times: " + repeatStr("Hello", 3))

    // Recursion way
    def repeatStrRec(s: String, n: Int): String = {
        if (n <= 1) s else s + repeatStrRec(s, n - 1)
    }

    println(repeatStrRec("He", 3))
    // But, there is a problem with recursion you can't use more time it will give
    // java.lang.StackOverflowError for example the below code
    // println(repeatStrRec("He", 30000))

    // Tail Recursion
    def repeatStrTailRec(s: String, n: Int): String = {
        // Scala supports nested function definitions
        // `helper()` scope limited to `repeatStrTailRec()`
        def helper(acc: String, t: Int): String = {
            if (t <= 1) acc
            // to avoid java.lang.StackOverflowError
            // try not to put calculation in stack
            // calculate the value before calling recursion
            // "s + acc" value gets calculated before recursion
            else helper(s + acc, t - 1)
        }

        helper(s, n)
    }

    // This will not give java.lang.StackOverflowError
    println(repeatStrTailRec("He", 30000))

    // Fibonacci recursion
    def fibRec(n: Int): Int = {
        if (n <= 1) n
        else fibRec(n - 1) + fibRec(n - 2)
    }

    // 1 2 3 4 5 6 7  8  9  10
    // 1 1 2 3 5 8 13 21 34 55

    println("fib 10: " + fibRec(10))
    // and this example has the same problem `java.lang.StackOverflowError`
    // Tail Recursion version

    def fibTailRec(n: Int): Int = {
        def helper(a: Int, b: Int, t: Int): Int = {
            if (t <= 2) a + b else helper(b, a + b, t - 1)
        }

        helper(0, 1, n)
    }

    println("fib 10: " + fibTailRec(3000))
}
