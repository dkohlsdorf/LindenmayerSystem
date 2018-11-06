package lsystems.two_dim

import lsystems.Symbol

class TurtleInterpreter(moveBy: Int, turnBy: Double) {

  import TurtleInterpreter._

  private def execute(cmd: List[Symbol], state: Turtle, stack: List[Turtle], drawable: List[Turtle]): List[Turtle] = cmd match {
    case Nil => drawable
    case RotateRight :: tail => execute(tail, state.turn(turnBy), stack, drawable)
    case RotateLeft  :: tail => execute(tail, state.turn(-turnBy), stack, drawable)
    case PushStack   :: tail => execute(tail, state, state :: stack, drawable)
    case PopStack    :: tail => execute(tail, stack.head.silence, stack.tail, stack.head.silence :: drawable)
    case head        :: tail => {
      val next = if (head.isSilent) state.moveSil(moveBy) else state.move(moveBy)
      execute(tail, next, stack, next :: drawable)
    }
  }

  def execute(cmd: List[Symbol], init: Turtle): List[Turtle] =
    execute(cmd, init, List.empty[Turtle], List(init))

}

object TurtleInterpreter {

  final val RotateRight = Symbol('+')
  final val RotateLeft  = Symbol('-')
  final val PushStack   = Symbol('[')
  final val PopStack    = Symbol(']')

}