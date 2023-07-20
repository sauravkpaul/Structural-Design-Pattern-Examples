// Target interface
trait MediaPlayer {
  def play(filename: String): Unit
}

// Adaptee interface
trait AdvancedMediaPlayer {
  def playVlc(filename: String): Unit
  def playMp4(filename: String): Unit
}

// Concrete Adaptee implementation
class VlcPlayer extends AdvancedMediaPlayer {
  def playVlc(filename: String): Unit = {
    println(s"Playing vlc file: $filename")
  }

  def playMp4(filename: String): Unit = {
    // Do nothing
  }
}

// Concrete Adaptee implementation
class Mp4Player extends AdvancedMediaPlayer {
  def playVlc(filename: String): Unit = {
    // Do nothing
  }

  def playMp4(filename: String): Unit = {
    println(s"Playing mp4 file: $filename")
  }
}

// Adapter implementation
class MediaAdapter(advancedPlayer: AdvancedMediaPlayer) extends MediaPlayer {
  def play(filename: String): Unit = {
    if (filename.endsWith(".vlc")) {
      advancedPlayer.playVlc(filename)
    } else if (filename.endsWith(".mp4")) {
      advancedPlayer.playMp4(filename)
    }
  }
}

// Concrete Target implementation
class AudioPlayer(mediaAdapter: MediaPlayer) extends MediaPlayer {
  def play(filename: String): Unit = {
    if (filename.endsWith(".mp3")) {
      println(s"Playing mp3 file: $filename")
    } else {
      mediaAdapter.play(filename)
    }
  }
}

// Client code
object AdapterPattern extends App {
  private val vlcPlayer = new VlcPlayer()
  private val mp4Player = new Mp4Player()
  private val mediaAdapter = new MediaAdapter(vlcPlayer)
  private val audioPlayer = new AudioPlayer(mediaAdapter)

  audioPlayer.play("song.mp3")
  audioPlayer.play("movie.vlc")
  audioPlayer.play("movie.mp4")

}