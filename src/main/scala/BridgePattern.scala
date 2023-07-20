// Implementor hierarchy
trait Color {
  def fill(): Unit
}

class RedColor extends Color {
  def fill(): Unit = {
    println("Filling with red color.")
  }
}

class BlueColor extends Color {
  def fill(): Unit = {
    println("Filling with blue color.")
  }
}

// Abstraction hierarchy
abstract class Shape(color: Color) {
  def draw(): Unit
}

class Circle(color: Color) extends Shape(color) {
  def draw(): Unit = {
    println("Drawing a circle.")
    color.fill()
  }
}

class Square(color: Color) extends Shape(color) {
  def draw(): Unit = {
    println("Drawing a square.")
    color.fill()
  }
}

case object BridgePattern extends App {
  // Client code
  private val redCircle = new Circle(new RedColor)
  redCircle.draw()

  private val blueSquare = new Square(new BlueColor)
  blueSquare.draw()
}
