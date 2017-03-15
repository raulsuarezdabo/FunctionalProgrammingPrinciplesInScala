package week8

object lists {
  def init[T](xs: List[T]): List[T] = xs match {
    case List()  => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List()  => ys
    case z :: zs => z :: concat(zs, ys)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List()  => List()
    case y :: ys => reverse(ys) ++ List(y)
  }                                               //> reverse: [T](xs: List[T])List[T]

  def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]

  removeAt(0, List('a', 'b', 'c', 'd'))           //> res0: List[Char] = List(b, c, d)

  val pair = ("", 3)                              //> pair  : (String, Int) = ("",3)
  val (label, value) = pair                       //> label  : String = ""
                                                  //| value  : Int = 3
  pair._1                                         //> res1: String = ""
  pair._2                                         //> res2: Int = 3

}

import math.Ordering
object mergesort {
  //def msort[T](xs: List[T])(lf: (T, T) => Boolean): List[T] = {
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) {
      xs
    } else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, Nil) => List()
          case (Nil, ys)  => ys
          case (xs, Nil)  => xs
          case (headX :: tailX, headY :: tailY) =>
            if (ord.lt(headX, headY)) headX :: merge(tailX, ys)
            else headY :: merge(xs, tailY)
        }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }
  
  val nums = List(2, -4, 5, 7, 1)
  // msort(nums)((a:Int, b:Int) => a<b)
  msort(nums) // (Ordering.Int)
  
  val fruits = List("apple", "pineapple", "orange", "banana")
  // msort(fruits)((a:String, b:String) => a.length < b.length)
  msort(fruits)// (Ordering.String)
}