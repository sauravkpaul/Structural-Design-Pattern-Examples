// Theater Subsystem classes
class TicketCounter {
  def buyTicket(movieName: String): Unit = {
    println(s"Ticket purchased for movie: $movieName")
  }
}

class SeatReservation {
  def reserveSeat(movieName: String, seatNumber: Int): Unit = {
    println(s"Seat $seatNumber reserved for movie: $movieName")
  }
}

class FoodCounter {
  def orderPopcorn(): Unit = {
    println("Popcorn ordered.")
  }

  def orderSoda(): Unit = {
    println("Soda ordered.")
  }
}

// Facade class
class MovieTheaterFacade {
  private val ticketCounter = new TicketCounter()
  private val seatReservation = new SeatReservation()
  private val foodCounter = new FoodCounter()

  def buyMovieTicket(movieName: String, seatNumber: Int): Unit = {
    ticketCounter.buyTicket(movieName)
    seatReservation.reserveSeat(movieName, seatNumber)
  }

  def buyMovieTicketWithSnacks(movieName: String, seatNumber: Int): Unit = {
    buyMovieTicket(movieName, seatNumber)
    foodCounter.orderPopcorn()
    foodCounter.orderSoda()
  }
}

// Client code
object FacadePattern extends App {
  private val theaterFacade = new MovieTheaterFacade()
  // Buying a movie ticket
  theaterFacade.buyMovieTicket("Avengers: Endgame", seatNumber = 5)
  // Buying a movie ticket with snacks
  theaterFacade.buyMovieTicketWithSnacks("The Matrix", seatNumber = 8)
}

