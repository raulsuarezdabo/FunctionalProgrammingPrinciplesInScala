object overrides {

}

abstract class Base {
  def foo: Int = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3
}