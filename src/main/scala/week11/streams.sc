package week11

object streams {
  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
                                                  //> xs  : Stream.Cons[Int] = Stream(1, ?)
  Stream(1,2,3)                                   //> res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  Stream(1)                                       //> res1: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  
  (1 to 1000).toStream                            //> res2: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  def streamRange(lo: Int, hi: Int): Stream[Int] = {
  	print(lo.toString())
  	if (lo >= hi) Stream.empty
  	else Stream.cons(lo, streamRange(lo+1, hi))
  }                                               //> streamRange: (lo: Int, hi: Int)Stream[Int]
  	
  def listRange(lo: Int, hi: Int): List[Int] = {
  	print(lo.toString())
  	if (lo >= hi) Nil
  	else lo :: listRange(lo+1, hi)
  }                                               //> listRange: (lo: Int, hi: Int)List[Int]
  	
  streamRange(0, 1000).take(3)                    //> 0res3: scala.collection.immutable.Stream[Int] = Stream(0, ?)
  listRange(0, 1000).take(3)                      //> 0123456789101112131415161718192021222324252627282930313233343536373839404142
                                                  //| 4344454647484950515253545556575859606162636465666768697071727374757677787980
                                                  //| 8182838485868788899091929394959697989910010110210310410510610710810911011111
                                                  //| 2113114115116117118119120121122123124125126127128129130131132133134135136137
                                                  //| 1381391401411421431441451461471481491501511521531541551561571581591601611621
                                                  //| 6316416516616716816917017117217317417517617717817918018118218318418518618718
                                                  //| 8189190191192193194195196197198199200201202203204205206207208209210211212213
                                                  //| 2142152162172182192202212222232242252262272282292302312322332342352362372382
                                                  //| 3924024124224324424524624724824925025125225325425525625725825926026126226326
                                                  //| 4265266267268269270271272273274275276277278279280281282283284285286287288289
                                                  //| 2902912922932942952962972982993003013023033043053063073083093103113123133143
                                                  //| 1531631731831932032132232332432532632732832933033133233333433533633733833934
                                                  //| 034134234334434534634734
                                                  //| Output exceeds cutoff limit.
  
  lazy val x = 1+1                                //> x: => Int
  
  x                                               //> res5: Int = 2
  
  def expr = {
  	val x = {print("x"); 1}
  	lazy val y = {print("y"); 2}
  	def z = {print("z"); 3}
  	z+y+x+z+y+x
  }                                               //> expr: => Int
  
  expr                                            //> xzyzres6: Int = 12
  
  def from(n: Int): Stream[Int] = n #:: from(n+1) //> from: (n: Int)Stream[Int]
  val nats = from(0)                              //> nats  : Stream[Int] = Stream(0, ?)
 	val m4s = nats map (_*4)                  //> m4s  : scala.collection.immutable.Stream[Int] = Stream(0, ?)
 	
 	(m4s take 100).toList                     //> res7: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 
                                                  //| 56, 60, 64, 68, 72, 76, 80, 84, 88, 92, 96, 100, 104, 108, 112, 116, 120, 12
                                                  //| 4, 128, 132, 136, 140, 144, 148, 152, 156, 160, 164, 168, 172, 176, 180, 184
                                                  //| , 188, 192, 196, 200, 204, 208, 212, 216, 220, 224, 228, 232, 236, 240, 244,
                                                  //|  248, 252, 256, 260, 264, 268, 272, 276, 280, 284, 288, 292, 296, 300, 304, 
                                                  //| 308, 312, 316, 320, 324, 328, 332, 336, 340, 344, 348, 352, 356, 360, 364, 3
                                                  //| 68, 372, 376, 380, 384, 388, 392, 396)
 	
	def sieve(s: Stream[Int]): Stream[Int] = s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]
	
	val primes = sieve(from(2)).take(100).toList
                                                  //> primes  : List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 4
                                                  //| 3, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127,
                                                  //|  131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 
                                                  //| 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 2
                                                  //| 93, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 38
                                                  //| 9, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479
                                                  //| , 487, 491, 499, 503, 509, 521, 523, 541)
	
	def sqrtStream(x: Double): Stream[Double] = {
		def improve(guess: Double) = (guess +x /guess) / 2
		lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
		guesses
	}                                         //> sqrtStream: (x: Double)Stream[Double]
	
	sqrtStream(4).take(10).toList             //> res8: List[Double] = List(1.0, 2.5, 2.05, 2.000609756097561, 2.000000092922
                                                  //| 2947, 2.000000000000002, 2.0, 2.0, 2.0, 2.0)
	
	def isGoodEnough(guess: Double, x: Double) = math.abs((guess * guess) / x) < 0.0001
                                                  //> isGoodEnough: (guess: Double, x: Double)Boolean|
	
	sqrtStream(4).filter(isGoodEnough(_, 4)).take(10).toList
}