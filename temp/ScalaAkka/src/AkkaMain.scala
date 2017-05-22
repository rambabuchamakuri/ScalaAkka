import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class HelloActor extends Actor {
  def receive = {
    case s:String => println(s)
    case t:Int      => println(t)
  }
}

object AkkaMain extends App {
  val system = ActorSystem("HelloSystem")
  // default Actor constructor
  val helloActor = system.actorOf(Props[HelloActor], name = "helloa")
  helloActor ! "hello"
  helloActor ! "buenos dias"
  helloActor ! 10
}