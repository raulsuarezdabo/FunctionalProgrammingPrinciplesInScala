package week11

import java.util.Random

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val f: String => String = {case "ping" => "pong"}
                                                  //> f  : String => String = <function1>
  f("ping")                                       //> res0: String = pong
  //f("abc")
  
  val f2: PartialFunction[String, String] = { case "ping" => "pong" }
                                                  //> f2  : PartialFunction[String,String] = <function1>
  f2.isDefinedAt("abc")                           //> res1: Boolean = false
  f2.isDefinedAt("ping")                          //> res2: Boolean = true
  
  val rand = new Random                           //> rand  : java.util.Random = java.util.Random@340f438e
  rand.nextInt()                                  //> res3: Int = -2007472022

	
}