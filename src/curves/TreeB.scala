package curves

import lsystems.LSystem
import lsystems.two_dim.TurtleInterpreter

object TreeB extends Curve {

  final val F  = lsystems.Symbol('F')
  final val p  = lsystems.Symbol('+')
  final val n  = lsystems.Symbol('-')
  final val push  = lsystems.Symbol('[')
  final val pop   = lsystems.Symbol(']')

  val system = LSystem(
    start = List(F),
    rules = Map(
      F -> List(F,push,p,F,pop,F,push,n,F,pop,push,F,pop)
    )
  )

  val interpreter = new TurtleInterpreter(5, 20.0)

}
