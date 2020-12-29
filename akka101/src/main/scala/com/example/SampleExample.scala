package com.example

import akka.actor.{Actor, ActorSystem, Props}

object SampleExample extends App {

    class SampleActor extends Actor {
        override def receive: Receive = {
            case s: String => println("String: " + s)
            case i: Int => println("Int: " + i)
            case c: Char => println("Char:" + c)
            case _ => println("Unknown message")
        }
    }

    val system = ActorSystem("SimpleExample")
    val actor = system.actorOf(Props[SampleActor], "SampleActor")

    actor ! "Hello"
    actor ! 12
    actor ! 'X'
    actor ! -9.2423

    Thread.sleep(1000)
    system.terminate
}
