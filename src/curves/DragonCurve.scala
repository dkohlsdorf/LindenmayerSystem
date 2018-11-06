package curves

import lsystems.LSystem
import lsystems.two_dim.TurtleInterpreter

object DragonCurve extends Curve {

  final val A  = lsystems.Symbol('A')
  final val B  = lsystems.Symbol('B')

  final val l  = lsystems.Symbol('+')
  final val r  = lsystems.Symbol('-')

  val system = LSystem(
    start = List(A),
    rules = Map(
      A -> List(A,l,B,l),
      B -> List(r,A,r,B)
    )
  )

  val interpreter = new TurtleInterpreter(1, 90)

}
