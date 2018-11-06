package lsystems

case class Symbol(id: Char) {

  def isSilent: Boolean = id.isLower

  def isTerminal: Boolean = !id.isLetter || id.isLower

}
