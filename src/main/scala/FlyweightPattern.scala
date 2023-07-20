// Flyweight: Pen
trait Pen {
  def draw(x: Int, y: Int): Unit
}

// ConcreteFlyweight: ConcretePen
class ConcretePen(color: String) extends Pen {
  def draw(x: Int, y: Int): Unit = {
    println(s"Drawing at ($x, $y) with ${color.capitalize} pen")
  }
}

// FlyweightFactory: PenFactory
object PenFactory {
  private val pens: collection.mutable.Map[String, Pen] = collection.mutable.Map()
  def getPen(color: String): Pen = {
    pens.getOrElseUpdate(color, new ConcretePen(color))
  }
}

// Client code: DrawingApp
class DrawingApp {
  def drawShape(shape: String, x: Int, y: Int, color: String): Unit = {
    val pen = PenFactory.getPen(color)
    println(s"Drawing $shape at ($x, $y) with ${color.capitalize} pen")
    pen.draw(x, y)
  }
}

// Example usage
object FlyweightPattern extends App {
  private val app = new DrawingApp()
  app.drawShape("Circle", 10, 20, "red")
  app.drawShape("Square", 30, 40, "blue")
  app.drawShape("Triangle", 50, 60, "red")
  app.drawShape("Rectangle", 70, 80, "green")
  app.drawShape("Circle", 90, 100, "blue")
}


