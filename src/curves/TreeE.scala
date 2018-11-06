package curves

import lsystems.LSystem
import lsystems.two_dim.TurtleInterpreter

object TreeE extends Curve {

  final val X  = lsystems.Symbol('X')
  final val F  = lsystems.Symbol('F')
  final val p  = lsystems.Symbol('+')
  final val n  = lsystems.Symbol('-')
  final val push  = lsystems.Symbol('[')
  final val pop   = lsystems.Symbol(']')

  val system = LSystem(
    start = List(X),
    rules = Map(
      X -> List(F, push, p, X, pop, push, n, X, pop,F, X),
      F -> List(F,F)
    )
  )

  val interpreter = new TurtleInterpreter(3, 25.7)

}
