package collections_examples

import scala.collection.mutable.ArrayBuffer

object Ex2 extends App {
    // groupBy
    val words = ArrayBuffer("reduce", "cute", "tired", "mint", "afternoon", "fix", "connection", "irritate", "guitar",
        "twist", "swing", "lace", "appear", "rainstorm", "pail", "act", "angry", "identify", "legal",
        "watch", "garrulous", "polite", "dirty", "sweater", "exist")

    val groupByFirstLetter = words.groupBy(_.substring(0, 1))
    for (group <- groupByFirstLetter) println(group)
    //    (e,ArrayBuffer(exist))
    //    (s,ArrayBuffer(swing, sweater))
    //    (t,ArrayBuffer(tired, twist))
    //    (f,ArrayBuffer(fix))
    //    (a,ArrayBuffer(afternoon, appear, act, angry))
    //    (m,ArrayBuffer(mint))
    //    (i,ArrayBuffer(irritate, identify))
    //    (p,ArrayBuffer(pail, polite))
    //    (c,ArrayBuffer(cute, connection))
    //    (r,ArrayBuffer(reduce, rainstorm))
    //    (w,ArrayBuffer(watch))
    //    (d,ArrayBuffer(dirty))
    //    (g,ArrayBuffer(guitar, garrulous))
    //    (l,ArrayBuffer(lace, legal))

    val groupBySize = words.groupBy(_.length)
    for (group <- groupBySize) println(group)
    //    (5,ArrayBuffer(tired, twist, swing, angry, legal, watch, dirty, exist))
    //    (10,ArrayBuffer(connection))
    //    (6,ArrayBuffer(reduce, guitar, appear, polite))
    //    (9,ArrayBuffer(afternoon, rainstorm, garrulous))
    //    (7,ArrayBuffer(sweater))
    //    (3,ArrayBuffer(fix, act))
    //    (8,ArrayBuffer(irritate, identify))
    //    (4,ArrayBuffer(cute, mint, lace, pail))

    // Partition
    val city = "New York"
    val cityPartition = city.partition(_.isUpper)
    println(cityPartition) // (NY,ew ork)

    val numbers = ArrayBuffer(1, 2, -9, -7, 65, -93, 72, 94, 298, -902, 100, 23)
    val numbersPartition = numbers.partition(_ > 0)
    println(numbersPartition)
    //    (ArrayBuffer(1, 2, 65, 72, 94, 298, 100, 23),ArrayBuffer(-9, -7, -93, -902))

    def removeAllNegativeButFirst(n: ArrayBuffer[Int]) = {
        val indexesToRemove = (for (i <- n.indices if n(i) < 0) yield i).drop(1)
        n.indices.partition(!indexesToRemove.contains(_))._1.map(n)
    }

    println(removeAllNegativeButFirst(numbers))
    //    Vector(1, 2, -9, 65, 72, 94, 298, 100, 23)

    // alternate to removeAllNegativeButFirst
    def removeAllNegativeButFirst2(n: ArrayBuffer[Int]) = {
        val (l, r) = n.partition(_ < 0)
        r += l(0)
        r
    }

    println(removeAllNegativeButFirst2(numbers))
    //    ArrayBuffer(1, 2, 65, 72, 94, 298, 100, 23, -9)

    // ZIP

    val l1 = Array(7, 12, 9, 5)
    val l2 = Array("<", "=", ">")
    val pairs = l2.zip(l1)
    for (pair <- pairs) println(pair)
    //    (1,<)
    //    (2,=)
    //    (3,>)
    for ((symbol, times) <- pairs) println(symbol * times)
    //    <<<<<<<
    //    ============
    //    >>>>>>>>>
}
