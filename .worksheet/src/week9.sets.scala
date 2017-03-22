package week9

object sets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  val fruit = Set("apple", "banana", "pear");System.out.println("""fruit  : scala.collection.immutable.Set[String] = """ + $show(fruit ));$skip(25); 
  val s = (1 to 6).toSet;System.out.println("""s  : scala.collection.immutable.Set[Int] = """ + $show(s ));$skip(18); val res$0 = 
  
  s map(_ + 2);System.out.println("""res0: scala.collection.immutable.Set[Int] = """ + $show(res$0));$skip(20); val res$1 = 
  s map(x => x + 2);System.out.println("""res1: scala.collection.immutable.Set[Int] = """ + $show(res$1));$skip(38); val res$2 = 
  fruit filter ( _.startsWith("app"));System.out.println("""res2: scala.collection.immutable.Set[String] = """ + $show(res$2));$skip(13); val res$3 = 
  s.nonEmpty;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(15); val res$4 = 
  s map(_ /2 );System.out.println("""res4: scala.collection.immutable.Set[Int] = """ + $show(res$4));$skip(15); val res$5 = 
  s contains 5;System.out.println("""res5: Boolean = """ + $show(res$5))}
}
