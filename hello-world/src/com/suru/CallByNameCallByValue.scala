package com.suru

object CallByNameCallByValue extends App {
    def callByValue(time: Long) = {
        println("ByValue 1 Time is: " + time)
        println("ByValue 2 Time is: " + time)
    }

    def callByName(time: => Long) = {
        println("ByName 1 Time is: " + time)
        println("ByName 2 Time is: " + time)
    }

    callByValue(System.nanoTime())
    callByName(System.nanoTime())

    /*
        def callByValue(time: Long) = {}
        This is a simple function

        ByValue 1 Time is: 6111110932876
        ByValue 2 Time is: 6111110932876


        def callByName(time: => Long) = {}
        Two different values for same variable in same function
        The param with operator `=>` gets evaluated every time when it called

        ByName 1 Time is: 6111220651058
        ByName 2 Time is: 6111220718447
    */
}
