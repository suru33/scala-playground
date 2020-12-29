package random

import scala.util.{Random, Try}

object OptionsTest extends App {

    def someMethod(i: Int): Option[String] = {
        Some(Random.nextInt(100) * i + "")
        //        if (Random.nextBoolean()) Some(Random.nextInt() * i + "")
        //        else None
    }

    val cc = (x: String) => Some(x.toInt / 2)

    println(someMethod(10).flatMap(cc).)

}
