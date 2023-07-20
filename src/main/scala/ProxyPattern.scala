// Subject: Image interface
trait Image {
  def display(): Unit
}

// RealSubject: RealImage
class RealImage(filename: String) extends Image {
  def loadFromDisk(): Unit = {
    println(s"Loading $filename from disk...")
  }

  def display(): Unit = {
    println(s"Displaying $filename")
  }
}

// Proxy: ImageProxy
class ImageProxy(filename: String) extends Image {
  private var realImage: Option[RealImage] = None

  def display(): Unit = {
    if (realImage.isEmpty) {
      // Lazy initialization: Load real image only when needed
      realImage = Option(new RealImage(filename))
      realImage.get.loadFromDisk()
    }
    realImage.get.display()
  }
}

// Client code
object ProxyPattern extends App {
  // Using ImageProxy to load and display the image
  private val image1: Image = new ImageProxy("image1.png")
  private val image2: Image = new ImageProxy("image2.png")

  // The real image is loaded and displayed only when needed
  image1.display()
  image2.display()

  // Subsequent calls display the real image directly
  image1.display()
  image2.display()
}
