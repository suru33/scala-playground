package com.suru.oobasics.some_others

object Exceptions extends App {

    class MathException(msg: String) extends RuntimeException(msg)

    object Calc {
        def div(a: Int, b: Int) = {
            if (b == 0) throw new MathException("Divide by 0")
            a / b.toDouble
        }
    }



}
