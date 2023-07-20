// Component: Coffee (interface or abstract class)
trait Coffee {
  def cost(): Double
  def description(): String
}

// Concrete Component: BasicCoffee
class BasicCoffee extends Coffee {
  def cost(): Double = 2.0
  def description(): String = "Basic Coffee"
}

// Decorator: CondimentDecorator
abstract class CondimentDecorator(coffee: Coffee) extends Coffee {
  def cost(): Double = coffee.cost()
  def description(): String = coffee.description()
}

// Concrete Decorator: Milk
class Milk(coffee: Coffee) extends CondimentDecorator(coffee) {
  override def cost(): Double = super.cost() + 1.0
  override def description(): String = super.description() + ", Milk"
}

// Concrete Decorator: Sugar
class Sugar(coffee: Coffee) extends CondimentDecorator(coffee) {
  override def cost(): Double = super.cost() + 0.5
  override def description(): String = super.description() + ", Sugar"
}

// Client code
object DecoratorPattern extends App {
  // Ordering a basic coffee
  private var coffee: Coffee = new BasicCoffee()
  println(s"Cost: ${coffee.cost()}, Description: ${coffee.description()}")

  // Adding milk to the coffee
  coffee = new Milk(coffee)
  println(s"Cost: ${coffee.cost()}, Description: ${coffee.description()}")

  // Adding sugar to the coffee
  coffee = new Sugar(coffee)
  println(s"Cost: ${coffee.cost()}, Description: ${coffee.description()}")

}
