package curves

import lsystems.LSystem
import lsystems.two_dim.TurtleInterpreter

object Sierpinski extends Curve {
  final val A  = lsystems.Symbol('A')
  final val B  = lsystems.Symbol('B')

  final val l  = lsystems.Symbol('+')
  final val r  = lsystems.Symbol('-')

  val system = LSystem(
    start = List(B),
    rules = Map(
      A -> List(B,l,A,l,B),
      B -> List(A,r,B,r,A)
    )
  )

  val interpreter = new TurtleInterpreter(6, 60)

}
