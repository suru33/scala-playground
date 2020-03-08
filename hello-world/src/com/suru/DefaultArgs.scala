package com.suru

object DefaultArgs extends App {

    def repStr(s: String, n: Int): String = {
        def helper(acc: String, t: Int): String =
            if (t <= 1) acc else helper(s + acc, t - 1)

        helper(s, n)
    }

    println(repStr("Hello", 3))
    // acc doesn't need a initial value

    def repStrDef(s: String, n: Int, acc: String = ""): String = {
        if (n < 1) acc else repStrDef(s, n - 1, s + acc)
    }

    println(repStrDef("Hello10", 10))
}