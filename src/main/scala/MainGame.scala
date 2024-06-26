import scala.util.Random
import scala.io.StdIn.readLine

object MainGame extends App {

  def hitWasp(wasps: List[Wasp]): List[Wasp] = {
    val waspAlive = wasps.filter(!_.isDead)
    if(waspAlive.isEmpty){
      wasps
    } else {
      val randomWasp = waspAlive(Random.nextInt(waspAlive.length))
      val hitRandomWasp = randomWasp.hit()
      println(s"Wasp has been hit: $hitRandomWasp")
      wasps.map { wasp =>
        if (wasp eq randomWasp) hitRandomWasp else wasp
      }
    }
  }

  def restartGame(): Unit = {
    println("would you like to restart (yes,no): ")
    val userResponse = readLine().trim.toLowerCase
    userResponse match {
      case "yes" =>
        WaspNest.displayNest(initialWasps,0)
        gameLoop(initialWasps,0)
      case "no" => println("Thanks for playing")
      case _ =>
        println("Invalid command. Please enter 'yes' or 'no'")
        restartGame()
    }
  }

  def gameLoop(wasps: List[Wasp], hitCount: Int): Unit = {

    println("Enter Commands (fire,restart,quit): ")
    val command = readLine().trim.toLowerCase

    command match {
      case "fire" =>
        val updatedWasps = hitWasp(wasps)
        val newHitCount = hitCount + 1
        WaspNest.displayNest(updatedWasps, newHitCount)
        if(updatedWasps.exists(wasp => wasp.isDead && wasp.isInstanceOf[QueenWasp])) {
          println("Queen is dead, Game over")
          println(s"It took $newHitCount hits")
          restartGame()
        } else gameLoop(updatedWasps, newHitCount)

      case "restart" =>
        println("___________________________________")
        println("New game started")
        val initialWasps = WaspNest.initialiseWasps()
        WaspNest.displayNest(initialWasps, 0)
        gameLoop(initialWasps, 0)

      case "quit" =>
        println("Thanks for playing")

      case _ =>
        println("Invalid command. Please enter 'fire', 'restart', or 'quit'")
        gameLoop(wasps, hitCount)
    }
  }

  val initialWasps = WaspNest.initialiseWasps()
  WaspNest.displayNest(initialWasps,0)
  gameLoop(initialWasps, 0)

}
