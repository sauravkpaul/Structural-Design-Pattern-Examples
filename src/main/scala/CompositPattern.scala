// Component trait
trait MusicComponent {
  def play(): Unit
}

// Leaf class
class Song(name: String) extends MusicComponent {
  def play(): Unit = {
    println(s"Playing song: $name")
  }
}

// Composite class
class Playlist(name: String) extends MusicComponent {
  private var components: List[MusicComponent] = List.empty

  def add(component: MusicComponent): Unit = {
    components = component :: components
  }

  def remove(component: MusicComponent): Unit = {
    components = components.filterNot(_ == component)
  }

  def play(): Unit = {
    println(s"Playing playlist: $name")
    components.foreach(_.play())
  }
}

// Client code
case object CompositPattern extends App {
  private val song1 = new Song("Song 1")
  private val song2 = new Song("Song 2")
  private val song3 = new Song("Song 3")

  private val playlist1 = new Playlist("Playlist 1")
  playlist1.add(song1)
  playlist1.add(song2)

  private val playlist2 = new Playlist("Playlist 2")
  playlist2.add(song3)
  playlist2.add(playlist1)

  playlist2.play()
}
