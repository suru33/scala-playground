package com.suru

object StringOps extends App {
    val pathString = "/Library/Java/JavaVirtualMachines/jdk-11.0.6.jdk/Contents/Home/bin/java"
    println(pathString)

    println(pathString.charAt(20))
    println(pathString.substring(9, 15))
    println(pathString.split("/").toList)
    println(pathString.replace('/', '-'))
    println(pathString.toUpperCase)
    println(pathString.length)

    val numberString = "3978"
    val number: Int = numberString.toInt

    println(number + 32478)

    println(numberString :+ 'a')

}
