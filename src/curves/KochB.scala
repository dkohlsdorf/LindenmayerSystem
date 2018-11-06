package curves

import lsystems.LSystem
import lsystems.two_dim.TurtleInterpreter

object KochB extends Curve {
  final val F  = lsystems.Symbol('F')
  final val l  = lsystems.Symbol('+')
  final val r  = lsystems.Symbol('-')

  val system = LSystem(
    start = List(F,r,F,r,F,r,F),
    rules = Map(
      F -> List(F,F,r,F,r,F,r,F,r,F,F)
    )
  )

  val interpreter = new TurtleInterpreter(1, 90)
}
