import io.StdIn._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureTest extends App {
  
  //with Parallel threads
  for(i <- (10 to 50).par)  { 
   // println(i*4   )  
  }
  
  //without Parallel threads
  for(i <- (10 to 50))  { 
   // println(i*5  )  
  }
  
  
  //Future example
  var fut1= Future {
    for(i <- (10 to 50).par)  yield i*4    
  }
  
  fut1.foreach(println)
  
  
  //Future object methods example
    var fut2= Future {
    for(i <- (1 to 50000).par)  yield i*4    
  }
    var fut3= Future {
    for(i <- (20 to 50).par)  yield i*5   
  }
  
  val finalFut= Future.firstCompletedOf(List(fut2,fut3))
  //finalFut.foreach(println)
  
    
  Thread.sleep(5000)
  

}