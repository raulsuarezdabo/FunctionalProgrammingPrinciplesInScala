package week8

object lists {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(201); 
  def init[T](xs: List[T]): List[T] = xs match {
    case List()  => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  };System.out.println("""init: [T](xs: List[T])List[T]""");$skip(132); 

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List()  => ys
    case z :: zs => z :: concat(zs, ys)
  };System.out.println("""concat: [T](xs: List[T], ys: List[T])List[T]""");$skip(127); 

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List()  => List()
    case y :: ys => reverse(ys) ++ List(y)
  };System.out.println("""reverse: [T](xs: List[T])List[T]""");$skip(83); 

  def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1);System.out.println("""removeAt: [T](n: Int, xs: List[T])List[T]""");$skip(41); val res$0 = 

  removeAt(0, List('a', 'b', 'c', 'd'));System.out.println("""res0: List[Char] = """ + $show(res$0));$skip(22); 

  val pair = ("", 3);System.out.println("""pair  : (String, Int) = """ + $show(pair ));$skip(28); 
  val (label, value) = pair;System.out.println("""label  : String = """ + $show(label ));System.out.println("""value  : Int = """ + $show(value ));$skip(10); val res$1 = 
  pair._1;System.out.println("""res1: String = """ + $show(res$1));$skip(10); val res$2 = 
  pair._2;System.out.println("""res2: Int = """ + $show(res$2))}

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
