package curves

import lsystems.LSystem
import lsystems.two_dim.TurtleInterpreter

object IslandsAndLakes extends Curve {

  final val F  = lsystems.Symbol('F')
  final val f  = lsystems.Symbol('f')
  final val p  = lsystems.Symbol('+')
  final val n  = lsystems.Symbol('-')

  val system = LSystem(
    start = List(F,p,F,p,F,p,F),
    rules = Map(
      F -> List(F,p,f,n,F,F,p,F,p,F,F,p,F,f,p,F,F,n,f,p,F,F,n,F,n,F,F,n,F,f,n,F,F,F),
      f -> List(f,f,f,f,f,f)
    )
  )
  val interpreter = new TurtleInterpreter(1, 90)

}
