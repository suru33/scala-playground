package com.example

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object CountDown extends App {

    case class Count(n: Int)

    case class StartCounting(n: Int, partner: ActorRef)

    class CountDownActor extends Actor {
        override def receive: Receive = {
            case StartCounting(n, partner) => partner ! Count(n)
            case Count(n) =>
                if (n < 0) context.system.terminate
                else {
                    Thread.sleep(1000)
                    println(n)
                    sender ! Count(n - 1)
                }
        }
    }

    val system = ActorSystem("CountDown")
    val actor1 = system.actorOf(Props[CountDownActor], "CountDownsActor-1")
    val actor2 = system.actorOf(Props[CountDownActor], "CountDownsActor-2")

    actor1 ! StartCounting(10, actor2)

}
