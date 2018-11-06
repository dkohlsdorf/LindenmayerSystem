package curves

import lsystems.LSystem
import lsystems.two_dim.TurtleInterpreter

trait Curve {

  def interpreter: TurtleInterpreter

  def system: LSystem

}
