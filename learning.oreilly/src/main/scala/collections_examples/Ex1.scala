package collections_examples

import scala.collection.mutable.ArrayBuffer

object Ex1 extends App {
    // remove -ve numbers from an array buffer except 1st -ve number
    val numbers = ArrayBuffer(1, 8, 2, -9, 73, -3, 7, -92, 10, -839, -11, 832, 100)

    def removeAllNegativeButFirst(n: ArrayBuffer[Int]) = {
        val indexes = for (i <- n.indices if n(i) < 0) yield i
        // we don't want to remove first -ve num
        // drop() drops the number of elements from left
        val finalIndexesToRemove = indexes.drop(1)

        // reverse because the ArrayBuffer will change if you start removing from left
        for (i <- finalIndexesToRemove.reverse) n.remove(i)

        // another solution immutable one and preferred
        // for (i <- n.indices if !finalIndexesToRemove.contains(i)) yield n(i)
    }

    removeAllNegativeButFirst(numbers)
    println(numbers)
}
