package curves

import lsystems.LSystem
import lsystems.two_dim.TurtleInterpreter

object FASS extends Curve {
  final val A  = lsystems.Symbol('A')
  final val B  = lsystems.Symbol('B')

  final val p  = lsystems.Symbol('+')
  final val n  = lsystems.Symbol('-')

  val system = LSystem(
    start = List(A),
    rules = Map(
      A -> List(A,p,B,p,p,B,n,A,n,n,A,A,n,B,p),
      B -> List(n,A,p,B,B,p,p,B,p,A,n,n,A,n,B)
    )
  )

  val interpreter = new TurtleInterpreter(4, 60)
}
