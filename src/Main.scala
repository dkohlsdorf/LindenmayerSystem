import java.awt.Graphics2D

import curves._
import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO
import lsystems.two_dim.{Turtle, TurtlePainter}

object Main {

  def paint(file: String, depth: Int, width: Int, height: Int, curve: Curve): Unit = {
    val img     = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val g2d     = img.getGraphics.asInstanceOf[Graphics2D]
    val strg    = curve.system.produce(depth)
    val cmd     = curve.interpreter.execute(strg, Turtle(0,0,0,false))
    val painter = new TurtlePainter(cmd, width, height)
    painter.draw(g2d)
    ImageIO.write(img, "JPEG", new File(file))
  }

  def main(args: Array[String]): Unit = {
    paint("images/dragon.png", 10, 400, 400, DragonCurve)
    paint("images/islands_lakes.png", 2, 400, 400, IslandsAndLakes)
    paint("images/koch.png", 3, 400, 400, QuadraticKochIsland)
    paint("images/snowflake.png", 4, 200, 400, QuadraticSnowflake)
    paint("images/treeA.png", 4, 400, 100, TreeA)
    paint("images/treeB.png", 4, 400, 100, TreeB)
    paint("images/treeC.png", 4, 400, 200, TreeC)
    paint("images/treeE.png", 6, 400, 200, TreeE)
    paint("images/kochA.png", 4, 400, 400, KochA)
    paint("images/kochB.png", 4, 400, 400, KochB)
    paint("images/kochC.png", 4, 400, 400, KochC)
    paint("images/sierpinski.png", 6, 400, 400, Sierpinski)
    paint("images/fass.png", 4, 400, 400, FASS)
  }

}
