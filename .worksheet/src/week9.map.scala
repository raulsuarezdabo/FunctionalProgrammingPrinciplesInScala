package week9

object map {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(165); 
  def squareList(xs: List[Int]): List[Int] =
    xs match {
      case Nil     => Nil
      case y :: ys => y * y :: squareList(ys)
    };System.out.println("""squareList: (xs: List[Int])List[Int]""");$skip(67); 

  def squareList2(xs: List[Int]): List[Int] = xs map (x => x * x);System.out.println("""squareList2: (xs: List[Int])List[Int]""");$skip(35); 

  val nums = List(2, -4, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(63); 

  val fruits = List("apple", "pineapple", "orange", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(28); val res$0 = 

  nums filter (x => x > 0);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(30); val res$1 = 
  nums filterNot (x => x > 0);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(30); val res$2 = 
  nums partition (x => x > 0);System.out.println("""res2: (List[Int], List[Int]) = """ + $show(res$2));$skip(31); val res$3 = 

  nums takeWhile (x => x > 0);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(30); val res$4 = 
  nums dropWhile (x => x > 0);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(25); val res$5 = 
  nums span (x => x > 0);System.out.println("""res5: (List[Int], List[Int]) = """ + $show(res$5));$skip(207); 

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil                 => Nil
    case x :: (xs1: List[T]) => List(x :: (xs1 takeWhile (n => n == x))) ::: pack(xs1 dropWhile (n => n == x))
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(49); val res$6 = 

  pack(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res6: List[List[String]] = """ + $show(res$6));$skip(234); 

  def encode[T](xs: List[T]): List[(T, Int)] = xs match {
    case Nil                 => Nil
    case x :: (xs1: List[T]) =>
    	val (first, rest: List[T]) = xs span (y => y == x)
    		(first head, first size) :: encode(rest)
  };System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(90); 
  
  def encode2[T](xs: List[T]): List[(T, Int)] = pack(xs) map(ys => (ys.head, ys size));System.out.println("""encode2: [T](xs: List[T])List[(T, Int)]""");$skip(53); val res$7 = 
  
  encode(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res7: List[(String, Int)] = """ + $show(res$7));$skip(51); val res$8 = 
  encode2(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res8: List[(String, Int)] = """ + $show(res$8))}
}
