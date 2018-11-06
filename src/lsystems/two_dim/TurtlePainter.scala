package lsystems.two_dim

import java.awt.{Color, Graphics2D}

class TurtlePainter(turtlePositions: List[Turtle], width: Int, height: Int) {

  def scaled = {
    val turtleX = turtlePositions.map(turtle => turtle.x)
    val turtleY = turtlePositions.map(turtle => turtle.y)
    val maxX = turtleX.max
    val minX = turtleX.min
    val maxY = turtleY.max
    val minY = turtleY.min
    turtlePositions.map {
      case Turtle(x,y,angle,sil) => {
        val scaledX = (x - minX) / (maxX - minX).toDouble * width
        val scaledY = (y - minY) / (maxY - minY).toDouble * height
        Turtle(scaledX.toInt, scaledY.toInt, angle, sil)
      }
    }
  }

  def draw(g2d: Graphics2D): Unit = {
    g2d.setColor(Color.white)
    g2d.fillRect(0,0, width, height)
    g2d.setColor(Color.black)
    var last = scaled.head
    for(current <- scaled.tail) {
      if(!last.sil) g2d.drawLine(last.x, last.y, current.x, current.y)
      last = current
    }
  }

}