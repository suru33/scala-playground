package control_structures


object If extends App {
    val n1 = 100
    // if is an expression in scala it returns a value
    val isEven = if (n1 % 2 == 0) true else false
    // isEven type is boolean
    println(isEven)

    val some_any = if (n1 > 100) "something" else -2
    // some_any type is Any

    val some_unit = if (n1 > 100) "something"
    // some_any type is Any and else value is () -> "Unit" it's like Void in java but its a value

    // blocks
    val (x1, y1) = (7, 9) //its tuple
    val distance = {
        val (x2, y2) = (15, 20) //block scoped variables
        val (dx, dy) = (x2 - x1, y2 - y1)
        import math.sqrt //scoped import, import math._ to import all functions from math
        sqrt((dx * dx) + (dy * dy)) // last expression is return value
    }
    println(distance)
}
