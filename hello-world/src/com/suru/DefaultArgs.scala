package com.suru

object DefaultArgs extends App {
    def repStr(s: String, acc: String, n: Int): String = {
        if (n < 1) acc else repStr(s, s + acc, n - 1)
    }

    println(repStr("Hello", "", 3))
    // acc doesn't need a initial value

    def repStrDef(s: String, n: Int, acc: String = ""): String = {
        if (n < 1) acc else repStrDef(s, n - 1, s + acc)
    }

    println(repStrDef("Hello10", 10))
}