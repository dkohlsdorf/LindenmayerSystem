package curves

import lsystems.LSystem
import lsystems.two_dim.TurtleInterpreter

object QuadraticSnowflake extends Curve {

  final val F  = lsystems.Symbol('F')
  final val l  = lsystems.Symbol('+')
  final val r  = lsystems.Symbol('-')

  val system = LSystem(
    start = List(r, F),
    rules = Map(
      F -> List(F,l,F,r,F,r,F,l,F)
    )
  )

  val interpreter = new TurtleInterpreter(1, 90)

}
