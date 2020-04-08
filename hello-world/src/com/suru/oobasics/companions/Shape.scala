package com.suru.oobasics.companions

object Shape {
    def triangle = new Shape("Triangle")

    def square = new Shape("Square", 4)
}

class Shape(val name: String, val sides: Int = 3) {

}