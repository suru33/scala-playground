object Collections extends App {
    // until function
    for (i <- 0 until 5) println(i) // 0 1 2 3 4
    // 0 to 5 -> 0, 1, 2, 3, 4, 5
    // 0 until 5 -> 0, 1, 2, 3, 4 ** mostly used to traverse arrays

    val nums = new Array[Int](10) // init the array of size 10 and it is immutable
    // generics in scala use [] to access elements use ()
    nums(3) = 89
    println(nums(3)) // 89

    val strings = Array("Hello", "Scala", "!")
    // array of strings with length 3
    println(strings.length)
    println(strings(1))
    for (s <- strings) println(s)
    for (i <- 0 until strings.size) println(i, strings(i))
    for (i <- strings.indices) println(i, strings(i)) // same as "0 until strings.size"

    val x = Array((1, 'a'), (2, 'b'), (3, 'c'))
    for ((ix, ch) <- x) println(ix, ch)

}
