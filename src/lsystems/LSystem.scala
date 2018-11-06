package lsystems

import scala.annotation.tailrec

case class LSystem(start: List[Symbol], rules: Map[Symbol, List[Symbol]]) {

  private def produce(symbol: Symbol): List[Symbol] =
    if(symbol.isTerminal) List(symbol)
    else rules(symbol)

  @tailrec
  private def produce(current: List[Symbol], result: List[Symbol]): List[Symbol] = current match {
    case Nil          => result
    case head :: tail => {
      produce(tail, result ::: produce(head))
    }
  }

  @tailrec
  private def produce(current: List[Symbol], stepsLeft: Int): List[Symbol] =
    if(stepsLeft == 0) current
    else produce(produce(current, Nil), stepsLeft - 1)

  def produce(depth: Int): List[Symbol] = produce(start, depth)

}
