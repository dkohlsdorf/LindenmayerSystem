package lsystems.two_dim

case class Turtle(x: Int, y: Int, angle: Double, sil: Boolean) {

  def move(distance: Int): Turtle =
    Turtle(math.round(x + distance * math.cos(math.toRadians(angle))).toInt, math.round(y + distance * math.sin(math.toRadians(angle))).toInt, angle, false)

  def moveSil(distance: Int): Turtle =
    Turtle(math.round(x + distance * math.cos(math.toRadians(angle))).toInt, math.round(y + distance * math.sin(math.toRadians(angle))).toInt, angle, true)

  def turn(by: Double): Turtle = {
    Turtle(x, y, (angle + by) % 360, false)
  }

  def silence: Turtle = Turtle(x, y, angle, true)

}