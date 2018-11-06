package curves

import lsystems.LSystem
import lsystems.two_dim.TurtleInterpreter

object TreeC extends Curve {

  final val F  = lsystems.Symbol('F')
  final val p  = lsystems.Symbol('+')
  final val n  = lsystems.Symbol('-')
  final val push  = lsystems.Symbol('[')
  final val pop   = lsystems.Symbol(']')

  val system = LSystem(
    start = List(F),
    rules = Map(
      F -> List(F,F,n,push,n,F,p,F,p,F,pop,p,push,p,F,n,F,n,F,pop)
    )
  )

  val interpreter = new TurtleInterpreter(10, 22.5)

}
