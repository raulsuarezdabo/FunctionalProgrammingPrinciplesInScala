package week12

object test {
	val problem = new Pouring(Vector(4, 9))   //> problem  : week12.Pouring = week12.Pouring@327471b5
	problem.moves                             //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek12.test.problem.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), Pour(0
                                                  //| ,1), Pour(1,0))
	
	problem.pathSets.take(3).toList           //> res1: List[Set[week12.test.problem.Path]] = List(Set(-->Vector(0, 0)), Set(F
                                                  //| ill(0)-->Vector(4, 0), Fill(1)-->Vector(0, 9)), Set(Fill(0) Fill(1)-->Vector
                                                  //| (4, 9), Fill(0) Pour(0,1)-->Vector(0, 4), Fill(1) Fill(0)-->Vector(4, 9), Fi
                                                  //| ll(1) Pour(1,0)-->Vector(4, 5)))
	
	problem.solutions(6)                      //> res2: Stream[week12.test.problem.Path] = Stream(Fill(1) Pour(1,0) Empty(0) P
                                                  //| our(1,0) Empty(0) Pour(1,0) Fill(1) Pour(1,0)-->Vector(4, 6), ?)
  val problem2 = new Pouring(Vector(4, 7, 9))     //> problem2  : week12.Pouring = week12.Pouring@c038203
	problem2.moves                            //> res3: scala.collection.immutable.IndexedSeq[Product with Serializable with w
                                                  //| eek12.test.problem2.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0), Fi
                                                  //| ll(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), Pour(
                                                  //| 2,1))
}