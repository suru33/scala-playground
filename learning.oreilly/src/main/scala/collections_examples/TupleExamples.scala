package collections_examples

object TupleExamples extends App {
    val t = (1, "John", 23)
    println(t) // (1,John,23)
    println(t.getClass) // class scala.Tuple3
    println(t._1) // 1
    println(t._2) // John
    println(t._3) // 23
    val (sno, name, age) = t
    println(sno) // 1
    println(name) // John
    println(age) // 23
}
